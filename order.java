public class order {
	
	private Pizza pizza;
	private Customer customer;
	private double cost;
	private int pickUpTime;
	private int orderProgress;
	
	public order(Pizza pizza, Customer customer, double cost, int pickUpTime) {
		this.pizza = pizza;
		this.customer = customer;
		this.cost = cost;
		this.pickUpTime = pickUpTime;
		orderProgress = 1;
	}
	
	public double getCost() {
		return cost;
	}
	
	public int getPickUpTime() {
		return pickUpTime;
	}
	
	public void nextStage() {
		if(orderProgress != 3) {
			orderProgress++;
		}
	}
	
	public void emailCustomer() {
		// to be implemented
	}

}
