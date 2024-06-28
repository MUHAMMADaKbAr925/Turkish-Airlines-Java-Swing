import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Navbar extends JPanel {
  private  ImageIcon turkishAirlines;
  private JPanel btns;
  private JButton helpbtn;
  private JButton signupbtn;
  private JButton signinbtn;
private JLabel taLabel;
    public Navbar(){
        setLayout(new BorderLayout());
        btns= new JPanel();
        helpbtn= new JButton(new ImageIcon("Help.png")); 
         signupbtn= new JButton(new ImageIcon("SignUp.png"));
            




        signinbtn= new JButton(new ImageIcon("SignIn.png"));   
        helpbtn.setBackground(getBackground());
        signinbtn.setBackground(getBackground());
        signupbtn.setBackground(getBackground());
        helpbtn.setBorderPainted(false);
        signinbtn.setBorderPainted(false);
        signupbtn.setBorderPainted(false);
        helpbtn.setFocusable(false);
        signinbtn.setFocusable(false);
        signupbtn.setFocusable(false);
        btns.add(helpbtn);
        btns.add(signupbtn);
        btns.add(signinbtn);
       signupbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub    
              SIgnUp signup = new SIgnUp();
              signup.setVisible(true);
              signup.setSize(800,800);
        }
       });
    
      
       signinbtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub    
              Login login = new Login();
        }
       });
    
      
      turkishAirlines  = new ImageIcon("Turkish_Airlines_tag.png");
       taLabel = new JLabel(turkishAirlines); 
    //   taLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    add(taLabel,BorderLayout.WEST);add(btns,BorderLayout.EAST);

    setVisible(true);
    setSize(100,2);
    btns.setBackground(getBackground());
setBackground(getBackground());

}
public Color getBackground(){
    return new Color(36,44,60);
}

public static void main(String[] args) {

    
}

}
