/*--------------------------------------------
Program 6: MPLS Dog Management System
	
    Course: COMP 170, Fall I 2026
    System: Visual Studio Code, Windows 11
    Author: E. Pomes
*/

import java.util.ArrayList; //Importing Scanner Class
import java.util.Scanner; //Importing ArrayList Class
public class DogManagement {

    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword

    //readfromfile goes to arraylist, arraylist convert to objects, with index 0 used for object name
   static ArrayList<Dog> globalDogList = new ArrayList<Dog>();
    //test change
    


    //readFromFile();
    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);
    

    static int index;
    // static int adjustedEntry;

    //declaring final variables for menu options
    final static String NAV_PROMPT = "\nSelect a menu option:";
    final static String NAV_OPT_1 = "\t1) Create a dog record";
    final static String NAV_OPT_2 = "\t2) Display dog record";
    final static String NAV_OPT_3 = "\t3) Update dog record";
    final static String NAV_OPT_4 = "\t4) Exit Program";
    final static String ENTRY_UPDATE_PROMPT = "Which field do you want to edit?";
    final static String UPDATE_OPT_1 = "1. Name";
    final static String UPDATE_OPT_2 = "2. Weight";
    final static String UPDATE_OPT_3 = "3. Age";
	final static String UPDATE_OPT_4 = "4. Delete record";

  //main method here
    public static void main(String[]args) throws Exception {
        //local variables
        int menuOption;

		//read existing doginfo file, convert into entries into dog objects, create arraylist for dogIDs
        Helper helper = new Helper();
        globalDogList = helper.dogList;

        welcome();
        while(true){
            options();
            menuOption = getInput(scn, "Enter selection here: ", "Menu option does not exist. ", 5);
            switch (menuOption) {
                case 1:
                createEntry();
                break;
            case 2:
                entryDisplay();
                break;
            case 3:
                entryUpdate();
                break;
            case 4:
                System.exit(4);
                break;
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

    }
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
            if(isInteger(menuString)) {// method call
                break; // Exit loop
            } else {
                System.out.print("Invalid input type, " + prompt); // Wasn't valid, prompt again
            }
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

    public static int dogAge(Scanner scn, String prompt) {
        System.out.print(prompt); // Tell user what to input
        int menuOption;
        String menuString;
        while (true) { // Keep looping until valid input is found
            menuString = scn.next();
            if(isInteger(menuString)) {
                menuOption = Integer.parseInt(menuString);
                break;
            }else {
                System.out.print("Invalid input type, " + prompt);
            } // Wasn't valid, prompt again
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
        String menuString;
        while (true) { // Keep looping until valid input is found
            menuString = scn.next();
            if(isDouble(menuString)) {// method call
                menuOption = Double.parseDouble(menuString);
                break; // Exit loop
            } else if(isInteger(menuString)) {
                double converter = Integer.parseInt(menuString);
                menuOption = converter;
                break;
            }else {
                System.out.print("Invalid input type, " + prompt);
            } // Wasn't valid, prompt again
        }
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
        if(i > menu || i < 1) {
            return false;
        } else {
            return true;
        }
    }

	public static int getIndex (String prompt, String error, ArrayList <Dog> u){
       // Helper helper = new Helper();
        //globalDogList = helper.dogList;
        
        int userResponse;
		userResponse = getInput(scn, prompt, error, 1000);
        while(true){
            for(int i = 0; i < u.size(); i++) {
                if(u.get(i).getID() == userResponse) {
                    index = i;
                    return index;
                }
            }
		    System.out.println(error);
		    System.out.print(prompt);
		    userResponse = Integer.parseInt(scn.next());
        }
    }

	    //end helper methods

	public static void entryDisplay() { //option 2
        //no parameters in this one.

        //Helper helper = new Helper();
       //globalDogList = helper.dogList;
        if(globalDogList.isEmpty()){
            System.out.println("No existing entries, terminating entry display.");
        } else {
     		for (int i = 0; i < globalDogList.size(); i++) { 
                if(i % 2 == 0) {
                    System.out.print("ID: " + globalDogList.get(i).getID() + " | Name: " + globalDogList.get(i).getName());
                } else{
                System.out.println("\t ID: " + globalDogList.get(i).getID() + " | Name: " + globalDogList.get(i).getName()); 
                }
            }
            //change - instead of pulling index, look up actual object and pull that
            index = getIndex("\nEnter Dog ID: ", "No existing dog with that id!", globalDogList);
            
			//use ID to look up dog object, and then print dog object's attributes

			//getName(globalDogList.get(index))
			//(globalDogList.get(index)).name
			System.out.println("\nDog Name: " + globalDogList.get(index).getName());
            System.out.println("Dog Weight: " + globalDogList.get(index).getWeight() + " lbs");
            System.out.println("Dog Age: " + globalDogList.get(index).getAge());
        }
    }   
//*two methods below are for altering array elements

    public static void createEntry() {
		//Helper helper = new Helper();
        //globalDogList = helper.dogList;
        int numberID;
		String dogName;
		double dogWeight;
		int dogAge;
		numberID = getInput(scn, "Create dog ID: ", "Not a valid ID.", 1000); //this takes the user input and assigns it to a variable
		for(int i = 0; i < globalDogList.size(); i++) {
            if(globalDogList.get(index).getID() == (numberID)) {  //edit for object arraylist instead of int
			    System.out.println("Dog ID already in use, please choose another.");
			    numberID = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 1000);
		    }
        }
        System.out.print("Enter Dog Name: "); 
        dogName = scn.next();
        dogWeight = dogWeight(scn, "Enter Dog Weight in lbs: ");
        dogAge = dogAge(scn, "Enter Dog Age: ");
        //according to wikipedia, the oldest dog to ever live died a few months short of 32 years old

		Dog adog = new Dog(numberID, dogName, dogWeight, dogAge);
        globalDogList.add(adog);

		//create dog object and then write attributes back to file
		
        System.out.println("Record " + numberID + " has successfully been created.\n");
    }



    public static void entryUpdate() {
		//Helper helper = new Helper();
        //globalDogList = helper.dogList;
		int fieldNumber;
		index = getIndex("Enter Dog ID: ", "No existing dog with that id!", globalDogList);
		
        //the part where users are allowed to update fields, where fieldNumber gets initialized
        System.out.println(ENTRY_UPDATE_PROMPT);
        System.out.println(UPDATE_OPT_1);
        System.out.println(UPDATE_OPT_2);
        System.out.println(UPDATE_OPT_3);
		System.out.println(UPDATE_OPT_4);
        fieldNumber = getInput(scn, "Enter the field number you wish to edit: ", "Selected field does not exist.", 4);
        switch(fieldNumber){
            case 1: //updates dog name
			    //(globalDogList.get(index)).name
                System.out.println("Current Dog Name: " + globalDogList.get(index).getName());
                System.out.print("Enter new Dog Name: ");
                String nameholder = scn.next();
                globalDogList.get(index).setName(nameholder);
                break;
            case 2: //updates dog weight
                System.out.println("Current Dog weight: " + globalDogList.get(index).getWeight() + " lbs");
                double weightHolder = dogWeight(scn, "Enter new dog weight: ");
                globalDogList.get(index).setWeight(weightHolder);
                break;
            case 3: //updates dog age
                System.out.println("Current Dog Age: " + globalDogList.get(index).getAge());
                int ageHolder = dogAge(scn, "Enter Dog Age: ");
                globalDogList.get(index).setAge(ageHolder);
                break;
            case 4: //deletes dog record
                System.out.println("Hit Y to confirm deletion, or any other key to go back to home screen.");
                if(scn.next().equalsIgnoreCase("Y")) {
                    globalDogList.remove(index);
                    System.out.println("Dog record deleted.");
                } else {
                    System.out.println("Returning to home screen.");
                }
			//delete dog object, remove from file
		}
		//write changes back to csv
    }
    
    

    }
    

