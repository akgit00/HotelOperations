package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void punchIn_shouldSetEmployeeAsClockedIn() {
        //arrange
        Employee emp = new Employee(101, "Ahmad", "Front Desk", 20.0, 0.0, 0.0);

        //act
        emp.punchIn(9.0);
        emp.punchOut(17.0); // 8 hours worked

        //assert
        assertEquals(8.0, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void punchOut_shouldAddCorrectHoursWorked() {
        //arrange
        Employee emp = new Employee(102, "Aisha", "Housekeeping", 18.0, 0.0, 0.0);

        //act
        emp.punchIn(10.0);
        emp.punchOut(15.5); // 5.5 hours

        //assert
        assertEquals(5.5, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void multiplePunches_shouldAccumulateHours() {
        //arrange
        Employee emp = new Employee(103, "Maryam", "Maintenance", 22.0, 0.0, 0.0);

        //act
        emp.punchIn(8.0);
        emp.punchOut(12.0); // 4 hours
        emp.punchIn(13.0);
        emp.punchOut(17.5); // 4.5 hours

        //assert
        assertEquals(8.5, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void punchOut_beforePunchIn_shouldNotAddHours() {
        //arrange
        Employee emp = new Employee(104, "Josie", "Front Desk", 19.0, 0.0, 0.0);

        //act
        // punching out before punching in
        emp.punchOut(14.0);

        //assert
        assertEquals(0.0, emp.getHoursWorked(), 0.01);
    }


}