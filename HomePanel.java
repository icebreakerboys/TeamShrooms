
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  

import javafx.*;




public class HomePanel extends JPanel {
    private JButton OrderButton;
    private JButton battleRoyale;
    private JLabel title , pic ,logo_name;
    private JTextArea PizzaArea;
    private ImageIcon logo;
    private JPanel panel;

    public HomePanel(JFrame frame) throws FileNotFoundException {
    	
    	panel = new JPanel();
    	panel.setPreferredSize(new Dimension(1080, 720));
    	// bg color
    	float hue = 7;
    	float saturation = (float) 0.48;
    	float balance = (float) 0.57;

    	panel.setBackground(Color.getHSBColor(hue, saturation, balance));

    	// title text
    	title = new JLabel("SUNDEVIL Pizza          ");
    	title.setFont(new Font("Impact", Font.PLAIN, 40));
    	
    	// button
    	OrderButton = new JButton(" Make an order! ");
    	OrderButton.setPreferredSize(new Dimension(300, 100));
    	OrderButton.setFont(new Font("Arial", Font.PLAIN, 30));
    	OrderButton.addActionListener(new ButtonListener(frame));
    	
    	// logo
    	logo = new ImageIcon("C:\\\\Users\\\\Connor\\\\eclipse-workspace\\\\img\\\\asulogo.png");
    	logo_name =new JLabel( logo , 0);
    	
    	
    	//frame.add(logo_name);
    	panel.add(title);
    	panel.add(OrderButton);
        add(panel);
        
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
        	remove(panel);

        	// transition to order screen
        	MainGui.showOrderPanel(frame);

        }
    }

}