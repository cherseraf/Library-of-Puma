import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibrarianPasswordInfo extends CredentialsOfSqlServer implements ActionListener{
    static String QUERY;
	JButton show = new JButton("Show");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JTextField salary = new JTextField("Salary");
	JTextField end = new JTextField("Password Ends");
	JLabel success = new JLabel("Successfull");
	JLabel label;
	JLabel nameLabel;
	
	
	public LibrarianPasswordInfo() {

		show.setBounds(50,200,200,40);
		show.setFocusable(false);
		show.addActionListener(this);
		panel.add(show);
		
		success.setBounds(400,100,1500,50);
		success.setFont(new Font(null,Font.PLAIN,25));
		panel.add(success);
		frame.add(panel);
		success.setVisible(false);
		
		salary.setBounds(50,100, 200,30);    
	    panel.add(salary);
	    
	    end.setBounds(50,150, 200,30);    
	    panel.add(end);
		
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
			QUERY =  "SELECT librarianName FROM (SELECT * FROM librarian WHERE librarianSalary > "+salary.getText()+") AS employee WHERE librarianPassword LIKE '%"+end.getText()+"' ";
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	                Statement stmt = conn.createStatement();
	                ResultSet rs = stmt.executeQuery(QUERY);) {
	        		int co = 100;
	        	
	                while (rs.next()) {
	                	
	                    label(rs.getString("librarianName"), co);
	                    co = co+20;

	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		
	}
	
	public void label(String name,int co) {
		
		
		label = new JLabel("Names of the librarians whose salaries are above "+salary.getText()+" and their password ends with "+end.getText()+": ");
		label.setBounds(400,50,1500,50);
		label.setFont(new Font(null,Font.PLAIN,25));
		panel.add(label);
		label.setVisible(true);
		
		nameLabel = new JLabel(name);
		nameLabel.setBounds(400,co,1500,50);
		nameLabel.setFont(new Font(null,Font.PLAIN,25));
		panel.add(nameLabel);
		frame.add(panel);
	
}
}
