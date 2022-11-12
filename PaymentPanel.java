import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.*;




public class PaymentPanel extends JPanel {
    private JButton ReturnHome;
    private JButton seeProgress;
    private JLabel cost;
    private JLabel IDPrompt, namePrompt,getEmail , CHECK;
    private JTextArea IDArea , nameArea ,enterEmail ;
    private String name , email;
    private int id;
    Customer c = new Customer();
    order newOrder = new order();


    public PaymentPanel(JFrame frame , Pizza p) {

    	// button
    
    	seeProgress = new JButton(" See order progress ");
    	seeProgress.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	namePrompt = new JLabel("Enter your Name: ");
    	namePrompt.setLocation(300, 100);
    	
    	IDPrompt = new JLabel("enter your ASU ID:");
    	IDPrompt.setLocation(300, 200);
    	
    	getEmail = new JLabel("Enter your email:");
    	getEmail.setLocation(400, 200);
    	 

    	// text box for email?
    	IDArea = new JTextArea(1, 5);
    	nameArea = new JTextArea(1, 5);
    	enterEmail = new JTextArea(1,5);
    	
    	

    	// text for total price
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	cost = new JLabel("your total: " + currencyFormatter.format(MainGui.total));
    	cost.setLocation(200, 010);

    	// add the elements
    //	order newOrder = new order(pza , );
    	add(cost);
    	add(namePrompt);
    	add(nameArea);
    	add(IDPrompt);
        add(IDArea);
        add(getEmail);
        add(enterEmail);
        add(seeProgress);
        email = enterEmail.getText();
        name = nameArea.getText();
       // id = Integer.parseInt(enterEmail.getText());
        CHECK = new JLabel(name); 
        add (CHECK);
        
 
        }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// remove the elements
        	
        	remove(IDPrompt);
        	remove(nameArea);
        	remove(namePrompt);
        	remove(cost);
        	remove(seeProgress);
        	remove(IDArea);
  

        	// transition back to the home panel
        	
				//MainGui.showProgressGUI(frame);
				MainGui.showChefsView(frame ,newOrder );
			
     

        }
    }

}