package a4_40022733_40029417;

public class TeachingAssistant extends Employee{
    
    private String classification;
    private int numClass;
    private int totalWorkingHours;
    
    public TeachingAssistant(){
        super();
        classification = "";
        numClass = 0;
        totalWorkingHours = 0;
    }
    
    public TeachingAssistant(long employeeID, String firstName, String lastName, String cityResidence, int hireYear, String classification, int numClass, int totalWorkingHours){
        super(employeeID, firstName, lastName, cityResidence, hireYear);
        this.classification = classification;
        this.numClass = numClass;
        this.totalWorkingHours = totalWorkingHours;
    }
    
    public TeachingAssistant(TeachingAssistant copy){
        super(copy);
        classification = copy.classification;
        numClass = copy.numClass;
        totalWorkingHours = copy.totalWorkingHours;
    }
    
    public void setClassification(String classification){
        this.classification = classification;
    }
    
    public void setNumClass(int numClass){
        this.numClass = numClass;
    }
    
    public void setTotalWorkingHours(int totalWorkingHours){
        this.totalWorkingHours = totalWorkingHours;
    }
    
    public String getClassification(){
        return classification;
    }
    
    public int getNumClass(){
        return numClass;
    }
    
    public int getTotalWorkingHours(){
        return totalWorkingHours;
    }
    
    public String toString() {
        return "This teaching assitant is " + lastName + ", " + firstName + " lives in " + cityResidence + ", was hired in " + hireYear + ", has a classification of"
                + classification + ",taking " + numClass + " classes and works " + totalWorkingHours;
    }

    public boolean equals(Object ob) {
        if (ob.getClass() != this.getClass() || ob == null) {
            return false;
        }
        TeachingAssistant e = (TeachingAssistant) ob;
        if (super.equals(e) && e.classification.equals(classification) && e.numClass == numClass && e.totalWorkingHours == totalWorkingHours) {
            return true;
        }
        return false;
    }
}
