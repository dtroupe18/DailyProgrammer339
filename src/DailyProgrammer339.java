/*
 * Created by Dave on 11/17/17.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class DailyProgrammer339 {

    public static void main(String[] args) {
        readTextFile();
    }

    public static void readTextFile() {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        FileReader fr = null;
        BufferedReader br = null;
        try {

            fr = new FileReader("C:\\Users\\e358122\\Desktop\\EmployeeData.txt");
            br = new BufferedReader(fr);
            String line;
            String[] nameAgeDOB = null;
            ArrayList<String> extensions = new ArrayList<String>();

            for(int i = 0; (line = br.readLine()) != null; i++)
                try {
                    // System.out.println( "\n" + line);
                    if (!(line.startsWith("::EXT::")) && nameAgeDOB == null) {
                        // new employee
                        // System.out.println("Name and DOB: " + line);
                        nameAgeDOB = line.split("\\s+");
                    }
                    else if (!(line.startsWith("::EXT::")) && nameAgeDOB != null) {
                        // construct and save employee
                        // System.out.println("Old Name and DOB: " + nameAgeDOB[0] + " " + nameAgeDOB[1] + " " + nameAgeDOB[2]);
                        Employee employee = new Employee(nameAgeDOB, extensions);
                        extensions.clear();
                        employees.add(employee);

                        nameAgeDOB = line.split("\\s+");
                        // System.out.println("New Name and DOB: " + nameAgeDOB[0] + " " + nameAgeDOB[1] + " " + nameAgeDOB[2]);
                    }
                    else if (line.startsWith("::EXT::")) {
                        // System.out.println("Extension for " + nameAgeDOB[0] + " " + nameAgeDOB[1] + " " + parseExtension(line));
                        extensions.add(parseExtension(line));
                    }


                }
                catch (Throwable thr) {
                    System.out.println("Catastrophic error while parsing entry " + i + " " + line + "\n" + thr.getMessage()
                            + " " + thr.getCause());
                }
        }
        catch(IOException e) {
            System.out.println("Unable to load text file " + e);
        }
        finally {
            if(br != null) {
                try {
                    br.close();
                    br = null;
                } catch(IOException e) {
                    System.out.println("Unable to close br. " + e);
                }
            }
            System.out.println(whoMakesTheMost(employees));
        }
    }

    public static String whoMakesTheMost(ArrayList<Employee> employees) {
        if (!employees.isEmpty()) {
            Collections.sort(employees);
            return employees.get(employees.size() - 1).toString();
        }
        else {
            return "No Employees";
        }
    }
    public static String parseExtension(String line) {
        line = line.replaceFirst("::EXT::", "");
        // System.out.println("parsed line: " + line);
        return line;
    }
}
