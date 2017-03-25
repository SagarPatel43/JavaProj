public class ShoppingCart {

    //Declare all instance variables
    private IceCreamOrder[] cart;
    private int counter = 0;

    //Constructor taking no parameter and initializes the array of IceCreamOrder object to 5 
    public ShoppingCart() {
        //Initiliazing the array of IceCreamOrder toa max of 5 orders
        cart = new IceCreamOrder[5];
    }

    //A method to add ice cream orders to the array
    public void add(IceCreamOrder order) {
        //If there are 5 items print an error
        if (counter > 5) {
            System.out.println("Error cart is full");
        } else {
            //If cart isn't full add the item at an index where it is null and increment the counter
            for (int i = 0; i < cart.length; i++) {
                if (cart[i] == null) {
                    cart[i] = order;
                    counter++;
                    break;
                }
            }
        }
    }

    //A method to remove ice creams orders in the array
    public void remove(int position) {
        /*If the user wants to remove an item that doesn't exist or inputs an index grater than or less than the array 
        of IceCreamOrders print an error*/
        if (cart[position] == null || position > cart.length - 1 || position < 0) {
            System.out.println("Error, cart is empty or it is not an item in the cart");
        } else {
            //If not then remove it at the specific index in the array and then decrement the counter
            cart[position] = null;
            counter--;
            //Reorganize the array
            organizeArray();
        }
    }

    //A method to reorganize the array after deleteing an item
    private void organizeArray() {
        //for loop to move the array up
        for (int i = 0; i < cart.length; i++) {
            //Declare a local variable to hold a temporary order
            IceCreamOrder temp;
            //Find the first null element in the index
            if (cart[i] == null) {
                temp = cart[i];
                //After compare that element with the resting element, and swap with the first non-null element and break
                for (int j = i + 1; j < cart.length; j++) {
                    if (cart[j] != null) {
                        cart[i] = cart[j];
                        cart[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    //A method to format a string to print the size of the shopping cart
    public String toString() {
        String temp = "";
        for (int i = 0; i < size(); i++) {
            temp += get(i) + "\n";
        }
        return temp;
    }

    //A method to check if the shopping cart is empty
    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        } else {
            return false;
        }
    }

    //A method to check if the shopping cart is full
    public boolean isFull() {
        if (counter == 5) {
            return true;
        } else {
            return false;
        }
    }

    //A method to get the specific ice cream order in the array
    public IceCreamOrder get(int position) {
        //If user try to get a ice cream order out greater or less than the arrray length print an error and return null
        if (position > cart.length - 1 || position < 0) {
            System.out.println("Error out of range");
            return null;
        } else {
            //Otherwise return the speicified ordera at that index
            return cart[position];
        }
    }

    //A method to get the size of the shopping cart
    public int size() {
        return counter;

    }
}
