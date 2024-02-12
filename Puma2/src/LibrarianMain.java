import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LibrarianMain implements ActionListener{
    JPanel panel = new JPanel();
    JButton addBook  = new JButton("Add Book");
    JButton generalInfo = new  JButton("Some General Information");
    JButton use = new JButton("Use");
    JButton borrow = new JButton("Borrow");
    //JButton member = new JButton("Members");
    //JButton remove = new JButton("Remove a member");
    JButton delete = new JButton("Delete Books");
    JButton extra = new JButton("Extra Info");
    JButton generalLibrarian = new JButton("All Librarian Info");
    JButton generalBook = new JButton("General Book Info");
    JButton librarianPasswordInfo = new JButton("Librarian Password Info");
    JButton update = new JButton("Update Book Status");
    JFrame frame = new JFrame();
    JButton updateLaptop = new JButton("Update Laptop Status");


    LibrarianMain(){
        addBook.setBounds(80,100,200,40);
        addBook.setFocusable(false);
        addBook.addActionListener(this);
        panel.add(addBook);

        generalInfo.setBounds(80,160,200,40);
        generalInfo.setFocusable(false);
        generalInfo.addActionListener(this);
        panel.add(generalInfo);
        
        borrow.setBounds(80,220,200,40);
        borrow.setFocusable(false);
        borrow.addActionListener(this);
        panel.add(borrow);
        
        librarianPasswordInfo.setBounds(400,220,200,40);
        librarianPasswordInfo.setFocusable(false);
        librarianPasswordInfo.addActionListener(this);
        panel.add(librarianPasswordInfo);
        
        generalLibrarian.setBounds(400,160,200,40);
        generalLibrarian.setFocusable(false);
        generalLibrarian.addActionListener(this);
        panel.add(generalLibrarian);
        
        generalBook.setBounds(400,340,200,40);
        generalBook.setFocusable(false);
        generalBook.addActionListener(this);
        panel.add(generalBook);
        
        use.setBounds(400, 280,200,40);
        use.setFocusable(false);
        use.addActionListener(this);
        panel.add(use);
        
        extra.setBounds(80,280,200,40);
        extra.setFocusable(false);
        extra.addActionListener(this);
        panel.add(extra);
        
        update.setBounds(80,340,200,40);
        update.setFocusable(false);
        update.addActionListener(this);
        panel.add(update);
        
        updateLaptop.setBounds(80,400,200,40);
        updateLaptop.setFocusable(false);
        updateLaptop.addActionListener(this);
        panel.add(updateLaptop);

        delete.setBounds(400,100,200,40);
        delete.setFocusable(false);
        delete.addActionListener(this);
        panel.add(delete);


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
        if(e.getSource()== borrow) {
            Borrow books = new Borrow("LibrarianBook");
        }
        else if(e.getSource() == use) {
            Borrow use = new Borrow("LibrarianLaptop");
        }
        else if(e.getSource() == delete) {
            Delete delete = new Delete();
        }
        else if(e.getSource() == extra) {
            ExtraInfo extra = new ExtraInfo();
        }
        else if(e.getSource() == generalLibrarian) {
            GeneralInfo generalLib = new GeneralInfo();
        }
        else if(e.getSource() == generalBook) {
            GeneralBook generalBook = new GeneralBook();
        }
        else if(e.getSource() == librarianPasswordInfo) {
        	LibrarianPasswordInfo librarianPassInfo = new LibrarianPasswordInfo();
        }
        else if(e.getSource() == update) {
        	Update update = new Update();
        }
        else if(e.getSource() == generalInfo) {
        	Some genInfo = new Some();
        }
        else if(e.getSource() == addBook) {
        	AddLibrary add = new AddLibrary();
        }
        else if(e.getSource() == updateLaptop) {
        	UpdateLaptop add = new UpdateLaptop();
        }
        
    }
}