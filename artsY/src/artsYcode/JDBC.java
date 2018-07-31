package artsYcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/db_artsy"; 
	static final String USER = "root";
	static final String PASSWORD = "HTuk2018"; //"password" - samt uppdatera mySQL-connectorn
	Connection connection = null;
	Statement statement = null;
	
	public Connection getConnection() {
        Connection connection = null;
 
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");//.newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error when connecting: " + e);
        }
        return connection;
    }
		
	public boolean logIn(String email, String password) {
		boolean loggedIn = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();		
			String getUser = "SELECT email, password FROM artsyuser WHERE email = '" + email + "' AND password = '" + password + "'";
			ResultSet rs = statement.executeQuery(getUser);
			while (rs.next()) {
				loggedIn = true;
			}
			/*
			while (rs == null) {
				//Felmeddelande
				System.out.println("Error message");
			}
			*/
			rs.close();								
		} 
		catch (SQLException e) {
			//io?
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null)
					statement.close();
			}
			catch(SQLException e) {	}
			
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) { }
		}
		
		return loggedIn;
	}
	
	public boolean addUser(ArtsYuser user) {
		boolean userAdded = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();

			String postcodeQuery = "INSERT INTO postcode (postcode, street, city, county) VALUES ('" + 
									user.getPostcode() + "', '" + user.getStreet() + "', '" + user.getCity()  +  "', '" + user.getCounty() + "')";					
			statement.executeUpdate(postcodeQuery);
			//CHECK FOR DUBBLETTER!!!!!!! (eller ska samtliga addresser läggas in innan? Nej. Orimligt. Låt dbn växa med purchases.)
					
			String addressQuery = "INSERT INTO address (houseNo, postcode) VALUES (" + user.getHouseNumber() + ", '" + user.getPostcode() + "');";		
			statement.executeUpdate(addressQuery);
			//CHECK FOR DUBBLETTER!!!!!!!

			
			String userQuery = "INSERT INTO artsyuser (email, password, name, defaultHouseNo, defaultPostcode) VALUES ('" + 
							user.getEmail() + "', '" + user.getEmail() + "', '" + user.getUsername() + "', " + user.getHouseNumber() + ", '" + user.getPostcode() + "');";
			//CHECK FOR DUBBLETTER!!!!!!!
			
			if (statement.executeUpdate(userQuery) > 0)
				userAdded = true;
		} 
		catch (SQLException e) {
			//io?
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null)
					statement.close();
			}
			catch(SQLException e) {	}
			
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) { }
		}
		
		return userAdded;
	}
	
	public boolean addItem (Item item) {
		boolean itemAdded = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();
			
			String itemQuery = "INSERT INTO item (itemID, seller, title, description, price) VALUES ('" + 
									item.getItemID() + "', '" + item.getSeller() + "', '" + item.getTitle() + "', '" 
									+ item.getDescription() +  "', '" + item.getPrice() + "')";					
			//CHECK FOR DUBBLETTER!!!!!!! (eller? IDt är ju det enda unika)
			
			if (statement.executeUpdate(itemQuery) > 0)
				itemAdded = true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (statement != null)
					statement.close();
			}
			catch(SQLException e) {	}
			
			try {
				if(connection != null)
					connection.close();
			}
			catch(SQLException e) { }
		}
		
		return itemAdded;
	}
	
	
}
