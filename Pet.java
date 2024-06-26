package pawclinic;

public class Pet {
    private String Pet_Name;
    private String Breed;
    private String Sex;
    protected Visitor user = new Visitor();

    
    public Pet(String petName, String breed, String sex){
        Pet_Name = petName;
        Breed = breed;
        Sex = sex;
    }
    
    public Pet(){
       
    }

    //---------- setters
    public void setPetName(String petName){
        Pet_Name = petName;
    }
    public void setBreed(String breed){
        Breed = breed;
    }
    public void setSex(String sex){
        Sex = sex;
    }
    
    //---------- getters
    public String getPetName(){
        return Pet_Name;
    }
    public String getBreed(){
        return Breed;
    }
    public String getSex(String sex){
        return Sex;
    }
    
    /**
     * Returns formatted string
     * @return 
     */
    @Override
    public String toString(){
        String str = "Pet name: " + Pet_Name + "\nBreed: " + Breed
                + "\nSex: " + Sex + "\n";
        return str;
    }
}
