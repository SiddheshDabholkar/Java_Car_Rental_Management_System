import javax.swing.*;
import java.awt.*;

public class CarList extends JFrame {

    public void addTable(){
        String data[][]={{"101","GA 11","Nissan","20","2","true","Bajaj","11/11/11","11/11/11","123456"}};
        String column[]={"id","car no","company","mileage","capacity","availability","insurance company","effective date","insurance exp.date","car identification no."};
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        add(sp);
    }

    CarList(){
        //NOTE: Adding setLayout(null) doesn't shows table
        addTable();
        setVisible(true);
        setTitle("CarList");
        setMinimumSize(new Dimension(700,500));
    }

    public static void main(String[] args) {
        new CarList();
    }
}
