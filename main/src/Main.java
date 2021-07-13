import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    CardLayout cardLayout = new CardLayout();
    JMenuBar menuBar = new JMenuBar();
    JPanel panel = new JPanel();
    //_______________________Menus_________________________//
    //*\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*//
    //------HomeMenu------//
    JMenu homeMenuPanel = new JMenu("Home");
    JPanel pnlCarsInfo,pnlRest,pnlCars,pnlBookCars;

    public void addCarsInfoRestButtons(){
        JButton update,save,delete,search;
        JPanel thirteen=new JPanel();
        thirteen=new JPanel();
        update=new JButton("update");
        save=new JButton("save");
        delete=new JButton("delete");
        search=new JButton("search");
        thirteen.setLayout(new FlowLayout(FlowLayout.CENTER));
        thirteen.add(update);
        thirteen.add(save);
        thirteen.add(delete);
        thirteen.add(search);
        pnlRest.add(thirteen);
    }

    public void addCarsInfoRestForm(){

        pnlRest = new JPanel();
        JPanel formContainer=new JPanel();
        JPanel one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
        JLabel id,car_no,company,mileage,capacity,fuelType,fuelCapacity,availability,insurance_company,effective_date,insurance_exp_date,car_identification_no;
        JTextField tf_id,tf_car_no,tf_company,tf_mileage,tf_capacity,tf_fuelType,tf_fuelCapacity,tf_availability,tf_insurance_company,tf_effective_date,tf_insurance_exp_date,tf_car_identification_no;

        one=new JPanel(new FlowLayout(FlowLayout.LEFT));
        id=new JLabel("id");
        tf_id=new JTextField(15);
        one.add(id);
        one.add(tf_id);

        two=new JPanel(new FlowLayout(FlowLayout.LEFT));
        car_no=new JLabel("car no");
        tf_car_no=new JTextField(15);
        two.add(car_no);
        two.add(tf_car_no);

        three=new JPanel(new FlowLayout(FlowLayout.LEFT));
        company=new JLabel("car company");
        tf_company=new JTextField(15);
        three.add(company);
        three.add(tf_company);

        four=new JPanel(new FlowLayout(FlowLayout.LEFT));
        mileage=new JLabel("car mileage");
        tf_mileage=new JTextField(15);
        four.add(mileage);
        four.add(tf_mileage);

        five=new JPanel(new FlowLayout(FlowLayout.LEFT));
        capacity=new JLabel("car capacity");
        tf_capacity=new JTextField(15);
        five.add(capacity);
        five.add(tf_capacity);

        six=new JPanel(new FlowLayout(FlowLayout.LEFT));
        availability=new JLabel("isBooked");
        tf_availability=new JTextField(15);
        six.add(availability);
        six.add(tf_availability);

        seven=new JPanel(new FlowLayout(FlowLayout.LEFT));
        insurance_company=new JLabel("insurance company");
        tf_insurance_company=new JTextField(15);
        seven.add(insurance_company);
        seven.add(tf_insurance_company);

        eight=new JPanel(new FlowLayout(FlowLayout.LEFT));
        effective_date=new JLabel("effective date");
        tf_effective_date=new JTextField(15);
        eight.add(effective_date);
        eight.add(tf_effective_date);

        nine=new JPanel(new FlowLayout(FlowLayout.LEFT));
        insurance_exp_date=new JLabel("insurane exp. date");
        tf_insurance_exp_date=new JTextField(15);
        nine.add(insurance_exp_date);
        nine.add(tf_insurance_exp_date);

        ten=new JPanel(new FlowLayout(FlowLayout.LEFT));
        car_identification_no=new JLabel("car identification no");
        tf_car_identification_no=new JTextField(15);
        ten.add(car_identification_no);
        ten.add(tf_car_identification_no);

        eleven=new JPanel(new FlowLayout(FlowLayout.LEFT));
        fuelCapacity=new JLabel("fuel capacity");
        tf_fuelCapacity=new JTextField(15);
        eleven.add(fuelCapacity);
        eleven.add(tf_fuelCapacity);

        twelve=new JPanel(new FlowLayout(FlowLayout.LEFT));
        fuelType=new JLabel("fuel type");
        tf_fuelType=new JTextField(15);
        twelve.add(fuelType);
        twelve.add(tf_fuelType);

        addCarsInfoRestButtons();
        formContainer.setLayout(new GridLayout(6,2));
        formContainer.add(one);
        formContainer.add(two);
        formContainer.add(three);
        formContainer.add(four);
        formContainer.add(five);
        formContainer.add(six);
        formContainer.add(seven);
        formContainer.add(eight);
        formContainer.add(nine);
        formContainer.add(ten);
        formContainer.add(eleven);
        formContainer.add(twelve);

        pnlRest.add(formContainer);
    }

    public void addCarsInfoRest(){
        addCarsInfoRestForm();
        pnlRest.setLayout(new BoxLayout(pnlRest,BoxLayout.Y_AXIS));
        pnlRest.setBackground(Color.GRAY);
        pnlCarsInfo.add(pnlRest);
    }

    public void addCarsInfo() {
        JMenuItem mniCarsInfo = new JMenuItem("Cars Info");
        homeMenuPanel.add(mniCarsInfo);
        pnlCarsInfo = new JPanel();
        panel.add(pnlCarsInfo, "pnlCarsInfo");
        //
        mniCarsInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlCarsInfo");
            }
        });
        String[][] data = {{"101", "GA 11", "Nissan", "20", "2", "true", "Bajaj", "11/11/11", "11/11/11", "123456"}};
        String[] column = {"id", "car no", "company", "mileage", "capacity", "availability", "insurance company", "effective date", "insurance exp.date", "car identification no."};
        JTable jt = new JTable(data, column);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jt);
        pnlCarsInfo.add(sp);
        //
        addCarsInfoRest();
        //
        pnlCarsInfo.setBackground(Color.black);
        pnlCarsInfo.setLayout(new GridLayout(2,1));
    }
    public void addCars() {
        pnlCars = new JPanel();
        JMenuItem mniCars = new JMenuItem("Cars");
        pnlCars.setBackground(Color.black);
        homeMenuPanel.add(mniCars);
        panel.add(pnlCars, "pnlCars");
        pnlCars.add(new JLabel("cars"));
        mniCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlCars");
            }
        });
    }
    public void addBookCars() {
        JMenuItem mniBookCars = new JMenuItem("Book Cars");
        pnlBookCars = new JPanel();
        pnlBookCars.setBackground(Color.black);
        homeMenuPanel.add(mniBookCars);
        panel.add(pnlBookCars, "pnlBookCars");
        pnlBookCars.add(new JLabel("Book cars"));
        mniBookCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlBookCars");
            }
        });
    }
    public void addHome() {
        addBookCars();
        addCars();
        addCarsInfo();
        menuBar.add(homeMenuPanel);
    }
    //------MoreMenu------//
    public void addMoreMenu() {
        JMenu moreMenuPanel = new JMenu("More");
        JMenuItem mniHelp = new JMenuItem("Help");
        JMenuItem mniExit = new JMenuItem("Exit");
        JPanel pnlHelp = new JPanel();
        moreMenuPanel.add(mniHelp);
        moreMenuPanel.add(mniExit);
        panel.add(pnlHelp, "pnlHelp");
        pnlHelp.add(new JLabel("GUI is self explanatory"));
        menuBar.add(moreMenuPanel);
        mniHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlHelp");
            }
        });
        mniExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    //_____________________________________________________//
    //*\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\*//
    Main() {
        panel.setLayout(cardLayout);
        cardLayout.show(panel, "pnlHelp");
        setJMenuBar(menuBar);
        add(panel);
        //
        addHome();
        addMoreMenu();
        //
        setMinimumSize(new Dimension(800, 600));
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}