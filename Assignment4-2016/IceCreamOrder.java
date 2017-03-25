import java.text.DecimalFormat;

public class IceCreamOrder {
    
    //Declare all instance variables
    private String flavor;
    private String vessel;
    private String amount;
    private double unitPrice;
    private int quantity;
    private DecimalFormat df = new DecimalFormat("#.00");
    
    //Constructor which takes no parameters but takes users input instead
    public IceCreamOrder() {
        //Declare and initialize the flavor menu options
        String[] flavor_menu = {"Avocado", "Banana", "Chocolate", "Coffee", "Hazelnut", "Lemon", "Mango", "Mocha", "Vanilla"};
       
        //Instantiate the menu class to create the flavour menu
        Menu firstMenu = new Menu(flavor_menu);
       
        //Set the top and bottom message and top prompt of this flavor menu
        firstMenu.setTopMessage(" Placing an order is as easy as ABC , and D.");
        firstMenu.setBottomMessage(null);
        firstMenu.setTopPrompt("Step A: Select your favorite flavour");
       
        //Get the user choice of flavour
        int firstChoice = firstMenu.getOptionNumber(); 
        
        //Set flavor to the user's choice of flavor
        this.flavor = flavor_menu[firstChoice - 1];
        
        //Declare and initialize the vessel menu options
        String[] vessel_menu = {"Cone", "Cup", "Sundae"};
        
        //Instantiate the menu class to create the vessel menu
        Menu vesselMenu = new Menu(vessel_menu);
        
        //Set the top and bottom message and top prompt of this vessel menu
        vesselMenu.setTopMessage(null);
        vesselMenu.setTopPrompt("Step B: Select a vessel for your ice cream :");
        vesselMenu.setBottomMessage(null);
        
        //Get the user choice of vessel
        int vesselChoice = vesselMenu.getOptionNumber();
        
        //Set vessel to the user's choice of vessel
        this.vessel = vessel_menu[vesselChoice - 1];
        
        //Declare and initialize the amount menu options
        String[] amount_menu = {"Single Scoop", "Double Scoop", "Triple Scoop"};
        
        //Instantiate the menu class to create the amount menu
        Menu amountMenu = new Menu(amount_menu);
        
        //Set the top and bottom message and top prompt of this amount menu
        amountMenu.setTopMessage(null);
        amountMenu.setTopPrompt("Step C: How much ice cream ?");
        amountMenu.setBottomMessage(null);
        
        //Get the user choice of the amount of ice cream
        int amountChoice = amountMenu.getOptionNumber();
        
        //Set the amount of ice cream to the user's choice of amount
        this.amount = amount_menu[amountChoice - 1];

        //Declare and initialize the quantity menu options
        String[] quantity_menu = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        
        //Instantiate the menu class to create the quantity menu
        Menu fourthMenu = new Menu(quantity_menu);
        
        //Set the top and bottom message, top and bottom prompt of this amount menu
        fourthMenu.setTopMessage(null);
        fourthMenu.setTopPrompt("Step D: how many orders of your current selection ?");
        fourthMenu.setBottomMessage(null);
        fourthMenu.setBottomPrompt("Enter how many orders : ");
        
        //Get the user choice of the quantity of orders
        int quantityChoice = fourthMenu.getOptionNumber();
        
        //Set the quantity of ice cream orders to the user's choice of orders
        this.quantity = quantityChoice;
        
        //Declare and initialize the unit prices for the vessels
        double[][] prices = {{3.49, 4.49, 5.49},
        {2.99, 3.99, 4.99},
        {4.25, 5.25, 6.25}};
        
        //Set the unitPrice according vessel and the amount of ice cream
        this.unitPrice = prices[vesselChoice - 1][amountChoice - 1];
    }
    
    //Constructor which takes 5 parameters and initializing each instance variables to them
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice, int quantity) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    
    //Constructor which takes 4 parameters and initilizes them to the parameters and sets quantity to 1
    public IceCreamOrder(String flavor, String vessel, String amount, double unitPrice) {
        this.flavor = flavor;
        this.vessel = vessel;
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.quantity = 1;
    }
    
    //A method to get a formatted string to print the ice cream order
    public String toString() {
        String temp = quantity + " orders of " + this.amount + " of " + this.flavor + " ice cream in a " + this.vessel + " for \n\t$" + df.format(price()) + " = " + this.quantity + " x " + this.unitPrice;
        return temp;
    }
    
    //A method to get the price of the order
    public double price() {
        return this.quantity * this.unitPrice;
    }
    
    //A setter method to set the flavor of the ice cream
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    
    //A getter method to set the flavor of the ice cream
    public String getFlavor() {
        return this.flavor;
    }
    
    //A setter method to set the vessel type
    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    //A getter method to get the vessel type
    public String getVessel() {
        return this.vessel;
    }
    
    //A setter method to set the amount of ice creams
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    //A getter method to get the amount of ice creams
    public String getAmount() {
        return this.amount;
    }
    
    //A setter method to set the unit price
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    //A getter method to get the unit price
    public double getUnitPrice() {
        return this.unitPrice;
    }
    
    //A setter method to set the quantity 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //A getter method to get the quantity
    public int getQuantity() {
        return this.quantity;
    }
}