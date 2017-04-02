package a4_40022733_40029417;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner console = new Scanner(System.in);

    static void addFTRecords(ArrayList<FullTimeFaculty> ft, String fileName) throws FileNotFoundException {
        int ans = 0;
        Scanner read = new Scanner(new FileInputStream(fileName));
        System.out.print("Please enter information for new Full Time Faculty record: ");
        while (read.hasNext()) {
            FullTimeFaculty temp = new FullTimeFaculty(read.nextLong(), read.next(), read.next(), read.next(), read.nextInt(), read.nextDouble());
            ft.add(temp);
        }
        read.close();

        while (ans != -1) {
            System.out.print("Please enter information for new Full Time Faculty record: ");
            FullTimeFaculty temp = new FullTimeFaculty(console.nextLong(), console.next(), console.next(), console.next(), console.nextInt(), console.nextDouble());
            while (ft.contains(temp)) {
                System.out.print("There is already an employee with that ID, please enter a new employee ID : ");
                temp.setEmployeeID(console.nextLong());
            }
            ft.add(temp);
            System.out.println("Record added. Do you wish to enter a new record? (Enter -1 to stop, 1 to continue)");
            ans = console.nextInt();
        }

        PrintWriter pw = new PrintWriter(fileName);
        for (FullTimeFaculty i : ft) {
            pw.println(i);
        }
        pw.close();
    }

    static void addPTRecords(ArrayList<PartTimeFaculty> pt, String fileName) throws FileNotFoundException {
        int ans = 0;
        Scanner read = new Scanner(new FileInputStream(fileName));
        System.out.print("Please enter information for new Part Time Faculty record: ");
        while (read.hasNext()) {
            PartTimeFaculty temp = new PartTimeFaculty(read.nextLong(), read.next(), read.next(), read.next(), read.nextInt(), read.nextDouble(), read.nextInt(), read.nextInt());
            pt.add(temp);
        }
        while (ans != -1) {
            System.out.print("Please enter information for new Part Time Faculty record: ");
            PartTimeFaculty temp = new PartTimeFaculty(console.nextLong(), console.next(), console.next(), console.next(), console.nextInt(), console.nextDouble(), console.nextInt(), console.nextInt());
            while (pt.contains(temp)) {
                System.out.println("There is already an employee with that ID, please enter a new employee ID : ");
                temp.setEmployeeID(console.nextLong());
            }
            pt.add(temp);
            System.out.println("Record added. Do you wish to enter a new record? (Enter -1 to stop, 1 to continue)");
            ans = console.nextInt();
        }
        read.close();
        PrintWriter pw = new PrintWriter(fileName);
        for (PartTimeFaculty i : pt) {
            pw.println(i);
        }
        pw.close();
    }

    static void addTARecords(ArrayList<TeachingAssistant> ta, String fileName) throws FileNotFoundException {
        int ans = 0;
        Scanner read = new Scanner(new FileInputStream(fileName));
        System.out.print("Please enter information for new Teaching Assistant record: ");
        while (read.hasNext()) {
            TeachingAssistant temp = new TeachingAssistant(read.nextLong(), read.next(), read.next(), read.next(), read.nextInt(), read.next(), read.nextInt(), read.nextInt());
            ta.add(temp);
        }
        while (ans != -1) {
            System.out.print("Please enter information for new Teaching Assistant record: ");
            TeachingAssistant temp = new TeachingAssistant(console.nextLong(), console.next(), console.next(), console.next(), console.nextInt(), console.next(), console.nextInt(), console.nextInt());
            while (ta.contains(temp)) {
                System.out.println("There is already an employee with that ID, please enter a new employee ID : ");
                temp.setEmployeeID(console.nextLong());
            }
            ta.add(temp);
            System.out.println("Record added. Do you wish to enter a new record? (Enter -1 to stop, 1 to continue)");
            ans = console.nextInt();
        }
        read.close();
        PrintWriter pw = new PrintWriter(fileName);
        for (TeachingAssistant i : ta) {
            pw.println(i);
        }
        pw.close();
    }

    static void findTermSalary(String PT, String TA) throws FileNotFoundException {
        Scanner PTinput = new Scanner(new FileInputStream(PT));
        Scanner TAinput = new Scanner(new FileInputStream(TA));

        EmployeeList PTlist = new EmployeeList();
        EmployeeList TAlist = new EmployeeList();

        while (PTinput.hasNext()) {
            PTlist.add(new PartTimeFaculty(PTinput.nextLong(), PTinput.next(), PTinput.next(), PTinput.next(), PTinput.nextInt(), PTinput.nextDouble(), PTinput.nextInt(), PTinput.nextInt()));
        }
        while (TAinput.hasNext()) {
            TAlist.add(new TeachingAssistant(TAinput.nextLong(), TAinput.next(), TAinput.next(), TAinput.next(), TAinput.nextInt(), TAinput.next(), TAinput.nextInt(), TAinput.nextInt()));
        }

        double totalSalary = 0;
        for (int i = 1; i <= PTlist.getSize(); i++) {
            PartTimeFaculty pt = (PartTimeFaculty) PTlist.getValue(i);
            totalSalary += pt.getHourlyRate() * pt.getNumHours();
        }

        for (int i = 1; i <= TAlist.getSize(); i++) {
            TeachingAssistant ta = (TeachingAssistant) TAlist.getValue(i);

            if (ta.getClassification().equals("Grad")) {
                totalSalary += (ta.getTotalWorkingHours() * 18.25) * 1.2;
            } else if (ta.getClassification().equals("UGrad")) {
                totalSalary += ta.getTotalWorkingHours() * 18.25;
            } else {
                totalSalary += 0;
            }

        }

        System.out.println("Total term salary for Teaching Assistants and Part Time is: $" + totalSalary);

    }

    static void findHighest_and_Lowest_FT_Salary(String FT) throws FileNotFoundException {
        Scanner FTinput = new Scanner(new FileInputStream(FT));

        EmployeeList FTlist = new EmployeeList();

        while (FTinput.hasNext()) {
            FTlist.add(new FullTimeFaculty(FTinput.nextLong(), FTinput.next(), FTinput.next(), FTinput.next(), FTinput.nextInt(), FTinput.nextDouble()));
        }
        FullTimeFaculty lowestSalary = ((FullTimeFaculty) FTlist.getValue(1));
        FullTimeFaculty highestSalary = ((FullTimeFaculty) FTlist.getValue(1));

        for (int i = 2; i <= FTlist.getSize(); i++) {
            FullTimeFaculty ft = (FullTimeFaculty) FTlist.getValue(i);
            if (ft.getSalary() < lowestSalary.getSalary()) {
                lowestSalary = ft;
            }
            if (ft.getSalary() > highestSalary.getSalary()) {
                highestSalary = ft;
            }
        }

        String lowest = lowestSalary.toString() + "\n";
        String highest = highestSalary.toString() + "\n";

        for (int i = 1; i <= FTlist.getSize(); i++) {
            FullTimeFaculty ft = (FullTimeFaculty) FTlist.getValue(i);
            if (lowestSalary.getSalary() == ft.getSalary() && !lowestSalary.equals(ft)) {
                lowest += ft + "\n";
            }
            if (highestSalary.getSalary() == ft.getSalary() && !highestSalary.equals(ft)) {
                highest += ft + "\n";
            }
        }

        System.out.println("\nEmployee(s) with lowest salary: " + lowest + "\nEmployee(s) with highest salary: " + highest);
    }

    static void increase_Staff_Salary(String ST) throws FileNotFoundException {
        Scanner STinput = new Scanner(new FileInputStream(ST));

        EmployeeList STlist = new EmployeeList();

        while (STinput.hasNext()) {
            STlist.add(new Staff(STinput.nextLong(), STinput.next(), STinput.next(), STinput.next(), STinput.nextInt(), STinput.nextDouble(), STinput.next().charAt(0)));
        }

        PrintWriter pw = new PrintWriter(new FileOutputStream(ST));
        for (int i = 1; i <= STlist.getSize(); i++) {
            Staff st = (Staff) STlist.getValue(i);
            switch (st.getPerfCode()) {
                case 'A': {
                    st.setSalary(1.08 * st.getSalary());
                    st.setPerfCode('E');
                    break;
                }
                case 'B': {
                    st.setSalary(1.06 * st.getSalary());
                    st.setPerfCode('E');
                    break;
                }
                case 'C': {
                    st.setSalary(1.03 * st.getSalary());
                    st.setPerfCode('E');
                    break;
                }
                case 'D': {
                    st.setSalary(1.01 * st.getSalary());
                    st.setPerfCode('E');
                    break;
                }
            }
            pw.println(st);
        }
        pw.close();
     
    }

    public static void main(String[] args) {

        ArrayList<TeachingAssistant> ta = new ArrayList<TeachingAssistant>();
        ArrayList<FullTimeFaculty> ft = new ArrayList<FullTimeFaculty>();
        ArrayList<PartTimeFaculty> pt = new ArrayList<PartTimeFaculty>();

        try {
            //addFTRecords(ft, "Full-Time-Faculty.txt");
            //addPTRecords(pt, "Part-Time-Faculty.txt");
            //addTARecords(ta, "TAs.txt");
            findTermSalary("Part-Time-Faculty.txt", "TAs.txt");
            findHighest_and_Lowest_FT_Salary("Full-Time-Faculty.txt");
            increase_Staff_Salary("StaffCOPY.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
