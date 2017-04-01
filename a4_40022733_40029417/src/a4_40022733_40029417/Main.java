package a4_40022733_40029417;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        for (int i = 0; i < PTlist.getSize(); i++) {
            PartTimeFaculty pt = (PartTimeFaculty)PTlist.getValue(i);
            
            System.out.println(pt.getSalary());
            totalSalary += pt.getSalary();
        }

        for (int i = 0; i < TAlist.getSize(); i++) {
            TeachingAssistant ta = (TeachingAssistant)TAlist.getValue(i);
            
            System.out.println(ta.getSalary());
            totalSalary += ta.getSalary();
        }

        System.out.println("Total term salary for Teaching Assistants and Part Time is: $" + totalSalary);

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
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
