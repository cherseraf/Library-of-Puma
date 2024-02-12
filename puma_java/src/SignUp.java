import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUp extends CredentialsOfSqlServer implements ActionListener{
	JPanel panel = new JPanel();
	JButton sign = new  JButton("Sign up");
	JFrame frame = new JFrame();
	JTextField mail = new JTextField("E-mail Address");
	JTextField name = new JTextField("Full Name");
	JTextField password = new JTextField("Password");
	JLabel label = new JLabel("Please Sign up");
	JLabel succ = new JLabel ("You have successfully signed up.");
	static String QUERY = "SELECT max(memberID) from member;";
	
	SignUp(){
		
		label.setBounds(50,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		
		succ.setBounds(300,70,1500,50);
		succ.setFont(new Font(null,Font.PLAIN,25));
		panel.add(succ);
		succ.setVisible(false);
		
	    name.setBounds(50,100, 200,30);    
	    panel.add(name);
		
	    mail.setBounds(50,150, 200,30);    
	    panel.add(mail);
	    
	    password.setBounds(50,200, 200,30);    
	    panel.add(password);
		
		sign.setBounds(50,250,200,40);
		sign.setFocusable(false);
		sign.addActionListener(this);
		panel.add(sign);
		
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
		if(e.getSource()==sign) {
			succ.setVisible(false);
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	        		Statement stmt2 = conn.createStatement();
	        		ResultSet rs = stmt.executeQuery(QUERY);
	            ) {
	        		rs.next();
	        		int id = rs.getInt(1)+1;
	        		
	                String sql = "INSERT INTO member (memberID, memberName, memberAddress, memberPassword)" +
	                        " VALUES ("+id+",'"+name.getText()+"', '"+mail.getText()+"', '"+password.getText()+"')";
	                stmt.executeUpdate(sql);
	                succ.setVisible(true);
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
			succ.setVisible(true);
			LaunchPage launch = new LaunchPage();
		}
		
	}
}
