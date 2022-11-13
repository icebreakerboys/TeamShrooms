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
	
	public double getCost() {
		return pizza.getCost();
	}
	
	public String getPickUpTime() {
		return pickUpTime;
	}
	public int getOrderNum() {
		return orderNumber;
	}
	
	public void nextStage() {
		if(orderProgress != 3) {
			orderProgress++;
		}
	} 
	public void setOrderProgress(int newOrderProgress) {
		this.orderProgress = newOrderProgress;
		
	}
	public int getOrderProgress() {
		return this.orderProgress;
	}
	public void setPickUpTime(String newPickUp) {
		this.pickUpTime = newPickUp;
	}
	
	public String getCustomerEmail() {
		return customer.getEmail();
	}

}