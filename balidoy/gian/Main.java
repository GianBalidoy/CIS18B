package balidoy.gian;

import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main {
    
    public static void main(String[] args) 
    {
        Lion mufasa = new Lion();
        Giraffe melman = new Giraffe();
        
        System.out.println(mufasa.speak());
        System.out.println(melman.speak());
    }
}
