import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Update extends CredentialsOfSqlServer implements ActionListener{
    JPanel panel = new JPanel();
    JButton updateBook = new  JButton("Update");
    JFrame frame = new JFrame();
    JTextField inputBookID = new JTextField("Book ID");
    JTextField inputBookStatus = new JTextField("Book Status");
    JLabel updateBookText = new JLabel("Update Book");
    JLabel fail = new JLabel ("Something went wrong. Please try again.");
    JLabel succ = new JLabel ("Successfully updated.");
    static String QUERY;



    Update(){


        updateBookText.setBounds(450,50,1500,50);
        updateBookText.setFont(new Font(null,Font.PLAIN,25));
        panel.add(updateBookText);


        fail.setBounds(450,250,1500,50);
        fail.setFont(new Font(null,Font.PLAIN,25));
        panel.add(fail);
        fail.setVisible(false);

        succ.setBounds(450,550,1500,50);
        succ.setFont(new Font(null,Font.PLAIN,25));
        panel.add(succ);
        succ.setVisible(false);

        inputBookID.setBounds(450,100, 200,30);
        panel.add(inputBookID);

        inputBookStatus.setBounds(450,150, 200,30);
        panel.add(inputBookStatus);

        updateBook.setBounds(450,200,200,40);
        updateBook.setFocusable(false);
        updateBook.addActionListener(this);
        panel.add(updateBook);

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

        QUERY = "UPDATE book SET bookStatus = '"+inputBookStatus.getText()+"' WHERE BookID = '"+inputBookID.getText()+"'";
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