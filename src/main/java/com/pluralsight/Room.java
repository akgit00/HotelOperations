package com.pluralsight;

public class Room {

    private int numberOfRooms;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfRooms, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isAvailable(){
        if(!this.isDirty() && !this.isOccupied()){
            return true;
        }
        return false;
    }

    //This section is for adding new methods for exercise 2

    public void checkIn() {
        if (!isAvailable()) {
            System.out.println("Room is not available for check-in.");
            return;
        }
        isOccupied = true;
        isDirty = true;
        System.out.println("Guest checked in successfully!");
    }

    public void checkOut() {
        if (!isOccupied) {
            System.out.println("No guest to check out.");
            return;
        }
        isOccupied = false;
        System.out.println("Guest checked out. Room must be cleaned before next guest.");
    }

    public void cleanRoom() {
        if (isOccupied) {
            System.out.println("Cannot clean room while it is occupied!");
            return;
        }
        isDirty = false;
        System.out.println("Room has been cleaned and is now available.");
    }
}
