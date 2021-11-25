package balidoy.gian;

import java.io.*;
import java.util.ArrayList;
import animal.*;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main {
    
    public static void main(String[] args) 
    {
        ArrayList<Animal> animalList = new ArrayList<>();
        
        System.out.println("How many lions would you like?");
        int numLions = Integer.parseInt(getInput());
        
        for(int i = 0; i < numLions; ++i)
        {
            animalList.add(new Lion(getRandName()));
        }
        
        System.out.println("How many giraffes would you like?");
        int numGiraffes = Integer.parseInt(getInput());
        
        for(int i = 0; i < numGiraffes; ++i)
        {
            animalList.add(new Giraffe(getRandName()));
        }
       
        String fileOutput = "";
        for(Animal cAnimal : animalList)
        {
            fileOutput += String.format("%s is a %s.%n", cAnimal.getName(), cAnimal.getType());
        }
        try(FileWriter oFile = new FileWriter("output file.txt"))
        {
            oFile.write(fileOutput);
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }
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
