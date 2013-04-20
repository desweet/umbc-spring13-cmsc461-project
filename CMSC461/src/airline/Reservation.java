package airline;

public class Reservation {
	private int id;
	private int flightNum;
	private double SSN;
	private String status;
	private String seatType;
	private double amountCharged;
	private int numBags = 0;
	
	
	public Reservation(int id, int flightNum, double SSN, String status, String seatType, double amountCharged, int numBags) {
		this.id = id;
		this.flightNum = flightNum;
		this.SSN = SSN;
		this.status = status;
		this.seatType = seatType;
		this.amountCharged = amountCharged;
		this.numBags = numBags;
	}
	
	public Reservation(int flightNum, double SSN, String seatType, double amountCharged, int numBags) {
		this.flightNum = flightNum;
		this.SSN = SSN;
		this.seatType = seatType;
		this.amountCharged = amountCharged;
		this.numBags = numBags;
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


	public double getSSN() {
		return SSN;
	}


	public void setSSN(double sSN) {
		SSN = sSN;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSeatType() {
		return seatType;
	}


	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}


	public double getAmountCharged() {
		return amountCharged;
	}


	public void setAmountCharge(double amountCharged) {
		this.amountCharged = amountCharged;
	}


	public int getNumBags() {
		return numBags;
	}


	public void setNumBags(int numBags) {
		this.numBags = numBags;
	}
	
	
	
}
