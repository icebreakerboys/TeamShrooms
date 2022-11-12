public class Pizza {

	private String type;
	private boolean topping[] = new boolean[4];
	private double cost;
	
	public Pizza(String type, boolean topping[], double cost) {
		this.type = type;
		this.topping = topping;
		this.cost = cost;
	}
	public Pizza() {
		type = "UNKOWN";
		topping[0] = false; topping[1] = false; topping[2] = false; topping[3] = false;
		cost = 0;
	}
	
	public void setType(String newType) {
		type = newType;
	}
	
	public void setTopping(String newTopping) {
		//topping = newTopping;
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
		return "";
	}
}
