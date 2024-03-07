/**
 * The CarPark class represents a car park that manages parking slots and cars.
 * It allows the addition, removal, and searching of parking slots based on different criteria.
 * @Shahnaz Akter, id:103510528
 * @version 15
 * @date 23/10/2023
 */

import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;



public class CarPark {
    private ArrayList<ParkingSlot> ParkingSlots;     // List to store all parking slots

    // Default constructor initializing an empty parking slots list
    public CarPark() {
        ParkingSlots = new ArrayList<ParkingSlot>();
    }
    
     // Adds a new parking slot to the list
    public void addNewParkingSlot(ParkingSlot aParkingSlot) {
        ParkingSlots.add(aParkingSlot);
    }

    /**
     * Removes a parking slot based on slot ID if it's not occupied.
     * @param slotId - ID of the slot to be removed.
     * @return true if the slot was removed, false otherwise.
     */

    public boolean removeAParkingSlot(String slotId) {
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getParkingSlotId().equalsIgnoreCase(slotId) && !aParkingSlot.getIsOccupied()) {
                ParkingSlots.remove(aParkingSlot);
                return true;
            }
        }
        return false;
    }

    // Returns a list of available (unoccupied) parking slots.
    public ArrayList<ParkingSlot> getAvailableParkingSlots() {
        ArrayList<ParkingSlot> availParkingSlots = new ArrayList<ParkingSlot>();
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (!aParkingSlot.getIsOccupied())
                availParkingSlots.add(aParkingSlot);
        }
        return availParkingSlots;
    }

    // Searches and returns parking slots based on car owner's name
    public ArrayList<ParkingSlot> findcarOwner(String ownerN) {
        ArrayList<ParkingSlot> foundParkingSlots = new ArrayList<ParkingSlot>();
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getCar() != null) {
                if (aParkingSlot.getCar().getOwner().equals(ownerN) && aParkingSlot.getIsOccupied()) {
                    foundParkingSlots.add(aParkingSlot);
                }
            }
        }
        return foundParkingSlots;
    }

    // Searches and returns parking slots based on car registration number
    public ArrayList<ParkingSlot> findVehicleRego(String CarRego) {
        ArrayList<ParkingSlot> foundParkingSlots = new ArrayList<ParkingSlot>();
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getCar() instanceof Car) {
                if (((Car) aParkingSlot.getCar()).getRego().equals(CarRego) && aParkingSlot.getIsOccupied()) {
                    foundParkingSlots.add(aParkingSlot);
                }
            }
        }
        return foundParkingSlots;
    }
    
    // Searches and returns a parking slot based on its ID
    public ParkingSlot findParkingbyID(String Id) {
        ParkingSlot foundParkingSlot = new ParkingSlot("-1");       // Return a dummy parking slot if not found
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getParkingSlotId().equals(Id)) {
                foundParkingSlot = aParkingSlot;
                break;
            }
        }
        return foundParkingSlot;
    }

     // Returns a list of occupied parking slots
    public ArrayList<ParkingSlot> getOccupiedParkingSlots() {
        ArrayList<ParkingSlot> occupiedParkingSlots = new ArrayList<ParkingSlot>();
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getIsOccupied()) {
                occupiedParkingSlots.add(aParkingSlot);
            }
        }
        return occupiedParkingSlots;
    }

     // Returns a list of staff parking slots
    public ArrayList<ParkingSlot> getStaffParkingSlots() {
        ArrayList<ParkingSlot> staffParkingSlots = new ArrayList<ParkingSlot>();
        for (ParkingSlot aParkingSlot : ParkingSlots) {
            if (aParkingSlot.getIsStaff()) {
                staffParkingSlots.add(aParkingSlot);
            }
        }
        return staffParkingSlots;
    }

     // Returns a list of all parking slots
    public ArrayList<ParkingSlot> getAllParkingSlots() {
        return ParkingSlots;
    }
}