//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*Works similarly to Ferry, enums must still be public since they would not be functional otherwise*/

package AirCraftPackage;
import PublicTransportPackage.*;

public class AirCraft extends PublicTransportation{
    
    public enum Crafts {Helicopter, Airline, Glider, Balloon};
    public enum Maintenance {Weekly, Monthly, Yearly};
    private Crafts craft;
    private Maintenance maint;
    
    public AirCraft(){
        super();
        craft = null;
        maint = null;
    }
    
    public AirCraft(Crafts craft, Maintenance maint, double price, int numStops){
        super(price, numStops);
        this.craft = craft;
        this.maint = maint;
    }
    
    public AirCraft(AirCraft copy){
        this.craft = copy.getCraft();
        this.maint = copy.getMaint();
        super.setPrice(copy.getPrice());
        super.setNumStops(copy.getNumStops());
    }
    
    public void setCraft(Crafts craft){
        this.craft = craft;
    }
    
    public void setMaint(Maintenance maint){
        this.maint = maint;
    }
    
    public Crafts getCraft(){
        return craft;
    }
    
    public Maintenance getMaint(){
        return maint;
    }
    
    public String toString(){
        return super.toString() + " It is the type " + craft + " and maintenace " + maint + ".";
    }
    
    public boolean equals(AirCraft ob){
        if(this.getClass() != ob.getClass() || ob == null){
            return false;
        }
        AirCraft c = (AirCraft) ob;
        if(craft == ob.getCraft() && maint == ob.getMaint() && super.getPrice() == c.getPrice() && super.getNumStops() == c.getNumStops()){
            return true;
        }else{
            return false;
        }
    }
    
    
    public AirCraft clone(){
        return new AirCraft(this);
    }
}
