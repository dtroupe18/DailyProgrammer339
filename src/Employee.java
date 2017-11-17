/*
 * Created by Dave on 11/17/17.
 */

import java.util.ArrayList;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    String firstName, lastName, job, col;
    int age, year, month, day;
    double salary;
    Date dob;

    public Employee(String[] nameAgeDOB, ArrayList<String> extensions) {
        firstName = nameAgeDOB[0];
        lastName = nameAgeDOB[1];
        parseAgeDOB(nameAgeDOB[2]);
        this.salary = 0; // to avoid null issues if there is no salary in extensions

        parseExtensions(extensions);
    }

    private void parseAgeDOB(String s) {
        age = Integer.parseInt(s.substring(0, 2));
        year = Integer.parseInt(s.substring(2, 4));
        month = Integer.parseInt(s.substring(4, 6));
        day = Integer.parseInt(s.substring(6, 8));
    }

    private void parseExtensions(ArrayList<String> extensions) {
        if (!extensions.isEmpty()) {
            for (String s: extensions) {
                if (s.startsWith("JOB")) {
                    this.job = s.replaceFirst("JOB", "");
                }
                else if (s.startsWith("SAL")) {
                    String sal = s.replaceFirst("SAL", "");
                    String trimmedSal = sal.trim();
                    this.salary = Integer.parseInt(trimmedSal);
                    // System.out.println("salary: " + this.salary);
                }
                else if (s.startsWith("COL")) {
                    this.col = s.replaceFirst("COL", "");
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name ").append(firstName).append(" ").append(lastName).append(" salary: ").append(salary).append(" age: ")
                .append(age).append(" DOB: 19").append(year).append("-").append(month).append("-")
                .append(day).append("\n");

        return sb.toString();
    }

    @Override
    public int compareTo(Employee other) {
        if (this.salary > other.salary) {
            return 1;
        }
        else if (this.salary < other.salary) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
