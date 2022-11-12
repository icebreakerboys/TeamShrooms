import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;

import javafx.*;




public class OrderPanel extends JPanel {
    private JButton PayButton;

    private JLabel pizza_type, logo_name, toppings_label;
    private JPanel input_panel, toppings_panel, toppings2_panel;

	String pizzaType, name_str, address_str, contact_str;
	String toppings;

	private ButtonGroup group , tops;
    private JRadioButton pep, chs , veg  ;	
   private JPanel top1_panel, top2_panel ,pizza_panel ;
   private JCheckBox mush, onion , olives , exChs;
   private ImageIcon logo;

    public OrderPanel(JFrame frame) {

    	// button
    	setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
    	
    	PayButton = new JButton(" Pay! ");
    	PayButton.addActionListener(new ButtonListener(frame));
    	input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(10, 10, 10, 10));	
					
		pizza_panel = new JPanel();
		pizza_panel.setLayout(new GridLayout(1, 3));			
		
		//Delivery Type
		pizza_type = new JLabel(" Pizza Type:");
	//	delivery_panel.add(delivery_type);		
		pep = new JRadioButton("Peperoni");
		pep.setActionCommand(pizzaType = "PEP");
		chs = new JRadioButton("Cheese");
		chs.setActionCommand(pizzaType = "Cheese");
		veg = new JRadioButton("Veggie");
		veg.setActionCommand( pizzaType = "Veggie");

    	// text to make pizza selection
    	

    	// adding the elements
		group = new ButtonGroup();
		group.add(pep);
		group.add(chs);
		group.add(veg);
		pizza_panel.add(pep);
		pizza_panel.add(chs);
		pizza_panel.add(veg);
		

		input_panel.add(pizza_type);					
		input_panel.add(pizza_panel);		
		add(pizza_type);
		add(pizza_panel);
		
		//toppings
		/*
		table_no = new JLabel("Pizza toppings");	
		
		
		mush = new JRadioButton("Mushroom");
		mush.setActionCommand("mush");
		exChs = new JRadioButton("Extra Cheese");
		exChs.setActionCommand("exChs");
		onion = new JRadioButton("Onion");
		onion.setActionCommand("onion");
		olives = new JRadioButton("Olives");
		olives.setActionCommand("olives");
		
		
		tops = new ButtonGroup();
		tops.add(mush);
		tops.add(olives);
		tops.add(onion);
		tops.add(exChs);
		delivery_panel.add(mush);
		delivery_panel.add(olives);
		delivery_panel.add(onion);
		delivery_panel.add(exChs);
		*/
		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("Toppings:");	

		onion = new JCheckBox("Onion", false);
		mush = new JCheckBox("Mushroom", false);
		olives = new JCheckBox("Olives", false);
		exChs = new JCheckBox("Cheese", false);
		
		
		ItemListener itemListener = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				int rate = 1;
				if(state == ItemEvent.SELECTED)
				{
					MainGui.total  += rate + 1.50;
					
					
							
				}
			}
		};
	
		ItemListener onionButt = new ItemListener()
		{
			public void itemStateChanged(ItemEvent itemEvent)
			{
				AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					toppings = "onion";		}
				
			}
		};
		ItemListener mushButt = new ItemListener()
		{public void itemStateChanged(ItemEvent itemEvent)
			{AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					toppings += " mush";		}
				}
		};
		ItemListener olivesButt = new ItemListener()
		{public void itemStateChanged(ItemEvent itemEvent)
			{AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					toppings += " olives";		}
				}
		};
		ItemListener exchsButt = new ItemListener()
		{public void itemStateChanged(ItemEvent itemEvent)
			{AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED)
				{
					toppings += " Extra cheese";		}
				}
		};
		
		Pizza newPizza = new Pizza("pepperoni" ," mush ", MainGui.total );
		
		onion.addItemListener(itemListener);
		onion.addItemListener(onionButt);
		mush.addItemListener(itemListener);
		mush.addItemListener(mushButt);
		olives.addItemListener(itemListener);
		olives.addItemListener(olivesButt);
		exChs.addItemListener(itemListener);	
		exChs.addItemListener(exchsButt);	
		
		top1_panel.add(onion);
		top1_panel.add(mush);
		top2_panel.add(olives);	
		top2_panel.add(exChs);					
	
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
					
		toppings2_panel.add(toppings_label);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
	
      
        logo = new ImageIcon("C:\\Users\\Connor\\eclipse-workspace\\test\\src\\pizzaSlice.jpg");
    	logo_name =new JLabel(logo , 0);
    	
    	add(logo_name);
    	add(PayButton);
          
        

        }

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// remove the elements
        	
        	Pizza newZA = new Pizza(pizzaType , toppings , MainGui.total );
        	remove(PayButton);
        	remove(pizza_panel);
        	remove(toppings2_panel);
        	remove(pizza_type);
        	remove(toppings2_panel);
        	remove(logo_name);

        	// transition to payment screen
        	MainGui.showPaymentPanel(frame , newZA);

        }
    }

}