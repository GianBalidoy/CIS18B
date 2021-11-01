package balidoy.gian;

import java.util.ArrayList;
import animal.*;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        filePathWithName = pName;
        aList = li;
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
        
        int numLions = 10;
        int numGiraffes = 5;
        
        for(int i = 0; i < numLions; ++i)
        {
            animalList.add(new Lion(getRandName()));
        }
        
        for(int i = 0; i < numGiraffes; ++i)
        {
            animalList.add(new Giraffe(getRandName()));
        }

        String fileOutput = "";
        
        for(Animal cAnimal : animalList)
        {
            fileOutput += String.format("%s is a %s.%n", cAnimal.getName(), cAnimal.getType());
        }
        try(FileWriter oFile = new FileWriter(filePathWithName))
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

public class Main {
    
    public static void main(String[] args) 
    {
        ArrayList<Animal> animalList1 = new ArrayList<>();
        ArrayList<Animal> animalList2 = new ArrayList<>();
        
        System.out.println("Main thread starting.");
        
        MyThread thrd1 = MyThread.createAndStart("Child #1", "Output 1.txt", animalList1);
        MyThread thrd2 = MyThread.createAndStart("Child #2", "Output 2.txt", animalList2);
        
        try
        {
            thrd1.thrd.join();
            thrd2.thrd.join();
        }
        catch(InterruptedException exc)
        {
            System.out.println("Main thread interrupted.");
        }
        
        System.out.println("Main thread ending.");
    }
}
