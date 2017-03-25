//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*
This class works similarly to the Ferry class, with the exception of its enums which are public, the reason for this is that enums are static and final classes, therefore
in order to be shared with the Main method to pass attributes contained in the enum as parameters, they would have to be public.
 */
package AirCraftPackage;

import PublicTransportPackage.*;

public class AirCraft extends PublicTransportation {

    public static enum Crafts {
        Helicopter, Airline, Glider, Balloon
    };

    public static enum Maintenance {
        Weekly, Monthly, Yearly
    };
    //Private attributes of the enums defined above
    private Crafts craft;
    private Maintenance maint;

    public AirCraft() {
        price = 0;
        numStops = 0;
        craft = null;
        maint = null;
    }

    public AirCraft(Crafts craft, Maintenance maint, double price, int numStops) {
        this.price = price;
        this.numStops = numStops;
        this.craft = craft;
        this.maint = maint;
    }

    public AirCraft(AirCraft copy) {
        craft = copy.craft;
        maint = copy.maint;
        price = copy.price;
        numStops = copy.numStops;
    }

    public void setCraft(Crafts craft) {
        this.craft = craft;
    }

    public void setMaint(Maintenance maint) {
        this.maint = maint;
    }

    public Crafts getCraft() {
        return craft;
    }

    public Maintenance getMaint() {
        return maint;
    }

    public String toString() {
        return super.toString() + " It is the type " + craft + " and maintenace " + maint + ".";
    }

    public boolean equals(AirCraft ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        AirCraft c = (AirCraft) ob;
        if (craft == ob.craft && maint == ob.maint && price == c.price && numStops == c.numStops) {
            return true;
        } else {
            return false;
        }
    }

}
