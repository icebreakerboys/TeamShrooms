public class order {
	
	private Pizza pizza;
	private Customer customer;
	private double cost;
	private String pickUpTime;
	private int orderProgress;
	private int orderNumber;
	
	public order(Pizza pizza, Customer customer, double cost, String pickUpTime) {
		this.pizza = pizza;
		this.customer = customer;
		this.cost = cost;
		this.pickUpTime = pickUpTime;
		orderProgress = 1;
	}
	public order() {
		
	}
	
	public double getCost() {
		return cost;
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
	} public void setOrderProgress(int newOrderProgress) {
		this.orderProgress = newOrderProgress;
		
	}
	public int getOrderProgress() {
		return this.orderProgress;
	}
	public void setPickUpTime(String newPickUp) {
		this.pickUpTime = newPickUp;
		
	}
	
	
	public void emailCustomer() {
		// to be implemented
	}

}
