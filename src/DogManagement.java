/*--------------------------------------------
Program 5: MPLS Dog Management System
	
    [REPLACE MY INFORMATION WITH YOURS]
    Course: COMP 170, Fall I 2026
    System: Visual Studio Code, Windows 11
    Author: E. Pomes


    project wishlist: 
    1. sentinal values for:
        Entry display, giving user the option to exit after dog IDs are displayed instead of selecting an entry
        dogEntry, after available IDs are displayed
    2. Confirmation prompt for dogEntry before overwriting existing record
    3. write to file to keep data so this program would actually be usuable
        with option to save changes and confirmation prompt if exiting without saving
*/

import java.util.Scanner; //Importing Scanner Class
import java.util.ArrayList; //importing arraylist function
public class DogManagement {
    /*
     * Global Declaration for parallel arrays and Scanner Object
     */
    //DECLARING PARALEL ARRAYS OUTSIDE OF MAIN METHOD TO HOLD DOG DATA use the static keyword
    static final int[] dogID = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    static String[] dogName = new String[12];
    static double[] dogWeight = new double[12];
    static int[] dogAge = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    //arraylists for tracking slot status
    static ArrayList<Integer> closedSlots = new ArrayList<Integer>();
    static ArrayList<Integer> openSlots = new ArrayList<Integer>();

    //DECLARING SCANNER OBJECT
    static Scanner scn = new Scanner(System.in);
    
    //this is used to re-sync user input with the actual index number of the arrays, should always be 'user input - 1 = array index'
    static int raw;
    static int adjustedEntry; 

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

