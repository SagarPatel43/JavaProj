import java.text.DecimalFormat;

public class IceCreamStore {

    //Declare all instance variables
    private ShoppingCart cart = new ShoppingCart();
    private String[] main_options = {"Place an order", "Delete an order", "Price the cart", "List the cart", "Proceed to checkout", "Exit this menu"};
    private Menu main_menu = new Menu(main_options);
    private boolean running;
    private DecimalFormat df = new DecimalFormat("#.00");

    //Constructor with no parameters and sets the running variable to true
    public IceCreamStore() {
        running = true;
    }

    //Method to check the option user has chosen form the menu
    public void choices(int userChoice) {
        //Place an order option
        if (userChoice == 1) {
            if (!cart.isFull()) {
                placeOrder();
            }
        }
        //Delete an order option
        if (userChoice == 2) {
            if (!cart.isEmpty()) {
                deleteOrder();
            }
        }
        //Price the cart option
        if (userChoice == 3) {
            if (!cart.isEmpty()) {
                printTotalPrice();
            }
        }
        //List the cart option
        if (userChoice == 4) {
            if (!cart.isEmpty()) {
                reviewOrders();
            }
        }
        //Proceed to checkout option
        if (userChoice == 5) {
            if (!cart.isEmpty()) {
                checkout();
            }
        }
        //Exit this menu option
        if (userChoice == 6) {
            System.out.println("Cheers!");
            System.exit(0);
            running = false;
        }
    }

    //Method to place an order
    public void placeOrder() {
        //Instantiate a new order every time this method is called and add it to the cart
        IceCreamOrder order = new IceCreamOrder();
        cart.add(order);
        cart.toString();
    }

    //Method to delete an order
    public void deleteOrder() {
        //Create a exit menu string to add to the menu options
        String exit = "Exit this menu";
        //Declare and initialize a array of string to add the list of orders and add the exit option
        String[] element = new String[cart.size() + 1];
        //for loop to loop through the cart and add it to the options for this delete menu
        for (int i = 0; i < element.length; i++) {
            if (i == element.length - 1) {
                element[i] = exit;
            } else {
                element[i] = cart.get(i).toString();
            }
        }

        //Instantiate a delete menu object
        Menu delete_menu = new Menu(element);

        //Set the top message and top prompt message
        delete_menu.setTopMessage("You have selected to remove an order from your cart");
        delete_menu.setTopPrompt("What would you like to do?");
        delete_menu.setBottomMessage(null);

        //Get the user choice of item to delete
        int userChoice = delete_menu.getOptionNumber();

        //If the user chose the exit menu then ignore the deletion request
        //else remove the chosen item from the cart
        if (userChoice != cart.size() + 1) {
            cart.remove(userChoice - 1);
            System.out.println("The order you selected was deleted \n");
        }

    }

    //Method to compute the total price of the cart
    public double computeTotalPrice() {
        //Create a local variable
        double price = 0;
        //for loop to add all the prices for all the orders in the cart
        for (int i = 0; i < cart.size(); i++) {
            price += cart.get(i).price();
        }
        //Return the total price of the cart
        return price;
    }

    //Method to print the total price of the cart
    public void printTotalPrice() {
        System.out.println("Total price of all your orders in the cart : $" + df.format(computeTotalPrice()));
    }

    //Method to list the items in the cart
    public void reviewOrders() {
        System.out.println("-----------------------------------------------------");
        //Print each element in the cart
        System.out.print(cart.toString());
        System.out.println("-----------------------------------------------------\n");
    }

    //Method to proceed to checkout
    public void checkout() {
        System.out.println("Your current selections of our scrumptious ice creams\n"
                + "-----------------------------------------------------");
        //for loop to print each element in the cart
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).toString());
        }
        System.out.println("-----------------------------------------------------\n"
                + " - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -=");
        //print total price of the cart
        printTotalPrice();
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -=\n");

    }

    //Method to keep the main menu looping until specified by the user to exit
    public void run() {
        //While the running variable is true it will continue to loop until user enters option 6 which sets running to false and exits the program
        while (running) {
            //Create a local variable to store the user choice
            int temp = 0;

            //If the cart is empty
            if (cart.isEmpty()) {
                main_menu.setTopMessage("Your Shopping Cart is empty.");
                main_menu.setTopPrompt("You have only two options : 1 or 6");
                main_menu.setBottomMessage("Please enter 1 or 6");
                //If the cart is full
            } else if (cart.isFull()) {
                main_menu.setTopMessage("Your Shopping Cart is full with 5 ice cream orders.");
                main_menu.setTopPrompt("Cannot place orders ! what would you like to do?");
                main_menu.setBottomMessage("Please select option 2 , 3 , 4 , 5 , or 6");
                //If the cart is neither full nor empty
            } else if (!cart.isFull() || !cart.isEmpty()) {
                main_menu.setTopMessage("Your shopping cart contains " + cart.size() + " ice cream order");
                main_menu.setTopPrompt("What would you like to do?");
                main_menu.setBottomMessage(null);
            }
            temp = main_menu.getOptionNumber();

            //Correspond the choices with the correct actions
            choices(temp);
        }
    }
}
