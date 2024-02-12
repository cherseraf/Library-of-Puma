

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LaunchPage implements ActionListener{

	JFrame frame = new JFrame();
	JButton loginMember  = new JButton("Member Login");
	JButton loginLibrarian = new  JButton("Librarian Login");
	
	LaunchPage(){
		loginMember.setBounds(100,100,200,40);
		loginMember.setFocusable(false);
		loginMember.addActionListener(this);
		frame.add(loginMember);
		
		loginLibrarian.setBounds(100,160,200,40);
		loginLibrarian.setFocusable(false);
		loginLibrarian.addActionListener(this);
		frame.add(loginLibrarian);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginMember) {
			MemberLogin librarian = new MemberLogin();
		}
		if(e.getSource() == loginLibrarian) {
			LibrarianLogin librarian = new LibrarianLogin();
		}
		
	}



}
