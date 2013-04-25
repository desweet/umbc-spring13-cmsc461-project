package airline;

import java.util.Date;

public class Stop {
	
	private int id;
	private int flightNum;
	private int stopNum;
	private String city;
	private Date arrival;
	private Date departure;
	
	public Stop ( int flightNum, String city, Date arrival, Date departure){
		this.flightNum = flightNum;
		this.city = city;
		this.arrival = arrival;
		this.departure = departure;
	}
	
	public Stop ( int flightNum, int stopNum, String city, Date arrival, Date departure){
		this.flightNum = flightNum;
		this.stopNum = stopNum;
		this.city = city;
		this.arrival = arrival;
		this.departure = departure;
	}
	
	public Stop ( int id, int flightNum, int stopNum, String city, Date arrival, Date departure){
		this.id = id;
		this.flightNum = flightNum;
		this.stopNum = stopNum;
		this.city = city;
		this.arrival = arrival;
		this.departure = departure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightNum() {
		return flightNum;
	}

	public void setFlightNum(int flightNum) {
		this.flightNum = flightNum;
	}

	public int getStopNum() {
		return stopNum;
	}

	public void setStopNum(int stopNum) {
		this.stopNum = stopNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}
}
