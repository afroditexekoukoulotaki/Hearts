package hearts;


public abstract class Human {
    private String name, lastName, information;
    int age;
    
    public abstract void introduceSelf();
    
    public Human(){
        this.name = "Afrodite";
        
    }
    
    public Human(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        information = "";
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
   
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
