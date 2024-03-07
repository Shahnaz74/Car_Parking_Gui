/**
 * The Car class defines a vehicle that can be parked in a parking lot. Cars have unique registration numbers and optional colors.
 * The Car class extends the Application class, suggesting additional functions and attributes.
 * @Shahnaz Akter, id:103510528
 * @version 15
 * @date 23/10/2023
 */

import java.awt.Color;

public class Car extends Application
    {
        private String CarRego;      // Registration number of the car
        private Color color; 
        
    /**
     * Constructor for creating a Car instance.
     *
     * @param CarRego The registration number of the vehicle.
     * @param owner The owner of the vehicle.
     */
    public Car(String CarRego, String owner)
        {
            // Initialise instance variables using the parent constructor for owner details
            super(owner);
            this.CarRego = CarRego;
    }
    
    /**
     * Gets the color 
     * @return color, The color
     */
    public Color getColor()
        {
            return color;
    }

    /**
     * Sets the color
     * @param color,
     */
    public void setColor(Color color)
        {
            this.color = color;
    }
    
    /**
     * Gets the registration number of the car
     * @return String The registration number of the vehicle.
     */
    public String getRego()
        {
            return CarRego;
    }

    /**
     * Displays information about the Car
     *
     * @return String, The concatenated string of car details
     *//**
     * Provides a string representation of the Car's details.
     *
     * @return String The concatenated string of car details.
     */
    @Override
    public String toString()
        {
            return "Car" + "," + getOwner() + "," + getArrivalTime() + "," + CarRego;
    }
}
