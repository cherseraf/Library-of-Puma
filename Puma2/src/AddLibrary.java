import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class AddLibrary extends CredentialsOfSqlServer implements ActionListener{
	
	JPanel panel = new JPanel();
	JButton main  = new JButton("Home Page");
	JButton books = new  JButton("Books");
	JButton borrow = new  JButton("Borrow");
	JFrame frame = new JFrame();
	JTextField bookid = new JTextField("Book ID");
	JTextField name = new JTextField("Book Name");
	JTextField author = new JTextField("Book Author");
	JTextField genre = new JTextField("Book Genre");
	JTextField length = new JTextField("Book Length");
	JTextField date = new JTextField("Book Date");
	JTextField status = new JTextField("Book Status");
	JLabel succ = new JLabel("The action is successfull");
	JButton add = new JButton("Add");
	JButton add2 = new JButton("Add2");
	
	AddLibrary(){
			
			succ.setBounds(50,50,1500,50);
			succ.setFont(new Font(null,Font.PLAIN,25));
			panel.add(succ);
			succ.setVisible(false);
			
			bookid.setBounds(50,100, 200,30);    
		    panel.add(bookid);
		    
		    name.setBounds(50,150, 200,30);    
		    panel.add(name);
			
		    author.setBounds(50,200,200,40);
			panel.add(author);
			
			length.setBounds(50,250,200,40);
			panel.add(length);
			
			date.setBounds(50,300,200,40);
			panel.add(date);
			
			genre.setBounds(50,350,200,40);
			panel.add(genre);
			
			status.setBounds(50,400,200,40);
			panel.add(status);
			
			add.setBounds(50,450,200,40);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == add) {
			succ.setVisible(false);
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	            ) {
	                String sql = "INSERT INTO book (bookID, bookName, bookAuthor, bookGenre,bookLength, bookDate, bookStatus)\r\n"
	                		+ "VALUES ('"+bookid.getText()+"', '"+name.getText()+"', '"+author.getText()+"', '"+genre.getText()+"', '"+length.getText()+"', '"+date.getText()+"', '"+status.getText()+"')";
	                stmt.executeUpdate(sql);
	                succ.setVisible(true);
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	        }
		}
		
	}

