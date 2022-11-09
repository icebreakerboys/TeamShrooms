import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class MainGui {

	
	static double total;
    public static void main(String[] args) throws FileNotFoundException {

        JFrame frame = new JFrame("pizza ordering app");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1080, 720));

        // make the initial call to show the home screen
        showHomePanel(frame);
    }

    // displays the home screen
    public static void showHomePanel(JFrame frame) throws FileNotFoundException {
    	HomePanel homepanel = new HomePanel(frame);
        frame.getContentPane().add(homepanel);
        
        frame.pack();
        frame.setVisible(true);
    }

    // displays the ordering screen
    public static void showOrderPanel(JFrame frame) {
    	OrderPanel orderpanel = new OrderPanel(frame);
        frame.getContentPane().add(orderpanel);

        frame.pack();
        frame.setVisible(true);
    }

    // displays the screen to make "payment"
    public static void showPaymentPanel(JFrame frame) {
    	PaymentPanel paymentpanel = new PaymentPanel(frame);
        frame.getContentPane().add(paymentpanel);

        frame.pack();
        frame.setVisible(true);
    }



}