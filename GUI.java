/**
 * This class provides a graphical interface for interacting with the CarPark system.
 * The application displays a header, manages actions related to parking, and updates the status of the car park.
 * To facilitate interaction, the GUI includes buttons, panels, and action listeners.
 * @Shahnaz Akter, id:103510528
 * @version 15
 * @date 23/10/2023
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class GUI implements ActionListener{
   private JFrame mainFrame;                     // The main frame of the GUI
   private JLabel headerLabel;                   // Label for the header
   private JLabel statusLabel;                   // Label for displaying status
   private JButton labelButton;                  // Button for GUI actions
   private JPanel controlPanel;                  // Panel for controls like buttons
   private JPanel headerpanel;                   // Panel for header display
   private JTextArea msglabel;                   // TextArea for messages or logs
   private CarPark carpar;                       // Instance of the CarPark system this GUI interacts with
   
   
   /**
     * Constructor for the GUI.
     * Initializes the GUI with the given CarPark system.
     * @param carpar CarPark system instance to interact with
     */

    
   public GUI(CarPark carpar){
      this.carpar = carpar;
      prepareGUI();
   }
   
   
    
   /**
     * Sets up the initial GUI elements.
     * Constructs the main frame, panels, labels, and adds action listeners.
     * Organizes layout and positions of these components.
     */
   private void prepareGUI(){
      mainFrame = new JFrame("Gui System for Project 1");              // Initialize a new JFrame
      mainFrame.setSize(1000,600);
      mainFrame.setLayout(new GridLayout(3, 1));                        // The JFrame consists of 4 rows and 3 columns.
      
      mainFrame.addWindowListener(new WindowAdapter() {                 // Click the cross button in the top right corner to exit
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      addVisitorStaffParking();                                             // Adding visitor and staff parking funtions.
   
      JPanel imagePanel = new JPanel(new GridLayout(2, 1));            // adding header
      JLabel textLabel = new JLabel("CAR PARK SYSTEM");                // Label for the header panel
      textLabel.setHorizontalAlignment(SwingConstants.CENTER);         // Sets the horizontal alignment of the label
      textLabel.setVerticalAlignment(SwingConstants.CENTER);
      textLabel.setFont(new Font("Serif", Font.BOLD, 40));
      imagePanel.add(textLabel);      
                               
   
      headerpanel = new JPanel(new GridLayout(2, 1, 10, 5));          // Jpanel with grid layout in the middle
      
      headerpanel.setBackground(new Color(255, 234, 221));
      Border blackline = BorderFactory.createLineBorder(new Color(215, 229, 202)); // Put a border around it
      headerpanel.setBorder(blackline);
      mainFrame.add(headerpanel, BorderLayout.CENTER);
      
      
      mainFrame.add(headerpanel);                                      // Add the JFrame to the main window
      JButton button1 = new JButton("Show All Parking Spots");
      button1.setBackground(new Color(144, 238, 144));
      JButton button2 = new JButton("Find Car");                        // The last panel has been updated with new JButtons
      button2.setBackground(new Color(192, 216, 192));
      JButton button3 = new JButton("Park Car");
      button3.setBackground(new Color(106, 156, 137));
      JButton button4 = new JButton("Delete Spot");
      button4.setBackground(new Color(100, 204, 197));
      JButton button5 = new JButton("Remove Car");
      button5.setBackground(new Color(174, 195, 174));
      JButton button6 = new JButton("Add Parking Spot");
      button6.setBackground(new Color(160, 216, 179));
      JButton button7 = new JButton("Exit Application");
      JButton button8 = new JButton("Clear Screen");
      button7.setBackground(new Color(255, 128, 128));
      button8.setBackground(new Color(224, 100, 105));
      JPanel main = new JPanel(new GridLayout(4, 2));                     
      button1.addActionListener(new ActionListener()
            {
               /* Removes the anonymous action listener for the first action
                 * Runs the showallParkings function when button 1 is pressed.
                 */
                public void actionPerformed(ActionEvent e)
                {
                    headerpanel.removeAll();
                    showAllParkings();
                }
            });
      button2.addActionListener(new ActionListener()
            {
                /* 
                 * A second anonymous action listener is started
                 * When button 2 is pressed, the findCar function is activated
                 * 
                 */
                public void actionPerformed(ActionEvent e)
                {
                  findCar();
                }
            });
      
      button3.addActionListener(new ActionListener()
            {
                /* 
                 * Third anonymous action listener is started
                 * When button 3 is pressed, the parkCar function is activated
                 */
                public void actionPerformed(ActionEvent e)
                {
                    parkCar();
                }
            });
            
      button4.addActionListener(new ActionListener()
            {
                /* 
                 * The fourth anonymous action listener removes everything from the header panel and runs the application.
                 * When button 4 is pressed, the parking function will be deleted.
                 */
                public void actionPerformed(ActionEvent e)
                {
                    headerpanel.removeAll();
                    deleteParking();
                }
            });
            
      button5.addActionListener(new ActionListener()
            {
                 /* 
                 *The fifth anonymous action listener runs the removeVehicle function when button 5 is pressed.
                 */
                public void actionPerformed(ActionEvent e)
                {
                    removeVehicle();
                }
            });
            
      button6.addActionListener(new ActionListener()
            {
                 /* 
                 * When button 6 is pressed, the sixth anonymous action listener executes the addParkingSpot function.
                 */
                public void actionPerformed(ActionEvent e)
                {
                    addParkingSpot();
                }
            });       
            
            
                /* 
                 *  When button 7 is pressed, the seventh anonymous action listener exits the program
                 */
      button7.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                 System.exit(0);   
                }
            });
      
            /* 
                 *  When button 8 is pressed, the eighth anonymous action listener runs the showHomeScreen function
                 */
      button8.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                 showHomeScreen();   
                }
            });      
            
      main.add(button1);
      main.add(button2);
      main.add(button3);                             // The last JPanel contain all buttons
      main.add(button4);
      main.add(button5);
      main.add(button6);
      main.add(button7);
      main.add(button8);
      
      mainFrame.add(main);                           // Use JFrames for everything
      
      mainFrame.setVisible(true);  
   }
   
   /**
     * Adding a new JLabel to the header panel, followed by removing existing content from the header panel
     *  Headerpanel revalidated, repainted, and mainFrame set to true.
     */
   
      
   private void showHomeScreen(){
      headerpanel.removeAll(); 
      headerLabel= new JLabel("Gui Car Park System.");
      headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
      headerLabel.setVerticalAlignment(SwingConstants.CENTER);
      headerpanel.add(headerLabel); 
      headerpanel.revalidate();
      headerpanel.repaint();   // Changing components requires this step
      mainFrame.setVisible(true);      
   }
   
   /**
     * A new JOptionPane will be initiated and user input will be taken in order to add visitor and staff parking spaces.
     * Input from the user determines the number of parking spots.
     * 
     */
    
   
   public void addVisitorStaffParking(){
      JOptionPane jO = new JOptionPane();
      boolean query = false;
      while (!query){
      String vis = jO.showInputDialog("Enter the number of visitor parking spots");
      String stf = jO.showInputDialog("Enter Number of Staff parking spots");
      if (vis!=null && stf!=null){
      
      if(!vis.chars().allMatch( Character::isDigit ) || !stf.chars().allMatch( Character::isDigit ))
      {
          jO.showMessageDialog(null, "Please provide a number value, such as (1 or 5)");
          
      }
       else if(stf.equals("") || vis.equals(""))
      {
          jO.showMessageDialog(null, "Input should not be left blank. Please enter a numeric value, such as (1 or 5)");

      }
      else
      {
      int vid = Integer.parseInt(vis);
      int nid = Integer.parseInt(stf);
      
      int p = 0;
      int z = 0;
      
      while (p<vid)
        {
            p++;                                                                       // A sequential id of three digits, such as "001", "002", etc.
            String uniqueNum = String.format("%03d", p);                               
            ParkingSlot aParkingSlot = new ParkingSlot("V" + uniqueNum, new Color(255, 171, 171));               //It follows that V + 001, V + 002, and so forth
            carpar.addNewParkingSlot(aParkingSlot); 
        }
      while (z<nid)
        {
            z++;                                                                       
            String uniqueNum = String.format("%03d", z);                                //A sequential id of three digits, such as "001", "002", etc/ 3 digit sequential id "001", "002" etc
            ParkingSlot aParkingSlot = new ParkingSlot("S" + uniqueNum, new Color(228, 133, 134), true);
          // It follows that V + 001, V + 002, and so forth
            carpar.addNewParkingSlot(aParkingSlot); 
        }
      JOptionPane.showMessageDialog(null, p + " visitor parking spots created and " + z + " staff parking spots created!"); 
      query = true; 
             }
            }
        }
    }
    
   /**
     * Delete the car parking spot by taking the user's input and deleting it if it is not occupied. 
     * The user is notified that the item has been deleted and a success message is displayed, otherwise an alert is displayed.
     * An anonymous listener is used in PrepareGUI in order to implement this function.
     * 
     */ 
    
    
   public void deleteParking(){
       
           showAllParkings();
           String spotID = JOptionPane.showInputDialog("Select the spot you would like to delete eg. (V001)");
      if (spotID!=null)
           {
           if (spotID.equals(""))
           {
               JOptionPane.showMessageDialog(null, "Alert: Please don't enter a blank value");
            }
       else
           {
               if(carpar.removeAParkingSlot(spotID) )
                {
                    JOptionPane.showMessageDialog(null, "Success: spot deleted!","Spot Deleted Message", JOptionPane.INFORMATION_MESSAGE);
                    headerpanel.removeAll();
                    showAllParkings();
                }
                else
                {
                JOptionPane.showMessageDialog(null, "Alert: Spot doesn't exist or is currently occupied");
                }
           }
        }
    }
   
   /**
    * The parking slot will be created by using the user's input. The parking ID will be generated if it does not exist, but matches the format.
    * The parking space is added to the carpark, and the updated parking spaces are displayed.
    * The function is implemented in the prepareGUI code as an anonymous listener.
    * 
    */ 
    
   public void addParkingSpot(){
       
       String spotID = JOptionPane.showInputDialog("Add Spot ID eg. (S110)");
       boolean isParkingSlotDuplicate = false;
           if (spotID!=null)
           {
           if (spotID.equals(""))
           {
                JOptionPane.showMessageDialog(null, "Please do not leave the ID field blank.");
            }
           else
           {
            for(ParkingSlot aParkingSlot : carpar.getAllParkingSlots())
            {
                /* checking if id starts with S, total length is 4 and contains numerics after S */
                if(aParkingSlot.getParkingSlotId().equalsIgnoreCase(spotID))
                {
                    isParkingSlotDuplicate = true;
                    JOptionPane.showMessageDialog(null, "Alert: Spot "+spotID+" already exists!. ");
                }
            }
            
            if(!isParkingSlotDuplicate)
            {
                String spotstfvis = JOptionPane.showInputDialog("Is this parking space for a staff or visitors??").toUpperCase();
                if(spotstfvis.contains("STAFF"))
                {
                     /* checking if id starts with V, total length is 4 and contains numerics after V */
                    if (spotID.startsWith("S") && spotID.length()==4 && spotID.substring(1).chars().allMatch( Character::isDigit ))
                    {
                        JOptionPane.showMessageDialog(null, "Success! Staff Parking Added.");
                        ParkingSlot aParkingSlot = new ParkingSlot(spotID, true);         // New parking spots are configured by default with isStaff set to false
                        carpar.addNewParkingSlot(aParkingSlot);
                        headerpanel.removeAll();
                        showAllParkings();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Staff parking must begin with the letter S and have 4 digits, for example, (S101). Try again.");
                    }
                }
                else if(spotstfvis.contains("VISITOR"))
                {
                    /* If the user does not select staff or visitor, an error message will appear */
                    if (spotID.startsWith("V")  && spotID.length()==4 && spotID.substring(1).chars().allMatch( Character::isDigit ))
                    {
                        JOptionPane.showMessageDialog(null, "Successfully added Visitor Parking Spot");
                        ParkingSlot aParkingSlot = new ParkingSlot(spotID);       // new parking spot by default isStaff is false
                        carpar.addNewParkingSlot(aParkingSlot);
                        headerpanel.removeAll();
                        showAllParkings();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Visitor Parking must begin with V should be 4 digits i.e. (V999). Try again");
                    }
                    }
                      /* If the user does not select staff or visitor, an error message will appear */
                    else
                    {
                    JOptionPane.showMessageDialog(null, "Please choose \"staff\" or \"visitor\"");
                    }
                }
            }
        }
    } 
    
   /**
    * The parking slots have been updated to be vacant after the parked vehicle has been removed from the slots
    * By utilizing the registration number that is taken from the user's input.
    * The listener for this function is implemented in the prepareGUI class as an anonymous inner class listener.
    */  
    
   public void removeVehicle(){
       boolean userQuery = false;
       String rego = JOptionPane.showInputDialog("Please enter the registration number of the vehicle, e.g. (D12345).");
           if(rego!=null)
           {
           for(ParkingSlot aParkingSlot : carpar.getAllParkingSlots())
            {
            /*  checking if parking is occupied and vehicle is an instance of Car */
            if(aParkingSlot.getIsOccupied() && aParkingSlot.getCar() instanceof Car )
            {
                  /*  checking if registration matches. */
                if(((Car)aParkingSlot.getCar()).getRego().equals(rego))
                {
                 aParkingSlot.removeCar();
                 userQuery = true;
                 JOptionPane.showMessageDialog(null, "Car removed successfully");
                 headerpanel.removeAll();
                 showAllParkings();
                }
            }
        }
    }
         /*   If the user query is not true, an error message will be displayed  */
       if(!userQuery)
        {
           JOptionPane.showMessageDialog(null, "Car not found");
        }
    
    }
    
   /**
    * This JFrame provides functionality for ParkingSlot buttons in showAllParkings().
    * Implements the functions addParkingSpot(), removeParkingSpotSubMenu(String spotid).
    * When a parking space is occupied, remove the CarSubMenu(String spotid).
    * Upon determining that a parking space is vacant, parkCarSubMenu(spotid).
    * An action listener that receives the spotid from the clicked button.
    * Display menu options to the user after selecting a menu.
    * Execute the function associated with it.
    */
    
    
    public void actionPerformed(ActionEvent e)
    {
        
        String spotid = e.getActionCommand().substring(6, 10);
        final JPopupMenu menu = new JPopupMenu("Menu");
        menu.add("Add Parking Spot").addActionListener(ee-> {    
        addParkingSpot();                                // Activate the parking spot by running the addParkingSpot function
        });
        menu.add("Delete Spot "+spotid ).addActionListener(ee-> {  
         removeParkingSpotSubMenu(spotid);                 // Remove ParkingSpotSubMenu using the parameter of spotID
        });
        if(carpar.findParkingbyID(spotid).getIsOccupied()){
            
        menu.add("Remove Car" ).addActionListener(ee-> {
        removeCarSubMenu(spotid);                     // Run the removeCarSubMenu function with spotid as an argument
                                                          //   Pass the spot as a parameter if it is already occupied
        });
            
        }
        
        if(!carpar.findParkingbyID(spotid).getIsOccupied()){
            
            menu.add("Park Car" ).addActionListener(ee-> {
            parkCarSubMenu(spotid);                             // Run the parkCarSubMenu function using the spotID 
        });                                                     //   When a spot is available, use this parameter     
            
        }
        menu.show(labelButton, labelButton.getWidth(), labelButton.getHeight());   // On clicking the parking slot button, a menu will appear
    }
    
    
