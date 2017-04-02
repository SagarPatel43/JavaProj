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
        return super.toString() + String.format("%-7.0f %-7c", salary, performanceCode);
    }
  
}