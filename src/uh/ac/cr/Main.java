//Student: Daniel Medrano Guadamuz
package uh.ac.cr;

import uh.ac.cr.shape.ShapePrinter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //New object of shapePrinter.
        ShapePrinter shapePrinter = new ShapePrinter();

        //Asking rows to print for the diamond.
        Scanner scanner = new Scanner(System.in);

        //While loop that ends if the user inserts 6 which is the option to exit the program.
        while (shapePrinter.getOption() != 6) {
            int size = 0;
            int width = 0;
            int height = 0;

            shapePrinter.selectOption();
            //If the option selected has been the rectangle (3) then it is gonna ask the user for two values: the height and width. Otherwise it´ll just ask for the size
            if (shapePrinter.getOption() == 3) {
                try {
                    System.out.println("Insert the height and width separated by a space: ");
                    height = scanner.nextInt();
                    width = scanner.nextInt();
                    //If the numbers are negative, it will throw an exception.
                    if (height < 0 || width < 0) {
                        throw new IllegalArgumentException("\n" + "ERROR: Only positive integers.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            } else if (shapePrinter.getOption() > 0 && shapePrinter.getOption() < 6) {
                try {
                    System.out.println("Insert the size of the shape: ");
                    size = scanner.nextInt();
                    //If the number is negative, it will throw an exception.
                    if (size < 0) {
                        throw new IllegalArgumentException("\n" + "ERROR: Only positive integers.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                }
            }
            //The option selected by the user is checked in this switch.
            switch (shapePrinter.getOption()) {
                case 1:
                    shapePrinter.printDiamond(size);
                    break;
                case 2:
                    shapePrinter.printSquare(size);
                    break;
                case 3:
                    shapePrinter.printRectangle(height, width);
                    break;
                case 4:
                    shapePrinter.printCircle(size);
                    break;
                case 5:
                    shapePrinter.printHeart(size);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n" + "ERROR: Not a valid option." + "\n");
            }
        }
    }
}
