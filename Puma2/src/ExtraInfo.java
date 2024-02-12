import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;


public class ExtraInfo extends CredentialsOfSqlServer implements ActionListener{

    static final String QUERY = "SELECT AVG(bookLength), COUNT(*), MAX(bookDate) FROM book";
    static final String QUERY2 = "SELECT max(bookID) from puma.book;";
	JButton show = new JButton("Show");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
    
	ExtraInfo(){
		
		show.setBounds(50,200,200,40);
		show.setFocusable(false);
		show.addActionListener(this);
		panel.add(show);
		
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
		if(e.getSource() == show) {
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	        		Statement stmt2 = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);
	        		ResultSet rs2 = stmt2.executeQuery(QUERY2);) {
	        		int co = 150;
	        		rs.next();
	        		rs2.next();
	        	
	                while (co <= 240) {
	                	
	                    if(co == 150) {
	                    	label(rs.getInt(1), co, "");
	                    }
	                    else if(co == 180) {
	                    	label(rs.getInt(2),co, "");
	                    }
	                    else if(co == 210){
	                    	label(0, co, rs.getString(3));
	                    }
	                    else {
	                    	label(0, co, rs2.getString(1));
	                    }
	                    co = co+30;

	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		
	}
	
	public void label(int state, int co, String s) {
		JLabel books;
		if(co == 150 && s.equals("")) {
			books = new JLabel("Average length of the books currently in the Puma Library: "+state);
			books.setBounds(400,co,1500,50);
		}
		else if(co == 180 && s.equals("")) {
			books = new JLabel("Total number of books currently in the Puma Library: "+state);
			books.setBounds(400,co,1500,50);
		}
		else if(co == 210 && !s.equals("")) {
			books = new JLabel("ID of the last added book: "+state);
			books.setBounds(400,co,1500,50);
		}
		else{
			books = new JLabel("Newest book addition date to the Puma Library: "+s);
			books.setBounds(400,co,1500,50);
		}
		books.setFont(new Font(null,Font.PLAIN,25));
		panel.add(books);
		frame.add(panel);
		books.setVisible(true);
}
}
