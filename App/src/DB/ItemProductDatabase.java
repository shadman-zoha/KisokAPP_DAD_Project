package DB;

import java.sql.*;

import kioskapp.product.Product;

public class ItemProductDatabase {

	public int insertItemProduct(Product itemProduct) throws SQLException {
		
		DatabaseConnection databaseConnection = new DatabaseConnection();
		
		PreparedStatement ps = databaseConnection.prepareStatement("INSERT INTO itemproduct (name, price) VALUES ( ?, ?)");
		
		ps.setString	(1, itemProduct.getName());
		ps.setDouble	(2, itemProduct.getPrice());
		
		int status = ps.executeUpdate();
		
		return status;
		
	}
	
	public Product getItemProduct(int id) throws SQLException {
		
		Product itemProduct = null;
		DatabaseConnection databaseConnection = new DatabaseConnection();
		PreparedStatement ps = databaseConnection.prepareStatement("SELECT * FROM itemproduct WHERE Product = ?");
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			itemProduct = new Product();
			
			itemProduct.setItemProduct(id);
			itemProduct.setName(rs.getString(2));
			itemProduct.setPrice(rs.getFloat(3));
			
		}
		
		rs.close();
		ps.close();
		return itemProduct;
	
		
	}
}
