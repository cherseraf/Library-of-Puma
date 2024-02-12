import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Borrow extends CredentialsOfSqlServer implements ActionListener{
	
	JPanel panel = new JPanel();
	JButton main  = new JButton("Home Page");
	JButton books = new  JButton("Books");
	JButton borrow = new  JButton("Borrow");
	JFrame frame = new JFrame();
	JLabel label = new JLabel("Please contact the librarians to borrow books or use laptops.");
	JTextField book = new JTextField("Book Name");
	JTextField member = new JTextField("Member Address");
	JTextField borrowDateBook = new JTextField("Borrowed Date");
	JTextField laptop = new JTextField("Laptop Model ID");
	JTextField memberLaptop = new JTextField("Member Address");
	JTextField dueDateBook = new JTextField("Due Date");
	JTextField extDateBook = new JTextField("Extension Date");
	JTextField borrowDateLaptop = new JTextField("Borrowed Date");
	JTextField dueDateLaptop = new JTextField("Due Date");
	JLabel succ = new JLabel("The action is successfull");
	JButton add = new JButton("Add");
	JButton add2 = new JButton("Add");
	static String QUERY = "SELECT max(borrowID) from borrow;";
	static String QUERY2 = "SELECT max(useID) from use;";
	
	
	Borrow(String part){
		if(part == "Member") {
			label.setBounds(50,50,1500,50);
			label.setFont(new Font(null,Font.PLAIN,25));
			panel.add(label);
			
			panel.setSize(1500,900);
			panel.setLayout(null);
			panel.setVisible(true);

			frame.setSize(1500,900);
			frame.setLayout(null);
			frame.setVisible(true);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(panel);
		}
		else if(part == "LibrarianBook") {
			
			succ.setBounds(50,50,1500,50);
			succ.setFont(new Font(null,Font.PLAIN,25));
			panel.add(label);
			succ.setVisible(false);
			
		    book.setBounds(50,100, 200,30);    
		    panel.add(book);
		    
		    member.setBounds(50,150, 200,30);    
		    panel.add(member);
			
		    borrowDateBook.setBounds(50,200,200,40);
			panel.add(borrowDateBook);
			
			extDateBook.setBounds(50,250,200,40);
			panel.add(extDateBook);
			
			dueDateBook.setBounds(50,300,200,40);
			panel.add(dueDateBook);
			
			add.setBounds(50,350,200,40);
			add.setFocusable(false);
			add.addActionListener(this);
			frame.add(add);
			
			panel.setSize(1500,900);
			panel.setLayout(null);
			panel.setVisible(true);

			frame.setSize(1500,900);
			frame.setLayout(null);
			frame.setVisible(true);
			
			frame.add(panel);
			
		}
		else if(part == "LibrarianLaptop") {
			succ.setBounds(50,50,1500,50);
			succ.setFont(new Font(null,Font.PLAIN,25));
			panel.add(label);
			succ.setVisible(false);
			
		    laptop.setBounds(50,100, 200,30);    
		    panel.add(laptop);
		    
		    memberLaptop.setBounds(50,150, 200,30);    
		    panel.add(memberLaptop);
			
		    borrowDateLaptop.setBounds(50,200,200,40);
			panel.add(borrowDateLaptop);
			
			dueDateLaptop.setBounds(50,250,200,40);
			panel.add(dueDateLaptop);
			
			add2.setBounds(50,300,200,40);
			add2.setFocusable(false);
			add2.addActionListener(this);
			frame.add(add2);
			
			panel.setSize(1500,900);
			panel.setLayout(null);
			panel.setVisible(true);

			frame.setSize(1500,900);
			frame.setLayout(null);
			frame.setVisible(true);
			
			frame.add(panel);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add) {
			succ.setVisible(false);
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	        		Statement stmt2 = conn.createStatement();
	        		ResultSet rs = stmt.executeQuery(QUERY);
	            ) {
	        		rs.next();
	        		int id = rs.getInt(1)+1;
	                String sql = "INSERT INTO borrow (borrowID, borrowDate, borrowDue, borrowExtension, bookID, memberID) "
	                		+ "VALUES ("+id+",'"+borrowDateBook.getText()+"','"+dueDateBook.getText()+"','"+extDateBook.getText()+"',"
	                		+ "(SELECT bookID FROM book WHERE bookName = '"+book.getText()+"'),"
	                		+ "(SELECT memberID FROM member WHERE memberAddress = '"+member.getText()+"'))";
	                stmt.executeUpdate(sql);
	                label();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
		else {
			succ.setVisible(false);
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	        		Statement stmt2 = conn.createStatement();
	        		ResultSet rs = stmt.executeQuery(QUERY);
	            ) {
	        		rs.next();
	        		int id = rs.getInt(1)+1;
	                String sql = "INSERT INTO puma.use (useID, useDate, useDue, LaptopID, membersID) VALUES ('"+id+"','"+borrowDateLaptop.getText()+"','"+dueDateLaptop.getText()+"',\r\n"
	                		+ "(SELECT laptopID FROM laptop WHERE laptopID = '"+laptop.getText()+"'),\r\n"
	                		+ "(SELECT memberID FROM member WHERE memberAddress = '"+memberLaptop.getText()+"'))";
	                stmt.executeUpdate(sql);
	                label();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		}
	public void label() {
		
		
		JLabel label = new JLabel("Successfull");
		label.setBounds(400,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		label.setVisible(true);
		frame.add(panel);
}
		
	}

