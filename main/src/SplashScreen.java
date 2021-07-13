import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame{

    public SplashScreen() {
        try{
            createGUI();
            WelcomeText();
            Thread.sleep(4000);
            dispose();
            new welcome();
        }catch(InterruptedException e){
            System.out.println("got interrupted!");
        }
    }

    public void createGUI(){
        getContentPane().setLayout(null);
        setUndecorated(true);
        setSize(800,500);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.black);
        setVisible(true);
    }
    public void WelcomeText(){
        JLabel l1,l2;
        l1=new JLabel("Car Rental Management");
        l1.setBounds(170,230,500,30);
        l1.setFont(new Font("Serif",Font.PLAIN,30));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        add(l1);
  }
    public static void main(String[] args){
        new SplashScreen();
    }
}