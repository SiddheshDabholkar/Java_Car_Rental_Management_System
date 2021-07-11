import javax.swing.*;
import java.awt.*;

public class Booking extends JFrame {
    Booking(){
        setLayout(null);
        setVisible(true);
        setTitle("Booking");
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Booking();
    }
}
