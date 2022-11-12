import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer {

	private String email;
	private String ID;
	//private Order order;
	private String name;
	
	public Customer(String name, String email, String ID) {
		this.email = email;
		this.ID = ID;
		this.name = name;
	}

	public Customer() {
		email ="UNKNOWN";
		ID = "";
		name = "UNKNOWN";
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean verifyID() {
		//functionality to be added
		boolean b = false;
		try{
			File dataBase = new File("database.txt");
			Scanner dBP = new Scanner(dataBase);
			while(dBP.hasNextLine()){
				String curID = dBP.nextLine();
				if(this.ID.equals(curID)){
					b = true;
				}
			}
			dBP.close();
		} catch (FileNotFoundException e){
			System.out.println("database.txt was unabled to be opened.");
		}
		return b;
	}
	
	public String getName() {
		return name;
}
		public void setName(String newName) {

		name = newName;
	}
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	public void setId(String newID) {
		ID = newID;
	}

	
}
