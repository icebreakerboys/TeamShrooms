public class Order {
	private static int curOrderNum = 1;
	private Pizza pizza;
	private Customer customer;
	private String pickUpTime;
	private int orderProgress;
	private int orderNumber;
	
	public Order(Pizza pizza, Customer customer, String pickUpTime) {
		this.pizza = pizza;
		this.customer = customer;
		this.pickUpTime = pickUpTime;
		orderProgress = 1;
		orderNumber = curOrderNum;
		curOrderNum++;
	}

	public Order() {
		
	}
	// returns cost of pizza
	public double getCost() {
		return pizza.getCost();
	}
	// returns pickup time
	public String getPickUpTime() {
		return pickUpTime;
	}
	//returns order num
	public int getOrderNum() {
		return orderNumber;
	}
	// sets the next stage of the order process
	public void nextStage() {
		if(orderProgress != 3) {
			orderProgress++;
		}
	} 
	// sets the order progress
	public void setOrderProgress(int newOrderProgress) {
		this.orderProgress = newOrderProgress;
		
	}
	// returns the order progress
	public int getOrderProgress() {
		return this.orderProgress;
	}
	// sets the pickup time 
	public void setPickUpTime(String newPickUp) {
		this.pickUpTime = newPickUp;
	}
	// returns the customer email
	public String getCustomerEmail() {
		return customer.getEmail();
	}
	public String getCustomerName() {
		return customer.getName();
	}
	
	public String getPizzaType() {
		return pizza.getType();
	}
	public String getPizzaTopping() {
		return pizza.getTopping();
	}

}
