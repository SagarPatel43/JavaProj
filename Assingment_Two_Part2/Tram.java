//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*Works similar to Metro class.*/
package CityPackage;

public class Tram  extends CityBus{
    
    private int maxSpeed;
    
    public Tram(){
        super();
        maxSpeed = 0;
    }
    
    public Tram(double price, int numStops, long routeNumber, int beginOpYear, String lineName, String driverName, int maxSpeed){
        super(price, numStops, routeNumber, beginOpYear, lineName, driverName);
        this.maxSpeed = maxSpeed;
    }
    
    public Tram(Tram copy){
        super(copy.getPrice(), copy.getNumStops(), copy.getRouteNumber(), copy.getBeginOpYear(), copy.getLineName(), copy.getDriverName());
        maxSpeed = copy.getMaxSpeed();
    }
    
    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }
    
    public int getMaxSpeed(){
        return maxSpeed;
    }
    
    public String toString(){
        return super.toString() + " With a max speed of " + maxSpeed + " km/h.";
    }
    
    public boolean equals(Object ob){
        if(this.getClass() != ob.getClass() || ob == null){
            return false;
        }
        Tram c = (Tram) ob;
        if(maxSpeed  == c.getMaxSpeed() && super.getRouteNumber() == c.getRouteNumber() && super.getBeginOpYear() == c.getBeginOpYear() &&
                super.getLineName().equals(c.getLineName()) && super.getDriverName().equals(c.getDriverName()) && super.getPrice() == c.getPrice() && super.getNumStops() == c.getNumStops()){
            return true;
        }else{
            return false;
        }
    }
    
    public Tram clone(){
        return new Tram(this);
    }
}