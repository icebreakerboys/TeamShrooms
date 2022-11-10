
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
//import javafx.application.Application; 
//import javafx.scene.Group; 
//import javafx.scene.Scene; 
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;  
//import javafx.stage.Stage;  

//import javafx.*;




public class HomePanel extends JPanel {
    private JButton OrderButton;
    private JButton battleRoyale;
    private JLabel title , pic ,logo_name;
    private JTextArea PizzaArea;
    private ImageIcon logo;

    public HomePanel(JFrame frame) throws FileNotFoundException {

    	// button
    	OrderButton = new JButton(" Make an order! ");
    	OrderButton.addActionListener(new ButtonListener(frame));

    	// title text
    	
    	title = new JLabel("WELCOME to order a pizza :D");
    	title.setLocation(200, 100);
    	
    	logo = new ImageIcon("C:\\\\Users\\\\Connor\\\\eclipse-workspace\\\\img\\\\asulogo.png");
    	logo_name =new JLabel( logo , 0);
    	
    	add(logo_name);
   
        add(OrderButton);
        add(title);

        }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// removing the elements
        	remove(OrderButton);
        	remove(title);

        	// transition to order screen
        	MainGui.showOrderPanel(frame);

        }
    }

}