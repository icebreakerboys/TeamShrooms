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

//import javafx.*;




public class PaymentPanel extends JPanel {
    private JButton ReturnHome;
    private JButton battleRoyale;
    private JLabel cost;
    private JLabel IDPrompt;
    private JTextArea PizzaArea;

    public PaymentPanel(JFrame frame) {

    	// button
    	ReturnHome = new JButton(" Return to home ");
    	ReturnHome.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	IDPrompt = new JLabel("enter your ASU ID:");
    	IDPrompt.setLocation(300, 100);

    	// text box for email?
    	PizzaArea = new JTextArea(5, 20);

    	// text for total price
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	cost = new JLabel("your total: " + currencyFormatter.format(MainGui.total));
    	cost.setLocation(200, 010);

    	// add the elements
    	add(cost);
    	add(IDPrompt);
        add(PizzaArea);
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
        	remove(IDPrompt);
        	remove(cost);
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