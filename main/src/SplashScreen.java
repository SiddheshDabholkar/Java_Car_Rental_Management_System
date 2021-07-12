import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame{
    ImageIcon icon=new ImageIcon("../../images/lmabo.jpg");
    JLabel homePageImage = new JLabel(icon);

    public SplashScreen() {
        try{
            createGUI();
            addImage();
            Thread.sleep(2000);
            dispose();
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

    public void addImage(){
        homePageImage.setSize(800,500);
        add(homePageImage,BorderLayout.CENTER);
    }

    public static void main(String[] args){
        new SplashScreen();
        new welcome();
    }
}