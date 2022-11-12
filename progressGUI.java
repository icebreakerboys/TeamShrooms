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
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class progressGUI extends JPanel{
   // ProgressBar progressBar = new ProgressBar(0);
    JProgressBar jb;    
    JProgressBar progressBAR;
    int i=0,num=0;     
    private JButton ReturnHome;
  
    public  progressGUI(JFrame frame, Order o) {
  
    

    	// button
    	ReturnHome = new JButton(" Return to home ");
    	ReturnHome.addActionListener(new ButtonListener(frame));

    	
    	   
        
    	progressBAR=new JProgressBar(0,5);    
    	progressBAR.setBounds(40,40,160,30);         
    	progressBAR.setValue(0);    
    	progressBAR.setStringPainted(true);    
        

  

    	// add the elements
        add(ReturnHome);
        add(progressBAR);
     
      
  


    }public void updateProgress(int newProgress){
    	progressBAR.setValue(newProgress);
    	
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
 
        	// transition back to the home panel
			MainGui.showHomePanel(frame);
        }

}}
