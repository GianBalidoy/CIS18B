package mythread;

import animal.*;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MyThread implements Runnable
{
    String threadName;
    String filePathWithName;
    ArrayList<Animal> aList;
    Thread thrd;
    
    MyThread(String n, String pName, ArrayList<Animal> li)
    {
        threadName = n;
        thrd = new Thread(this, threadName);
    }
    
    public static MyThread createAndStart(String n, String pName, ArrayList<Animal> li)
    {
        MyThread myThrd = new MyThread(n, pName, li);
        
        myThrd.thrd.start();
        return myThrd;
    }
    
    public void run()
    {
        System.out.println(thrd.getName() + " starting.");
            
        ArrayList<Animal> animalList = new ArrayList<>();

        String fileOutput = "";
        for(Animal cAnimal : animalList)
        {
            fileOutput += String.format("%s is a %s.%n", cAnimal.getName(), cAnimal.getType());
        }
        try(FileWriter oFile = new FileWriter("barnacles.txt"))
        {
            oFile.write(fileOutput);
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }
        
        System.out.println(thrd.getName() + " terminating.");
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