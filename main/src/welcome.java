import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {

    public void addWelcomeMessage(){
        JLabel l1,l2;

        l1=new JLabel("Welcome to");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Serif",Font.PLAIN,20));
        l1.setBounds(290,100,200,14);

        l2=new JLabel("Car Rental Management");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Serif",Font.PLAIN,30));
        l2.setBounds(170,140,400,24);

        add(l1);
        add(l2);
        getContentPane().setLayout(null);
    }

    public void addButton(){
        JButton admin,exit;
        admin=new JButton("admin");
        admin.setBounds(300,275,100,20);
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        exit=new JButton("exit");
        exit.setBounds(300,310,100,20);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(admin);
        add(exit);
    }

    public void HomeLayout(){
        addWelcomeMessage();
        addButton();
    }
    welcome(){
        HomeLayout();
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Welcome to Car Rental Management");
        getContentPane().setBackground(Color.black);
        setMinimumSize(new Dimension(700,500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new welcome();
    }
}
