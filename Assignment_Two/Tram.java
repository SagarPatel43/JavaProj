//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class works in the same way as the Metro class with its own attributes.
 */
package CityPackage;

public class Tram extends CityBus {

    private int maxSpeed;

    public Tram() {
        price = 0;
        numStops = 0;
        routeNumber = 0;
        beginOpYear = 0;
        lineName = "";
        driverName = "";
        maxSpeed = 0;
    }

    public Tram(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName, int maxSpeed) {
        this.price = price;
        this.numStops = numStops;
        this.routeNumber = routeNumber;
        this.beginOpYear = beginOpYear;
        this.lineName = lineName;
        this.driverName = driverName;
        this.maxSpeed = maxSpeed;
    }

    public Tram(Tram copy) {
        price = copy.price;
        numStops = copy.numStops;
        routeNumber = copy.routeNumber;
        beginOpYear = copy.beginOpYear;
        lineName = copy.lineName;
        driverName = copy.driverName;
        maxSpeed = copy.maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String toString() {
        return super.toString() + " With a max speed of " + maxSpeed + " km/h.";
    }

    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        Tram c = (Tram) ob;
        if (maxSpeed == c.maxSpeed && routeNumber == c.routeNumber && beginOpYear == c.beginOpYear && lineName.equals(c.lineName)
                && driverName.equals(c.driverName) && price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }
}
