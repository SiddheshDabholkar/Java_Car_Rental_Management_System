import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO:
//  Show vehicle card
//  Show Button for Booking, after pressing it,
//  dispose the the current JFrame and Open the
//  new one with JTabbedPane with insurance and
//  car details

public class Cars extends JFrame {
    public void addButton(){
    JButton b=new JButton("book this car");
    b.setBounds(100,100,200,20);
    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new BookCar();
        }
    });
    add(b);
    }

    Cars(){
        addButton();
        setLayout(null);
        setVisible(true);
        setTitle("Cars");
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Cars();
    }
}
