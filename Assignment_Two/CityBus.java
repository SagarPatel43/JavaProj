//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class extends the PublicTransportation class and serves as a parent class to several other classes within its package which will inherit its attributes. Similar to
PublicTransportation, its attributes are protected to allow them to be inherited, and it can access PublicTransportation's attributes directly since it is a child.
 */
package CityPackage;

import PublicTransportPackage.*;

public class CityBus extends PublicTransportation {

    protected long routeNumber;
    protected int beginOpYear;
    protected String lineName;
    protected String driverName;

    public CityBus() {
        price = 0;
        numStops = 0;
        routeNumber = 0;
        beginOpYear = 0;
        lineName = "";
        driverName = "";
    }

    public CityBus(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName) {
        this.price = price;
        this.numStops = numStops;
        this.routeNumber = routeNumber;
        this.beginOpYear = beginOpYear;
        this.lineName = lineName;
        this.driverName = driverName;
    }

    public CityBus(CityBus copy) {
        price = copy.price;
        numStops = copy.numStops;
        routeNumber = copy.routeNumber;
        beginOpYear = copy.beginOpYear;
        lineName = copy.lineName;
        driverName = copy.driverName;
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
        if (routeNumber == c.routeNumber && beginOpYear == c.beginOpYear && lineName.equals(c.lineName) && driverName.equals(c.driverName) && price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }
}
