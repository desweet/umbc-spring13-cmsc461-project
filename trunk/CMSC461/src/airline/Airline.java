package airline;

import java.sql.*;
import java.util.Date;

public class Airline {
	private Connection CONN = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultset = null;
	
	public Airline ( ){
		try {
		// load JDBC driver for MySQL, will have to change to run on Oracle
		Class.forName("com.mysql.jdbc.Driver");
		
		// establish connection to database to be used for every method
		CONN = DriverManager.getConnection("jdbc:mysql://localhost/airline?" + "user=root&password=password");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Boolean addFlight(){
		System.out.println("Adding a flight!");
		try {
			PreparedStatement insertStatement = CONN.prepareStatement("INSERT into AIRLINE.FLIGHTS values (default, ?, ?, ?, ?, ?, ?");
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	//get list of all flights
	public void getFlights() {
		
		
	}
	
	
	public void close(){
		try {
			if (CONN != null){
				CONN.close();
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
