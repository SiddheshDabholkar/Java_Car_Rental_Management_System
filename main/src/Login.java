import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    JLabel user,pass,incorrect,message;
    public void displayMessage(){
        message =new JLabel("Welcome Admin");
        message.setForeground(Color.WHITE);
        message.setFont(new Font("Serif",Font.PLAIN,20));
        message.setBounds(260,90,200,14);
        getContentPane().add(message);
    }

    public void LoginForm(){
        JTextField tf_user;
        JPasswordField tf_pass;
        JButton login;
        //
        user=new JLabel("username :");
        user.setBounds(240,150,100,20);
        user.setForeground(Color.WHITE);
        tf_user=new JTextField("Admin");
        tf_user.setEditable(false);
        tf_user.setBounds(330,150,100,20);
        //
        pass=new JLabel("password :");
        pass.setBounds(240,200,100,20);
        pass.setForeground(Color.WHITE);
        tf_pass=new JPasswordField();
        tf_pass.setBounds(330,200,100,20);
        //
        incorrect=new JLabel("incorrect password");
        incorrect.setBounds(275,220,200,20);
        incorrect.setForeground(Color.red);
        //
        login=new JButton("login");
        login.setBounds(240,270,190,30);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password=new String(tf_pass.getPassword());
                String realPassword="admin";
                if(password.equals(realPassword)){
                    dispose();
                    new Main();
                }else{
                    add(incorrect);
                    incorrect.setText("Incorrect password");
                }
            }
        });
        //
        displayMessage();
        add(user);
        add(tf_user);
        add(pass);
        add(tf_pass);
        add(login);
    }
    Login(){
        LoginForm();
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setTitle("Admin Login");
        setVisible(true);
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Login();
    }

}