public void parkCarSubMenu(String spotid) {
    String reg = JOptionPane.showInputDialog(null, "Enter your registration number (e.g., D1234):", "Open Registration", JOptionPane.INFORMATION_MESSAGE);
    
    if (reg != null) {
        // Use a regular expression to validate the car registration format
        if (reg.matches("^[A-Z]\\d{4}$")) {  
            if (carpar.findVehicleRego(reg).isEmpty()) {
                String owner = JOptionPane.showInputDialog(null, "Enter Owner Name:", "Enter Owner Window", JOptionPane.INFORMATION_MESSAGE);

                if (owner != null && !owner.isEmpty()) {
                    String parkingType = JOptionPane.showInputDialog(null, "Enter parking type (staff/visitor):", "Parking Type", JOptionPane.INFORMATION_MESSAGE);

                    if (parkingType != null) {
                        if (parkingType.equalsIgnoreCase("staff")) {
                            if (carpar.findParkingbyID(spotid).getIsStaff()) {
                                Car car = new Car(reg, owner);
                                carpar.findParkingbyID(spotid).addStaffVehicle(car);
                                JOptionPane.showMessageDialog(null, "Staff car parked successfully", "Car Parked", JOptionPane.INFORMATION_MESSAGE);
                                headerpanel.removeAll();
                                showAllParkings();
                            } else {
                                JOptionPane.showMessageDialog(null, "This spot " + spotid + " isn't a staff spot", "Not a Staff Spot", JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (parkingType.equalsIgnoreCase("visitor")) {
                            if (!carpar.findParkingbyID(spotid).getIsStaff()) {
                                Car car = new Car(reg, owner);
                                carpar.findParkingbyID(spotid).addVisitorVehicle(car);
                                JOptionPane.showMessageDialog(null, "Visitor car parked successfully", "Car Parked", JOptionPane.INFORMATION_MESSAGE);
                                headerpanel.removeAll();
                                showAllParkings();
                            } else {
                                JOptionPane.showMessageDialog(null, "This spot " + spotid + " is not for visitor parking", "Not a Visitor Spot", JOptionPane.ERROR_MESSAGE);
                            }
                         } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid car registration number (e.g., D1234)", "Invalid Registration Format", JOptionPane.ERROR_MESSAGE);
        }
    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid owner name", "Invalid Owner Name", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car park registrations already exist in the car park", "Duplicate Registration", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid car registration number (e.g., D1234)", "Invalid Registration Format", JOptionPane.ERROR_MESSAGE);
        }
    }
}


     
            
   /**
    * The parking slot can be removed by clicking on the parking slot button. If the parking slot is not occupied then it will be removed.
    * It is implemented in showAllParkings by using this frame as a listener so that the function can be called.
    * 
    */ 
   
   public void removeParkingSpotSubMenu(String spotid){
         if(carpar.removeAParkingSlot(spotid))
         {
            JOptionPane.showMessageDialog(null, "Successfully Deleted The Parking Spot.");
            headerpanel.removeAll();
            showAllParkings();
         }
          else
         {
            JOptionPane.showMessageDialog(null, "Alert: Parking spot is occupied. Please try again later.");

         }
    }
   
    /**
    * Removing the Car parked in an occupied parking spot .
    * A listener is used in showAllParkings, which is only used by occupied parking spaces.
    * 
    */ 
            
   public void removeCarSubMenu(String id){
    carpar.findParkingbyID(id).removeCar();
    JOptionPane.showMessageDialog(null, "Successfully removed the car");
    headerpanel.removeAll();
    showAllParkings();
    }
    
    /**
    * Displaying all parking spaces available to the user. This includes spaces that are occupied and vacant.
    * Interactive buttons are used to display the output and to provide functionality by utilizing this frame as a listener.
    * In the prepareGUI class, this function is implemented as an anonymous inner class listener.
    */ 
    
    
   
   public void showAllParkings() {
    headerpanel.removeAll();

    for (ParkingSlot aParkingSlot : carpar.getAllParkingSlots()) {
        JButton slotButton = new JButton(aParkingSlot.getParkingSlotId());

        // Set the background color based on whether it's a visitor or staff parking
        if (aParkingSlot.getIsStaff()) {
            slotButton.setBackground(new Color(240, 153, 125)); // Staff color
        } else {
            slotButton.setBackground(new Color(242, 247, 161)); // Visitor color
        }

        // Add text and other information to the button
        StringBuilder buttonText = new StringBuilder("<html>");
        buttonText.append(aParkingSlot.getParkingSlotId()).append("<br/>");
        buttonText.append(aParkingSlot.getIsStaff() ? "Staff" : "Visitor").append("<br/>");
        buttonText.append(aParkingSlot.getIsOccupied() ? "Occupied" : "Vacant");
        
        // If the slot is occupied and has a car, add owner and registration information
        if (aParkingSlot.getIsOccupied() && aParkingSlot.getCar() instanceof Car) {
            Car car = (Car) aParkingSlot.getCar();
            buttonText.append("<br/>").append(car.getOwner());
            buttonText.append("<br/>").append(car.getRego());
        }
        
        buttonText.append("</html>");
        
        slotButton.setText(buttonText.toString());
        headerpanel.add(slotButton);

        slotButton.addActionListener(this); // This acts as a listener for buttons displayed on the screen
    }

    headerpanel.revalidate();
    headerpanel.repaint();
    mainFrame.setVisible(true);
}

    
   /**
    * Input of registration is used to locate the car. If there is no car available, the system will turn back to the user.
    * The user is then taken back to the home screen after viewing an error message
    * An anonymous inner class listener implements this function.
    */ 
   
   public void findCar() {
    headerpanel.removeAll();
    headerLabel = new JLabel("");
    
    String rego = JOptionPane.showInputDialog("The Registration No of the Car i.e (D1234)");
    if (rego != null && isValidRego(rego)) {
        String details = getCarParkingDetails(rego);
        if (!details.isEmpty()) {
            headerLabel.setText(details);
            headerpanel.add(headerLabel);
            headerpanel.revalidate();
            headerpanel.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No car found with the given registration.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Invalid registration format.");
    }
}

private boolean isValidRego(String rego) {
    return rego.matches("^[A-Z]\\d{4}$");
}

private String getCarParkingDetails(String rego) {
    String value = "<html> Your Parking details are as following: <br><p style='font-size:11px;'>" + "ID " + " Status " + " Vacancy " + " Registration " + " Owner " + " Time In " + "</p>";

    boolean carFound = false;

    for (ParkingSlot aParkingSlot : carpar.getAllParkingSlots()) {
        if (aParkingSlot.getIsOccupied() && aParkingSlot.getCar() instanceof Car) {
            if (((Car) aParkingSlot.getCar()).getRego().equals(rego)) {
                value += "<p>" + aParkingSlot.getParkingSlotId() + " " + ((aParkingSlot.getIsStaff()) ? "Staff Parking" : "Visitor Parking") + " " + ((aParkingSlot.getIsOccupied()) ? "Occupied" : "Vacant") + " " + ((Car) aParkingSlot.getCar()).getRego() + " " + aParkingSlot.getCar().getOwner() + " " + aParkingSlot.getCar().getTimeIn() + " min</p>";
                carFound = true;
            }
        }
    }

    value += "</html>";
    return carFound ? value : "";
}



    
   /**
    * Inputs the registration number, owner name, and spot ID when parking a car. Duplicate registrations are not permitted.
    * The listener for this function is implemented in the prepareGUI  as an anonymous inner class listener.
    */  
    
   public void parkCar(){
       String rego = JOptionPane.showInputDialog("The Rego Number of the Car eg (D1234)");
   
       String value = "";
       if(rego!=null){
       if (rego.length() == 5 && !carpar.findVehicleRego(rego).contains(rego) && Character.isUpperCase(rego.charAt(0)) && rego.substring(1).matches("[0-9]{4}"))
        {
            String owner = JOptionPane.showInputDialog("Enter Name of the owner");
            Car car = new Car(rego , owner);                          // init new car
            Car vehicle = car;
           if(carpar.getAvailableParkingSlots().isEmpty()){
                headerLabel.setText("No Car Park Available");
           }
           else if(!carpar.findVehicleRego(rego).isEmpty()){
                JOptionPane.showMessageDialog(headerLabel, "Registration exists in carpark. Please select another Registration", "Duplicate Vehicle", JOptionPane.WARNING_MESSAGE);
                headerLabel.setText("<html>Alert: Vehicle Registration Already exists! Can not Park more than one Vehicle.</html>");
           }
           else
           {
              //value = "Please select a Parking Spot from below: " + "<br>";
              headerpanel.removeAll();
              showAllParkings();
              String parkingSpot = JOptionPane.showInputDialog("Enter Spot You Want to Park eg. (S001)");
              String staffMember = JOptionPane.showInputDialog("Are you a staff or visitor?");
              if (parkingSpot !=null && staffMember !=null){
              if(carpar.findParkingbyID(parkingSpot).getParkingSlotId().equals(parkingSpot) && !carpar.findParkingbyID(parkingSpot).getIsOccupied() )
            {  
              switch(staffMember)
              {
                  case "staff":
                  if(carpar.findParkingbyID(parkingSpot).getIsStaff()){
                      carpar.findParkingbyID(parkingSpot).addStaffVehicle(vehicle);
                      JOptionPane.showMessageDialog(null, "Success Staff Car is Parked");
                      headerpanel.removeAll();
                      showAllParkings();
                      break;
                    }
                  else{
                    JOptionPane.showMessageDialog(null, "The spot you have chosen is not a staff parking spot");
                    break;
                    }
                    
                  case "visitor":
                  if(!carpar.findParkingbyID(parkingSpot).getIsStaff()){
                      carpar.findParkingbyID(parkingSpot).addVisitorVehicle(vehicle);
                      JOptionPane.showMessageDialog(null, "Success Visitor Car is Parked");
                      headerpanel.removeAll();
                      showAllParkings();
                      break;
                    }
                  else{
                    JOptionPane.showMessageDialog(null, "The spot you have chosen is not a visitor parking spot");
                    break;
                    }  
                    
                  default:
                  JOptionPane.showMessageDialog(null,"Please enter \"staff\" or \"visitor\" ");
                  
              }
             
            }
            else
            {
                headerLabel.setText("<html><div style='text-align: center;'> Spot is occupied or no parking exists</div></html>");
                JOptionPane.showMessageDialog(headerLabel, "Spot is occupied or doesn't exist", "Parking Spot Error", JOptionPane.ERROR_MESSAGE);
            }
           }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(headerLabel, "Make Sure Registration follows proper format eg.(D1234).", "Registration input incorrect", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
   
   /**
    *Runs the GUI application by adding a carpark instance to a GUI instance and calling showHomeScreen.
    */ 
    
   public static void main(String[] args)
   {
      CarPark carpar = new CarPark(); 
      GUI  newGUI = new GUI(carpar);  
      newGUI.showHomeScreen();
   }
}