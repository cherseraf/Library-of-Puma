
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MemberMain implements ActionListener{
	JPanel panel = new JPanel();
	JButton main  = new JButton("Home Page");
	JButton books = new  JButton("Books");
	JButton borrow = new  JButton("Borrow");
	JFrame frame = new JFrame();
	
	
	MemberMain(){
		main.setBounds(80,100,200,40);
		main.setFocusable(false);
		main.addActionListener(this);
		panel.add(main);
		
		books.setBounds(80,160,200,40);
		books.setFocusable(false);
		books.addActionListener(this);
		panel.add(books);
		
		borrow.setBounds(80,220,200,40);
		borrow.setFocusable(false);
		borrow.addActionListener(this);
		panel.add(borrow);
		
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
		if(e.getSource()==books) {
			Books books = new Books();
		}
		else if(e.getSource() == borrow) {
			Borrow borrow = new Borrow("Member");
		}
		
	}
}
