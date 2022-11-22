

import static org.junit.jupiter.api.Assertions.*;

import java.awt.LayoutManager;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

class tester {
	private static final  JFrame j= new JFrame();
	private static final  Customer mainCustTest = new Customer("Connor McCleve" , "connoriscool@gmail.com",
			"2175621");
	private static final boolean mainTop[] = new boolean[4];	
	Pizza mainPizzaTest = new Pizza("Pepperoni", mainTop, 10.34);

	@Test
	void customerTest() {
		 Customer custTest = new Customer();
		custTest.setName("Connor McDaddy");
		assertEquals("Connor McDaddy", custTest.getName());
	}
	@Test
	void orderTest() {
		
		mainTop[0] = true;
		mainTop[1] = true;
		mainTop[2]= true;
		mainPizzaTest.setTopping(mainTop);
		Order orderTest = new Order(mainPizzaTest,mainCustTest , "10:30" );
		assertEquals(orderTest.getCustomerName(), "Connor McCleve");
		assertEquals(orderTest.getPizzaType() , "Pepperoni");
	
	}
	@Test
	void pizzaTest() {
		boolean top[] = new boolean[4];
		top[0] = true;
		top[2]= true;
		Pizza pizzaTest = new Pizza();
		Pizza pizzaTest2 = new Pizza("Veggie" ,top, 3.43);
		pizzaTest.setCost(3.43);
		pizzaTest.setTopping(top);
		pizzaTest.setType("Veggie");
		
		assertEquals(pizzaTest.getCost(), pizzaTest2.getCost());
		assertEquals(pizzaTest.getTopping(), pizzaTest2.getTopping());
		assertEquals(pizzaTest.getType(), pizzaTest2.getType());
	}
	
	
	@Test 
	void idTest() {
		
		/*
		 * Try to set an unvalid ID and make sure it responds with false*/
		mainCustTest.setId("NOT VALID" );
		assertFalse(mainCustTest.verifyID());
		//Test valid ID in the database
		mainCustTest.setId("cmcclev2" );
		assertTrue(mainCustTest.verifyID());
	}
	@Test
	void guiTest() {
		PaymentPanel payTest = new PaymentPanel(j , mainPizzaTest);
		JTextArea nameTest = new JTextArea();
		j.add(nameTest);
		nameTest.setText("Connor McCleve");
		JTextArea emailTest = new JTextArea();
		j.add(emailTest);
		emailTest.setText("cmac@gmail.com");
		JTextArea idTest = new JTextArea();
		j.add(idTest);
		idTest.setText("cmcclev2");
		Customer hold = new Customer(nameTest.getText(), emailTest.getText() , idTest.getText());
		
		assertEquals("Connor McCleve", hold.getName());
		assertEquals("cmac@gmail.com", hold.getEmail());
		
	
	}
	@Test 
	void noToppingTest() {
		boolean notop[] = new boolean[4];
		Pizza noTopPizza = new Pizza("Veggie" , notop, 12.34);
		
		assertEquals("" , noTopPizza.getTopping());
	}
	@Test 
	void costUpdateTest() {
		boolean notop[] = new boolean[4];
		Pizza costUp = new Pizza("Veggie" , notop, 12.34);
		costUp.setCost(15.15);
		assertEquals(15.15 , costUp.getCost());
	}
	
	@Test 
	void progressUpdateTest() {
		mainTop[0] = true;
		mainTop[1] = true;
		mainTop[2]= true;
		mainPizzaTest.setTopping(mainTop);
		Order orderTest = new Order(mainPizzaTest,mainCustTest , "10:30" );
		assertEquals(1, orderTest.getOrderProgress());
		progressGUI pTest = new progressGUI(j,orderTest);
		chefsViewGui chefTest = new chefsViewGui(j , orderTest ,pTest );
		chefTest.updateOrderProgress(1);
		
		assertEquals(1 , orderTest.getOrderProgress());
		
		chefTest.updateOrderProgress(2);
		assertEquals(2 , orderTest.getOrderProgress());
				
	}
	
	

}
