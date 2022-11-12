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
    private JButton battleRoyale;
    private JLabel cost1, cost2;
    private JLabel IDPrompt;
    private JTextArea PizzaArea;
    private JPanel payment_text, enterID;

    public PaymentPanel(JFrame frame) {

    	// button
    	ReturnHome = new JButton(" Return to home ");
    	ReturnHome.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	enterID = new JPanel();
    	enterID.setLocation(400, 600);
    	IDPrompt = new JLabel("enter your ASU ID: ");
    	IDPrompt.setFont(new Font("Arial", Font.PLAIN, 20));
    	IDPrompt.setLocation(300, 100);

    	// text box for UD
    	PizzaArea = new JTextArea(5, 20);
    	IDbutton = new JButton(" Submit ID ");
    	IDbutton.addActionListener(new ButtonListener(frame));

    	// text for total price
    	payment_text = new JPanel();
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	cost1 = new JLabel("your total: ");
    	cost1.setFont(new Font("Arial", Font.BOLD, 30));
    	cost2 =  new JLabel(currencyFormatter.format(MainGui.total));
    	cost2.setFont(new Font("Arial", Font.ITALIC, 25));
    	cost2.setForeground(Color.green);
    	cost1.setLocation(200, 010);
    	cost2.setLocation(200, 010);

    	// add the elements
    	payment_text.add(cost1);
    	payment_text.add(cost2);
    	add(payment_text, BorderLayout.SOUTH);
    	
    	enterID.add(IDPrompt);
    	enterID.add(PizzaArea);
    	enterID.add(IDbutton);
    	add(enterID);
    	
        add(ReturnHome);
    }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// remove the elements
        	remove(enterID);
        	remove(payment_text);
        	remove(ReturnHome);
        	remove(PizzaArea);

        	// transition back to the home panel
        	try {
				MainGui.showHomePanel(frame);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
    }

}