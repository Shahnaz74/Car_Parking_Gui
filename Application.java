/**
 * This class represents a generic application for managing vehicle parking.
 * It contains information about a vehicle's owner and arrival time.
 * @Shahnaz Akter, id:103510528
 * @version 15
 * @date 23/10/2023
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


 
    public abstract class Application
        {
         protected String owner;                              // Instance variables,Stores the name of the owner of the vehicle
         private LocalDateTime arrivalTime;                   // Stores the arrival time of the vehicle
            
            
                
          /**
           * Constructor for objects of class Vehicle
           *@param ownerN, the owner of the vehicle
           */
            
        public Application(String owner)
            {
            
                this.owner = owner;                             // Initialize the owner of the vehicle
                arrivalTime = LocalDateTime.now();             // Set the arrival time to the current time
            }
                            
        /**
          * Getting the owner of the vehicle
          *@return owner, the owner of the vehicle
          */
            
        public String getOwner()
            {
                return owner;
            }
            
        /**
          * Getting the arrival time from LocalDateTime
          *@return arrivalTime, the arrival time of the vehicle in the parking eg. 3pm
          */
           
        public LocalDateTime getArrivalTime()
            {
                return arrivalTime;
            }
            
        /**
          * Getting the time in the parking once vehicle is parked
          * @return Time (in minutes) since the vehicle was parked
          */
            
        public long getTimeIn()
            {
                return arrivalTime.until(LocalDateTime.now(),ChronoUnit.MINUTES);   // Calculate the difference between the current time and the arrival time in minutes
            }
            
        /**
          * Displaying information about vehicle
          * Convert vehicle information to a string format for display.
          * @return String representation of the vehicle information 
          */
            
        public String toString()
            {
             return "Owner: "+owner+" Arrival Time : "+arrivalTime+"\n Time In : "+getTimeIn()+"\n***********";   
            }
            
  }