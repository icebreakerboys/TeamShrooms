import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class MainGui {
    public static void main(String[] args) throws FileNotFoundException {

        JFrame frame = new JFrame("Pizza Ordering App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1080, 720));
        frame.setBackground(Color.RED);
       
        // make the initial call to show the home screen
        showHomePanel(frame);
    }
    
    // displays the home screen
    public static void showHomePanel(JFrame frame) {
    	HomePanel homepanel = new HomePanel(frame);
        frame.getContentPane().add(homepanel);
        
        //setting background colors to maroon
        Color customColor = new Color(140,29,64);
        homepanel.setBackground(customColor);
        
        frame.pack();
        frame.setVisible(true);
    }

    // displays the ordering screen
    public static void showOrderPanel(JFrame frame) {
    	OrderPanel orderpanel = new OrderPanel(frame);
        frame.getContentPane().add(orderpanel);

        //setting background colors to gold
        Color customColor = new Color(255, 198, 39);
        orderpanel.setBackground(customColor);

        frame.pack();
        frame.setVisible(true);
    }

    // displays the screen to make "payment"
    public static void showPaymentPanel(JFrame frame, Pizza p) {
    	PaymentPanel paymentpanel = new PaymentPanel(frame, p);
        frame.getContentPane().add(paymentpanel);

        //setting background colors to lightGray
        Color customColor = new Color(211, 211, 211);
        paymentpanel.setBackground(customColor);

        frame.pack();
        frame.setVisible(true);
    }

    public static void showProgressGUI(JFrame frame, Order o) {
    	progressGUI progress = new progressGUI(frame, o);
        frame.getContentPane().add(progress);

        frame.pack();
        frame.setVisible(true);
    }

    public static void showChefsView(JFrame frame, Order i) {
    	chefsViewGui chef = new chefsViewGui(frame, i);
    	
        frame.getContentPane().add(chef);
      
        frame.pack();
        frame.setVisible(true);
    }
}
