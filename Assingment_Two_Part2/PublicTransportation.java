//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*For part 2 the attributes of PublicTransportation are private, this means that child classes cannot access them directly and that they will
have to go through accessor and mutator methods to manipulate these variables.*/
package PublicTransportPackage;

public class PublicTransportation {

    private double price;
    private int numStops;

    public PublicTransportation() {
        price = 0.0;
        numStops = 0;
    }

    public PublicTransportation(double price, int numStops) {
        this.price = price;
        this.numStops = numStops;
    }

    public PublicTransportation(PublicTransportation copy) {
        this.price = copy.getPrice();
        this.numStops = copy.getNumStops();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    public double getPrice() {
        return price;
    }

    public int getNumStops() {
        return numStops;
    }

    public String toString() {
        return "This " + this.getClass().getSimpleName() + " has " + numStops + " stops, and costs " + price + ".";
    }

    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        PublicTransportation c = (PublicTransportation) ob;
        if (price == c.getPrice() && numStops == c.getNumStops()) {
            return true;
        } else {
            return false;
        }
    }

    //Method returning a new object that is a copy of the current class
    public PublicTransportation clone() {
        return new PublicTransportation(this);
    }

}
