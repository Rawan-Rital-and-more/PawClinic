package pawclinic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PawClinic {

    public static void main(String[] args) throws IOException 
    {
        
        //---------- welcoming
        System.out.println("\n   🐾\t🐾");        
        System.out.println("🐾   Pawsitive Veterinary Clinic");
        System.out.println("\tFor cats & dogs care\t   🐾");
        System.out.println("\t\t\t 🐾    🐾");        
        System.out.println("____________________________________");
        
        //---------- creating scanner object
        Scanner keyboard = new Scanner(System.in);
        
        //---------- declare variables
        String fname ,lname;
        int phonenumber;
        
        //---------- prompting for the visitors data
        System.out.print( "\nEnter your first name: " );
        fname = keyboard.nextLine();
        System.out.print( "Enter your last name: " );
        lname = keyboard.nextLine();
        System.out.print( "Enter your phone number: " );
        phonenumber = keyboard.nextInt();
        
        //---------- visitor + printEtiter objects
        Visitor user = new Visitor(fname,lname,phonenumber);
        PrintWriter file = new PrintWriter("visitor.txt");
        
        file.println("\n   🐾\t🐾");        
        file.println("🐾   Pawsitive Veterinary Clinic");
        file.println("\tFor cats & dogs care\t   🐾");
        file.println("\t\t\t\t 🐾    🐾");        
        file.println("_____________________________________\n");
        
        user.catVSdog();//calling a method to determine pet type
        
        file.println("\t\tPet owner information\n");
        file.println(user);
        file.println("\n\t\tPet information");
file.close();
        //---------- calling methods based on pet type
        if (user.Pet_Type.equalsIgnoreCase("cat") ||
            user.Pet_Type.equalsIgnoreCase("cats"))
            cat(user.NUM_OF_PETS);
        else 
            dog(user.NUM_OF_PETS);
  
        System.out.println("\nThank you for trusting us,"
                + " here's your confirmation message");
        
        Scanner input = new Scanner(new File("visitor.txt"));
        while (input.hasNextLine())
        {
           System.out.println(input.nextLine());
        }
        
    }//Main method
    
    
    public static void cat(int numOfPets) throws IOException
    {
        
       CatServices cat = new CatServices();
       cat.setPetInfo();
       
       FileWriter fw = new FileWriter ("visitor.txt", true);
       PrintWriter file = new PrintWriter (fw);
       file.println("_____________________________________\n");
       file.println("\t\tServices selected\n");
       file.close();
       
       cat.setServices();
       
    }//cat method 
    
    
    public static void dog(int numOfPets) throws IOException
    {
        
       DogServices dog = new DogServices();
       dog.setPetInfo();
       
       FileWriter fw = new FileWriter ("visitor.txt", true);
       PrintWriter file = new PrintWriter (fw);
       file.println("_____________________________________\n");
       file.println("\t\tServices selected\n");
       file.close();
       
       dog.setServices();        
    }//dog method 
    
    
}//PawClinic Class
