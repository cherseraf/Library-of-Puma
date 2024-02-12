import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MemberLogin extends CredentialsOfSqlServer implements ActionListener{
	JPanel panel = new JPanel();
	JButton login = new  JButton("Login");
	JButton sign = new  JButton("Sign up");
	JFrame frame = new JFrame();
	JTextField username = new JTextField("Mail");
	JTextField password = new JTextField("Password");
	JLabel label = new JLabel("Please Sign in");
	JLabel fail = new JLabel ("Your username or password is wrong, please try again.");
    static String QUERY;
    String username2;
    String password2;
	
	MemberLogin(){
		label.setBounds(50,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		
		fail.setBounds(300,70,1500,50);
		fail.setFont(new Font(null,Font.PLAIN,25));
		panel.add(fail);
		fail.setVisible(false);
		
	    username.setBounds(50,100, 200,30);    
	    panel.add(username);
	    
	    password.setBounds(50,150, 200,30);    
	    panel.add(password);
		
		login.setBounds(50,200,200,40);
		login.setFocusable(false);
		login.addActionListener(this);
		panel.add(login);
		
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
		if(e.getSource() == login) {
			
			username2 = username.getText();
			password2 = password.getText();
			QUERY = "SELECT * FROM PUMA.MEMBER WHERE EXISTS (SELECT * FROM puma.member WHERE memberAddress = '"+username2+"' AND memberPassword = '"+password2+"');";
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);) {
	        			MemberMain m;
	                	if(rs.next()) {
	                	  m = new MemberMain();
	                	    
	                	}
	                	else {
	                		fail.setVisible(true);
	                	}
	                } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
			//buraya username.getText() ve password.getText() ile aldiginiz username ve passwordu jdbc ile kontrol ettirin
			//eger true donerse yani databasede varsa MemberMain m = new MemberMain(); yoksa fail.setVisible(true);
		}
		else if(e.getSource() == sign) {
			SignUp s = new SignUp();
			
		}
		
	}
	

	public String getUsername() {
		return username.getText();
	}
}
