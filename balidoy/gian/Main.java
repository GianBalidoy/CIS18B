package balidoy.gian;

import java.io.*;
import java.util.ArrayList;
import animal.*;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;
import ui.*;

public class Main {
    
    public static void main(String[] args) 
    {
        UI ui = new UI();
        ui.start();
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
