//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*The Main class is used to test whether all the constructors work correctly, if the equals methods gives the correct output, if the toString methods work,
and to create an array of PublicTransportation and trace through it to find the object that is least expensive and most expensive.*/
package a2_40022733_40029417;

import AirCraftPackage.*;
import CityPackage.*;
import FerryPackage.Ferry;
import PublicTransportPackage.*;

public class Main {

    public static void main(String[] args) {

        PublicTransportation ob1 = new PublicTransportation(10.0, 5);
        CityBus ob2 = new CityBus();
        CityBus ob21 = new CityBus(ob2);
        Ferry ob3 = new Ferry(25.75, 10, 1960, "Fork lifter");
        AirCraft ob4 = new AirCraft(AirCraft.Crafts.Helicopter, AirCraft.Maintenance.Weekly, 700.0, 1);
        Metro ob5 = new Metro(3.50, 14, 87, 1860, "Green Line", "John Bob", 7, "Montreal");
        Tram ob6 = new Tram(10.0, 25, 74, 1940, "Blue Line", "Billy", 150);

        //Tests if the above objects are equal
        System.out.println(ob1.equals(ob2));
        System.out.println(ob3.equals(ob4));
        System.out.println(ob4.equals(ob5));
        System.out.println(ob5.equals(ob1));
        System.out.println(ob21.equals(ob2));
        System.out.println(ob6.equals(ob2));

        //Creates array of PublicTransportation and sets each index to a different PublicTransportation
        PublicTransportation[] arrayOfObj = new PublicTransportation[10];
        arrayOfObj[0] = new CityBus(100, 4, 45, 2185, "Blue Line", "Sally");
        arrayOfObj[1] = new Ferry(30.0, 5, 1970, "Titanic");
        arrayOfObj[2] = new AirCraft(AirCraft.Crafts.Balloon, AirCraft.Maintenance.Yearly, 5, 2);
        arrayOfObj[3] = new Metro(7, 4, 77, 1960, "Orange Line", "John Cena", 1, "Montreal");
        arrayOfObj[4] = new Tram(17.50, 2, 4, 1970, "Yellow Line", "Jim", 999);
        arrayOfObj[5] = new Ferry(100.0, 5, 1970, "Flash");
        arrayOfObj[6] = new Metro(3.5, 4, 77, 1960, "Red Line", "John", 1, "Montreal");
        arrayOfObj[7] = new Tram((Tram) arrayOfObj[4]);
        arrayOfObj[8] = new AirCraft(AirCraft.Crafts.Helicopter, AirCraft.Maintenance.Yearly, 700, 2);
        arrayOfObj[9] = new CityBus(1.5, 2, 66, 2010, "Purple Line", "Bill");

        //Uses each objects toString method
        for (int i = 0; i < arrayOfObj.length; i++) {
            System.out.println(arrayOfObj[i]);
        }

        System.out.println();

        //Initializes mostExp,leastExp object
        PublicTransportation mostExp = arrayOfObj[0];
        PublicTransportation leastExp = arrayOfObj[0];
        //Traces through the array of PublicTransportation, and if the price of current index object is greater than currently stored mostExp object, mostExp is replaced
        //(getPrice() method is used to compare prices)
        for (int i = 1; i < arrayOfObj.length; i++) {
            if (mostExp.getPrice() < arrayOfObj[i].getPrice()) {
                mostExp = arrayOfObj[i];
            }
            if (leastExp.getPrice() > arrayOfObj[i].getPrice()) {
                leastExp = arrayOfObj[i];
            }
        }

        //Prints result with toString
        System.out.println(mostExp);
        System.out.println(leastExp);
    }
}
