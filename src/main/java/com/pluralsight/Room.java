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

}
