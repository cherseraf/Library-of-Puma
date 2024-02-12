import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Delete extends CredentialsOfSqlServer implements ActionListener{
	JButton delete = new JButton("Delete");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JTextField id = new JTextField("Book ID");
	JLabel success = new JLabel("Successfull");
	
	public Delete() {
		delete.setBounds(50,200,200,40);
		delete.setFocusable(false);
		delete.addActionListener(this);
		panel.add(delete);
		
		success.setBounds(400,100,1500,50);
		success.setFont(new Font(null,Font.PLAIN,25));
		panel.add(success);
		frame.add(panel);
		success.setVisible(false);
		
	    id.setBounds(50,100, 200,30);    
	    panel.add(id);
		
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
		if(e.getSource() == delete) {
	        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement())

	            {
	                String sql = "DELETE FROM book WHERE bookID = "+id.getText();
	                stmt.executeUpdate(sql);
	                success.setVisible(true);
	                System.out.println("ney");

	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
		}
		
	}
	
	
}
