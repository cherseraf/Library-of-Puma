import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Some extends CredentialsOfSqlServer implements ActionListener{
	
    static String QUERY;
	JButton show = new JButton("Show");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JTextField page = new JTextField("Book Page");
	JTextField genre = new JTextField("Book Genre");
	JLabel success = new JLabel("Successfull");
    
	public Some() {
		show.setBounds(50,200,200,40);
		show.setFocusable(false);
		show.addActionListener(this);
		panel.add(show);
		
		success.setBounds(400,100,1500,50);
		success.setFont(new Font(null,Font.PLAIN,25));
		panel.add(success);
		frame.add(panel);
		success.setVisible(false);
		
		page.setBounds(50,100, 200,30);    
	    panel.add(page);
	    
	    genre.setBounds(50,150, 200,30);    
	    panel.add(genre);
		
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
			QUERY =  "SELECT SUM(bookLength), bookGenre FROM book GROUP BY bookGenre HAVING SUM(bookLength) > "+page.getText()+"" +
		            " AND bookGenre = '"+genre.getText()+"' ";
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);) {
	        		int co = 100;
	        		
	                while (rs.next()) {


	                    System.out.print("Sum of the book lengths consisting of more than 500 pages: " + rs.getInt(1));
	                    System.out.println(", Genre of the books: " + rs.getString("bookGenre"));
	                    label(rs.getInt(1), rs.getString("bookGenre"), co);


	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		
	}
	
	public void label(int sum, String genre,int co) {
		
		
		JLabel label = new JLabel("Sum of the book lengths consisting of more than "+page.getText()+" pages: "+sum);
		label.setBounds(400,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		label.setVisible(true);
		
		JLabel genre1 = new JLabel("Genre of the books: " + genre);
		genre1.setBounds(400,co,1500,50);
		genre1.setFont(new Font(null,Font.PLAIN,25));
		panel.add(genre1);
		frame.add(panel);
		genre1.setVisible(true);
}
}
