package a4_40022733_40029417;

public class FullTimeFaculty extends Employee {

    private double salary;

    public FullTimeFaculty() {
        super();
        salary = 0.0;
    }

    public FullTimeFaculty(long employeeID, String firstName, String lastName, String cityResidence, int hireYear, double salary) {
        super(employeeID, firstName, lastName, cityResidence, hireYear);
        this.salary = salary;
    }

    public FullTimeFaculty(FullTimeFaculty copy) {
        super(copy);
        salary = copy.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "This full time faculty member is " + lastName + ", " + firstName + " lives in " + cityResidence + ", was hired in " + hireYear + " and has a salary of"
                + salary;
    }

    public boolean equals(Object ob) {
        if (ob.getClass() != this.getClass() || ob == null) {
            return false;
        }
        FullTimeFaculty e = (FullTimeFaculty) ob;
        if (super.equals(e) && e.salary == salary) {
            return true;
        }
        return false;
    }
}
