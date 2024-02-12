import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeneralBook extends CredentialsOfSqlServer implements ActionListener{
	

    static String QUERY;
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JButton all = new JButton("All");
	JButton some = new JButton("Some");
	JLabel success = new JLabel("Successful");
    
	public GeneralBook() {
		
		success.setBounds(400,100,1500,50);
		success.setFont(new Font(null,Font.PLAIN,25));
		panel.add(success);
		frame.add(panel);
		success.setVisible(false);
		
		all.setBounds(50,100, 200,30);
	    all.setFocusable(false);
		all.addActionListener(this);
		panel.add(all);

	    some.setBounds(50,150, 200,30);
		some.setFocusable(false);
		some.addActionListener(this);
	    panel.add(some);
		
		panel.setSize(1500,900);
		panel.setLayout(null);
		panel.setVisible(true);

		frame.setSize(1500,900);
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int co = 100;
		if(e.getSource() == some) {
			 QUERY = "SELECT bookName, bookAuthor FROM book WHERE bookID = SOME (SELECT bookID FROM borrow WHERE book.bookID = borrow.bookID)";
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);) {
				System.out.println("Fetching information about currently borrowed books in the Puma Library:som:");
	                while (rs.next()) {
	                		
	                		label("Fetching information about currently borrowed books in the Puma Library: ", rs.getString("bookName"),
	                				rs.getString("bookAuthor"), co);


	                		co=co+50;


	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		if(e.getSource() == all) {
			QUERY = "SELECT bookName, bookAuthor FROM book WHERE bookID = ALL (SELECT bookID FROM borrow WHERE book.bookID = borrow.bookID)";

			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
				
				while (rs.next()) {
					label("Fetching information about currently registered books in the Puma Library:",
							rs.getString("bookName"), rs.getString("bookAuthor"), co);
					
					co=co+50;
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public void label(String general1, String name, String author,int co) {
		
		
		JLabel label = new JLabel(name + " "+author);
		label.setBounds(400,co,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		label.setVisible(true);
		
		JLabel general = new JLabel(general1);
		general.setBounds(400,10,1500,50);
		general.setFont(new Font(null,Font.PLAIN,25));
		panel.add(general);
		frame.add(panel);
		general.setVisible(true);
}
}
