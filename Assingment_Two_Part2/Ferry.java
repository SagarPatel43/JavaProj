//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*This class works in the same way as part 1 but it must go through public accessor and mutator methods whenever it wants to access the parent's attributes*/
package FerryPackage;

import PublicTransportPackage.*;

public class Ferry extends PublicTransportation {

    private int buildYear;
    private String shipName;

    //For these contructors we must use super() in order to go through the parent's public contructor and set its attributes
    public Ferry() {
        super();
        buildYear = 0;
        shipName = "";
    }

    public Ferry(double price, int numStops, int buildYear, String shipName) {
        super(price, numStops);
        this.buildYear = buildYear;
        this.shipName = shipName;
    }

    //Uses accessor methods to get the Ferry parameter's inherited attributes
    public Ferry(Ferry copy) {
        super(copy.getPrice(), copy.getNumStops());
        buildYear = copy.getBuildYear();
        shipName = copy.getShipName();
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

    public String toString() {
        return super.toString() + " The ship name is " + shipName + " and the year it was built is " + buildYear + ".";
    }

    //equals method has to use accessor methods for the super class as well as for the inherited attributes of the object parameter
    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        Ferry c = (Ferry) ob;
        if (shipName.equals(c.getShipName()) && buildYear == c.getBuildYear() && super.getPrice() == c.getPrice() && super.getNumStops() == c.getNumStops()) {
            return true;
        } else {
            return false;
        }
    }

    public Ferry clone() {
        return new Ferry(this);
    }
}
