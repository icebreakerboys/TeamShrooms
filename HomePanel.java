
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    private JLabel title, pic, logo_name, subtitle;
    private JTextArea PizzaArea;
    private ImageIcon logo;
    private JPanel panel, subtitle_panel, buttonPanel, titlePanel, bg, logoPanel;

    public HomePanel(JFrame frame) {

		bg = new JPanel();
		bg.setSize(1080, 720);
		bg.setLocation(0, 0);
		bg.setBackground(Color.GRAY);

    	// title text
    	title = new JLabel("SUNDEVIL Pizza          ");
    	title.setFont(new Font("Impact", Font.PLAIN, 40));
    	
    	// button
		buttonPanel = new JPanel();
		buttonPanel.setSize(310, 110);
		buttonPanel.setLocation(380, 450);
		buttonPanel.setBackground(Color.yellow);

    	OrderButton = new JButton(" Make an order! ");
    	OrderButton.setPreferredSize(new Dimension(300, 100));
    	OrderButton.setFont(new Font("Arial", Font.PLAIN, 30));
    	OrderButton.addActionListener(new ButtonListener(frame));

		buttonPanel.add(OrderButton);

		// title
		titlePanel = new JPanel();
		titlePanel.setSize(500, 35);
		titlePanel.setLocation(250, 0);
		titlePanel.setBackground(Color.GRAY);

    	title = new JLabel("Welcome to SUNDEVIL PIZZA");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		title.setForeground(Color.BLACK);

		titlePanel.add(title);

		subtitle = new JLabel("Brought to you by Team Shrooms");
		subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
		subtitle.setForeground(Color.YELLOW);

		subtitle_panel = new JPanel();
		subtitle_panel.setSize(300, 30);
		subtitle_panel.setLocation(345, 40);
		subtitle_panel.setBackground(Color.GRAY);
		subtitle_panel.add(subtitle);

    	
    	// logo
		logoPanel = new JPanel();
		logoPanel.setSize(100, 100);
		logoPanel.setLocation(300, 300);
		logoPanel.setBackground(Color.GRAY);

    	logo = new ImageIcon("res/ASUlogo.png");
    	logo_name = new JLabel(logo, 0);

		logoPanel.add(logo_name);
    	
		frame.add(titlePanel);
    	frame.add(logoPanel);
		frame.add(subtitle_panel);
		frame.add(buttonPanel);
		frame.add(bg);
        }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// removing the elements
            frame.remove(titlePanel);
        	frame.remove(subtitle_panel);
        	frame.remove(buttonPanel);
        	frame.remove(bg);

        	// transition to order screen
        	MainGui.showOrderPanel(frame);
        }
    }
}
