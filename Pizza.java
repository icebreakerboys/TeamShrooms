public class Pizza {

	private String type;
	private String topping;
	private double cost;
	
	public Pizza(String type, String topping, double cost) {
		this.type = type;
		this.topping = topping;
		this.cost = cost;
	}
	public Pizza() {
		type = "UNKOWN";
		topping = "NOT SPECIFIED";
		cost = 0;
	}
	
	public void setType(String newType) {
		type = newType;
	}
	
	public void setTopping(String newTopping) {
		topping = newTopping;
	}
	public void setCost(double newCost) {
		cost = newCost;
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
