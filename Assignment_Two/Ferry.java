//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class extends the PublicTransportation class therefore it inherits its attributes and methods, note that its variables are private to encourage encapsulation 
since this class will not be extended, additionally it overrides the toString and equals methods for its own implementation. This class is also in a seperate package
from PublicTransportation but this is not an issue since its package is imported, with its class extended, and PublicTransportation has protected variables.
 */
package FerryPackage;

import PublicTransportPackage.*;

public class Ferry extends PublicTransportation {

    private int buildYear;
    private String shipName;

    //This class can directly access PublicTransportation's protected variables since it is a child
    public Ferry() {
        price = 0;
        numStops = 0;
        buildYear = 0;
        shipName = "";
    }

    public Ferry(double price, int numStops, int buildYear, String shipName) {
        this.price = price;
        this.numStops = numStops;
        this.buildYear = buildYear;
        this.shipName = shipName;
    }

    public Ferry(Ferry copy) {
        price = copy.price;
        numStops = copy.numStops;
        buildYear = copy.buildYear;
        shipName = copy.shipName;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public String getShipName() {
        return shipName;
    }

    //Uses super.toString() to call parent's toString method since it has been overridden
    public String toString() {
        return super.toString() + " The ship name is " + shipName + " and the year it was built is " + buildYear + ".";
    }

    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        Ferry c = (Ferry) ob;
        if (shipName.equals(c.shipName) && buildYear == c.buildYear && price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }
}
