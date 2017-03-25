//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class extends the CityBus class which extends the PublicTransportation class, this means that it inherits both of their attributes and methods. It accesses all of the
attributes it inherits directly since they are protected, and also overrides the toString and equals method inherited. Note that Metro is in the same package as 
CityBus, therefore it does not need to import any packages since its inherited class, CityBus, takes care of it.
 */
package CityPackage;

public class Metro extends CityBus {

    private int numOfVehicles;
    private String nameOfCity;

    public Metro() {
        price = 0;
        numStops = 0;
        routeNumber = 0;
        beginOpYear = 0;
        lineName = "";
        driverName = "";
        numOfVehicles = 0;
        nameOfCity = "";
    }

    public Metro(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName, int numOfVehicles, String nameOfCity) {
        this.price = price;
        this.numStops = numStops;
        this.routeNumber = routeNumber;
        this.beginOpYear = beginOpYear;
        this.lineName = lineName;
        this.driverName = driverName;
        this.numOfVehicles = numOfVehicles;
        this.nameOfCity = nameOfCity;
    }

    public Metro(Metro copy) {
        price = copy.price;
        numStops = copy.numStops;
        routeNumber = copy.routeNumber;
        beginOpYear = copy.beginOpYear;
        lineName = copy.lineName;
        driverName = copy.driverName;
        numOfVehicles = copy.numOfVehicles;
        nameOfCity = copy.nameOfCity;
    }

    public void setNumOfVehicles(int numOfVehicles) {
        this.numOfVehicles = numOfVehicles;
    }

    public void setNameOfCity(String nameOfCity) {
        this.nameOfCity = nameOfCity;
    }

    public int getNumOfVehicles() {
        return numOfVehicles;
    }

    public String getNameOfCity() {
        return nameOfCity;
    }

    public String toString() {
        return super.toString() + " It has " + numOfVehicles + " number of vehicles and in the city of " + nameOfCity + ".";
    }

    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        Metro c = (Metro) ob;
        if (numOfVehicles == c.numOfVehicles && nameOfCity.equals(c.nameOfCity) && routeNumber == c.routeNumber && beginOpYear == c.beginOpYear && lineName.equals(c.lineName)
                && driverName.equals(c.driverName) && price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }
}
