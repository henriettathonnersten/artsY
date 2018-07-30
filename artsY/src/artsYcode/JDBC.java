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
	static final String PASSWORD = "password";
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
	
	public String logIn() {
		String returnStatement = "";

		try {
			/*connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();*/
			
		    //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//System.out.println("test!");
			
			//String insert = "INSERT into konstyuser VALUES ('hej@hejsan.se', 'hej', 'Hejsan_Hejsson', 7, 'M30 X77')";
			//statement.executeUpdate(insert);
			
			connection = getConnection();
			
			/*get name and password, hamta usern om den finns. Om ja, return true, annars return false
			 * Tank pa att detta inte kommer visas utat, sa det borde racka med en true/false return. 
			 * */ 
			
			
			String emailFromDb = "";
			String passwordFromDb = "";
			
			String select = "SELECT email, password FROM artsyuser";
			ResultSet rs = statement.executeQuery(select);
			while (rs.next()) {
				emailFromDb = rs.getString("email");
				passwordFromDb = rs.getString("password");
				returnStatement += emailFromDb + " " + passwordFromDb;
			}
			rs.close();			
			
			/*if (emailFromDb == inputEmail && passwordFromDb == inputPassword) 
				returnStatement =
			else
				returnStatement =*/
					
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
		
		return returnStatement;

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
	
	public ArtsYuser addUser(ArtsYuser user) {
		boolean userAdded = false;

		try {
			connection = getConnection();		
			statement = connection.createStatement();

			String postcodeQuery = "INSERT INTO postcode (postcode, street, city, county) VALUES ('" + 
									user.getPostcode() + "', '" + user.getStreet() + "', '" + user.getCity()  +  "', '" + user.getCounty() + "')";		
			//System.out.println(postcodeQuery);			
			statement.executeUpdate(postcodeQuery);
					
			String addressQuery = "INSERT INTO address (houseNo, postcode) VALUES (" + user.getHouseNumber() + ", '" + user.getPostcode() + "');";		
			//System.out.println(addressQuery);			
			statement.executeUpdate(addressQuery);
					
			String userQuery = "INSERT INTO artsyuser (email, password, name, defaultHouseNo, defaultPostcode) VALUES ('" + 
							user.getEmail() + "', '" + user.getEmail() + "', '" + user.getUsername() + "', " + user.getHouseNumber() + ", '" + user.getPostcode() + "');";
			//System.out.println(userQuery);			
			statement.executeUpdate(userQuery);			
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
	
	public String addUser(String username, String email, String password, String street, 
				String houseNumber, String apartment, String postcode, String city, String county) {
		
		try {
			
			connection = getConnection();
			
			/*connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			statement = connection.createStatement();*/
			String postcodeQuery = "INSERT INTO postcode (postcode, street, city, county) VALUES ('" + 
			postcode + "', '" + street + "', '" + city  +  "', '" + county + "')";		
			//System.out.println(postcodeQuery);			
			statement.executeUpdate(postcodeQuery);
			
			String addressQuery = "INSERT INTO address (houseNo, postcode) VALUES (" + houseNumber + ", '" + postcode + "');";		
			//System.out.println(addressQuery);			
			statement.executeUpdate(addressQuery);
			
			String userQuery = "INSERT INTO artsyuser (email, password, name, defaultHouseNo, defaultPostcode) VALUES ('" + 
					email + "', '" + password + "', '" + username + "', " + houseNumber + ", '" + postcode + "');";
			//System.out.println(userQuery);			
			statement.executeUpdate(userQuery);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return "hej";
	}
}
