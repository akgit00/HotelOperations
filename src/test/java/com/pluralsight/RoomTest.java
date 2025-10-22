package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    public void checkIn_shouldMakeRoomOccupiedAndDirty() {
        //arrange
        Room room = new Room(1, 100.0, false, false);

        //act
        room.checkIn();

        //assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkIn_shouldNotAllowIfRoomAlreadyOccupied() {
        Room room = new Room(1, 100.0, true, false);   // already occupied

        room.checkIn();

        assertTrue(room.isOccupied()); // still occupied
        assertFalse(room.isAvailable()); // not available for new guest
    }

    @Test
    public void checkIn_shouldNotAllowIfRoomIsDirty() {
        Room room = new Room(1, 100.0, false, true);   // dirty room

        room.checkIn();

        assertFalse(room.isOccupied()); // cannot check in
    }

    @Test
    public void checkout_shouldSetOccupiedToFalseButKeepDirty() {
        Room room = new Room(1, 100.0, true, true);

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_shouldMakeRoomCleanAndAvailable() {
        Room room = new Room(1, 100.0, false, true); // dirty room

        room.cleanRoom();

        assertFalse(room.isDirty());
        assertTrue(room.isAvailable());
    }

    @Test
    public void cleanRoom_shouldNotCleanIfOccupied() {
        Room room = new Room(1, 100.0, true, true); // occupied + dirty

        room.cleanRoom();

        assertTrue(room.isDirty()); // still dirty
        assertTrue(room.isOccupied()); // still occupied
    }



}