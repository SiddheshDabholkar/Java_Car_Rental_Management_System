import javax.swing.*;
import java.awt.*;

public class BookCar extends JFrame {
    BookCar(){
        setLayout(null);
        setVisible(true);
        setTitle("Book a car");
        setMinimumSize(new Dimension(700,500));
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new BookCar();
    }
}
