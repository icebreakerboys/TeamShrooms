import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chefsViewGui extends JPanel  {
	 private JPanel orderNum, name ,pizza_panel , orderInfo ;
	 private JLabel orderNUM , customer , pizzaType,jLabel , pizzaTop;
	public chefsViewGui(JFrame frame, Order i , progressGUI p) {
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		
		String[] orderProgressOptions = {"ORDER RECIEVED" ,"IN PREP", "COOKING", "READY FOR PICK UP"};

		
		
		customer = new JLabel("Customer Name: " + i.getCustomerName());
		customer.setFont(new Font("Arial", Font.PLAIN, 30));
		customer.setLocation(1080/3, 100);
		
		orderNUM = new JLabel("Order Number: " +Integer.toString(i.getOrderNum()));
		orderNUM.setFont(new Font("Arial", Font.PLAIN, 30));
		orderNUM.setLocation(1080/2, 100);
		
		pizzaType= new JLabel("Pizza Type: "+i.getPizzaType());
		pizzaType.setFont(new Font("Arial", Font.PLAIN, 20));
		pizzaType.setLocation(1080/2, 100);
		
		pizzaTop =new JLabel("Toppings: " + i.getPizzaTopping()+ " ");
		pizzaTop.setFont(new Font("Arial", Font.PLAIN, 20));
		pizzaTop.setLocation(1080/2, 100);
		
		
		
		
		final JComboBox<String> status = new JComboBox<String>(orderProgressOptions);
		status.setVisible(true);
		
		status.getItemAt(status.getSelectedIndex());
		JButton update = new JButton("Update Order Status");
		
		
		
		
		Box orderInfo = Box.createVerticalBox();
		orderInfo.add(customer);
		orderInfo.add(orderNUM);
		orderInfo.add(pizzaType);
		orderInfo.add(pizzaTop);
		
		orderInfo.add(status);
		orderInfo.add(update);
		
	
		add(orderInfo);
	
		
		update.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String newOrderProgress = status.getItemAt(status.getSelectedIndex());
                System.out.println(newOrderProgress);
                
                updateOrderProgress(status.getSelectedIndex());
                p.updateProgress(status.getSelectedIndex());
             
			}
		});
		
	}
	
	public void updateOrderProgress(int i) {
		System.out.println(i);
		
		
	}



}
