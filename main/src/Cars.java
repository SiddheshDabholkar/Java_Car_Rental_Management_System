import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
