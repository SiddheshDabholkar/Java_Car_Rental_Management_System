import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public void LoginForm(){
       JLabel l=new JLabel("lmao");
       l.setBounds(10,10,100,10);

       JTextField tf=new JTextField();
//       tf.setBounds(10,20,100,20);

       add(l);
       add(tf);
    }

    Login(){
        LoginForm();
        setLayout(null);
        setVisible(true);
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Login();
    }
}
