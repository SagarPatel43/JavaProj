//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #3
//March 14, 2017

/*
This program reads a Book Inventory from a file and fixes the inventory for any duplicate ISBNs, the fixed inventory is then written to another file of the user's choice. To accomplish this the 
Book class is used to store multiple Books in an array, and then operations are performed on this array to find any duplicate ISBNs, once the problem ISBNs are resolved, the array is written
to the output file and both are displayed. Several exceptions are used in this program, notably the FileAlreadyExistsException used when validating the user's output file choice, and
the DuplicateISBNException which is used when a duplicate ISBN is detected, prompting the user to input a new one until it is no longer a duplicate.
 */
package a3_40022733_40029417_part1;

import java.io.*;
import java.util.Scanner;

public class BookInventory1 {

    //static Book array to later hold contents of input file
    static Book bkArray[];

    //Method used to go through input file and count how many lines are in the file(using input file name as parameter and initializing a Scanner), returns number of lines
    private static int inventorySize(String inputFile) throws FileNotFoundException {
        int lines = 0;
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        while (sc.hasNextLine()) {
            sc.nextLine();
            lines++;
        }
        sc.close();
        return lines;
    }

    //The fixInventory method takes two parameters, the input+output file name, which allows it to initialize a Scanner and PrintWriter. With these, it reads the contents of the input file
    //and creates a Book object using the attributes being read, these book objects are then added to the static bkArr whose length is determined by intentorySize().
    //With the array initialized, the program goes through each index of the bkArr and finds any duplicate ISBNs, it then prompts the user with the location of the duplicate, and to 
    //correct it, if the user provides another duplicate the DuplicateISBNException is thrown, this process continues until all duplicate ISBNs are resolved.
    //Once the bkArr is fixed a PrintWriter is initialized to write to the outputFile provided using the toString method for each book.
    static void fixInventory(String inputFile, String outputFile) throws FileNotFoundException {
        System.out.println("Attempting to open file: Initial_Book_Info.txt\n");
        Scanner copy = new Scanner(new FileInputStream(inputFile));

        System.out.println("Detecting number of records in file: Initial_Book_Info");
        bkArray = new Book[inventorySize(inputFile)];

        int counter = 0;
        while (copy.hasNextLine()) {
            Book book = new Book(copy.nextLong(), copy.next(), copy.nextInt(), copy.next(), copy.nextDouble(), copy.nextInt());
            bkArray[counter] = book;
            counter++;
        }
        copy.close();

        Scanner console = new Scanner(System.in);
        boolean duplicate;
        for (int i = 0; i < bkArray.length; i++) {
            for (int j = i + 1; j < bkArray.length; j++) {
                if (bkArray[j].getISBN() == bkArray[i].getISBN()) {
                    duplicate = true;
                    while (duplicate) {
                        try {
                            System.out.print("Duplicate ISBN " + bkArray[j].getISBN() + " in record #" + (j + 1) + ". Please enter the correct ISBN: ");
                            long ISBN = console.nextLong();
                            for (int z = 0; z < bkArray.length; z++) {
                                if (ISBN == bkArray[z].getISBN()) {
                                    throw new DuplicateISBNException("Attempt of duplicate entry to a previous record." + "\nInitial appearance of ISBN " + bkArray[z].getISBN()
                                            + " was found at record #: " + (z + 1) + ".\nError.... Duplicate of ISBN. The entered ISBN exists for another record.");
                                }
                            }
                            bkArray[j].setISBN(ISBN);
                            duplicate = false;
                        } catch (DuplicateISBNException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }

        PrintWriter pw = new PrintWriter(new FileOutputStream(outputFile));
        for (int i = 0; i < bkArray.length; i++) {
            pw.println(bkArray[i]);
        }
        pw.close();
    }

    //Prints contents of a file containing book records, takes input file name as parameter and initializes Scanner with FileInputStream (which can throw a FileNotFoundException).
    static void displayFileContents(String inputFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(inputFile));
        while (sc.hasNext()) {
            System.out.println(sc.nextLong() + " " + sc.next() + " " + sc.nextInt() + " " + sc.next() + " " + sc.nextDouble() + " " + sc.nextInt());
        }
        sc.close();
    }

    public static void main(String[] args) {
        //Initialize Scanner for user input
        //Strings to hold output file name, boolean to validate users output file
        Scanner console = new Scanner(System.in);
        boolean fileExist = true;
        String output = "";

        //Asks user for an output file name, creates File object from input and validates to check if File already exists, if so FileAlreadyExistsException is thrown
        //and caught to prompt user again -- while loop will continue until no exception is thrown. Once valid, output+input file names are passed into fixInventory
        //where FileOutputStream+Scanner are initialized 
        System.out.print("Please enter the name of output file, which will have correct information: ");
        while (fileExist) {
            try {
                output = console.next();
                File file = new File(output);
                if (file.exists()) {
                    throw new FileAlreadyExistException(file);
                }
                fixInventory("Initial_Book_Info.txt", output);
                fileExist = false;
            } catch (FileAlreadyExistException | FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.print("\nPlease enter another file name to create: ");

            }
        }

        //Prints contents of input file and output file to show how fixInventory method works, try-catch block used since displayFileContents throws FileNotFoundException
        try {
            System.out.println("\nHere are the contents of file Initial_Book_Info.txt AFTER copying operation: ");
            System.out.println("---------------------------------------------------------------------------------");
            displayFileContents("Initial_Book_Info.txt");
            System.out.println("\nHere are the contents of file " + output + " AFTER copying operation: ");
            System.out.println("---------------------------------------------------------------------------------");
            displayFileContents(output);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
