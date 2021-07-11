import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    Login(){
        JLabel user,pass,incorrect,in;
        JTextField tf_user;
        JPasswordField tf_pass;
        JButton login;
        user=new JLabel("username :");
        user.setBounds(50,50,100,20);
        tf_user=new JTextField("Admin");
        tf_user.setEditable(false);
        tf_user.setBounds(150,50,100,20);
        pass=new JLabel("password :");
        pass.setBounds(50,100,100,20);
        tf_pass=new JPasswordField();
        tf_pass.setBounds(150,100,100,20);
        incorrect=new JLabel("incorrect password");
        incorrect.setBounds(50,140,200,20);
        incorrect.setForeground(Color.red);
        in=new JLabel();
        in.setBounds(50,250,200,20);
        login=new JButton("login");
        login.setBounds(150,200,100,20);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password=new String(tf_pass.getPassword());
                in.setText(password);
                String realPassword="admin";
                if(password.equals(realPassword)){
                    incorrect.setText("correct password");
                    dispose();
                    //TODO
                    //call new class here
                }else{
                    add(incorrect);
                    incorrect.setText("Incorrect password");
                }
            }
        });
        add(user);
        add(tf_user);
        add(pass);
        add(in);
        add(tf_pass);
        add(login);

        setLayout(null);
        setVisible(true);
        setMinimumSize(new Dimension(700,500));
    }
    public static void main(String[] args) {
        new Login();
    }
}
