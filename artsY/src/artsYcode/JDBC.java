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
	static final String PASSWORD = "password"; //"HTuk2018" - samt uppdatera mySQL-connectorn
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
	
	public boolean addUser(ArtsYuser user, Address address) {
		boolean userAdded = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();

			if (!checkForExistingPostcode(address, connection, statement))	{
				String postcodeQuery = "INSERT INTO postcode (postcode, street, city, county) VALUES ('" + 
									address.getPostcode() + "', '" + address.getStreet() + "', '" + address.getCity()  
									+  "', '" + address.getCounty() + "')";					
						
				statement.executeUpdate(postcodeQuery);
			}
			
			if (!checkForExistingAddress(address, connection, statement)) {
				String addressQuery = "INSERT INTO address (houseNo, postcode) VALUES (" + address.getHouseNumber() 
									+ ", '" + address.getPostcode() + "');";		
			
				statement.executeUpdate(addressQuery);
			}
			
			if (!checkForExistingUser(user, connection, statement)) {
				String userQuery = "INSERT INTO artsyuser (email, password, name, defaultHouseNo, defaultPostcode) VALUES ('" + 
								user.getEmail() + "', '" + user.getEmail() + "', '" + user.getUsername() + "', " + address.getHouseNumber() 
								+ ", '" + address.getPostcode() + "');";
			
				if (statement.executeUpdate(userQuery) > 0)
					userAdded = true;
			}
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
			
			if (checkForExistingItem(item, connection, statement)) {
				String itemQuery = "INSERT INTO item (itemID, seller, title, description, price) VALUES ('" + 
						item.getItemID() + "', '" + item.getSeller() + "', '" + item.getTitle() + "', '" 
						+ item.getDescription() +  "', '" + item.getPrice() + "')";					

				if (statement.executeUpdate(itemQuery) > 0)
					itemAdded = true;
			}
			
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
	
	public boolean addFavourite (Item item, ArtsYuser user) {
		boolean favouriteAdded = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();
			
			System.out.println("här");
			
			if (checkForExistingItem(item, connection, statement) && checkForExistingUser(user, connection, statement)) {
				String addFavouriteQuery = "INSERT INTO favourite (userID, itemID) VALUES ('" + 
						user.getEmail() + "', '" + item.getItemID() + "')";					
	
				if (statement.executeUpdate(addFavouriteQuery) > 0) {
					favouriteAdded = true;
					System.out.println("här också");
				}
			}
			
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
		
		return favouriteAdded;
	}	
	
	public boolean removeFavourite(Item item, ArtsYuser user) {
		boolean favouriteRemoved = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();
			
			if (checkForExistingItem(item, connection, statement) && checkForExistingUser(user, connection, statement)) {
				String removeFavouriteQuery = "DELETE FROM favourites WHERE userID = '" +
						user.getEmail() + "' AND itemID = '" + item.getItemID() + "'"; 				
				if (statement.executeUpdate(removeFavouriteQuery) > 0)
					favouriteRemoved = true;
			}
			
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
		
		return favouriteRemoved;
	}
	
	public boolean checkForExistingPostcode(Address address, Connection connection, Statement statement) {
		boolean postcodeExists = true;
		
		String checkForPostcode = "SELECT * FROM postcode WHERE postcode = '" + address.getPostcode() + "'";
		try {
			ResultSet rs = statement.executeQuery(checkForPostcode);		
			while (!rs.next()) {
				postcodeExists = false;
			}
			rs.close();	
		} 
		catch (SQLException e) {
			System.out.println("Error trying to check for postcode");
			e.printStackTrace();
		}
		
		return postcodeExists;		
	}
	
	public boolean checkForExistingAddress(Address address, Connection connection, Statement statement) {
		boolean addressExists = true;
		
		String checkForAddress = "SELECT * FROM address WHERE houseNo = '" + address.getHouseNumber() + "' AND postcode = '" + address.getPostcode() + "'";
		try {		
			ResultSet rs = statement.executeQuery(checkForAddress);		
			while (!rs.next()) {
				addressExists = false;
			}
			rs.close();	
		} 
		catch (SQLException e) {
			System.out.println("Error trying to check for address");
			e.printStackTrace();
		}
		
		return addressExists;	
	}
	
	public boolean checkForExistingUser(ArtsYuser user, Connection connection, Statement statement) { 
		boolean userExists = true;
		
		String checkForUser = "SELECT * FROM artsYuser WHERE email = '" + user.getEmail() + "'";
		try {		
			ResultSet rs = statement.executeQuery(checkForUser);		
			while (!rs.next()) {
				userExists = false; 
				break;
			}
			rs.close();	
		} 
		catch (SQLException e) {
			System.out.println("Error trying to check for user");
			e.printStackTrace();
		}
		
		return userExists;		
	}
	
	public boolean checkForExistingItem(Item item, Connection connection, Statement statement) { 
		boolean itemExists = true;
		
		String checkForItem = "SELECT * FROM item WHERE itemID = '" + item.getItemID() + "'";
		try {		
			ResultSet rs = statement.executeQuery(checkForItem);		
			while (!rs.next()) {
				itemExists = false;
				break;
			}
			rs.close();	
		} 
		catch (SQLException e) {
			System.out.println("Error trying to check for item");
			e.printStackTrace();
		}
		
		return itemExists;		
	}
	
	
	
}
