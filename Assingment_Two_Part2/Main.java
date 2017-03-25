//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #2
//February 17, 2017

/*Same as part 1 Main but now contains the method CopyCityBuss which takes an input of a PublicTransportation array and returns an array of PublicTransportation containing
only the CityBuss from the parameter array.*/
package a2_40022733_40029417_part2;

import AirCraftPackage.*;
import CityPackage.*;
import FerryPackage.Ferry;
import PublicTransportPackage.*;

public class Main {

    //This method creates an array of PublicTransportation with the same length as array passed as parameter, to trace the array, it checks if the array at each index
    //is an instance of CityBus, if it is then it calls the clone method of that PublicTransportation to be set into the copy array (where clone() is essentially
    //returning a copy of the object using its copy constructor).
    //The nested for loop with counter is simply used to add to the copy array in order, and having the non-Citybuss at the end of the array
    public static PublicTransportation[] copyCityBuss(PublicTransportation[] array) {
        PublicTransportation[] copy = new PublicTransportation[array.length];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = counter; j < array.length; j++) {
                if (array[j] instanceof CityBus) {
                    copy[i] = array[j].clone();
                    counter++;
                    break;
                }
                counter++;
            }
        }
        return copy;
    }

    public static void main(String[] args) {
        
        //Creates array of PublicTransportation with length 12
        PublicTransportation[] arrayOfObj = new PublicTransportation[12];
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
        arrayOfObj[10] = new Tram(10.0, 25, 74, 1940, "Blue Line", "Billy", 150);
        arrayOfObj[11] = new Ferry(25.75, 10, 1960, "Fork lifter");

        //Sets array to returned array from copyCityBuss
        PublicTransportation[] cb = copyCityBuss(arrayOfObj);
        
        //Prints both arrays for comparison, where we can see that the copyCityBuss method works as intended
        for (int i = 0; i < arrayOfObj.length; i++) {
            System.out.println(arrayOfObj[i]);
        }
        
        System.out.println("");
        
        for (int i = 0; i < cb.length; i++) {
            System.out.println(cb[i]);
        }
        
        
        
        

    }
}
