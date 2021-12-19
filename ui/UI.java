package ui;

import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;
import static balidoy.gian.Main.getRandName;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class UI extends JFrame implements ActionListener {
    
    static JTextField userText;
    
    static JLabel animText;
 
    static JFrame mainFrame;
 
    static JButton button;
 
    static JLabel label;
 
    public UI()
    {
    }
 
    // main class
    public static void start()
    {
        mainFrame = new JFrame("textfield");
 
        label = new JLabel("Enter a number to find the animal at that location!");
 
        button = new JButton("submit");
 
        userText = new JTextField(2);
        animText = new JLabel("");
 
        JPanel p = new JPanel();
 
        p.add(userText);
        p.add(button);
        p.add(label);
 
        // add panel to frame
        mainFrame.add(p);
 
        // set the size of frame
        mainFrame.setSize(300, 300);
 
        mainFrame.setVisible(true);
    }
 
    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        ArrayList<Animal> animalList = new ArrayList();
        
        for(int i = 0; i < 10; ++i)
        {
            animalList.add(new Lion(getRandName()));
            animalList.add(new Giraffe(getRandName()));
        }
        
        int userAnim = Integer.parseInt(userText.getText());
        
        try
        {
            animText.setText("This animal is a " + animalList.get(userAnim).getName() + "!");
        }
        catch(IndexOutOfBoundsException exc)
        {
            System.out.println("You entered an invalid number!");
        }
    }
}