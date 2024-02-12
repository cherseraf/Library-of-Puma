import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class UpdateLaptop extends CredentialsOfSqlServer implements ActionListener{
    JPanel panel = new JPanel();
    JButton updateLaptop = new  JButton("Update");
    JFrame frame = new JFrame();
    JTextField inputLaptopID = new JTextField("Laptop ID");
    JTextField inputLaptopStatus = new JTextField("Laptop Status");
    JLabel updateLaptopText = new JLabel("Update Laptop");
    JLabel fail = new JLabel ("Something went wrong. Please try again.");
    JLabel succ = new JLabel ("Successfully updated.");
    static String QUERY;



    UpdateLaptop(){


        updateLaptopText.setBounds(450,50,1500,50);
        updateLaptopText.setFont(new Font(null,Font.PLAIN,25));
        panel.add(updateLaptopText);


        fail.setBounds(450,250,1500,50);
        fail.setFont(new Font(null,Font.PLAIN,25));
        panel.add(fail);
        fail.setVisible(false);

        succ.setBounds(450,550,1500,50);
        succ.setFont(new Font(null,Font.PLAIN,25));
        panel.add(succ);
        succ.setVisible(false);

        inputLaptopID.setBounds(450,100, 200,30);
        panel.add(inputLaptopID);

        inputLaptopStatus.setBounds(450,150, 200,30);
        panel.add(inputLaptopStatus);

        updateLaptop.setBounds(450,200,200,40);
        updateLaptop.setFocusable(false);
        updateLaptop.addActionListener(this);
        panel.add(updateLaptop);

        panel.setSize(1500,900);
        panel.setLayout(null);
        panel.setVisible(true);

        frame.setSize(1500,900);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	succ.setVisible(false);
    	fail.setVisible(false);

        QUERY = "UPDATE laptop SET laptopStatus = '"+inputLaptopStatus.getText()+"' WHERE laptopID = '"+inputLaptopID.getText()+"'";
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement()){

            boolean rs = stmt.execute(QUERY);
            if(!rs) {
                succ.setVisible(true);

            }
            else {
                fail.setVisible(true);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            fail.setVisible(true);
        }
    }




}