// -------------------------------------------------------
// Assignment 4
// Written by: Kevin Tan, 40022733
// For COMP 248 Section P Fall 2016
// --------------------------------------------------------

public class Main {
    /*
        This program prompts users a menu with 6 different options. When their shopping cart is empty, the program will only allow users to place an order, or to 
        exit the program. When the cart is full, the user will no longer be able to place an order, only options 2 to 6 will be available. At any time other than
        the cart being empty, users are able to check the price of their cart, delete an items, list the items in the cart, proceed to checkout and exit the program.
        When users place an order, they are then prompted a new menu, with 9 different flavour they can choose, followed by the vessel for the ice cream, then the amount
        of ice cream and lastly the amount of orders of that ice cream. When users delete an item, another menu is prompted, to delete the items from their current cart 
        or to return to the main menu. When users choose to price the cart, the program will list the total price of the cart. When users choose to list the cart of all
        items orders,the ice cream amount, vessel type, ice cream flavour, as well as their total price of that order will be listed in a list along with all the other orders.
        When the program terminates, the console will print a closing message.
    */
    public static void main(String[] args) {
        System.out.println("\tWelcome the CreamyIce Company's online store\n"
                + "Please start by filling up your cart, enjoy your ice creams!\n");
        IceCreamStore shop = new IceCreamStore();
        shop.run();
    }
}