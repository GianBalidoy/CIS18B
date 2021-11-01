package animal;

public interface Animal 
{
    default String speak()
    {
        return "This animal doesn't speak!";
    }
    
    default String getName()
    {
        return "This animal has no name!";
    }
    
    default String getType()
    {
        return "This animal has no type!";
    }
}