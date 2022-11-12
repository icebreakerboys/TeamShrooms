import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class PaymentPanel extends JPanel {
    private JButton submitButton;
    private JLabel cost, costPrompt;
    private JLabel IDPrompt, namePrompt, emailPrompt, CHECK;
    private JTextArea IDArea, nameArea, emailArea ;
	
    Pizza p;

    public PaymentPanel(JFrame frame, Pizza p) {
		this.p = p;

    	// button
    	submitButton = new JButton(" See order progress ");
    	submitButton.addActionListener(new ButtonListener(frame));

    	// text for enter ASU id prompt
    	IDPrompt = new JLabel("enter your ASU ID: ");
    	IDPrompt.setFont(new Font("Arial", Font.PLAIN, 20));
    	IDPrompt.setLocation(300, 200);
	    
		namePrompt = new JLabel("Enter your Name: ");
    	namePrompt.setLocation(300, 100);
    	
    	emailPrompt = new JLabel("Enter your email:");
		emailPrompt.setLocation(400, 200);
    	 
    	// text box for email?
    	IDArea = new JTextArea(1, 5);
    	nameArea = new JTextArea(1, 5);
    	emailArea = new JTextArea(1,5);
    	
    	// text for total price
    	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    	
    	costPrompt = new JLabel("your total: ");
    	costPrompt.setFont(new Font("Arial", Font.BOLD, 30));
    	cost = new JLabel(currencyFormatter.format(p.getCost()));
    	cost.setFont(new Font("Arial", Font.ITALIC, 25));
    	cost.setForeground(Color.green);
    	costPrompt.setLocation(200, 010);
    	cost.setLocation(200, 010);
		
		//Order newOrder = new Order(p, c, );
    	add(costPrompt);
		add(cost);
    	add(namePrompt);
    	add(nameArea);
    	add(IDPrompt);
        add(IDArea);
        add(emailArea);
        add(emailPrompt);
        add(submitButton);
    }

	private String setTime(){
		LocalDateTime time = LocalDateTime.now();
		Random r = new Random();
		int hour = time.getHour();
		int minute = time.getMinute() + r.nextInt(16) + 10;
		if(minute >= 60){
			hour++;
			minute = minute - 60;
		}
		return hour + ":" + minute;
	}

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {

        	String ID = IDArea.getText();
			String name = nameArea.getText();
			String email = emailArea.getText();
			Customer c = new Customer(name, email, ID);

			if(c.verifyID()){
				remove(nameArea);
        		remove(namePrompt);
				remove(emailArea);
				remove(emailPrompt);
				remove(IDArea);
				remove(IDPrompt);
				remove(cost);
				remove(costPrompt);
        		remove(submitButton);

				String pickUpTime = setTime();
				Order o = new Order(p, c, pickUpTime);
				//MainGui.showHomePanel(frame);
				MainGui.showProgressGUI(frame, o);
			} else {
				IDPrompt.setText("ID invalid: ");
			}
			
        	// transition back to the home panel
			//MainGui.showChefsView(frame, o);
        }
    }
}
