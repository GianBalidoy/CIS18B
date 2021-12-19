package animal.herbivore;

import animal.Animal;

public class Giraffe implements Animal
{
    private String name;
    private final String type = "Giraffe";
    
    public Giraffe(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return type;
    }
}