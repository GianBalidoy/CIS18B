package animal.herbivore;

import animal.Animal;

public class Giraffe implements Animal
{
    private String name;
    private final String type = "giraffe";
    
    public Giraffe(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getType()
    {
        return type;
    }
}