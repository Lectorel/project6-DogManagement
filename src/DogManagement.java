/*--------------------------------------------
Program 6: MPLS Dog Management System
	
    Course: COMP 170, Fall I 2026
    System: Visual Studio Code, Windows 11
    Author: E. Pomes
*/

import java.util.Scanner; //Importing Scanner Class
import java.util.ArrayList; //importing arraylist function
public class DogManagement {

    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword
    static ArrayList<Integer> dogID;
	// static ArrayList<String> dogName;
	// static ArrayList<double> dogWeight;
	// static ArrayList<Integer> dogAge;

    /*
	//arraylists for tracking slot status
    static ArrayList<Integer> closedSlots = new ArrayList<Integer>();
    static ArrayList<Integer> openSlots = new ArrayList<Integer>();
	*/

    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);
    
  /*
	//this is used to re-sync user input with the actual index number of the arrays, should always be 'user input - 1 = array index'
    static int raw;
    static int adjustedEntry; */

    //declaring final variables for menu options
    final static String NAV_PROMPT = "\nSelect a menu option:";
    final static String NAV_OPT_1 = "\t1) Create a dog record";
    final static String NAV_OPT_2 = "\t2) Display dog record";
    final static String NAV_OPT_3 = "\t3) Update dog record";
    final static String NAV_OPT_4 = "\t4) Exit Program";
    final static String NAV_OPT_5 = "\t5) Just for fun: current boarders' ages in dog years";
    final static String ENTRY_UPDATE_PROMPT = "Which field do you want to edit?";
    final static String UPDATE_OPT_1 = "1. Name";
    final static String UPDATE_OPT_2 = "2. Weight";
    final static String UPDATE_OPT_3 = "3. Age";
	final static String UPDATE_OPT_4 = "4. Delete record";

  //main method here
    public static void main(String[] args) throws Exception {
        //local variables
        int menuOption;

		//read existing doginfo file, convert into entries into dog objects, create arraylist for dogIDs
        welcome();
        while(true){
            options();
            menuOption = getInput(scn, "Enter selection here: ", "Menu option does not exist. ", 5);
            if (menuOption == 1) {
                CreateEntry();
            } else if (menuOption == 2) {
                entryDisplay();
            } else if (menuOption == 3) {
                entryUpdate();
            } else if(menuOption == 4){
                System.exit(4);
            } else {
                dogYears();
            }
        }    

    }

    //Welcome method that outputs introductory options explaining program
    
    public static void welcome(){
        System.out.println("Welcome, this program allows for a care attendant to be able to create, retrieve and update a dog record from the system.");

    }

    public static void options(){
        System.out.println(NAV_PROMPT);
        System.out.println(NAV_OPT_1);
        System.out.println(NAV_OPT_2);
        System.out.println(NAV_OPT_3);
        System.out.println(NAV_OPT_4);
        System.out.println("\n" + NAV_OPT_5 + "\n");

    }


    /*
    *
    *Found and adapted methods below from here: https://stackoverflow.com/questions/24835445/how-to-limit-the-input-to-the-scanner
    *method getInput was written to allow users to navigate menu without breaking the program with invalid input
    *methods isInteger and isDouble check for correct data type
    *method menuLimit sets the upper and lower bounds of accepted int/double
    *method getInput was reproduced as dogWeight for use with doubles
    */
    
    public static int getInput(Scanner scn, String prompt, String error, int upperLimit) { 
        /* @param scn - used to get user input
        * @param prompt - what string the program outputs to direct the user
        * @param upperLimit -  highest number the menu can navigate to/the highest accepted value for a array element
        * */
        int menuOption;
        System.out.print(prompt); // Tell user what to input
        String menuString = "";
        while (true) { // Keep looping until valid input is found
            menuString = scn.nextLine();
            if(isInteger(menuString)) // method call
                break; // Exit loop
            System.out.print("Invalid input type, " + prompt); // Wasn't valid, prompt again
        }
        while (true)  {
            menuOption = Integer.parseInt(menuString);
            if(menuLimit(menuOption, upperLimit)) { //method call
                break;
            } else {
                System.out.print(error + " " + prompt);
                menuString = scn.nextLine();
            } //without this line it's an infinite loop
        }
        return menuOption; // Return valid user input
    }

    public static double dogWeight(Scanner scn, String prompt) { 
        /*
        * @param scn - used to get user input
        * @param prompt - what string the program outputs to direct the user
        */
        double menuOption;
        System.out.print(prompt); // Tell user what to input
        String menuString = "";
        while (true) { // Keep looping until valid input is found
            menuString = scn.nextLine();
            if(isDouble(menuString)) // method call
                break; // Exit loop
            System.out.print("Invalid input type, " + prompt); // Wasn't valid, prompt again
        }
        menuOption = Double.parseDouble(menuString);
        return menuOption; // Return valid user input
    }

    // helper methods 
    //these first two methods limit what user input is accepted, by forcing a loop until a string parses as an integer/double

    public static boolean isInteger(String menuResponse) {
        //@param menuResponse - this is the string from user input in getInput
        try {
            Integer.parseInt(menuResponse);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String menuResponse) {
        //@param menuResponse - this is the string from user input in dogWeight
        try {
            Double.parseDouble(menuResponse);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean menuLimit (int i, int menu) {
        /*
        * @param i - this is the user input from getInput, after it's passed the isInteger check
        * @param menu - this is the highest number in the available menu options
         */
        if(i > menu) {
            return false;
        } else if (i < 1) {
            return false;
        } else {
            return true;
        }
    }

	public static int getIndex (String prompt, String error; ArrayList <Integer> u){
		String response;
		System.out.print(prompt + " or hit any key to quit.");
		response = scn.nextLine();
		if(u.contains(response) {
			adjustedEntry = u.indexOf(response);
		} else {
			System.out.println(error);
			System.out.print(prompt);
			response = scn.nextLine();
        }
		return adjustedEntry;
	}
	

	    //end helper methods
	
    
    //methods for menu options
    
    public static void entryDisplay() {
        //no parameters in this one.
        if(isEmpty(dogID)){
            System.out.println("No existing entries, terminating entry display.");
            return;
        } else {
     		index = getIndex("Enter Dog ID: ", "No existing dog with that id!", ArrayList<Integer> dogID);
            
			//use ID to look up dog object, and then print dog object's attributes
			
			System.out.println("\nDog Name: " + getName());
            System.out.println("Dog Weight: " + getWeight() + " lbs");
            System.out.println("Dog Age: " + getAge());
        }
    }   
    
   
    //*two methods below are for altering array elements

    public static void createEntry() {
		int numberID;
		System.out.println("Create Dog ID: ")
		numberID = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 1000); //this takes the user input and assigns it to a variable
		if(dogID.contains(numberID)) {
			System.out.println("Dog ID already in use, please choose another.");
			numberID = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 1000);
		}
        System.out.print("Enter Dog Name: "); 
        dogName = scn.nextLine();
        dogWeight = dogWeight(scn, "Enter Dog Weight in lbs: ");
        dogAge = getInput(scn, "Enter Dog Age: ", "Please be serious. What's the actual age?", 32);
        //according to wikipedia, the oldest dog to ever live died a few months short of 32 years old

		Dog adog = new Dog(dogID, dogName, dogWeight, dogAge);

		//create dog object and then write attributes back to file
		
        System.out.println("\nRecord " + DogID + " has successfully been created.\n");
    }



    public static void entryUpdate() {
		int index;
		//look up dog object by ID attribute
		
		// index = getIndex("Enter Dog ID: ", "No existing dog with that id!", ArrayList<Integer> dogID);
		
        //the part where users are allowed to update fields, where fieldNumber gets initialized
        System.out.println(ENTRY_UPDATE_PROMPT);
        System.out.println(UPDATE_OPT_1);
        System.out.println(UPDATE_OPT_2);
        System.out.println(UPDATE_OPT_3);
		System.out.println(UPDATE_OPT_4);
        fieldNumber = getInput(scn, "Enter the field number you wish to edit: ", "Selected field does not exist.", 3);
        if(fieldNumber == 1) { //updates dog name
            System.out.println("Current Dog Name: " + getName());
            System.out.print("Enter new Dog Name: ");
            setName();
        } else if (fieldNumber == 2) { //updates dog weight
            System.out.println("Current Dog weight: " + getWeight() " lbs");
            setWeight();
        } else if (fieldNumber == 3) { //updates dog age
            System.out.println("Current Dog Age: " + getAge());
            setAge();
        } else {
			//delete dog object, remove from file
		}
		//write parallel arrays back to file, re-initialize file list to update dog object?
    }

    //extra credit, dog years module
    public static void dogYears() {
        int dogYears;
        for (int i = 0; i < dogAge.length; i++){
            if(dogAge[i] != 0) {
                closedSlots.add(i + 1);
            }
         System.out.println("Dog IDs in use:"); //different formatting, fixed output is only in front of variable output
            for(int s = 0; s < openSlots.size(); s++) {
                dogYears = dogAge[s-1] * 15;
                System.out.println("# " +  s + ": " + dogName[s-1] + " Age: " + dogAge[s-1] + " Age in Dog Years: " + dogYears);      
            }
        }
    }
}
