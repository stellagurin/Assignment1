import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

        // variables used in while loop
        Boolean isRunning = true;
        DataLine line, line2;
        int width = 640;
        int height = 480;
        int input;
        int counter = 0;
        int x1,y1,x2,y2;
        JFrame frame = new JFrame("Assignment 1");
        Scanner scan = new Scanner(System.in);
        Bresenham panel = new Bresenham(width, height);

        // for GUI
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // loop
        while (isRunning) {
            System.out.println("What would you like to do?");
            System.out.println("0: Draw Lines with Bresenham Algorithm");
            System.out.println("1: Draw Lines with Basic Line Algorithm");
            System.out.println("2: Output Lines");
            System.out.println("3: Exit");
            System.out.println("4: Test Bresenham");
            System.out.println("5: Test Basic Line");
            input = scan.nextInt();

            switch (input) {

            case 0:

                System.out.println("Enter the number of lines to draw:");
                int lines = scan.nextInt();

                for (int i = 0; i < lines; i++) {
                    x1 = (int)(Math.random() * 640);
                    y1 = (int)(Math.random() * 480);
                    x2 = (int)(Math.random() * 640);
                    y2 = (int)(Math.random() * 480);
                    line = new DataLine(x1,y1,x2,y2);
                    panel.drawLine(line);
                }

                break;

            case 1:

                System.out.println("Enter the number of lines to draw:");
                int lines2 = scan.nextInt();

                for (int i = 0; i < lines2; i++) {
                    x1 = (int)(Math.random() * 640);
                    y1 = (int)(Math.random() * 480);
                    x2 = (int)(Math.random() * 640);
                    y2 = (int)(Math.random() * 480);
                    line2 = new DataLine(x1,y1,x2,y2);
                    panel.drawDDALine(line2);
                }

                break;

            case 2:

                panel.outputLines(panel.getDatalines(),
                panel.getNumOfLines());
                break;

            case 3:

                isRunning = false;
                break;

            case 4:
                x1 = 10;
                y1 = 10;
                x2 = 30;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 10;
                y1 = 10;
                x2 = 10;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 30;
                y1 = 10;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 10;
                y1 = 30;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 10;
                y1 = 10;
                x2 = 20;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 10;
                y1 = 30;
                x2 = 20;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 20;
                y1 = 30;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                x1 = 20;
                y1 = 10;
                x2 = 10;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawLine(line);

                break;

            case 5:

                x1 = 10;
                y1 = 10;
                x2 = 30;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 10;
                y1 = 10;
                x2 = 10;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 30;
                y1 = 10;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 10;
                y1 = 30;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 10;
                y1 = 10;
                x2 = 20;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 10;
                y1 = 30;
                x2 = 20;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 20;
                y1 = 30;
                x2 = 10;
                y2 = 10;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                x1 = 20;
                y1 = 10;
                x2 = 10;
                y2 = 30;

                line = new DataLine(x1,y1,x2,y2);
                panel.drawDDALine(line);

                break;

            default:

                System.out.println("Invalid input.");

            }
        }
        System.exit(0);
    }
}
