package airline;

import java.util.Date;

public class Flight {
	
	private int flightNumber;
	private Date date;
	private String aircraftType;
	private String source;
	private String destination;
	private Date departure;
	private Date arrival;
	
	
	public Flight (int flightNumber, Date date, String aircraftType, String source, String destination, Date departure, Date arrival){
		this.flightNumber = flightNumber;
		this.date = date;
		this.aircraftType = aircraftType;
		this.source = source;
		this.destination = destination;
		this.departure = departure;
		this.arrival = arrival;
	}


	public int getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getAircraftType() {
		return aircraftType;
	}


	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Date getDeparture() {
		return departure;
	}


	public void setDeparture(Date departure) {
		this.departure = departure;
	}


	public Date getArrival() {
		return arrival;
	}


	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	
	
	
	
	
}
