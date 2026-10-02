# Program 6: MPLS Dog Management System using OOP Principles
**Programs 6 is similar in functionality to program 5**

The MPLS Dog Boarding company would like for you to create an application that allows for a care attendant to be able 
to create, retrieve and update dog records from the system. MPLS Dog Boarding can only have 12 dogs in their care at a time. When you select the option to **create** a dog record.  You will 
enter the dog's id, dog's name, weight and dog's age.  Once information is entered for a dog, the program will display
entered information and reprompt the care attendent to select an option to exit, display, create or update dog record.  

When the **update** option is selected the care attendant will be presented with option to enter the dog's id number and reassign information
pertaining to dog.  

When the **retrieve** option is selected, the user will be able to enter the dog's id and be presented
with dog information.

## What makes this program different from program 5
1. You will create and utilize a class structure to create dog objects.  
2. You will add functionality to read from a file and create new dog records.  The dog records should be held within an ArrayList.   

**Hints**
- Consider reading all the dog data from the file and creating your object instances once your program starts  
- Use ArrayList collection to store your dog objects.
- Use the toString method to format and display dog information.

Your program should operate similarly to the program shown in the .gif below The .gif below show three iterations of running the program

![Alt text](https://instructorc.github.io/site/slides/java/images/methods/sample_output_prog5.gif "Program 5 Execution Example")


#### Listed below is a detailed explanation of the requirements needed to complete the dog management system.  

## Requirement 1 (5 Points) 
Variables are properly declared and initialized; Use of Scanner Object to read input from console. Make use of constant final variables. 
Whenever possible, make sure to declare all variables that will hold data along with declaring final variables that will not change during runtime.
Proper structure used for allowing the end-user to continously select menu option until a sentinel value is entered.  Proper syntax for instantiating new objects.

## Requirement 2 (5 Points) 
The class structure should included these 5 things:
    1. Your class should have a minimum of 5 attributes.  Data encapsulation should be enforced with the use of Getter and Setter methods
    2. A constructor that allows you to set all of the class properties
    3. A default constructor that sets properties to default values.
    4. Methods that will allow you to display, create and update dog record.
    5. A toString method that outputs the dogs info.

## Requirement 3 (5 Points) 

Input from the csv file - Program reads all data into program and creates object instances.  All objects are added to an ArrayList.

## Requirement 4 (5 Points) 
Style - Proper use of comments, spacing, in program; use of descriptive variable names

## Requirement 5 (5 Points) 
Program is submitted by the due date listed and pushed to assigned GitHub Repository; Repository contains a minimum of three commits.

## Submission
Your project folder will need to be submitted to the assigned GitHub repository provided to you by the instructor. In Sakai, you will need to submit the link to your repository by the due date and time listed in the write-up. Make sure you receive confirmation from Sakai that your assignment has been submitted.
If you prefer, you can also submit the .java file to Sakai.

