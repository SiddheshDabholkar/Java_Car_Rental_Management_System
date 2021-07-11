import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {
    public void HomeLayout(){
        JButton admin,exit;

        admin=new JButton("admin");
        admin.setBounds(10,10,100,20);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        exit=new JButton("exit");
        exit.setBounds(10,50,100,20);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(admin);
        add(exit);

    }
    Home(){
        HomeLayout();
        setLayout(null);
        setVisible(true);
        setMinimumSize(new Dimension(700,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Home();
    }
}
