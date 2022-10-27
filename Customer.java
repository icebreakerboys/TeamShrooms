
public class Customer {

	private String email;
	private int ID;
	//private Order order;
	private String name;
	
	public Customer(String name, String email, int ID) {
		this.email = email;
		this.ID = ID;
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean verifyID() {
		//functionality to be added
		return true;
	}
	
	public String getName() {
		return name;
	}
	
}
