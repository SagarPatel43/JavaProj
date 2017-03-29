package a4_40022733_40029417;

public class PartTimeFaculty extends Employee{
    
    private double hourlyRate;
    private int numHours;
    private int numStudents;
    
    public PartTimeFaculty(){
        super();
        hourlyRate = 0.0;
        numHours = 0;
        numStudents = 0;
    }
    
    public PartTimeFaculty(long employeeID, String firstName, String lastName, String cityResidence, int hireYear, double hourlyRate, int numHours, int numStudents){
        super(employeeID, firstName, lastName, cityResidence, hireYear);
        this.hourlyRate = hourlyRate;
        this.numHours = numHours;
        this.numHours = numStudents;
    }
    
    public void setHourlyRate(double hourlyRate){
        this.hourlyRate = hourlyRate;
    }
    
    public void setNumHours(int numHours){
        this.numHours = numHours;
    }
    
    public void setNumStudents(int numStudents){
        this.numStudents = numStudents;
    }
    
    public double getHourlyRate(){
        return hourlyRate;
    }
    
    public int getNumHours(){
        return numHours;
    }
    
    public int getNumStudents(){
        return numStudents;
    }
    
    
    public String toString() {
        return super.toString() + "\t" + numHours + "\t" + numStudents;
    }

}