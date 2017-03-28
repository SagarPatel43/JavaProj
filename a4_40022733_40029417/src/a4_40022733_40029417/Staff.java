package a4_40022733_40029417;

public class Staff extends Employee{
    
    private double salary;
    private char performanceCode;

    public Staff() {
        super();
        salary = 0.0;
        performanceCode = ' ';
    }

    public Staff(long employeeID, String firstName, String lastName, String cityResidence, int hireYear, double salary, char performanceCode) {
        super(employeeID, firstName, lastName, cityResidence, hireYear);
        this.salary = salary;
        this.performanceCode = performanceCode;
    }

    public Staff(Staff copy) {
        super(copy);
        salary = copy.salary;
        performanceCode = copy.performanceCode;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public void setPerfCode(char performanceCode){
        this.performanceCode = performanceCode;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public char getPerfCode(){
        return performanceCode;
    }
    
    public String toString() {
        return "This staff member is " + lastName + ", " + firstName + " lives in " + cityResidence + ", was hired in " + hireYear + " with a salary of"
                + salary + " and a performance code of " + performanceCode;
    }

    public boolean equals(Object ob) {
        if (ob.getClass() != this.getClass() || ob == null) {
            return false;
        }
        Staff e = (Staff) ob;
        if (super.equals(e) && e.salary == salary && e.performanceCode == performanceCode) {
            return true;
        }
        return false;
    }   
}
