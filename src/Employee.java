/*
 * Created by Dave on 11/17/17.
 */

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

        StringBuilder date = new StringBuilder();
        date.append(s.substring(6, 8)).append("-").append(s.substring(4, 6)).append("-").append("19").append(s.substring(2,4));
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dob = dateFormat.parse(date.toString());
        }
        catch (ParseException pe) {
            System.out.println("Error parsing date for " + date.toString() + " error: " + pe.getLocalizedMessage());
        }
    }

    private void parseExtensions(ArrayList<String> extensions) {
        if (!extensions.isEmpty()) {
            for (String s: extensions) {
                if (s.startsWith("JOB")) {
                    this.job = s.replaceFirst("JOB", "").trim();
                }
                else if (s.startsWith("SAL")) {
                    String sal = s.replaceFirst("SAL", "");
                    String trimmedSal = sal.trim();
                    this.salary = Integer.parseInt(trimmedSal);
                    // System.out.println("salary: " + this.salary);
                }
                else if (s.startsWith("COL")) {
                    this.col = s.replaceFirst("COL", "").trim();
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
