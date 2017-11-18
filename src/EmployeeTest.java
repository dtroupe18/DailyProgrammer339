/*
 * Created by Dave on 11/17/17.
 */

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class EmployeeTest {

    @Test public void testEmployee() {
        // parseAgeDOB is private and is only called by the constructor so we will test it using the constructor
        // test with an arbitrary date
        ArrayList<String> ext = new ArrayList<String>();
        String[] nameAgeDOB = {"First-Name", "Last-Name", "29881114"};
        Employee e1 = new Employee(nameAgeDOB, ext);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dob = null;
        try {
            dob = dateFormat.parse("14-11-1988");
        }
        catch (ParseException pe) {
            System.out.println("Error parsing date in test " + pe.getLocalizedMessage());
        }
        assertEquals(29, e1.getAge());
        assertEquals(dob, e1.getDob());
        assertEquals(null, e1.getJob());
        assertEquals(0, e1.getSalary());
        assertEquals("First-Name", e1.getFirstName());
        assertEquals("Last-Name", e1.getLastName());
        assertEquals(88, e1.getYear());
        assertEquals(11, e1.getMonth());
        assertEquals(14, e1.getDay());

        ArrayList<String> ext2 = new ArrayList<String>();
        ext2.add("JOB loser");
        ext2.add("SAL 00000000000047706");
        ext2.add("COL hummus");
        String[] nameAgeDOB2 = {"John", "Smith", "25920815"};
        Employee e2 = new Employee(nameAgeDOB2, ext2);

        assertEquals("loser", e2.getJob());
        assertEquals(47706, e2.getSalary());
        assertEquals("hummus", e2.getCol());
    }
}