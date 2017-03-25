//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*For part 2, even though this class is in the same package as CityBus, it must still use accessor/mutator methods since its parent class' attributes are private, this class'
own attributes being private remaims unchanged */
package CityPackage;

public class Metro extends CityBus {

    private int numOfVehicles;
    private String nameOfCity;

    public Metro() {
        super();
        numOfVehicles = 0;
        nameOfCity = null;
    }

    public Metro(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName, int numOfVehicles, String nameOfCity) {
        super(price, numStops, routeNumber, beginOpYear, lineName, driverName);
        this.numOfVehicles = numOfVehicles;
        this.nameOfCity = nameOfCity;
    }

    public Metro(Metro copy) {
        super(copy.getPrice(), copy.getNumStops(), copy.getRouteNumber(), copy.getBeginOpYear(), copy.getLineName(), copy.getDriverName());
        numOfVehicles = copy.getNumOfVehicles();
        nameOfCity = copy.getNameOfCity();
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
        if (numOfVehicles == c.getNumOfVehicles() && nameOfCity.equals(c.getNameOfCity()) && super.getRouteNumber() == c.getRouteNumber() && super.getBeginOpYear() == c.getBeginOpYear()
                && super.getLineName().equals(c.getLineName()) && super.getDriverName().equals(c.getDriverName()) && super.getPrice() == c.getPrice() && super.getNumStops() == c.getNumStops()) {
            return true;
        } else {
            return false;
        }
    }

    public Metro clone() {
        return new Metro(this);
    }
}
