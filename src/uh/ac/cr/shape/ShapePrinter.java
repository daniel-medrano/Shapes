package uh.ac.cr.shape;
import java.util.Scanner;

public class ShapePrinter {

    int optionSelected = 0;
    Scanner scanner = new Scanner(System.in);

    public void selectOption() {
        System.out.println("Select the number of the shape you would like to print: ");
        System.out.println("""
                1: Diamond
                2: Square
                3: Rectangle
                4: Circle
                5: Heart
                6: Exit
                Your answer:\s""");
        optionSelected = scanner.nextInt();
    }

    public int getOption() {
        return optionSelected;
    }

    public void printDiamond(int lengthDesired) {
        //Creating a new line, just an visual printing.
        System.out.println();

        //Calculating number of rows that should be printed.
        int rowsToPrint = lengthDesired / 2 + 1;

        //For loop to print all the blanks required before printing the * on the next for loop.
        for (int actualRow = 1; actualRow <= rowsToPrint; actualRow++) {
            //Blank spaces to print
            for (int blank = 1; blank <= rowsToPrint - actualRow; blank++) {
                System.out.print(" ");
            }
            //Printing all the * required.
            for (int symbol = 1; symbol <= (2 * actualRow) - 1; symbol++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        //Printing second half of the shape.
        rowsToPrint--;
        for (int actualRow = 1; actualRow <= rowsToPrint; actualRow++) {
            //For loop to print all the blanks required before printing the * on the next for loop.
            for (int blank = 1; blank <= actualRow; blank++) {
                System.out.print(" ");
            }
            //Printing all the * required.
            for (int symbol = 1; symbol <= (rowsToPrint - actualRow) * 2 + 1; symbol++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("");
    }

    //1. Analyze this code and check why significant variable names and internal documentation are important.
    //I can see that the code is more difficult to understand because of the lack of comments and good variable names. If it had had good documentation I would have been able to understand the code much better.
    //2. What does variable x, y, z, dist1 and dist2 are doing in this code?
    /*
    x is used to go through each row.
    y is each element of a row, either a space or a dot.
    dist1 and dist2 are for the first part of the heart, to print the half circles. They determine if either a space or a dot is printed taking x and y into account.
    */
    //3. Is it easier to understand the code when it has internal documentation?
    //Yes, it definitely is
    public void printHeart(int size) {

        System.out.println();
        //It prints the first part of the heart
        for (int x = 0; x < size; x++) {
            for (int y = 0; y <= 4 * size; y++) {
                double dist1 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - size, 2));
                double dist2 = Math.sqrt(Math.pow(x - size, 2) + Math.pow(y - 3 * size, 2));
                if (dist1 < size + 0.5 || dist2 < size + 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        //It prints the rest of the heart, which is an upside down triangle.
        for (int row = 1; row < 2 * size; row++) {
            for (int y = 0; y < row; y++) {
                System.out.print(" ");
            }
            for (int y = 0; y < 4 * size + 1 - 2 * row; y++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }


    public void printSquare(int size) {

        System.out.println("");
        //First for to print each row, the amount of dots are determined by the size.
        for (int row = 0; row < size; row++) {
            //Second for to print each dot of a row, the dots are also determined by the size.
            for (int dot = 0; dot < size; dot++) {
                if (dot == size - 1) {
                    System.out.print("*");
                } else {
                    System.out.print("*_");
                }
            }
            //Jumps to the line.
            System.out.println("");
        }
        System.out.println("");
    }

    public void printRectangle(int height, int width) {

        System.out.println("");
        //First for to print each row, the rows are determined by the height.
        for (int row = 0; row <= height - 1; row++) {
            //Second for to print the dots of each row, the dots are determined by the width.
            for (int dot = 0; dot <= width - 1; dot++) {
                if (dot < width - 1) {
                    System.out.print("*_");
                } else {
                    System.out.print("*");
                }
            }
            //Once a row is printed, it is time to print the next one by jumping to the next line
            System.out.println("");
        }
        System.out.println("");
    }

    //The circle method works with a radius as a parameter.
    public void printCircle(int radius) {
        int diameter = radius % 2 == 0 ? radius * 2 : radius * 2 + 1; //Diameter is calculated taking into account if the number is even or odd.
        int amountOfDots = radius; //The initial amount of dots that is going to be printed in the first line is the same as the radius.
        int counter = 0; //Counter to print the rows that are going to be of the same size or same amount of dots.
        int dots = 2; //The amount of dots that are going to be added or subtracted per row.
        System.out.println("");

        for (int row = 0; row < diameter; row++) {
            //Loop for to print the spaces before the dots.
            for (int space = 0; space < (diameter - amountOfDots) / 2; space++) {
                System.out.print(" ");
            }
            //The dots of a row are printed
            for (int dot = 0; dot < amountOfDots; dot++) {
                System.out.print("*");
            }
            System.out.println("");
            amountOfDots += dots;
            //Once the amount of dots reach the size of the diameter, 2 will stop being added to "amountOfDots".
            if (amountOfDots == diameter) {
                while (counter < radius - 1) {
                    for (int dot = 0; dot < amountOfDots; dot++) {
                        System.out.print("*");
                    }
                    System.out.println("");
                    row++;
                    counter++;
                }
                //When the rows of the same amount of dots are printed, it is time to reduce the dots. In order to do that "dots" becomes negative.
                dots = -dots;
            }
        }
        System.out.println("");
    }
}