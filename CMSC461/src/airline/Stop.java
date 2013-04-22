package airline;

import java.util.Date;

public class Stop {
	
	private int id;
	private int flightNum;
	private int stopNum;
	private String city;
	private Date arrival;
	private Date depature;
	
	public Stop ( int flightNum, String city, Date arrival, Date depature){
		this.flightNum = flightNum;
		this.city = city;
		this.arrival = arrival;
		this.depature = depature;
	}
	
	public Stop ( int flightNum, int stopNum, String city, Date arrival, Date depature){
		this.flightNum = flightNum;
		this.stopNum = stopNum;
		this.city = city;
		this.arrival = arrival;
		this.depature = depature;
	}
	
	public Stop ( int id, int flightNum, int stopNum, String city, Date arrival, Date depature){
		this.id = id;
		this.flightNum = flightNum;
		this.stopNum = stopNum;
		this.city = city;
		this.arrival = arrival;
		this.depature = depature;
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

	public Date getDepature() {
		return depature;
	}

	public void setDepature(Date depature) {
		this.depature = depature;
	}
}
