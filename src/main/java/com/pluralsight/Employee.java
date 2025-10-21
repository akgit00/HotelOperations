package com.pluralsight;

import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    private String department;
    private double payRate;
    private double hoursWorked;
    private double startTime;
    private boolean isClockedIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked, double startTime) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.startTime = startTime;
        this.isClockedIn = isClockedIn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    // Regular hours capped at 40
    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    // Overtime is any time beyond 40
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    // Total pay includes overtime at 1.5x rate
    public double getTotalPay() {
        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * (payRate * 1.5);
        return regularPay + overtimePay;
    }


    // --- Overloaded punchIn methods ---
    public void punchIn(double time) {
        startTime = time;
        isClockedIn = true;
        System.out.println(name + " punched in at " + time);
    }

    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + (now.getMinute() / 60.0);
        startTime = time;
        isClockedIn = true;
        System.out.printf("%s punched in at %.2f (%02d:%02d)\n", name, time, now.getHour(), now.getMinute());
    }

    // --- Overloaded punchOut methods ---
    public void punchOut(double time) {
        if (!isClockedIn) {
            System.out.println(name + " is not currently clocked in!");
            return;
        }
        double hours = time - startTime;
        if (hours < 0) {
            System.out.println("Invalid punch-out time.");
            return;
        }
        hoursWorked += hours;
        isClockedIn = false;
        System.out.println(name + " punched out at " + time + " | Worked " + hours + " hours this shift.");
    }

    public void punchOut() {
        if (!isClockedIn) {
            System.out.println(name + " is not currently clocked in!");
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + (now.getMinute() / 60.0);
        double hours = time - startTime;
        if (hours < 0) {
            System.out.println("Invalid time entry.");
            return;
        }
        hoursWorked += hours;
        isClockedIn = false;
        System.out.printf("%s punched out at %.2f (%02d:%02d) | Worked %.2f hours.\n",
                name, time, now.getHour(), now.getMinute(), hours);
    }
}