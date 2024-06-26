package pawclinic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CatServices extends Pet {
    
    private String[] Cat_Services = new String[5];
    private double[] Cat_Prices = {85, 120, 100, 20, 20}; 
    private double Total_Cost = 0;
    private double Total_Cost_Per_Pet = 0;
    String[] petInfoArray;
    
    Scanner keyboard = new Scanner(System.in);
    
    /**
     * Displays and sets cat services and its prices
     */
    public void CatServices(){
        
        String str;
        
        Cat_Services[0] = "Medical examination";
        Cat_Services[1] = "Vaccination    ";
        Cat_Services[2] = "Full grooming";
        Cat_Services[3] = "Ear cleaning   ";
        Cat_Services[4] = "Nail clipping";
        System.out.println("_____________________________________\n");
        System.out.println("Cat services and prices");
        for (int i = 0 ; i < Cat_Services.length ; i++){
            str = String.format("%.0f$", Cat_Prices[i]);
            System.out.println((i+1)+ "- " + Cat_Services[i] + "\t\t" + str);
        }
        System.out.print("\nSelect the number of the desiered services "
                + "(press -1 to exit)");
           
    }
    
    /**
     * Sets the number of pets and its information, then saves them in file.
     * @throws IOException 
     */
    public void setPetInfo() throws IOException 
    {
        
        int numOfPets;
        System.out.print("How many cats do you have: ");
        numOfPets = keyboard.nextInt();
        while (numOfPets>3){
            System.out.println("Sorry!, We Cant Accept more than three pets "
                    + "in one Bill, Please Enter Again : ");
            numOfPets = keyboard.nextInt();
        }
        user.setNumOfPets(numOfPets);
        
        keyboard.nextLine();//consume line to read string later 
        
        petInfoArray = new String[numOfPets*3];//array to store cat info
        String petname;   
        int j = 0;//to store values in index
        
        for (int i = 0 ; i < numOfPets ; i++){
            System.out.print("\nEnter your cat name: ");
            petname = keyboard.nextLine();
            petInfoArray[j] = petname;
            j++;
            
            System.out.printf("Enter %s's breed: ",petname);
            petInfoArray[j] = keyboard.nextLine();
            j++;
        
            System.out.printf("Enter %s's sex (female or male): ",
                    petname);
            petInfoArray[j] = keyboard.nextLine();
             while (!petInfoArray[j].equalsIgnoreCase("male") && 
                    !petInfoArray[j].equalsIgnoreCase("female")){
                System.out.print("Wrong input!, Please Enter Again : ");
                petInfoArray[j] = keyboard.nextLine();
            }
            j++;
           
        }
        System.out.println("");
        
        String str;// to store printing format
        FileWriter fw = new FileWriter ("visitor.txt", true);
        PrintWriter file = new PrintWriter (fw);
        
        switch(numOfPets){
            case 1 -> {
                Pet pet1 = new Pet(petInfoArray[0], petInfoArray[1],
                                   petInfoArray[2]);
                str = String.format("\nCat name: " + petInfoArray[0]
                      + "\nCat breed: " + petInfoArray[1]
                      + "\nCat sex: " + petInfoArray[2]);
                file.println(str);
            }
            
            case 2 -> {
                Pet pet1 = new Pet(petInfoArray[0], petInfoArray[1],
                                   petInfoArray[2]);
                Pet pet2 = new Pet(petInfoArray[3], petInfoArray[4],
                                   petInfoArray[5]);
                str = "\nFirst Cat name: " + petInfoArray[0]
                      + "\nCat breed: " + petInfoArray[1]
                      + "\nCat sex: " + petInfoArray[2]
                      + "\n\nSecond Cat name: " + petInfoArray[3]
                      + "\nCat breed: " + petInfoArray[4]
                      + "\nCat sex: " + petInfoArray[5];
                file.println(str);
            }
            
            case 3 -> {
                Pet pet1 = new Pet(petInfoArray[0], petInfoArray[1],
                                   petInfoArray[2]);
                Pet pet2 = new Pet(petInfoArray[3], petInfoArray[4],
                                   petInfoArray[5]);
                Pet pet3 = new Pet(petInfoArray[6], petInfoArray[7], 
                                   petInfoArray[8]);
                str = "\nFirst Cat name: " + petInfoArray[0]
                      + "\nCat breed: " + petInfoArray[1]
                      + "\nCat sex: " + petInfoArray[2]
                      + "\n\nSecond Cat name: " + petInfoArray[3]
                      + "\nCat breed: " + petInfoArray[4]
                      + "\nCat sex: " + petInfoArray[5]
                      + "\n\nThird Cat name: " + petInfoArray[6]
                      + "\nCat breed: " + petInfoArray[7]
                      + "\nCat sex: " + petInfoArray[8];
                file.println(str);
            }
            
        }//switch
        
        file.close();
    }
    
    /**
     * It calculates the cost of services for each pet, and it total cost.
     * and saves them all in file.
     * @param choice
     * @throws IOException 
     */
    public void selectCatServices(int choice) throws IOException
    { 
        
        FileWriter fw = new FileWriter ("visitor.txt", true);
        PrintWriter file = new PrintWriter (fw);

        switch (choice){
            case 1 -> {
                file.println(Cat_Services[0] + "\t\t" + Cat_Prices[0]);
                Total_Cost_Per_Pet += Cat_Prices[0];
                Total_Cost += Cat_Prices[0];
            }
                
            case 2 -> {
                file.println(Cat_Services[1] + "\t\t" + Cat_Prices[1]);
                Total_Cost_Per_Pet += Cat_Prices[1];
                Total_Cost += Cat_Prices[1];
            }
                
            case 3 -> {
                file.println(Cat_Services[2] + "\t\t" + Cat_Prices[2]);
                Total_Cost_Per_Pet += Cat_Prices[2];
                Total_Cost += Cat_Prices[2];
            }
                
            case 4 -> {
                file.println(Cat_Services[3] + "\t\t" + Cat_Prices[3]);
                Total_Cost_Per_Pet += Cat_Prices[3];
                Total_Cost += Cat_Prices[3];
            }
                
            case 5 -> {
                file.println(Cat_Services[4] + "\t\t" + Cat_Prices[4]);
                Total_Cost_Per_Pet += Cat_Prices[4];
                Total_Cost += Cat_Prices[4];
            }
                
            default -> System.out.println("wrong choice. Enter only from 1-5, "
                    + "or -1 to exit");
        }
        file.close();
    }
    
    public void setServices() throws IOException{
        
        FileWriter fw = new FileWriter ("visitor.txt", true);
        PrintWriter file = new PrintWriter (fw);        
        int j = 0;//reset to zero to get petname in array
        
        CatServices();
        int choice;
        for (int i = 0 ; i < user.NUM_OF_PETS ; i++){
            System.out.println("\nService for " + petInfoArray[j] + ":");
            System.out.print("Enter the number of the desired service: ");
            choice = keyboard.nextInt();
            while (choice != -1){
                selectCatServices(choice);
                System.out.print("Enter the number of the desired service: ");
                choice = keyboard.nextInt();
            }
            file.printf("\nCost of services for %s: %.1f$\n",
                    petInfoArray[j], Total_Cost_Per_Pet);
            j += 3;
            Total_Cost_Per_Pet = 0;
        }
        file.println("\nTotal cost of services: " + getTotalCost());
        file.close();
    }
    
    //---------- getters
    public String getCatService(int index){
        return Cat_Services[index];
    }
    public double getCatPrice(int index){
        return Cat_Prices[index];
    }
    public String getTotalCost(){
        String str = String.format("%.1f$", Total_Cost);
        return str;
    }
}
