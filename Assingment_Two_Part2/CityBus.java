//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*For part 2, this class has to access PublicTransportation's attributes in a similar fashion(through accessors/mutators) and additionally since it will be
a parent class, its child classes will have to go through the same.*/
package CityPackage;

import PublicTransportPackage.*;

public class CityBus extends PublicTransportation {

    private long routeNumber;
    private int beginOpYear;
    private String lineName;
    private String driverName;

    public CityBus() {
        super();
        routeNumber = 0;
        beginOpYear = 0;
        lineName = "";
        driverName = "";
    }

    public CityBus(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName) {
        super(price, numStops);
        this.routeNumber = routeNumber;
        this.beginOpYear = beginOpYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    public CityBus(CityBus copy) {
        super(copy.getPrice(), copy.getNumStops());
        this.routeNumber = copy.getRouteNumber();
        this.beginOpYear = copy.getBeginOpYear();
        this.lineName = copy.getLineName();
        this.driverName = copy.getDriverName();
    }

    public void setRouteNumber(long routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setBeginOpYear(int beginOpYear) {
        this.beginOpYear = beginOpYear;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getRouteNumber() {
        return routeNumber;
    }

    public int getBeginOpYear() {
        return beginOpYear;
    }

    public String getLineName() {
        return lineName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String toString() {
        return super.toString() + " The route number is " + routeNumber + ", beginning operation year is " + beginOpYear + ", the line name is " + lineName + " and driver name is " + driverName + ".";
    }

    public boolean equals(CityBus ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        CityBus c = (CityBus) ob;
        if (routeNumber == c.getRouteNumber() && beginOpYear == c.getBeginOpYear() && lineName.equals(c.getLineName()) && driverName.equals(c.getDriverName()) && super.getPrice() == c.getPrice()
                && super.getNumStops() == c.getNumStops()) {
            return true;
        } else {
            return false;
        }
    }

    public CityBus clone() {
        return new CityBus(this);
    }
}
