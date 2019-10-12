/**
This class represents a passenger.
@author Keri Fulton 3616473
*/
public class Passenger{
	
	/** The name of the passenger */
	private String passengerName;
	/** The starting value for passenger numbers */
	private static int passengerID = 500;
	/** The personal number for each passenger */
	private int personalID;
	/** The weight of the passenger */
	private double passWeight;
	/** The weight of the passengers luggage*/
	private double luggWeight;
	
	/** Instance variable for the row seat*/
	private int rowSeat;
	/** Instance variable for the column seat */
	private int colSeat;
	
	
	/**
	This constructor creates a passenger object. It includes their name, 
	passenger weight, luggage weight, row number and seat number.
	@param name The passenger's name.
	@param passWeightIn The passenger's weight.
	@param luggWeightIn The passenger's luggage weight.
	@param rowSeatIn The passenger's row seat on the plane.
	@param colSeatIn The passenger's column seat on the plane.
	*/
	public Passenger(String passNameIn, double passWeightIn, double luggWeightIn, int rowSeatIn, int colSeatIn){
		passengerName = passNameIn;
		passWeight = passWeightIn;
		luggWeight = luggWeightIn;
		rowSeat = rowSeatIn;
		colSeat = colSeatIn;
		personalID = passengerID;
		passengerID++;
		
	}
	/**
	This method gets the full name of the passenger.
	@return their full name.
	*/
	public String getName(){
		return passengerName;
	}
	/** 
	This method retrieves the passengers unique ID. 
	@return the personal ID.
	*/
	public int getID(){
		return personalID;
	}
	/** 
	This method retrieves the weight of the passenger.
	@return the weight of the passenger.
	*/
	public double getPassengerWeight(){
		return passWeight;
	}
	/** 
	This method retrieves the weight of the passenger's 
	luggage weight.
	@return the weight of the passenger's luggage.
	*/
	public double getLuggageWeight(){
		return luggWeight;
	}
	/** 
	This method retrieves the row number of the passenger's seat
	@return the row number of the passenger's seat.
	*/
	public int getRowSeat(){
		return rowSeat;
	}
	/** 
	This method retrieves the column number of the passenger's seat
	@return the column number of the passenger's seat.
	*/
	public int getColSeat(){
		return colSeat;
	}
	/**
	This method can change the passenger's luggage weight.
	@param newWeightIn the new weight of the passenger's luggage. 
	*/
	public void setLuggageWeight(double newWeightIn){
		luggWeight = newWeightIn;
	}
	
	
	
	
	
}