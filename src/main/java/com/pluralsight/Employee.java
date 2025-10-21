package com.pluralsight;

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

    public void punchTimeCard(double time) {
        if (!isClockedIn) {
            // Employee clocking in
            startTime = time;
            isClockedIn = true;
            System.out.println(name + " punched in at " + time);
        } else {
            // Employee clocking out
            double hours = time - startTime;
            if (hours < 0) {
                System.out.println("Invalid time entry. Punch-out time cannot be earlier than punch-in time.");
                return;
            }
            hoursWorked += hours;
            isClockedIn = false;
            System.out.println(name + " punched out at " + time + " | Worked " + hours + " hours this shift.");
        }
    }
}