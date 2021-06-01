package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import FileCreate.FileCreate;
import Views.ApplicationView;
import kioskapp.order.Order;
import kioskapp.orderedproduct.OrderedProduct;
import kioskapp.ordertransaction.OrderTransaction;

public class MainKioskClient {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException, SQLException, ClassNotFoundException {
	

		int PORT = 3215;
		String ADDRESS = "localhost";
		String stop = "0";
		
		while(true) {
		
			ApplicationView applicationFrame = new ApplicationView();
			applicationFrame.setVisible(true);
			
			Socket socket = new Socket(ADDRESS, PORT);
			socket.setKeepAlive(true);
			
			DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
			DataInputStream dataInput = new DataInputStream(socket.getInputStream());
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			
			if(applicationFrame.getChoose() != -1) {
				
				if(applicationFrame.getChoose() != -1) {
				
					if(applicationFrame.getChoose() != -1) {
						
					
						String creditCardNumber = applicationFrame.getCreditCardNumber();
						dataOutput.writeUTF(creditCardNumber);
						dataOutput.flush();
						
				
						ArrayList<OrderedProduct> orderedItems = new ArrayList<OrderedProduct>();
						orderedItems = applicationFrame.getOrderedItems();
						
						OrderTransaction orderTransaction = new OrderTransaction();
						orderTransaction = applicationFrame.getOrderTransaction();
						
						
						objectOutputStream.writeObject(orderedItems);
						objectOutputStream.reset();
						objectOutputStream.writeObject(orderTransaction);
						objectOutputStream.reset();
						
					
						Order order = new Order();
						order = (Order) objectInputStream.readObject();
						orderTransaction = (OrderTransaction) objectInputStream.readObject();
						
						
						
						ReceiptTemplate receiptTemplate = new ReceiptTemplate();// create the object of receipt
						String receipt = receiptTemplate.Receipt(order, orderTransaction);// assign the value to the receipt
						FileCreate data = new FileCreate("Receipt"+order.getOrderId()+".txt", false);// setup the name and if we want it to append is same file name
						data.writeToFile(receipt);
						
					}	
					else {
						dataOutput.writeUTF(stop);
					}
				}else {
					dataOutput.writeUTF(stop);
				}
			}else {
				dataOutput.writeUTF(stop);
			}
			
			
			objectOutputStream.close();
			objectInputStream.close();
			dataOutput.close();
			dataInput.close();
			socket.close();
			
	
			applicationFrame.dispose();
			
		}
	}
}
