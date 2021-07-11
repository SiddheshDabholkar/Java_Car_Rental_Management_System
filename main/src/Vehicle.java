import javax.swing.*;
import java.awt.*;

public class Vehicle extends JFrame {

    public void VehicleDetails(){

    }

    Vehicle(){
        VehicleDetails();
        setLayout(null);
        setVisible(true);
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Vehicle();
    }
}
