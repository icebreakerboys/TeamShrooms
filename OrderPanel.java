import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderPanel extends JPanel {
    private JButton PayButton;

    private JLabel pizza_type, logo_name, toppings_label;
    private JPanel input_panel, toppings_panel, toppings2_panel;

	String pizzaType, name_str, address_str, contact_str;
	String toppings;

	private ButtonGroup group, tops;
    private JRadioButton pep, chs, veg;	
    private JPanel top1_panel, top2_panel ,pizza_panel, bg;
    private JCheckBox mush, onion , olives , exChs;
    private ImageIcon logo;

    public OrderPanel(JFrame frame) {
    	
    	// bg color
    	float hue = 7;
    	float saturation = (float) 0.48;
    	float balance = (float) 0.57;

    	// button
    	setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
    	
    	PayButton = new JButton(" Pay Now! ");
    	PayButton.setPreferredSize(new Dimension(100, 50));
    	PayButton.setFont(new Font("Arial", Font.PLAIN, 25));
    	PayButton.addActionListener(new ButtonListener(frame));
    	input_panel = new JPanel();
		input_panel.setLayout(new GridLayout(10, 10, 10, 10));
					
		pizza_panel = new JPanel();
		pizza_panel.setLayout(new GridLayout(1, 3));
		
		
		//Delivery Type
		pizza_type = new JLabel(" Base Pizza Type:");
		pizza_type.setFont(new Font("Arial", Font.BOLD, 30));
	//	delivery_panel.add(delivery_type);
		pep = new JRadioButton("Pepperoni");
		pep.setPreferredSize(new Dimension(50, 50));
		pep.setActionCommand("PEP");
		chs = new JRadioButton("Cheese");
		chs.setActionCommand(pizzaType = "Cheese");
		veg = new JRadioButton("Veggie");
		veg.setActionCommand(pizzaType = "Veggie");
    	// text to make pizza selection
    	
    	// adding the elements
		group = new ButtonGroup();
		group.add(pep);
		group.add(chs);
		group.add(veg);
		pizza_panel.add(pep);
		pizza_panel.add(chs);
		pizza_panel.add(veg);
		pizza_panel.setAlignmentY(BOTTOM_ALIGNMENT);
		

		input_panel.add(pizza_type);					
		input_panel.add(pizza_panel);		
		add(pizza_type);
		add(pizza_panel);

		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppings_label = new JLabel("Toppings:");
		toppings_label.setFont(new Font("Arial", Font.BOLD, 25));

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
	
      
        logo = new ImageIcon("res/pizzaSlice.jpg");
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

        	
        	Pizza newZA = new Pizza(pizzaType, toppings, MainGui.total);

        	remove(PayButton);
        	remove(pizza_panel);
        	remove(toppings2_panel);
        	remove(pizza_type);
        	remove(toppings2_panel);
        	remove(logo_name);

        	// transition to payment screen
        	MainGui.showPaymentPanel(frame, newZA);

        }
    }

}
