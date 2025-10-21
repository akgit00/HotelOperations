package com.pluralsight;

public class TheApp {
    public static void main(String[] args) {

        // Testing Room
        Room room1 = new Room(2, 150.0, false, false);
        System.out.println("Room available? " + room1.isAvailable());

        //Testing Reservation
        Reservation res = new Reservation("king", 3, true);
        System.out.println("Room Type: " + res.getRoomType());
        System.out.println("Price per night: $" + res.getPrice());
        System.out.println("Total: $" + res.getReservationTotal());

        // Testing Employee
        Employee emp = new Employee(101, "Ahmad", "Housekeeping", 20.0, 45);
        System.out.println("Employee: " + emp.getName());
        System.out.println("Regular hours: " + emp.getRegularHours());
        System.out.println("Overtime hours: " + emp.getOvertimeHours());
        System.out.println("Total Pay: $" + emp.getTotalPay());

    }
}
