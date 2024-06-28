import java.awt.GridLayout;

import javax.swing.JFrame;

public class TestClass extends JFrame{
  
    public static void main(String[] args) {
        TestClass frame= new TestClass();
        frame.setLayout(new GridLayout(3,1));
        Ticket f= new Ticket();
        frame.add(f);
        frame.add(new Ticket());
        frame.add(new Ticket());

        frame.setVisible(true);
        frame.setSize(900,400);
        frame.setLocationRelativeTo(null);
        
    }
}
