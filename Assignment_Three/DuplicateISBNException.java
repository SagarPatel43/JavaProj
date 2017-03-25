//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #3
//March 14, 2017

/*Exception class for Duplicate ISBNs, contains no argument constructor, parametrized constructor, and overridden getMessage method(super is used in both constructors and method since this is
extending the Exception class)
*/
package a3_40022733_40029417_part1;

public class DuplicateISBNException extends Exception{
    
    public DuplicateISBNException(){
        super("Error, there are two books with the same ISBN");
    }
    
    public DuplicateISBNException(String message){
        super(message);
    }
    
    public String getMessage(){
        return super.getMessage();
    }
}
