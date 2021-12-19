package animal.carnivore;

import animal.Animal;

public class Lion implements Animal
{
    private String name;
    private final String type = "Lion";
    
    public String speak()
    {
        return "The lion roars!";
    }
    
    public Lion(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return type;
    }
}