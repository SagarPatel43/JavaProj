//Kevin Tan 40022733, Sagar Patel 40029417
//COMP249
//Assignment #3
//March 14, 2017

/*
Book class with all the attributes stored in a Book Inventory, includes no argument constructor and parametrized constructor to create Book objects in BookInventory, set and get methods
for each attribute, a toString method, and an equals method.
 */
package a3_40022733_40029417_part1;

public class Book {

    protected long ISBN;
    protected String title, author;
    protected int issueYear, numPages;
    protected double price;

    public Book() {
        ISBN = 0;
        title = "";
        author = "";
        issueYear = 0;
        numPages = 0;
        price = 0.0;
    }

    public Book(long ISBN, String title, int issueYear, String author, double price, int numPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.issueYear = issueYear;
        this.numPages = numPages;
        this.price = price;
    }

    public void setISBN(long ISBN){
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return ISBN + " " + title + " " + issueYear + " " + author + " " + price + " " + numPages;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public int getNumPages() {
        return numPages;
    }

    public double getPrice() {
        return price;
    }

    public boolean equals(Object ob) {
        if (this.getClass() != ob.getClass() || ob == null) {
            return false;
        }
        Book c = (Book) ob;
        if (ISBN == c.ISBN && title == c.title && issueYear == c.issueYear && author == c.author && price == c.price && numPages == c.numPages) {
            return true;
        } else {
            return false;
        }
    }
}
