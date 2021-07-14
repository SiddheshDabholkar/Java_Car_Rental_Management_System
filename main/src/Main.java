import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//NOTE
// After updating ,deleting and adding car
// The JTable doesn't reloads .
// so we call the refresh method after
// every deleting,adding and updating car
// which is not an optimal solution.

public class Main extends JFrame {
    Connection con = null;
    PreparedStatement pst;
    CardLayout cardLayout = new CardLayout();
    JMenuBar menuBar = new JMenuBar();
    JPanel panel = new JPanel();
    //_______________________Menus_________________________//
    //--------------HomeMenu---------------//
    JMenu homeMenuPanel = new JMenu("Home");
    JPanel pnlCarsInfo,pnlRest,pnlBookCars;
    JTable table_1;
    JTextField tf_car_model,tf_car_no,tf_company,tf_mileage,tf_capacity,tf_fuelType,tf_fuelCapacity,tf_availability,tf_insurance_company,tf_effective_date,tf_insurance_exp_date,tf_car_identification_no;
    //--carInfo--//
    public void refresh(){
        dispose();
        new Main();
    }
    public void makeTextFieldsEmpty(){
        tf_car_no.setText("");
        tf_company.setText("");
        tf_mileage.setText("");
        tf_capacity.setText("");
        tf_fuelType.setText("");
        tf_fuelCapacity.setText("");
        tf_availability.setText("");
        tf_insurance_company.setText("");
        tf_effective_date.setText("");
        tf_insurance_exp_date.setText("");
        tf_car_identification_no.setText("");
        tf_car_model.setText("");
    }
    public void addTable(){
        try {
            table_1=new JTable();
            pst = con.prepareStatement("select * from carlist");
            ResultSet rs = pst.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
            table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            JScrollPane sp=new JScrollPane(table_1);
            pnlCarsInfo.add(sp);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void addCarsInfoRestButtons(){
        JButton update,save,delete,search;
        JPanel thirteen=new JPanel();
        thirteen=new JPanel();
        //
        update=new JButton("update");
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String car_model,car_no,company,mileage,capacity,fuelType,fuelCapacity,availability,insurance_company,effective_date,insurance_exp_date,car_identification_no;
                car_no=tf_car_no.getText();
                company=tf_company.getText();
                mileage=tf_mileage.getText();
                capacity=tf_capacity.getText();
                fuelType=tf_fuelType.getText();
                fuelCapacity=tf_fuelCapacity.getText();
                availability=tf_availability.getText();
                insurance_company=tf_insurance_company.getText();
                effective_date=tf_effective_date.getText();
                insurance_exp_date=tf_insurance_exp_date.getText();
                car_identification_no=tf_car_identification_no.getText();
                car_model=tf_car_model.getText();
                try {
                    pst = con.prepareStatement("update carlist set carModel = ?,carCompany = ?,carMileage = ?,carCapacity=?,isBooked=?,iCompany=?,effectiveDate=?,iExpirayDate=?,carIndentificationNumber=?,fuelCapacity=?,fuelType=? where carNo = ?");
                    pst.setString(1,car_model);
                    pst.setString(2,company);
                    pst.setString(3,mileage);
                    pst.setString(4,capacity);
                    pst.setString(5,availability);
                    pst.setString(6,insurance_company);
                    pst.setString(7,effective_date);
                    pst.setString(8,insurance_exp_date);
                    pst.setString(9,car_identification_no);
                    pst.setString(10,fuelCapacity);
                    pst.setString(11,fuelType);
                    pst.setString(12,car_no);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updateee!!!!!");
                    refresh();
                    makeTextFieldsEmpty();
                }
                catch (SQLException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        //
        delete=new JButton("delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carNo=tf_car_no.getText();
                try {
                    pst = con.prepareStatement("delete from carlist  where carNo = ?");
                    pst.setString(1, carNo);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleteeeeee!!!!!");
                    refresh();
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //
        search=new JButton("search");
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String carNo=tf_car_no.getText();
                    pst = con.prepareStatement("select carNo,carCompany,carMileage,carCapacity,isBooked,iCompany,effectiveDate,iExpirayDate,carIndentificationNumber,fuelCapacity,fuelType,carModel from carlist where carNo = ?");
                    pst.setString(1, carNo);
                    ResultSet rs = pst.executeQuery();
                    if(rs.next()==true)
                    {
                        String car_model,car_no,company,mileage,capacity,fuelType,fuelCapacity,availability,insurance_company,effective_date,insurance_exp_date,car_identification_no;

                        car_no=rs.getString(1);
                        company=rs.getString(2);
                        mileage=rs.getString(3);
                        capacity=rs.getString(4);
                        availability=rs.getString(5);
                        insurance_company=rs.getString(6);
                        effective_date=rs.getString(7);
                        insurance_exp_date=rs.getString(8);
                        car_identification_no=rs.getString(9);
                        fuelCapacity=rs.getString(10);
                        fuelType=rs.getString(11);
                        car_model=rs.getString(12);

                        tf_car_no.setText(car_no);
                        tf_company.setText(company);
                        tf_mileage.setText(mileage);
                        tf_capacity.setText(capacity);
                        tf_fuelType.setText(fuelType);
                        tf_fuelCapacity.setText(fuelCapacity);
                        tf_availability.setText(availability);
                        tf_insurance_company.setText(insurance_company);
                        tf_effective_date.setText(effective_date);
                        tf_insurance_exp_date.setText(insurance_exp_date);
                        tf_car_identification_no.setText(car_identification_no);
                        tf_car_model.setText(car_model);
                    }
                    else
                    {
                        makeTextFieldsEmpty();
                        JOptionPane.showMessageDialog(null,"Invalid Employee No");
                    }
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //
        save=new JButton("save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String car_model,car_no,company,mileage,capacity,fuelType,fuelCapacity,availability,insurance_company,effective_date,insurance_exp_date,car_identification_no;
                car_no=tf_car_no.getText();
                company=tf_company.getText();
                mileage=tf_mileage.getText();
                capacity=tf_capacity.getText();
                fuelType=tf_fuelType.getText();
                fuelCapacity=tf_fuelCapacity.getText();
                availability=tf_availability.getText();
                insurance_company=tf_insurance_company.getText();
                effective_date=tf_effective_date.getText();
                insurance_exp_date=tf_insurance_exp_date.getText();
                car_identification_no=tf_car_identification_no.getText();
                car_model=tf_car_model.getText();

                try{
                    pst=con.prepareStatement("insert into carlist(carNo,carCompany,carMileage,carCapacity,isBooked,iCompany,effectiveDate,iExpirayDate,carIndentificationNumber,fuelCapacity,fuelType,carModel)values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1,car_no);
                    pst.setString(2,company);
                    pst.setString(3,mileage);
                    pst.setString(4,capacity);
                    pst.setString(5,availability);
                    pst.setString(6,insurance_company);
                    pst.setString(7,effective_date);
                    pst.setString(8,insurance_exp_date);
                    pst.setString(9,car_identification_no);
                    pst.setString(10,fuelCapacity);
                    pst.setString(11,fuelType);
                    pst.setString(12,car_model);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"New Car Added");
                    refresh();
                    makeTextFieldsEmpty();
                }catch(Exception e2){
                    System.out.println(e2);
                }
            }
        });
        //
        String isHired[]={"available","Unavailable"};
        JComboBox cb=new JComboBox(isHired);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTable table_1=new JTable();
                    pst = con.prepareStatement("select * from carlist where isBooked=true");
                    ResultSet rs = pst.executeQuery();
                    table_1.revalidate();
                    table_1.setModel(DbUtils.resultSetToTableModel(rs));
                    table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    JScrollPane sp=new JScrollPane(table_1);
                    pnlCarsInfo.add(sp);
                }catch(SQLException e2){
                    e2.printStackTrace();
                }
            }
        });
        //
        thirteen.setLayout(new FlowLayout(FlowLayout.CENTER));
        thirteen.add(update);
        thirteen.add(save);
        thirteen.add(delete);
        thirteen.add(search);
        thirteen.add(cb);
        pnlRest.add(thirteen);
    }
    public void addCarsInfoRestForm(){
        pnlRest = new JPanel();
        JPanel formContainer=new JPanel();
        JPanel one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
        JLabel car_model,car_no,company,mileage,capacity,fuelType,fuelCapacity,availability,insurance_company,effective_date,insurance_exp_date,car_identification_no;

        one=new JPanel(new FlowLayout(FlowLayout.LEFT));
        car_model=new JLabel("car model");
        tf_car_model=new JTextField(15);
        one.add(car_model);
        one.add(tf_car_model);

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
        //
        addTable();
        addCarsInfoRest();
        //
        pnlCarsInfo.setBackground(Color.black);
        pnlCarsInfo.setLayout(new GridLayout(2,1));
    }
    //--bookCars--//
    JLabel id,name,surname,drivingLicenceNo,carNo,phoneNo,totalPaidMoney,hiredAt,returningDate,noOfDays;
    JTextField t_id,t_name,t_surname,t_drivingLicenceNo,t_carNo,t_phoneNo,t_totalPaidMoney,t_hiredAt,t_returningDate,t_noOfDays;
    JLabel carCompany,carMileage,carCapacity,fuelCapacity,fuelType,carModel;
    JTextField t_carCompany,t_carMileage,t_carCapacity,t_fuelCapacity,t_fuelType,t_carModel;

    public void addBookingCarInfo(){
        JPanel pnlRestBookCarInfo=new JPanel();
        JPanel one,two,three,four,five,six;

        one=new JPanel();
        carCompany=new JLabel("car company");
        t_carCompany=new JTextField(15);
        t_carCompany.setEditable(false);
        one.add(carCompany);
        one.add(t_carCompany);

        two=new JPanel();
        carMileage=new JLabel("car mileage");
        t_carMileage=new JTextField(15);
        t_carMileage.setEditable(false);
        two.add(carMileage);
        two.add(t_carMileage);

        three=new JPanel();
        carCapacity=new JLabel("car capacity");
        t_carCapacity=new JTextField(15);
        t_carCapacity.setEditable(false);
        three.add(carCapacity);
        three.add(t_carCapacity);

        four=new JPanel();
        fuelCapacity=new JLabel("fuel capacity");
        t_fuelCapacity=new JTextField(15);
        t_fuelCapacity.setEditable(false);
        four.add(fuelCapacity);
        four.add(t_fuelCapacity);

        five=new JPanel();
        fuelType=new JLabel("fuel type");
        t_fuelType=new JTextField(15);
        t_fuelType.setEditable(false);
        five.add(fuelType);
        five.add(t_fuelType);

        six=new JPanel();
        carModel=new JLabel("car model");
        t_carModel=new JTextField(15);
        t_carModel.setEditable(false);
        six.add(carModel);
        six.add(t_carModel);

        pnlRestBookCarInfo.setLayout(new GridLayout(3,2));
        pnlRestBookCarInfo.add(one);
        pnlRestBookCarInfo.add(two);
        pnlRestBookCarInfo.add(three);
        pnlRestBookCarInfo.add(four);
        pnlRestBookCarInfo.add(five);
        pnlRestBookCarInfo.add(six);

        pnlBookCars.add(pnlRestBookCarInfo);
    }
    public void addUserInfoForm(){
        JPanel pnlRestBookCars=new JPanel();
        JPanel one,two,three,four,five,six,seven,eight,nine,ten;

        one=new JPanel();
        id=new JLabel("id");
        t_id=new JTextField(15);
        t_id.setEditable(false);
        one.add(id);
        one.add(t_id);

        two=new JPanel();
        name=new JLabel("name");
        t_name=new JTextField(15);
        two.add(name);
        two.add(t_name);

        three=new JPanel();
        surname=new JLabel("surname");
        t_surname=new JTextField(15);
        three.add(surname);
        three.add(t_surname);

        four=new JPanel();
        drivingLicenceNo=new JLabel("driving licence no");
        t_drivingLicenceNo=new JTextField(15);
        four.add(drivingLicenceNo);
        four.add(t_drivingLicenceNo);

        five=new JPanel();
        carNo=new JLabel("car no");
        t_carNo=new JTextField(15);
        t_carNo.setEditable(false);
        five.add(carNo);
        five.add(t_carNo);

        six=new JPanel();
        phoneNo=new JLabel("phone no");
        t_phoneNo=new JTextField(15);
        six.add(phoneNo);
        six.add(t_phoneNo);

        seven=new JPanel();
        totalPaidMoney=new JLabel("total paid money");
        t_totalPaidMoney=new JTextField(15);
        seven.add(totalPaidMoney);
        seven.add(t_totalPaidMoney);

        eight=new JPanel();
        hiredAt=new JLabel("hired at");
        t_hiredAt=new JTextField(15);
        eight.add(hiredAt);
        eight.add(t_hiredAt);

        nine=new JPanel();
        returningDate=new JLabel("returning date");
        t_returningDate=new JTextField(15);
        nine.add(returningDate);
        nine.add(t_returningDate);

        ten=new JPanel();
        noOfDays=new JLabel("duration");
        t_noOfDays=new JTextField(15);
        ten.add(noOfDays);
        ten.add(t_noOfDays);

        pnlRestBookCars.setLayout(new GridLayout(5,2));
        pnlRestBookCars.add(one);
        pnlRestBookCars.add(two);
        pnlRestBookCars.add(three);
        pnlRestBookCars.add(four);
        pnlRestBookCars.add(five);
        pnlRestBookCars.add(six);
        pnlRestBookCars.add(seven);
        pnlRestBookCars.add(eight);
        pnlRestBookCars.add(nine);
        pnlRestBookCars.add(ten);

        pnlBookCars.add(pnlRestBookCars);
    }
    public void addBookCars() {
        JMenuItem mniBookCars = new JMenuItem("Book Cars");
        pnlBookCars = new JPanel();
        homeMenuPanel.add(mniBookCars);
        panel.add(pnlBookCars, "pnlBookCars");
        mniBookCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlBookCars");
            }
        });
        //
        addBookingCarInfo();
        addUserInfoForm();
        //
        pnlBookCars.setLayout(new GridLayout(2,1));
    }
    //
    public void addHome() {
        addCarsInfo();
        addBookCars();
        menuBar.add(homeMenuPanel);
    }
    //--------------MoreMenu---------------//
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
    //------------------ constructor call --------------------//
    Main() {
        con = DB.dbconnect();
        panel.setLayout(cardLayout);
        cardLayout.show(panel, "pnlCarsInfo");
        setJMenuBar(menuBar);
        add(panel);
        //--------------------------------------------//
        addHome();
        addMoreMenu();
        //--------------------------------------------//
        setMinimumSize(new Dimension(800, 600));
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