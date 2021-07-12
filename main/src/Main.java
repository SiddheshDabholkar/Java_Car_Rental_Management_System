import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    JLabel head;
    JButton cars, bookings,car_list;

    public void addHead() {
        head = new JLabel("Main menu");
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setBounds(10, 10, 100, 20);
        add(head);
    }

    public void addButtons() {
        //
        cars = new JButton("Cars");
        cars.setBounds(10, 100, 100, 20);
        cars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Cars();
            }
        });
        //
        bookings = new JButton("Bookings");
        bookings.setBounds(10, 150, 100, 20);
        bookings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Booking();
            }
        });
        //
        car_list=new JButton("car list");
        car_list.setBounds(10, 200, 100, 20);
        car_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CarList();
            }
        });
        //
        add(cars);
        add(bookings);
        add(car_list);
    }

    public void MainScreen() {
        addHead();
        addButtons();
    }

    Main() {
        MainScreen();
        setLayout(null);
        setVisible(true);
        setTitle("Main Menu");
        setMinimumSize(new Dimension(700, 500));
    }

    public static void main(String[] args) {
        new Main();
    }

}
