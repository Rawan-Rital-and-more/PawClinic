package pawclinic;

import java.util.Scanner;

public class Visitor {
    
    //---------- fields
    private String First_Name;
    private String Last_Name;
    private int Phone_Number;
    public String Pet_Type;
    public int NUM_OF_PETS;
    
    
    public Visitor(String Fname, String Lname, int PhoneNum){
            First_Name = Fname;
            Last_Name = Lname;
            Phone_Number = PhoneNum; 
    }
    
    public Visitor(){
        
    }
    
    //---------- setters
    public void setFirstName(String Fname){
        First_Name = Fname;
    }
    public void setLastName(String Lname){
        Last_Name = Lname;
    }
    public void setPhoneNum(int PhoneNum){
        Phone_Number = PhoneNum;
    }
    public void setNumOfPets(int petNum){
        NUM_OF_PETS = petNum;
    }
    
    //---------- getters
     public String getfullName(){
        return First_Name +" "+Last_Name;
    }
     public int getPhoneNum(){
         return Phone_Number;
     }
     public int getNumOfPets(){
         return NUM_OF_PETS;
     }
    
    @Override
    public String toString(){
        String str = "Visitor's full name: " + First_Name + " " + Last_Name 
                + "\nVisitor's phone number: " + Phone_Number 
                + "\n_______________________________________";
        
        return str;
    }
    
    /**
     * Determine the pet type
     */
    public void catVSdog(){
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your pet type "
                + "(only cats and dogs are accepted): ");
        Pet_Type = keyboard.nextLine();
    
        while (!Pet_Type.equalsIgnoreCase("cat") &&
               !Pet_Type.equalsIgnoreCase("cats") &&
               !Pet_Type.equalsIgnoreCase("dog") &&
               !Pet_Type.equalsIgnoreCase("dogs")){
            System.out.print("Wrong pet type, please enter again: ");
            Pet_Type = keyboard.nextLine();
        }
    }      
}
