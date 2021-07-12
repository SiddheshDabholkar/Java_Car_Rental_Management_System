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
    JMenu homeMenuPanel = new JMenu("More");

    public void addCarsInfo() {
        JPanel pnlCarsInfo;
        pnlCarsInfo = new JPanel();
        JMenuItem mniCarsInfo = new JMenuItem("Cars Info");
        homeMenuPanel.add(mniCarsInfo);
        panel.add(pnlCarsInfo, "pnlCarsInfo");
        mniCarsInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel, "pnlCarsInfo");
            }
        });
        //
        String data[][] = {{"101", "GA 11", "Nissan", "20", "2", "true", "Bajaj", "11/11/11", "11/11/11", "123456"}};
        String column[] = {"id", "car no", "company", "mileage", "capacity", "availability", "insurance company", "effective date", "insurance exp.date", "car identification no."};
        JTable jt = new JTable(data, column);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane sp = new JScrollPane(jt);
        pnlCarsInfo.add(sp);
        //
        JLabel l=new JLabel("lmao");
        pnlCarsInfo.add(l);
        //
        pnlCarsInfo.setBackground(Color.black);
        pnlCarsInfo.setLayout(new GridLayout(2,1));
    }

    public void addCars() {
        JPanel pnlCars = new JPanel();
        JMenuItem mniCars = new JMenuItem("Cars");
        pnlCars = new JPanel();
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
        JPanel pnlCars, pnlBookCars, pnlCarsInfo;
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
        setMinimumSize(new Dimension(700, 500));
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