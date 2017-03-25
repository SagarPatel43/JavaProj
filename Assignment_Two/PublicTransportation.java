//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class serves as a parent class to several other classes which will inherit its attributes, it contains a default, parametrized, and copy contructor, as well as 
accessor and mutator methods, along with overriden equals and toString methods. All of its methods are public but its variable are protected to allow its child classes
to inherit these attributes.
 */
package PublicTransportPackage;

public class PublicTransportation {

    protected double price;
    protected int numStops;

    //Default constructor, initializes variables
    public PublicTransportation() {
        price = 0.0;
        numStops = 0;
    }

    //Parametrized constructor
    public PublicTransportation(double price, int numStops) {
        this.price = price;
        this.numStops = numStops;
    }

    //Copy constructor
    public PublicTransportation(PublicTransportation copy) {
        price = copy.price;
        numStops = copy.numStops;
    }

    //Mutator methods
    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    //Accessor methods
    public double getPrice() {
        return price;
    }

    public int getNumStops() {
        return numStops;
    }

    //Overrides toString method to print attributes of class
    public String toString() {
        return "This " + this.getClass().getSimpleName() + " has " + numStops + " stops, and costs " + price + ".";
    }

    //Overrides equals method to verify whether both objects have equal attributes
    //Verifies that classes being compared are the same class
    //Verifies that object being passed as a parameter is not null to prevent program from crashing at runtime - with this verified, object gets cast as relevent object
    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        PublicTransportation c = (PublicTransportation) ob;
        if (price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }

}
