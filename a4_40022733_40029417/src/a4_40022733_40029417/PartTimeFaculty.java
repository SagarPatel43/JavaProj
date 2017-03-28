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
        return "This part time faculty member is " + lastName + ", " + firstName + " lives in " + cityResidence + ", was hired in " + hireYear + ", has a hourly salary of"
                + hourlyRate + " and has " + numHours +" hours and has" + numStudents +" students";
    }

    public boolean equals(Object ob) {
        if (ob.getClass() != this.getClass() || ob == null) {
            return false;
        }
        PartTimeFaculty e = (PartTimeFaculty) ob;
        if (super.equals(e) && e.hourlyRate == hourlyRate && e.numHours == numHours && e.numStudents == numStudents) {
            return true;
        }
        return false;
    }
}
