import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderPanel extends JPanel {
    private JButton PayButton;

    private JLabel pizzaPrompt, logo_name, toppingsPrompt;
    private JPanel pizza2_panel, toppings_panel, toppings2_panel;

	String pizzaType = "";
	boolean toppings[] = new boolean[4];
	double topPrice = 0;
	double basePrice = 0;

	private ButtonGroup types, tops;
    private JRadioButton pep, chs, veg;	
    private JPanel top1_panel, top2_panel, pizza_panel, bg;
    private JCheckBox mush, onion, olives, exChs;
    private ImageIcon logo;

    public OrderPanel(JFrame frame) {

    	// button
    	setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
    	
    	PayButton = new JButton(" Pay Now! ");
    	PayButton.setPreferredSize(new Dimension(250, 50));
    	PayButton.setFont(new Font("Arial", Font.PLAIN, 25));
    	PayButton.addActionListener(new ButtonListener(frame));
    	pizza2_panel = new JPanel();
		pizza2_panel.setLayout(new GridLayout(10, 10, 10, 10));
					
		pizza_panel = new JPanel();
		pizza_panel.setLayout(new GridLayout(1, 3));
		
		//Delivery Type
		pizzaPrompt = new JLabel(" Base Pizza Type:");
		pizzaPrompt.setFont(new Font("Arial", Font.BOLD, 30));

		//	delivery_panel.add(delivery_type);
		pep = new JRadioButton("Pepperoni");
		pep.setPreferredSize(new Dimension(50, 50));
		pep.setActionCommand(pizzaType = "PEP");
		chs = new JRadioButton("Cheese");
		chs.setActionCommand(pizzaType = "Cheese");
		veg = new JRadioButton("Veggie");
		veg.setActionCommand(pizzaType = "Veggie");
    	// text to make pizza selection
    	
    	// adding the elements
		types = new ButtonGroup();
		types.add(pep);
		types.add(chs);
		types.add(veg);
		pizza_panel.add(pep);
		pizza_panel.add(chs);
		pizza_panel.add(veg);
		pizza_panel.setAlignmentY(BOTTOM_ALIGNMENT);
		
		pizza2_panel.add(pizzaPrompt);					
		pizza2_panel.add(pizza_panel);
		add(pizzaPrompt);
		add(pizza_panel);

		top1_panel = new JPanel();
		top1_panel.setLayout(new GridLayout(1, 3));
		top2_panel = new JPanel();
		top2_panel.setLayout(new GridLayout(1, 3));
		toppings_panel = new JPanel();
		toppings_panel.setLayout(new GridLayout(2, 1));
		toppings2_panel = new JPanel();
		toppings2_panel.setLayout(new GridLayout(2, 1));
		
		toppingsPrompt = new JLabel("Toppings:");
		toppingsPrompt.setFont(new Font("Arial", Font.BOLD, 25));

		onion = new JCheckBox("Onion", false);
		mush = new JCheckBox("Mushroom", false);
		olives = new JCheckBox("Olives", false);
		exChs = new JCheckBox("Cheese", false);
		
		ItemListener onionButt = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				//AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					toppings[0] = true;
					topPrice += 1.50;
				}
				if(state == ItemEvent.DESELECTED){
					toppings[0] = false;
					topPrice -= 1.50;
				}
			}
		};
		ItemListener mushButt = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				//AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					toppings[1] = true;
					topPrice += 5.00;
				}
				if(state == ItemEvent.DESELECTED){
					toppings[1] = false;
					topPrice -= 1.50;
				}
			}
		};
		ItemListener olivesButt = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				//AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					toppings[2] = true;
					topPrice += 1.50;	
				}
				if(state == ItemEvent.DESELECTED){
					toppings[2] = false;
					topPrice -= 1.50;
				}
			}
		};
		ItemListener exchsButt = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				//AbstractButton abstractButton = (AbstractButton) itemEvent.getSource();
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					toppings[3] = true;
					topPrice += 1.50;		
				}
				if(state == ItemEvent.DESELECTED){
					toppings[3] = false;
					topPrice -= 1.50;
				}
			}
		};

		onion.addItemListener(onionButt);
		mush.addItemListener(mushButt);
		olives.addItemListener(olivesButt);
		exChs.addItemListener(exchsButt);
		
		top1_panel.add(onion);
		top1_panel.add(mush);
		top2_panel.add(olives);	
		top2_panel.add(exChs);					
		toppings_panel.add(top1_panel);
		toppings_panel.add(top2_panel);
		toppings2_panel.add(toppingsPrompt);
		toppings2_panel.add(toppings_panel);
		add(toppings2_panel);
	
        logo = new ImageIcon("res/pizzaSlice.png");
    	logo_name =new JLabel(logo , 0);
    	
    	add(logo_name);
    	add(PayButton);
    }

	private boolean pickPizza(){
		boolean selected = false;
		if(pep.isSelected()){
			basePrice = 5;
			selected = true;
			pizzaType = "Pepperoni";
		} else if(chs.isSelected()){
			basePrice = 5;
			selected = true;
			pizzaType = "Cheese";
		} else if(veg.isSelected()){
			basePrice = 5;
			selected = true;
			pizzaType = "Veggie";
		}
		return selected;
	}

    public class ButtonListener implements ActionListener {
    	private JFrame frame;
    	public ButtonListener(JFrame frame) {
    		this.frame = frame;
    	
    	}

        @Override
        public void actionPerformed(ActionEvent event) {
        	// remove the elements
			double total = basePrice + topPrice;
			boolean selected = pickPizza();

			if(selected){
				System.out.println(pizzaType);
				Pizza newZA = new Pizza(pizzaType, toppings, total);

        		remove(PayButton);
        		remove(pizza_panel);
        		remove(toppings2_panel);
        		remove(pizzaPrompt);
        		remove(toppings2_panel);
        		remove(logo_name);

        		// transition to payment screen
        		MainGui.showPaymentPanel(frame, newZA);
			} else {
				pizzaPrompt.setText("Must Select Base Pizza: ");
			}
        }
	}
}
