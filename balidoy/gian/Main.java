package balidoy.gian;

import java.io.*;
import java.util.ArrayList;
import animal.*;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main {
    
    public static void main(String[] args) 
    {
        ArrayList<Animal> animalList = new ArrayList();
        
        for(int i = 0; i < 10; ++i)
        {
            animalList.add(new Lion(getRandName()));
            animalList.add(new Giraffe(getRandName()));
        }
        
        System.out.println("There are "+ animalList.size() + " animals in the array.");
        
        System.out.println("Enter a number to find an animal at that location!\n");
        int userAnim = Integer.parseInt(getInput()) - 1;
        
        try
        {
            System.out.println("This animal is a " + animalList.get(userAnim).getName() + "!");
        }
        catch(IndexOutOfBoundsException exc)
        {
            System.out.println("You entered an invalid number!");
        }
        System.out.println("Goodbye!");
        
    }
    
    public static String getInput()
    {
        BufferedReader keyWriter = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        
        try
        {
            input = keyWriter.readLine();
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }
        
        return input;
    }
    
    public static String getRandName()
    {
        String str = "";
        int nameLine = (int)Math.floor(Math.random() * 99 + 1);
        
        try(BufferedReader br = new BufferedReader(new FileReader("names.txt")))
        {
            int line = 1;
            while(line++ < nameLine)
            {
                br.readLine();
            }
            str = br.readLine();
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }
        
        return str;
    }
}
