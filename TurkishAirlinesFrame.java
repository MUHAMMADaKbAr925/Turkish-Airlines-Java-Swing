import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.DateComponentFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class TurkishAirlinesFrame extends JFrame{
//normal constructor
    public TurkishAirlinesFrame(){
        setLayout(new BorderLayout());
              

        Navbar nav= new Navbar();
        add(nav,BorderLayout.NORTH);
                FirstPanelMain p1= new FirstPanelMain();
        add(p1,BorderLayout.CENTER);
        
        SecondPanelMainFrame p2= new SecondPanelMainFrame(1);
        add(p2,BorderLayout.SOUTH);

    }
    public TurkishAirlinesFrame(String credential, String preference){
        setLayout(new BorderLayout());
              

        Navbar nav= new Navbar();
        add(nav,BorderLayout.NORTH);
                FirstPanelMain p1= new FirstPanelMain();
        add(p1,BorderLayout.CENTER);
        
        SecondPanelMainFrame p2= new SecondPanelMainFrame(1,credential,preference);
        add(p2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(800,800);

    }
   //constructor for round trip but called from login
    public TurkishAirlinesFrame(String credential, String preference,String k){
        setLayout(new BorderLayout());
              

        Navbar nav= new Navbar();
        add(nav,BorderLayout.NORTH);
                FirstPanelMain p1= new FirstPanelMain();
        add(p1,BorderLayout.CENTER);
        
        SecondPanelRoundtrip p2= new SecondPanelRoundtrip(1,credential,preference);
        add(p2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(800,800);


    }
      //this cons opens a new window for round trip
    public TurkishAirlinesFrame(String k){
        setLayout(new BorderLayout());
              

        Navbar nav= new Navbar();
        add(nav,BorderLayout.NORTH);
                FirstPanelMain p1= new FirstPanelMain();
        add(p1,BorderLayout.CENTER);
        
        SecondPanelRoundtrip p2= new SecondPanelRoundtrip(1);
        add(p2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(800,800);


    }
    

    public static void main(String[] args) {
        TurkishAirlinesFrame frame= new TurkishAirlinesFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(800,500);
        frame.pack();
    }
}


