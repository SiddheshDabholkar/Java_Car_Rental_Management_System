import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    CardLayout cardLayout = new CardLayout();
    JMenuBar menuBar = new JMenuBar();
    JPanel panel = new JPanel();
    //
    public void addHome(){
        JMenu homeMenuPanel = new JMenu("More");
        JPanel pnlCars,pnlBookCars,pnlCarsInfo;

        JMenuItem mniCars=new JMenuItem("Cars");
        JMenuItem mniBookCars=new JMenuItem("Book Cars");
        JMenuItem mniCarsInfo=new JMenuItem("Cars Info");

        pnlCars=new JPanel();
        pnlBookCars=new JPanel();
        pnlCarsInfo=new JPanel();

        homeMenuPanel.add(mniCars);
        homeMenuPanel.add(mniBookCars);
        homeMenuPanel.add(mniCarsInfo);

        panel.add(pnlCars,"pnlCars");
        pnlCars.add(new JLabel("cars"));
        mniCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlCars");
            }
        });

        panel.add(pnlBookCars,"pnlBookCars");
        pnlBookCars.add(new JLabel("Book cars"));
        mniBookCars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlBookCars");
            }
        });

        panel.add(pnlCarsInfo,"pnlCarsInfo");
        pnlCarsInfo.add(new JLabel("cars info"));
        mniCarsInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlCarsInfo");
            }
        });

        menuBar.add(homeMenuPanel);
    }
    public void addMoreMenu() {
        JMenu moreMenuPanel = new JMenu("More");
        JMenuItem mniHelp = new JMenuItem("Help");
        JMenuItem mniExit = new JMenuItem("Exit");
        JPanel pnlHelp=new JPanel();
        moreMenuPanel.add(mniHelp);
        moreMenuPanel.add(mniExit);
        panel.add(pnlHelp,"pnlHelp");
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
    //
    Main(){
        panel.setLayout(cardLayout);
        cardLayout.show(panel, "pnlHelp");
        setJMenuBar(menuBar);
        add(panel);
        //
        addHome();
        addMoreMenu();
        //
        setMinimumSize(new Dimension(700,500));
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