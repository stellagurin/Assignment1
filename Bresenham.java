import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bresenham extends JPanel {

    private BufferedImage canvas;
    private ArrayList<DataLine> datalines = new ArrayList<DataLine>();
    private int numOfLines;
    private double[][] concatMatrix;

    public Bresenham(int width, int height) {
        int x1,x2,y1,y2;
        double[][] matrix = {{0.0,0.0,0.0}, {0.0,0.0,0.0}, {0.0,0.0,0.0}};
        concatMatrix = matrix;
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        fillCanvas(Color.BLACK);
        numOfLines = 0;
    }

    // put all lines in an output file
    public static int outputLines(ArrayList<DataLine> datalines, int num) {
        DataLine data;
        int x1,x2,y1,y2;
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name for the txt file (e.g. output.txt): ");
        input = scanner.nextLine();
        int count = 0;

        Writer writer = null;

        try {
            writer =
                new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(input), "utf-8"));

            for(int i = 0; i < num; i++) {
                data = datalines.get(i);
                x1 = data.getx1();
                y1 = data.gety1();
                x2 = data.getx2();
                y2 = data.gety2();
                writer.write("Line " + i + ": (" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")\n" );
                count++;
            }//for

        } catch (IOException ex) {
            System.out.println("Error");
        } finally {
            try {writer.close();}
            catch (Exception ex) {
                System.out.println("Error");
            }
        }
        return count;
    }

    public static int getScreenWorkingWidth() {
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().width;
    }

    public static int getScreenWorkingHeight() {
        return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getMaximumWindowBounds().height;
    }

    public double[][] getConcatMatrix() {
        return concatMatrix;
    }

    public ArrayList<DataLine> getDatalines() {
        return datalines;
    }

    public int getNumOfLines() {
        return numOfLines;
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }


    public void fillCanvas(Color c) {
        int color = c.getRGB();
        for (int x = 0; x < canvas.getWidth(); x++) {
            for (int y = 0; y < canvas.getHeight(); y++) {
                canvas.setRGB(x, y, color);
            }
        }
        repaint();
    }

    public void drawLine(DataLine dataline) {
        int rgb = 16777215;

        int x0 = dataline.getx1();
        int y0 = dataline.gety1();
        int x1 = dataline.getx2();
        int y1 = dataline.gety2();

        int w = x1 - x0;
        int h = y1 - y0;

        int dx1 = 0;
        int dy1 = 0;
        int dx2 = 0;
        int dy2 = 0;

        if (w < 0) {
            dx1 = -1;
        } else if (w > 0) {
            dx1 = 1;
        }

        if (h < 0) {
            dy1 = -1;
        } else if (h > 0) {
            dy1 = 1;
        }

        if (w < 0) {
            dx2 = -1;
        } else if (w > 0) {
            dx2 = 1;
        }

        int longest = Math.abs(w);
        int shortest = Math.abs(h);

        if (!(longest > shortest)) {
            longest = Math.abs(h);
            shortest = Math.abs(w);
            if (h < 0) {
                dy2 = -1;
            } else if (h > 0) {
                dy2 = 1;
            }

            dx2 = 0;
        }

        int numerator = longest >> 1;

        for (int i = 0; i <= longest;i ++) {
            if(x0 >= 0 && y0 >=0 && x0 <= 639 && y0 <= 479) {
                canvas.setRGB((int)x0, (int)y0, rgb);
                numerator += shortest;
                if (!(numerator < longest)) {
                    numerator -= longest;
                    x0 += dx1;
                    y0 += dy1;
                } else {
                    x0 += dx2;
                    y0 += dy2;
                }
            }
        }
        repaint();
        datalines.add(dataline);
        numOfLines++;
    }

    public void drawDDALine(DataLine dataline) {
        int rgb = 16777215;

        int x0 = dataline.getx1();
        int y0 = dataline.gety1();
        int x1 = dataline.getx2();
        int y1 = dataline.gety2();

        int steps, xincrease, yincrease;
        int w = x1 - x0;
        int h = y1 - y0;

        if (Math.abs(w) > Math.abs(h) && h != 0) {
            steps = Math.abs(h);
        } else {
            steps = Math.abs(w);
        }

        int x = x0;
        int y = y0;

        Graphics g = canvas.getGraphics();

        while (steps != 0) {
            xincrease = w/steps;
            yincrease = h/steps;
            steps--;
            x += xincrease;
            y += yincrease;
            g.fillOval(Math.round(x), Math.round(y), 10, 10);
        }

        repaint();
        datalines.add(dataline);
        numOfLines++;
    }


}
