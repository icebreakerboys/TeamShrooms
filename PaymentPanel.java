import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

//import javafx.*;

public class PaymentPanel extends JPanel {
    private JButton ReturnHome, IDbutton;
    private JButton seeProgress;
    private JLabel cost, costPrompt;
    private JLabel IDPrompt, namePrompt, getEmail, CHECK;
    private JTextArea PizzaArea;
    private JPanel payment_text, enterID;
    private String name, email;
    private JTextArea IDArea, nameArea, enterEmail ;
    private int id;
	
    Customer c = new Customer();
    Order newOrder = new Order();


    public PaymentPanel(JFrame frame, Pizza p) {

    	// button
    	seeProgress = new JButton(" See order progress ");
    	seeProgress.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	enterID = new JPanel();
    	enterID.setLocation(400, 600);
    	IDPrompt = new JLabel("enter your ASU ID: ");
    	IDPrompt.setFont(new Font("Arial", Font.PLAIN, 20));
    	IDPrompt.setLocation(300, 200);
	    
		namePrompt = new JLabel("Enter your Name: ");
    	namePrompt.setLocation(300, 100);
    	
    	getEmail = new JLabel("Enter your email:");
    	getEmail.setLocation(400, 200);
    	 
    	// text box for email?
    	IDArea = new JTextArea(1, 5);
    	nameArea = new JTextArea(1, 5);
    	enterEmail = new JTextArea(1,5);
    	
    	// text for total price
    	payment_text = new JPanel();
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	costPrompt = new JLabel("your total: ");
    	costPrompt.setFont(new Font("Arial", Font.BOLD, 30));
    	cost = new JLabel(currencyFormatter.format(MainGui.total));
    	cost.setFont(new Font("Arial", Font.ITALIC, 25));
    	cost.setForeground(Color.green);
    	costPrompt.setLocation(200, 010);
    	cost.setLocation(200, 010);

    	// add the elements
    	//payment_text.add(cost1);
    	//payment_text.add(cost2);
    	//add(payment_text, BorderLayout.SOUTH);
    	
    	//enterID.add(IDPrompt);
    	//enterID.add(PizzaArea);
    	//enterID.add(IDbutton);
    	//add(enterID);
    	
        //add(ReturnHome);
		//email = enterEmail.getText();
        //name = nameArea.getText();
		

		//Order newOrder = new Order(p, c, );
    	add(costPrompt);
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
    }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// remove the elements
        	//remove(enterID);
        	//remove(payment_text);
        	//remove(ReturnHome);
        	//remove(PizzaArea);
			//remove(IDArea);

        	remove(IDPrompt);
        	remove(nameArea);
        	remove(namePrompt);
        	remove(cost);
			remove(costPrompt);
        	remove(seeProgress);
        	remove(IDArea);
  

        	// transition back to the home panel
        	MainGui.showHomePanel(frame);
			//MainGui.showProgressGUI(frame);
			//MainGui.showChefsView(frame, newOrder);
        }
    }
}
