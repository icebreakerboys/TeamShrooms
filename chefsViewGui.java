import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class chefsViewGui extends JPanel {
	 private JPanel orderNum, name ,pizza_panel ;
	 private JLabel orderNUM , customer , pizzaType;
	public chefsViewGui(JFrame frame , order i) {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
		orderNum = new JPanel();
		orderNum.setLayout(new GridLayout(10,10,10,10));
		
		//orderNUM = new JLabel(i.getOrderNum());
		
		
		add(orderNum);
		
	}

}
