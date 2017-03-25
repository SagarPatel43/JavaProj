//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #3
//March 14, 2017

/*Exception class for when File already exists, contains no argument constructor, parametrized constructor, and overridden getMessage method(super is used in both constructors and method since this is
extending the Exception class) -- parametrized constructor takes a File as a parameter in order to obtain its name and size, which is set as the message for this exception.
*/
package a3_40022733_40029417_part1;

import java.io.File;

public class FileAlreadyExistException extends Exception{
    
    
    public FileAlreadyExistException(){
        super("Error. There is an existing file");
    }
    
    public FileAlreadyExistException(File message){
        super("Error. There is an existing file called: " + message.getName() + "\n"
                + "That file already has a size of " + message.length() +" bytes.");
    }
    
    public String getMessage(){
        return super.getMessage();
    }
    
}