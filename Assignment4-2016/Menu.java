import java.util.Scanner;

public class Menu {
    
    //Declare all instance variables
    private Scanner console = new Scanner(System.in);
    private String[] options;
    private String openingMessage;
    private String topPrompt;
    private String closingMessage;
    private String bottomPrompt;
    
    //Constructor which takes a array of String as an parameter and initializes the instance variables
    public Menu(String[] options) {
        this.options = options.clone();
        openingMessage = null;
        closingMessage = null;
        topPrompt = "Choose an option: ";
        bottomPrompt = "Enter an option number: ";
    }
    
    //Constructor which takes no parameters and initializes all instance variables to null
    public Menu() {
        options = null;
        openingMessage = null;
        topPrompt = null;
        closingMessage = null;
        bottomPrompt = null;
    }
    
    //Method to check if the array of String is empty
    public boolean isEmpty() {
        if (options == null) {
            return true;
        } else {
            return false;
        }
    }
    
    //Method to get the length of the array of String
    public int length() {
        if (isEmpty()) {
            return 0;
        } else {
            return options.length;
        }
    }
    
    //Method to get the print format for the array of Strings
    public String printOptions() {
        String temp = "";
        //Only format the array of string is its not empty
        if (!isEmpty()) {
            //for-loop to print every single element in the string
            for (int i = 0; i < options.length; i++) {
                temp += "   (" + (i + 1) + ") " + options[i] + "\n";
            }
        }
        //Return the formatted string
        return temp;
    }
    
    //Method to get the formatted menu display to print
    public String toString() {
        String opening = openingMessage + "\n";
        String top = topPrompt + "\n";
        String optionPrint = printOptions();
        String closing = closingMessage + "\n";
        String bottom = "?-> " + bottomPrompt;

        String temp2 = opening + top + optionPrint + closing + bottom;
        
        //Return the formatted array without the null
        return temp2.replaceAll("null", "");
    }
    
    //Setter method for the top prompt message in the menu
    public void setTopPrompt(String prompt) {
        this.topPrompt = prompt;
    }
    
    //Getter method for the top prompt message in the menu
    public String getTopPrompt() {
        return this.topPrompt;
    }
    
    //Setter method for the bottom prompt message in the menu
    public void setBottomPrompt(String prompt) {
        this.bottomPrompt = prompt;
    }
    
    //Getter method for the bottom prompt message in the menu
    public String getBottomPrompt() {
        return this.bottomPrompt;
    }
    
    //Setter method for the top message in the menu
    public void setTopMessage(String message) {
        this.openingMessage = message;
    }
    
    //Getter method for the top message in the menu
    public String getTopMessage() {
        return this.openingMessage;
    }
    
    //Setter method for the bottom message in the menu
    public void setBottomMessage(String message) {
        this.closingMessage = message;
    }
    
    //Getter method for the bottom message in the menu
    public String getBottomMessage() {
        return this.closingMessage;
    }
    
    //Method to print out the menu prompt, messsages and options
    //as well as to get user input and check if its between 1 and N and return the choice
    public int getOptionNumber() {       
        int userChoice = 0;
        
        //Only check if the option length is not 0
        if (length() != 0) {
            //Prompt user to enter an option 
            System.out.print(toString().trim().replaceAll("(?m)^[ \\t]*\\r?\\n", ""));
            userChoice = console.nextInt();
            
            //while loop to make sure the number isn't less than 1 or greater than N
            while(userChoice > length() || userChoice < 1){
                //If it is reprint the options and reprompt users to input another value from 1 to N
                System.out.println("You entered: " + userChoice + ". It must be at a range form [1,"+ length() +"]\n");
                System.out.print(toString().trim().replaceAll("(?m)^[ \\t]*\\r?\\n", ""));
                userChoice = console.nextInt();
            }
            System.out.println();
        } else {
            //If the length is 0, then just return the number itself
            System.out.print(toString());
            userChoice = console.nextInt();
        }
        return userChoice;
    }
}