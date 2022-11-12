public class Pizza {

	private String type;
	private String topping;
	private double cost;
	
	public Pizza(String type, String topping, double cost) {
		this.type = type;
		this.topping = topping;
		this.cost = cost;
	}
	
	public void changeType(String newType) {
		type = newType;
	}
	
	public void changeTopping(String newTopping) {
		topping = newTopping;
	}
	
	public double calculateCost() {
		// functionality to be added
		return 0.00;
	}
	
	public String getType() {
		return type;
	}
	
	public String getTopping() {
		return topping;
	}
	
}
