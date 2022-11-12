import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class chef {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
	   LocalDateTime now = LocalDateTime.now();  
	   
	   
	  
	public void setOrderStatus(order i , int newOrderProgress) {
		i.setOrderProgress(newOrderProgress);
		
	
		
		if (newOrderProgress == 4) {
			i.setPickUpTime(dtf.format(now));
			
		}
		}
	
	
	
	

}
