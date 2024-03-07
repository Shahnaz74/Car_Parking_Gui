/**
 * The ParkingSlot class represents parking slots with unique slot IDs and parking information.
 * @Shahnaz Akter, id:103510528
 * @version 20
 * @date 23/10/2023
 */

import java.time.LocalDateTime;
import java.time.Duration;
import java.awt.Color;

// Attributes of the ParkingSlot
public class ParkingSlot {
    private String id;                     // Unique ID of the parking slot
    private Car CarInParkingSlot;          // Car currently parked in the slot, if any
    private boolean isOccupied;
    private boolean isStaff;
    private LocalDateTime arrivalTime;      // Time when the current car arrived
    private Color slotColor;                // Optional color for the parking slot

    /**
     * Constructor for creating a Visitor ParkingSlot.
     * @param sId Unique ID for the slot.
     */
    public ParkingSlot(String sId) {
        this.id = sId;
        isOccupied = false;
        isStaff = false;
    }

    /**
     * Constructor for creating a Staff ParkingSlot.
     * @param sId Unique ID for the slot.
     * @param isStaff Flag indicating if the slot is reserved for staff.
     */
    public ParkingSlot(String sId, boolean isStaff) {
        this.id = sId;
        isOccupied = false;
        this.isStaff = isStaff;
    }

    /**
     * Constructor for creating a ParkingSlot with a specific color.
     * @param color The color of the slot for visitor.
     */
    public ParkingSlot(String sId, Color color) {
        this.id = sId;
        this.slotColor = color;
        isOccupied = false;
        isStaff = false;
    }

    /**
     * Constructor for creating a Staff ParkingSlot with a specific color.
     * @param color The color of the slot.
     * @param isStaff Flag indicating if the slot is reserved for staff.
     */
    public ParkingSlot(String sId, Color color, boolean isStaff) {
        this.id = sId;
        this.slotColor = color;
        isOccupied = false;
        this.isStaff = isStaff;
    }

    /**
     * Calculate the duration for which a car has been parked in the slot.
     * @return Duration for which the car has been parked.
     */
    public Duration getParkedDuration() {
        if (isOccupied) {
            return Duration.between(arrivalTime, LocalDateTime.now());
        }
        return Duration.ZERO;
    }

    // Add visitor vehicle
    public void addVisitorVehicle(Car CarInParkingSlot) {
        this.CarInParkingSlot = CarInParkingSlot;
        CarInParkingSlot.setColor(new Color(255, 171, 171));
        isOccupied = true;
        isStaff = false;
        arrivalTime = LocalDateTime.now();
    }

    /**
     * Add a visitor's vehicle to the parking slot.
     * @param CarInParkingSlot The car to be parked.
     */
    public void addStaffVehicle(Car CarInParkingSlot) {
        this.CarInParkingSlot = CarInParkingSlot;
        CarInParkingSlot.setColor(new Color(228, 133, 134));
        isOccupied = true;
        isStaff = true;
        arrivalTime = LocalDateTime.now();
    }

    /**
     * Add a staff's vehicle to the parking slot.
     * @param CarInParkingSlot The car to be parked.
     */
    public String getParkingSlotId() {
        return id;
    }

    // Standard getters and setters
    public Car removeCar() {
        isOccupied = false;
        return CarInParkingSlot;
    }

    public Car getCar() {
        return CarInParkingSlot;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public boolean getIsStaff() {
        return isStaff;
    }

    public void setStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * String representation of the ParkingSlot object.
     * @return A string detailing the parking slot's status and the parked car's details.
     */
    @Override
    public String toString() {
        if (CarInParkingSlot != null) {
            if (CarInParkingSlot instanceof Car) {
                Duration parkedDuration = getParkedDuration();
                long minutesParked = parkedDuration.toMinutes();
                long hoursParked = minutesParked / 60;
                long remainingMinutes = minutesParked % 60;
                return "ParkingSlot Id : " + id +
                       "\nCar In ParkingSlot : " + ((Car) CarInParkingSlot).getRego() +
                       "\nStaff Slot : " + isStaff +
                       "\nOccupied : " + (isOccupied ? "Yes" : "No") +
                       "\nArrivalTime(atParkingSlot) : " + arrivalTime +
                       "\nDuration Parked: " + hoursParked + " hours " + remainingMinutes + " minutes" + "\n";
            }
    }
    return "ParkingSlot Id : " + id +
           "\nStaffSlot : " + isStaff +
           "\nOccupied? : " + (isOccupied ? "Yes\n" : "No\n");
    }

}
