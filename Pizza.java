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
	
	public void setTopping(boolean newTopping[]) {
		topping = newTopping;
	}
	public void setCost(double newCost) {
		cost = newCost;
	}

	public double getCost(){
		return cost;
	}

	public String getType() {
		return type;
	}
	
	public String getTopping() {
		String toppingList = "";
		if(topping[0]){
			toppingList += "Onions\n";
		}
		if(topping[1]){
			toppingList += "Mushroom\n";
		}
		if(topping[2]){
			toppingList += "Olives\n";
		}
		if(topping[3]){
			toppingList += "Extra Cheese\n";
		}
		return toppingList;
	}
}