  //main method here
    public static void main(String[] args) throws Exception {
        //local variables
        int menuOption;

        welcome();
        while(true){
            options();
            menuOption = getInput(scn, "Enter selection here: ", "Menu option does not exist. ",5);
            if (menuOption == 1) {
                dogEntry();
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

    //end helper methods

    /*
    *adding spaces to make code easier to scan visually
    *
    * 
    * 
    * the two methods below are used to check if any given index number in the parallel arrays already have data*/
    
    /**error is happening in making entries into the array list - testing showed that the arraylist does generate, 
     * but it doesn't populate
     * 
     * 
     * changelog 1: switched from using dogName array to dogAge array, and set all dogAgg elements to zero. Swapped
     * if(dogName[i] == null) to if(dogAge[i] == 0), added a seperate step to create an int for the ID, no go.
     * 
     * changelog 2: tested with a for loop with an if statement, if dogAge[i] == 0, print i+1. nothing. The loop doesn't
     * appear to be working
     * 
     * changelog 3: moved the entire for loop into the main method, it didn't run. 
     * 
     * changelog 4: tested by changing dogAge[i] == 0 to dogAge[1] < 1
     * 
     * changelog 5: I'm an idiot and need to be tested for dyslexia, the for loop was set up with i > dogAge.length instead of
     * i < dogAge.length
     */
    public static void freeSlot() {  
        /* checks which slots in the parallel arrays have null entries
        *@param i - the parallel arrays index number
        *@param s - the arraylist index number
        * */
        for (int i = 0; i < dogAge.length; i++){ 
            /*dogAge array is used as test for if other parallel arrays indices are in use
            *the zero value can only exist if parallel arrays haven't been filled
            *since the array is initialized with zeros for each indices and user input is limited to >=1
            */
            if(dogAge[i] == 0) {
                openSlots.add(i + 1); 
                //updates the arraylist with the adjusted value - the index number is always 1 less than the dog ID
            }
        }
        if(openSlots.isEmpty()) {
            System.out.println("All Dog IDs are assigned!"); //keeps program from printing a no entry list
        } else {
            for(int s = 0; s < (openSlots.size() - 1); s++) //only one free ID case formatting
                if(s == (openSlots.size() - 1) && s == 0){
                    System.out.println("Dog ID " + openSlots.get(s) + "is free.");
                    break; 
                } else { //multiple free IDs
                    System.out.print("Dog IDs "); //fixed output in front of the variable output
                    for(int m = 0; m < openSlots.size(); m++) {
                        if(m == (openSlots.size() - 1)){ //for loop to print out all open slots
                            System.out.print("and " + openSlots.get(s)); //last entry in list gets special formatting
                        } else {
                            System.out.print(openSlots.get(s) + ", "); //everything else gets entry-comma-space format
                        }
                }
            }
            System.out.println(" are free. ");   //fixed output after the variable output    
        }
        openSlots.clear(); //clear arraylist so changes are reflected next time it runs 
    }


    public static void usedSlot() { 
        /* checks which slots in the parallel arrays indices are in use, like freeSlot unless noted
        *@param i - the parallel arrays index number
        *@param s - the arraylist index number
        * */
        for (int i = 0; i < dogAge.length; i++){
            if(dogAge[i] != 0) {
                closedSlots.add(i + 1);
            }
        }
        if(closedSlots.isEmpty()) {
            System.out.println("No IDs currently in use.");
        } else {
            System.out.println("Dog IDs in use:"); //different formatting, fixed output is only in front of variable output
            for(int s = 0; s < closedSlots.size(); s++) {  
                System.out.println("# " +  (s + 1) + ": " + dogName[s]);      
            }
        }
    }
    //end index check methods
    
    //method to display array elements
    
    public static void entryDisplay() {
        //no parameters in this one.
        usedSlot();
        if(Empty(closedSlots)){
            System.out.println("No existing entries, terminating edit function.");
            return;
        }
        adjustedEntry = getInput(scn, "Select dog ID: ", "Not a valid ID.", 12) - 1;
        if(dogName[adjustedEntry] == null){
            System.out.println("Unused ID");
        } else {
            System.out.println("\nDog Name: " + dogName[adjustedEntry]);
            System.out.println("Dog Weight: " + dogWeight[adjustedEntry] + " lbs");
            System.out.println("Dog Age: " + dogAge[adjustedEntry]);
        }
    }   
    
    //another helper method, for terminating the 'update' branch if there's no existing data
    public static boolean Empty(ArrayList<Integer> i){
        /*
        *@param ArrayList<Integer> i- this pulls the arraylist used by name  */
        if(i.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    

   
    //*two methods below are for altering array elements

    public static void dogEntry() {
        /* no parameters in this method
        *
        *wishlist: add a confirmation prompt before overwriting an existing entry*/
        freeSlot();  //displays open slots but does not prevent overwriting
        raw = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 12); //this takes the user input and assigns it to a variable
        adjustedEntry = raw - 1; //this matches the displayed dog ID with its index number
        System.out.print("Enter Dog Name: "); 
        dogName[adjustedEntry] = scn.nextLine();
        dogWeight[adjustedEntry] = dogWeight(scn, "Enter Dog Weight in lbs: ");
        dogAge[adjustedEntry] = getInput(scn, "Enter Dog Age: ", "Please be serious. What's the actual age?", 32);
        //according to wikipedia, the oldest dog to ever live died a few months short of 32 years old
        System.out.println("\nRecord " + raw + " has successfully been updated.\n");
    }



    public static void entryUpdate() {
        int fieldNumber; //declared as local because it's only used here, it gets initialized as the user input
        usedSlot();
        adjustedEntry = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 12) - 1;
        //check if the entry already exists, to prevent users from entering data in only one of the parallel arrays
        while(dogName[adjustedEntry] == null){ 
            System.out.println("Unused ID");
            System.out.print("Enter Valid ID or hit any letter to go back to menu: ");
            while(scn.hasNextInt()) {
                adjustedEntry = getInput(scn, "Enter dog ID: ", "Not a valid ID.", 12) - 1;
            }
            return; //if the input isn't an integer, method terminates and program starts from main again.
        }
        //the part where users are allowed to update fields, where fieldNumber gets initialized
        System.out.println(ENTRY_UPDATE_PROMPT);
        System.out.println(UPDATE_OPT_1);
        System.out.println(UPDATE_OPT_2);
        System.out.println(UPDATE_OPT_3);
        fieldNumber = getInput(scn, "Enter the field number you wish to edit: ", "Selected field does not exist.",3);
        if(fieldNumber == 1) { //updates dog name
            System.out.println("Current Dog Name: " + dogName[adjustedEntry]);
            System.out.print("Enter new Dog Name: ");
            dogName[adjustedEntry] = scn.next();
        } else if (fieldNumber == 2) { //updates dog weight
            System.out.println("Current Dog weight: " + dogWeight[adjustedEntry] + " lbs");
            dogWeight[adjustedEntry] = dogWeight(scn, "Enter new Dog Weight: ");
        } else { //updates dog age
            System.out.println("Current Dog Age: " + dogAge[adjustedEntry]);
            dogAge[adjustedEntry] = getInput(scn, "Enter Dog Age:", "Please be serious. What's the actual age?", 32);
        }

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
