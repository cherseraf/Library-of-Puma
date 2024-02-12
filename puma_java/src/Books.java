
import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Books extends CredentialsOfSqlServer implements ActionListener{
	
    JFrame frame= new JFrame();
    JTextField input = new JTextField(); 
    JButton button = new JButton("Search");
    JLabel label = new JLabel("Please Enter Your Book's Name");
    JPanel panel = new JPanel();
    static String QUERY;
    String name;
    JLabel exist = new JLabel("This book is not at our library.");
    JLabel avbl = new JLabel("This book is not available at the moment.");
    static String QUERY2;
    static String QUERY3;
    
	Books(){
		
		avbl.setBounds(500,150,1500,50);
		avbl.setFont(new Font(null,Font.PLAIN,25));
		panel.add(avbl);
		avbl.setVisible(false);
		
		exist.setBounds(500,150,1500,50);
		exist.setFont(new Font(null,Font.PLAIN,25));
		panel.add(exist);
		exist.setVisible(false);
		
		label.setBounds(50,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		
		
	    input.setBounds(50,100, 200,30);    
	    panel.add(input);
		
	    button.setBounds(50,200,200,40);
	    button.setFocusable(false);
	    button.addActionListener(this);
		panel.add(button);
		
		
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
		if(e.getSource() == button) {
			avbl.setVisible(false);
			exist.setVisible(false);
			label("","","","",0,0);
			//books.setVisible(false);
			name = input.getText();
			QUERY = "SELECT * FROM book WHERE EXISTS (SELECT bookName, bookAuthor, bookGenre, bookLength, bookStatus FROM book WHERE bookName = '" + name + "');";
			QUERY2 = "SELECT bookStatus FROM book WHERE bookName = '" + name + "'";
			QUERY3 = "SELECT bookName, bookAuthor, bookGenre, bookLength FROM book WHERE bookName = '" + name + "'";
			//QUERY3 = "SELECT * FROM book";
			int numbery = 150;
			
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        		Connection conn2 = DriverManager.getConnection(DB_URL, USER, PASS);
	        		Connection conn3 = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	        		Statement stmt2 = conn2.createStatement();
	        		Statement stmt3 = conn3.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);
	        		ResultSet rs2 = stmt2.executeQuery(QUERY2);
	        		ResultSet rs3 = stmt3.executeQuery(QUERY3);) {
	        		
	        		
	                if(rs.next()) {
	                	rs2.next();
	                	if(rs2.getInt(1) == 1) {
	                		
	                		while(rs3.next()) {
	                			label(rs3.getString("bookName"), rs3.getString("bookAuthor"), rs3.getString("bookGenre"), rs3.getString("bookLength"), numbery, 1);
	                			numbery = numbery+30;
	                		}
	                	}else {
	                		avbl.setVisible(true);
	                	}	                	



	                }else {
	                	exist.setVisible(true);
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		
	}
	public void label(String column1, String column2, String column3, String column4, int yAxis, int state) {
			JLabel books = new JLabel(column1+"\t    "+column2+"\t    "+column3+"\t    "+column4);
			books.setBounds(400,yAxis,1500,50);
			books.setFont(new Font(null,Font.PLAIN,25));
			panel.add(books);
			frame.add(panel);
			if(state == 0) {
				books.setVisible(false);
			}else if(state == 1) {
				books.setVisible(true);
			}
	}


}
