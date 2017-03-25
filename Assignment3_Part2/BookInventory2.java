//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #3
//March 14, 2017

/*
This program reads a BookInventory from a file and allows the user to add however many records they'd like, the program then writes the contents of the file into an array
of Books and displays the contents of the file with the user of a BufferedReader. The program then utilizes a sequential search and binary search to find the user-inputted ISBN
within the array, and displays its location and how many iterations each search took. Finally it writes the objects of the Book array into a binary file.
 */
package a3_40022733_40029417_part2;

import java.io.*;
import java.util.*;

public class BookInventory2 {

    //static bkArray and static counterBinary to count iterations without misbehaving due to recursive method
    static Scanner console = new Scanner(System.in);
    static Book[] bkArray;
    static int counterBinary = 1;

    //Reads from input file and initializes Book objects with attributes stored in file, then stores Book objects into array, array is then sorted by ISBN(increasing)
    static void copyIntoArray(Book[] array, String inputStream) throws FileNotFoundException {
        Scanner read = new Scanner(new FileInputStream(inputStream));
        int index = 0;
        while (read.hasNext()) {
            array[index] = new Book(read.nextLong(), read.next(), read.nextInt(), read.next(), read.nextDouble(), read.nextInt());
            index++;
        }
        read.close();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].getISBN() > array[j].getISBN()) {
                    Book temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //Refer to BookInventory1
    static int numOfRecords(String inputStream) throws FileNotFoundException {
        Scanner input = new Scanner(new FileInputStream(inputStream));
        int counter = 0;
        while (input.hasNextLine()) {
            counter++;
            input.nextLine();
        }
        input.close();
        return counter;
    }

    //Allows user to add however many records they'd like to file, using output file given as parameter and writing to it with PrintWriter and Book's to String method
    static void addRecords(FileOutputStream out) {
        System.out.print("Do you want to add a record? Enter \"yes\" or \"no\": ");
        String answer = console.next();
        String gb = console.nextLine();
        PrintWriter write = new PrintWriter(out);
        while (answer.equals("yes")) {
            System.out.println("Enter the ISBN, book name, the year of publishing, author, price and number of pages: ");
            Book book = new Book(console.nextLong(), console.next(), console.nextInt(), console.next(), console.nextDouble(), console.nextInt());
            write.println(book);
            System.out.print("Do you want to add another record? Enter \"yes\" or \"no\":  ");
            answer = console.next().toLowerCase();
            gb = console.nextLine();
        }
        write.close();
    }

    //Prints contents of input file provided with the use of a BufferedReader
    static void displayFileContents(FileInputStream in) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(in));
        String x = read.readLine();
        while (x != null) {
            System.out.println(x);
            x = read.readLine();
        }
        read.close();
    }

    //Uses recursion to search through array of Books for given ISBN within indices, method utilizes midpoint of provided indices, and checks base case of whether the array at mid is equal
    //to the given ISBN, if not it adjusts the indices and recursively calls itself until the location is found from the base case. returns int corresponding to location
    static int binaryBookSearch(Book[] book, int startIndex, int endIndex, long ISBN) {
        int mid = (endIndex + startIndex) / 2;
        int indexFound = -1;
        if (startIndex > endIndex) {
            System.out.print("The binary search took " + counterBinary + " iterations. ");
            return -1;
        }
        if (book[mid].getISBN() == ISBN) {
            System.out.print("The binary search took " + counterBinary + " iterations. ");
            return mid;
        } else if (book[mid].getISBN() < ISBN) {
            counterBinary++;
            indexFound = binaryBookSearch(book, mid + 1, endIndex, ISBN);
        } else if (book[mid].getISBN() > ISBN) {
            counterBinary++;
            indexFound = binaryBookSearch(book, startIndex, mid - 1, ISBN);
        }
        return indexFound;
    }

    //Searches within the given indices for an ISBN in the given array of Books using a sequential search, i.e. going through every index and checking if its equal to the given ISBN
    //returns location of ISBN and how many iterations search required
    static void sequentialBookSeach(Book[] book, int startIndex, int endIndex, long ISBN) {
        int index = -1;
        int counter = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i].getISBN() == ISBN) {
                index = i;
                break;
            }
            counter++;
        }
        if (index == -1) {
            System.out.println("Sequential search returned: " + index + ". The ISBN was not found, it took " + counter + " iterations");
        } else {
            System.out.println("The sequential search took " + counter + " iterations. The ISBN you were looking for is found at index " + index);
        }
    }

    //Stores Book objects within array of Books to a binary file using ObjectOutputStream
    static void storeInBinaryFile(String outStream, Book[] array) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outStream));
        for (int i = 0; i < array.length; i++) {
            out.writeObject(array[i]);
        }
        out.close();
    }

    public static void main(String[] args) {
        //Declares Streams to be used 
        FileInputStream fileIn = null;
        FileOutputStream fileOut = null;

        ObjectInputStream ob = null;

        try {
            //Initializes output and input stream with provided file, append for outputstream is set to true
            fileOut = new FileOutputStream("Sorted_Book_Info.txt", true);
            fileIn = new FileInputStream("Sorted_Book_Info.txt");

            //allows user to add however many records they'd like
            addRecords(fileOut);
            System.out.println();

            //Displays contents of file which is unsorted after user's addition
            System.out.println("File before sorting:");
            displayFileContents(fileIn);
            System.out.println();
            
            //Initializes bkArray with numofRecords to count lines
            bkArray = new Book[numOfRecords("Sorted_Book_Info.txt")];
            System.out.println("Storing book into array and sorting by ISBN\n");
            //Copies contents of file into bkArray
            copyIntoArray(bkArray, "Sorted_Book_Info.txt");
            //Prints the sorted bkArray
            System.out.println("Printing the sorted list of books by ISBN");
            for (int i = 0; i < bkArray.length; i++) {
                System.out.println(bkArray[i]);
            }

            //Users enters ISBN they wish to search for using both searches
            System.out.print("\nEnter the ISBN you want to find in the file: #");
            long ISBN = console.nextLong();

            //Binary Search with corresponding output
            int index = binaryBookSearch(bkArray, 0, bkArray.length - 1, ISBN);
            if (index == -1) {
                System.out.println("Binary search returned: -1. The ISBN was not found in the file");
            } else {
                System.out.println("The ISBN you were looking for is found at index " + index);
            }

            //Sequential Search
            sequentialBookSeach(bkArray, 0, bkArray.length, ISBN);

            //Stores to binary file with name given by user, utilizes method to write array of Books into binary file
            String gb = console.nextLine();
            System.out.print("\nEnter file name to store Book objects into binary file: ");
            String testBin = console.next() + ".ser";
            storeInBinaryFile(testBin, bkArray);
            ob = new ObjectInputStream(new FileInputStream(testBin));
            
            //Reads contents of binary file using ObjectInputStream, cast and Book's to String
            //Catches ClassNotFoundException thrown by readObject
            //EOF thrown by reading file until the end
            //IOException thrown by object streams
            System.out.println("\nHere are the contents of the binary file: ");
            try {
                while (true) {
                    System.out.println((Book) ob.readObject());
                }
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (EOFException e) {
                System.out.println("\nDone printing -- reached end of file");
                System.out.println("Thanks for using Book Inventory program! -- Program will now terminate");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
