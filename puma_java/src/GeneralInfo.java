import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralInfo extends CredentialsOfSqlServer implements ActionListener{

	static final String QUERY = "SELECT DISTINCT librarianID, librarianName, CASE " +
			"WHEN librarianSalary < 37500 THEN 'This is an intern' " +
			"WHEN librarianSalary BETWEEN 37500 AND 47500 THEN 'This is an employee' " +
			"WHEN librarianSalary > 47500 THEN 'This is the head librarian' ELSE 'Isnt assigned yet' END AS librarianRank FROM librarian";
	JButton show = new JButton("Show");
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();

	public GeneralInfo() {
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
			panel.revalidate();
			panel.repaint();
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
				int co = 100;

				while (rs.next()) {

					co = co+50;


				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void label(String id, String name, String rank, int co) {

		JLabel firstRow = new JLabel("ID Name");
		firstRow.setBounds(400,50,1500,50);
		firstRow.setFont(new Font(null,Font.PLAIN,25));
		panel.add(firstRow);

		firstRow.setVisible(true);

		JLabel rank1 = new JLabel("Status");
		rank1.setBounds(700,50,1500,50);
		rank1.setFont(new Font(null,Font.PLAIN,25));
		panel.add(rank1);
		rank1.setVisible(true);

		JLabel info;
		info = new JLabel(id+" "+name+" "+" "+rank);
		info.setBounds(400,co,1500,50);
		info.setFont(new Font(null,Font.PLAIN,25));
		panel.add(info);
		frame.add(panel);
		info.setVisible(true);
	}


}