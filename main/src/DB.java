import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    Connection con=null;
    java.sql.PreparedStatement pst;

    public static Connection dbconnect(){
        try{
            //NOTE: shows deprecated message
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental_management","root","");
            return conn;
        }catch(Exception e1){
            System.out.println(e1);
            return null;
        }
    }
}
