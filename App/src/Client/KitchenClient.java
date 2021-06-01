package Client;





import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import Views.KitchenView;
import kioskapp.order.Order;
import kioskapp.orderedproduct.OrderedProduct;
import kioskapp.ordertransaction.OrderTransaction;

public class KitchenClient {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{

		KitchenView kitchenView = new KitchenView();
		kitchenView.setVisible(true);	
		
		int PORT = 3215;
		String ADDRESS = "localhost";
		
		while(true){
			
			Socket socket = new Socket(ADDRESS, PORT);
			socket.setKeepAlive(true);
			
			DataInputStream dataInput = new DataInputStream(socket.getInputStream());
			
			ObjectInputStream objectAsInput = new ObjectInputStream(socket.getInputStream());
			if(dataInput.readBoolean()) {
			
				Order order = new Order();
				order = (Order) objectAsInput.readObject();
				
				if(order != null) {
					
					OrderTransaction orderTransaction = (OrderTransaction) objectAsInput.readObject();
				
					
					String orderList = "Order referrence number: "+order.getOrderReferenceNumber()+"\n";
					for (OrderedProduct orderedItem: order.getOrderedItems()) {
						orderList += orderedItem.getItemProduct().getName()+": "+orderedItem.getQuantity()+"\n";
					}
			
					
					if(orderTransaction.getOrderMode().equalsIgnoreCase("Eat In")){
					kitchenView.setTextDineIn(orderList);
					}
					else {
						kitchenView.setTextTakeAway(orderList);
					}
				}
			}
		
			socket.close();
	
		}
	}
}