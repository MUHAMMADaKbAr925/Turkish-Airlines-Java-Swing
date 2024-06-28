import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ticket extends JPanel {
    private JPanel fromPanel;
    private JPanel toPanel;ImageIcon southImage;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel typeImgPanel;
    private JLabel from;
    private JLabel to;
    private JPanel businessPanel;
    private JPanel economyPanel;
    private JLabel business;
    private JLabel economy;
    private JLabel businessPrice;
    private JLabel economyPrice;
    private JPanel businessBody;
    private JPanel economyBody;
    private JRadioButton bussinessRadio;
    private JRadioButton economyRadio;

    public Ticket() {
        setLayout(new GridLayout(1, 2));
        firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        fromPanel = new JPanel();
        toPanel = new JPanel();
        typeImgPanel = new JPanel();
     
        fromPanel.setBackground(Color.WHITE);
        toPanel.setBackground(Color.WHITE);
        fromPanel.setPreferredSize(new Dimension(120, 50));
        fromPanel.setLayout(new GridLayout(2, 1));
        toPanel.setLayout(new GridLayout(2, 1));
        toPanel.setPreferredSize(new Dimension(120, 50));
        firstPanel.setPreferredSize(new Dimension(400, 200)); // Increased height for firstPanel
        typeImgPanel.setPreferredSize(new Dimension(160, 70)); // Adjusted size for typeImgPanel
        typeImgPanel.setLayout(new BoxLayout(typeImgPanel, BoxLayout.X_AXIS));
        typeImgPanel.setBackground(Color.WHITE);
        typeImgPanel.add(Box.createHorizontalGlue());
        typeImgPanel.add(new JLabel(new ImageIcon("Direct.png")));
        typeImgPanel.add(Box.createHorizontalGlue());

        from = new JLabel("7:05");
        from.setHorizontalAlignment(JLabel.CENTER);
        fromPanel.add(from);
        fromPanel.add(new JLabel(new ImageIcon("IST.png")));
        to = new JLabel("12:00");
        to.setHorizontalAlignment(JLabel.CENTER);
        toPanel.add(to); 
        toPanel.add(new JLabel(new ImageIcon("JFK.png")));
     
        firstPanel.add(fromPanel, BorderLayout.WEST);
        firstPanel.add(toPanel, BorderLayout.EAST);
        firstPanel.add(typeImgPanel, BorderLayout.CENTER);
        firstPanel.setBackground(Color.WHITE);

        // Add image to the south
        ImageIcon southImage = new ImageIcon("ISTJFKDurr.png");
        JLabel southLabel = new JLabel(southImage);
        firstPanel.add(southLabel, BorderLayout.SOUTH);
        
        // Panels for business and economy
        businessPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        economyPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        
        // Panels for details of business and economy
        businessBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning
        economyBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning

        GridBagConstraints c = new GridBagConstraints(); // Constraints for GridBagLayout

        // Radio Buttons
        bussinessRadio = new JRadioButton();
        economyRadio = new JRadioButton();
        // Prices
        businessPrice = new JLabel("12000");
        businessPrice.setFont(businessPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        economyPrice = new JLabel("5000");
        economyPrice.setFont(economyPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        // Allignments
        businessPrice.setHorizontalAlignment(JLabel.CENTER);
        economyPrice.setHorizontalAlignment(JLabel.CENTER);
        // Adding components to businessBody
        
        JLabel businessPerPersonLabel = new JLabel("per person");
        businessPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        businessPerPersonLabel.setForeground(Color.GRAY); // Set font color
        businessPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        businessBody.add(businessPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        businessBody.add(bussinessRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        businessBody.add(businessPrice, c); // Add price label to the second row
        
        // Adding components to economyBody
        
        JLabel economyPerPersonLabel = new JLabel("per person");
        economyPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        economyPerPersonLabel.setForeground(Color.GRAY); // Set font color
        economyPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        economyBody.add(economyPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        economyBody.add(economyRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        economyBody.add(economyPrice, c); // Add price label to the second row

        // JLabels for business and economy class
        business = new JLabel(new ImageIcon("Bussiness_img.png"));
        business.setOpaque(true);
        business.setBackground(new Color(243, 235, 227));
        business.setForeground(Color.BLACK);

        economy = new JLabel(new ImageIcon("Economy_img.png"));
        economy.setOpaque(true);
        economy.setBackground(new Color(219,227,235));
        economy.setForeground(Color.BLACK);

        // Add components to businessPanel and economyPanel
        businessPanel.setBackground(Color.WHITE);
        businessPanel.add(business, BorderLayout.NORTH);
        businessPanel.add(businessBody, BorderLayout.CENTER);
        
        economyPanel.setBackground(Color.WHITE);
        economyPanel.add(economy, BorderLayout.NORTH);
        economyPanel.add(economyBody, BorderLayout.CENTER);

        // Add businessPanel and economyPanel to secondPanel
        secondPanel = new JPanel(); 
        secondPanel.setLayout(new GridLayout(1, 2));
        secondPanel.add(businessPanel);
        secondPanel.add(economyPanel);

        // Add firstPanel and secondPanel to Ticket panel
        add(firstPanel);
        add(secondPanel);
        secondPanel.setBackground(Color.WHITE);

        setVisible(true);
    }
    public Ticket(String NewYork) {
        setLayout(new GridLayout(1, 2));
        firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        fromPanel = new JPanel();
        toPanel = new JPanel();
        typeImgPanel = new JPanel();
     
        fromPanel.setBackground(Color.WHITE);
        toPanel.setBackground(Color.WHITE);
        fromPanel.setPreferredSize(new Dimension(120, 50));
        fromPanel.setLayout(new GridLayout(2, 1));
        toPanel.setLayout(new GridLayout(2, 1));
        toPanel.setPreferredSize(new Dimension(120, 50));
        firstPanel.setPreferredSize(new Dimension(400, 200)); // Increased height for firstPanel
        typeImgPanel.setPreferredSize(new Dimension(160, 70)); // Adjusted size for typeImgPanel
        typeImgPanel.setLayout(new BoxLayout(typeImgPanel, BoxLayout.X_AXIS));
        typeImgPanel.setBackground(Color.WHITE);
        typeImgPanel.add(Box.createHorizontalGlue());
        typeImgPanel.add(new JLabel(new ImageIcon("Direct.png")));
        typeImgPanel.add(Box.createHorizontalGlue());

        from = new JLabel("7:05");
        from.setHorizontalAlignment(JLabel.CENTER);
        fromPanel.add(from);
        fromPanel.add(new JLabel(new ImageIcon("IST.png")));
        to = new JLabel("12:00");
        to.setHorizontalAlignment(JLabel.CENTER);
        toPanel.add(to); 
        toPanel.add(new JLabel(new ImageIcon("JFK.png")));
     
        firstPanel.add(fromPanel, BorderLayout.WEST);
        firstPanel.add(toPanel, BorderLayout.EAST);
        firstPanel.add(typeImgPanel, BorderLayout.CENTER);
        firstPanel.setBackground(Color.WHITE);

        // Add image to the south
        ImageIcon southImage = new ImageIcon("ISTJFKDurr.png");
        JLabel southLabel = new JLabel(southImage);
        firstPanel.add(southLabel, BorderLayout.SOUTH);
        
        // Panels for business and economy
        businessPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        economyPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        
        // Panels for details of business and economy
        businessBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning
        economyBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning

        GridBagConstraints c = new GridBagConstraints(); // Constraints for GridBagLayout

        // Radio Buttons
        bussinessRadio = new JRadioButton();
        economyRadio = new JRadioButton();
        // Prices
        businessPrice = new JLabel("12000");
        businessPrice.setFont(businessPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        economyPrice = new JLabel("5000");
        economyPrice.setFont(economyPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        // Allignments
        businessPrice.setHorizontalAlignment(JLabel.CENTER);
        economyPrice.setHorizontalAlignment(JLabel.CENTER);
        // Adding components to businessBody
        
        JLabel businessPerPersonLabel = new JLabel("per person");
        businessPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        businessPerPersonLabel.setForeground(Color.GRAY); // Set font color
        businessPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        businessBody.add(businessPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        businessBody.add(bussinessRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        businessBody.add(businessPrice, c); // Add price label to the second row
        
        // Adding components to economyBody
        
        JLabel economyPerPersonLabel = new JLabel("per person");
        economyPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        economyPerPersonLabel.setForeground(Color.GRAY); // Set font color
        economyPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        economyBody.add(economyPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        economyBody.add(economyRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        economyBody.add(economyPrice, c); // Add price label to the second row

        // JLabels for business and economy class
        business = new JLabel(new ImageIcon("Bussiness_img.png"));
        business.setOpaque(true);
        business.setBackground(new Color(243, 235, 227));
        business.setForeground(Color.BLACK);

        economy = new JLabel(new ImageIcon("Economy_img.png"));
        economy.setOpaque(true);
        economy.setBackground(new Color(219,227,235));
        economy.setForeground(Color.BLACK);

        // Add components to businessPanel and economyPanel
        businessPanel.setBackground(Color.WHITE);
        businessPanel.add(business, BorderLayout.NORTH);
        businessPanel.add(businessBody, BorderLayout.CENTER);
        
        economyPanel.setBackground(Color.WHITE);
        economyPanel.add(economy, BorderLayout.NORTH);
        economyPanel.add(economyBody, BorderLayout.CENTER);

        // Add businessPanel and economyPanel to secondPanel
        secondPanel = new JPanel(); 
        secondPanel.setLayout(new GridLayout(1, 2));
        secondPanel.add(businessPanel);
        secondPanel.add(economyPanel);

        // Add firstPanel and secondPanel to Ticket panel
        add(firstPanel);
        add(secondPanel);
        secondPanel.setBackground(Color.WHITE);

        setVisible(true);
    }
    public String timeOfDeparture;
    public String timeOfArrival;
    public String departureCity;
    public String destinationCity;
    public String flightNum;
    public int  bussiness_price;
    public int economy_price;
    public Ticket(String flightNum,String CityOfDeparture,String CityOfArrival,String departureTime, String arrivalTime, boolean is_direct,int business_price,int economy_price) {
      this.flightNum=flightNum;
      this.bussiness_price=business_price;
      this.economy_price=economy_price;
        setLayout(new GridLayout(1, 2));
        firstPanel = new JPanel();
        firstPanel.setLayout(new BorderLayout());
        fromPanel = new JPanel();
        toPanel = new JPanel();
        typeImgPanel = new JPanel();
    
        fromPanel.setBackground(Color.WHITE);
        toPanel.setBackground(Color.WHITE);
        fromPanel.setPreferredSize(new Dimension(120, 50));
        fromPanel.setLayout(new GridLayout(2, 1));
        toPanel.setLayout(new GridLayout(2, 1));
        toPanel.setPreferredSize(new Dimension(120, 50));
        firstPanel.setPreferredSize(new Dimension(400, 200)); // Increased height for firstPanel
        typeImgPanel.setPreferredSize(new Dimension(160, 70)); // Adjusted size for typeImgPanel
        typeImgPanel.setLayout(new BoxLayout(typeImgPanel, BoxLayout.X_AXIS));
        typeImgPanel.setBackground(Color.WHITE);
        typeImgPanel.add(Box.createHorizontalGlue());
        if(is_direct){
        typeImgPanel.add(new JLabel(new ImageIcon("Direct.png")));}
        typeImgPanel.add(Box.createHorizontalGlue());
       
        from = new JLabel(departureTime+""); 
        from.setFont(from.getFont().deriveFont(Font.BOLD,35));
        from.setHorizontalAlignment(JLabel.CENTER);
        fromPanel.add(from);
        if(CityOfDeparture.equals("Istanbul")){
        fromPanel.add(new JLabel(new ImageIcon("IST.png")));}
        else if(CityOfDeparture.equals("New York")){
            fromPanel.add(new JLabel(new ImageIcon("JFK.png")));
        }
        else if(CityOfDeparture.equals("Ankara")){
            fromPanel.add(new JLabel(new ImageIcon("ESB.png")));
        }
        to = new JLabel(arrivalTime+"");
        to.setFont(to.getFont().deriveFont(Font.BOLD,35));

        to.setHorizontalAlignment(JLabel.CENTER);
        toPanel.add(to); 
        if(CityOfArrival.equalsIgnoreCase("New York")){
        toPanel.add(new JLabel(new ImageIcon("JFK.png")));}
        else if(CityOfArrival.equals("Istanbul")){
            toPanel.add(new JLabel(new ImageIcon("IST.png")));
        }
        else if(CityOfArrival.equals("Ankara")){
            toPanel.add(new JLabel(new ImageIcon("ESB.png")));
        }
     
        firstPanel.add(fromPanel, BorderLayout.WEST);
        firstPanel.add(toPanel, BorderLayout.EAST);
        firstPanel.add(typeImgPanel, BorderLayout.CENTER);
        firstPanel.setBackground(Color.WHITE);




if((CityOfDeparture.equals("Istanbul")||CityOfArrival.equals("Istanbul")& (CityOfDeparture.equals("Ankara")||CityOfArrival.equals("Ankara")))){
        // Add image to the south
         southImage = new ImageIcon("ISTESBDurr.png");}
else{
         southImage = new ImageIcon("ISTJFKDurr.png");}
        JLabel southLabel = new JLabel(southImage);
        firstPanel.add(southLabel, BorderLayout.SOUTH);
        
        // Panels for business and economy
        businessPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        economyPanel = new JPanel(new BorderLayout()); // Initialize with BorderLayout
        
        // Panels for details of business and economy
        businessBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning
        economyBody = new JPanel(new GridBagLayout()); // Use GridBagLayout for precise positioning

        GridBagConstraints c = new GridBagConstraints(); // Constraints for GridBagLayout

        // Radio Buttons
        bussinessRadio = new JRadioButton();
economyRadio = new JRadioButton();

ButtonGroup buttonGroup;
buttonGroup = new ButtonGroup();
buttonGroup.add(bussinessRadio);
buttonGroup.add(economyRadio);


// Add action listener to the economy radio button
 // Prices
        businessPrice = new JLabel(business_price+"");
        businessPrice.setFont(businessPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        economyPrice = new JLabel(economy_price+"");
        economyPrice.setFont(economyPrice.getFont().deriveFont(Font.BOLD, 25)); // Enlarge the font
        // Allignments
        businessPrice.setHorizontalAlignment(JLabel.CENTER);
        economyPrice.setHorizontalAlignment(JLabel.CENTER);
        // Adding components to businessBody
        
        JLabel businessPerPersonLabel = new JLabel("per person");
        businessPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        businessPerPersonLabel.setForeground(Color.GRAY); // Set font color
        businessPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        businessBody.add(businessPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        businessBody.add(bussinessRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        businessBody.add(businessPrice, c); // Add price label to the second row
        
        // Adding components to economyBody
        
        JLabel economyPerPersonLabel = new JLabel("per person");
        economyPerPersonLabel.setFont(new Font("Arial", Font.PLAIN, 10)); // Set font size
        economyPerPersonLabel.setForeground(Color.GRAY); // Set font color
        economyPerPersonLabel.setHorizontalAlignment(JLabel.CENTER);

        c.gridx = 1;
        c.gridy = 0;
        economyBody.add(economyPerPersonLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        economyBody.add(economyRadio, c); // Add radio button to the second row
        
        c.gridx = 1;
        economyBody.add(economyPrice, c); // Add price label to the second row

        // JLabels for business and economy class
        business = new JLabel(new ImageIcon("Bussiness_img.png"));
        business.setOpaque(true);
        business.setBackground(new Color(243, 235, 227));
        business.setForeground(Color.BLACK);

        economy = new JLabel(new ImageIcon("Economy_img.png"));
        economy.setOpaque(true);
        economy.setBackground(new Color(219,227,235));
        economy.setForeground(Color.BLACK);

        // Add components to businessPanel and economyPanel
        businessPanel.setBackground(Color.WHITE);
        businessPanel.add(business, BorderLayout.NORTH);
        businessPanel.add(businessBody, BorderLayout.CENTER);
        
        economyPanel.setBackground(Color.WHITE);
        economyPanel.add(economy, BorderLayout.NORTH);
        economyPanel.add(economyBody, BorderLayout.CENTER);

        // Add businessPanel and economyPanel to secondPanel
        secondPanel = new JPanel(); 
        secondPanel.setLayout(new GridLayout(1, 2));
        secondPanel.add(businessPanel);
        secondPanel.add(economyPanel);

        // Add firstPanel and secondPanel to Ticket panel
        add(firstPanel);
        add(secondPanel);

        setVisible(true);
    }
    public boolean isBusinessSelected() {
        return bussinessRadio.isSelected();
    }

    public boolean isEconomySelected() {
        return economyRadio.isSelected();
    }

    public String getFlightNum() {
        return flightNum;
    }
    public JRadioButton getBussinessRadio() {
        return bussinessRadio;
    }
    
    public JRadioButton getEconomyRadio() {
        return economyRadio;
    }
    public int getBusinessPrice(){
        return bussiness_price;
    }
    public int getEconomyPrice(){
        return economy_price;
    }
}
