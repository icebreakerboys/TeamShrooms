import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import javax.swing.*;    
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class progressGUI extends JPanel{
    JProgressBar jb;    
    JProgressBar progressBAR;
	JLabel timeReady, emailReceipt;
	JPanel panel;
    int i=0,num=0;     
    private JButton ReturnHome;
  
    public  progressGUI(JFrame frame, Order o) {
		frame.getContentPane();
    

    	// button
    	ReturnHome = new JButton(" Return to home ");
    	ReturnHome.addActionListener(new ButtonListener(frame));

    	
    	   
        // progress bar
    	progressBAR=new JProgressBar(0,300);
    	progressBAR.setBounds(40,40,160,30);   
    	progressBAR.setValue(0);
    	progressBAR.setStringPainted(true);

		// thank you text
		timeReady = new JLabel("Your order will be ready to pick up at " + o.getPickUpTime());
    	timeReady.setFont(new Font("Arial", Font.BOLD, 30));
    	timeReady.setLocation(160, 100);

		emailReceipt = new JLabel("A receipt has been sent to " + o.getCustomerEmail());
    	emailReceipt.setFont(new Font("Arial", Font.PLAIN, 20));
    	emailReceipt.setBounds(300, 600, 100, 75);

		// SET LOCATION OF JLABEL
		panel = new JPanel();
		panel.setSize(700, 300);
		panel.setLocation(0, 300);
		panel.add(timeReady);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.add(panel);

    	// add the elements
        add(ReturnHome);
        add(progressBAR);
		add(emailReceipt);
      
    }
	public void updateProgress(int newProgress){
     	if (newProgress == 2) {
    		progressBAR.setValue(100*newProgress);
    		
    	}else {
    		progressBAR.setValue(100*newProgress);
    	}
    	
    }
    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	remove(ReturnHome);
        	remove(progressBAR);
			remove(emailReceipt);
 
        	// transition back to the home panel
			MainGui.showHomePanel(frame);
        }
	}
}