/**
This class represents a plane.
@author Keri Fulton 3616473
*/
public class Plane{
	
	/** Creating a list of Passenger objects using an array*/
	private Passenger[] passSheet;
	
	/** Instance variable for the total weight of all passengers*/
	private double totalWeight = 0;
	
	/** Instance variable for the total number of rows on the plane*/
	private int seatRows;
	/** Instance variable for the total number of columns on the plane*/
	private int seatCols;
	
	/** Instance variable for the maximum weight on the plane */
	private double maxWeight;
	
	/** Instance variable for the maximum seating*/
	private int maxSeating;
	
	/**companion variable for the Passenger array*/
	private int passengerCount;

	
	/** 
	This constructor represents a plane object. It includes the number of rows and columns for seating and
	the maximum weight the plane can hold.
	@param seatRows the number of seat rows
	@param seatCols the number of seat columns
	@param maxWeight the maximum weight of the plane.
	*/
	public Plane(int seatRows, int seatCols, double maxWeight){
		this.seatRows = seatRows;
		this.seatCols = seatCols;
		this.maxWeight = maxWeight;
		this.maxSeating = seatRows * seatCols;
		passSheet = new Passenger[maxSeating];
		this.passengerCount = 0;
	}
	/**
	This method retrieves the plane's maximum weight.
	@return The maximum weight of the plane.
	*/
	public double getMaxWeight(){
		return maxWeight;
	}
	
	/**
	This method adds a passenger to the plane.
	@return true or false value on whether or not the passenger has been added.
	@param passenger; Passing through a passenger object to add them to the plane.
	*/
	public boolean addPassenger(Passenger passenger){
		boolean success = false;
		double passTotalWeight = passenger.getPassengerWeight() + passenger.getLuggageWeight();
		//if plane is not full
		if(this.passengerCount == this.maxSeating){
			
			return success;
		}
		for(int i = 0; i< passengerCount; i++){
			if(passenger.getID() == passSheet[i].getID()){
				
				return success;
			}
			//if the passenger row and column seats match return false
			else if(passenger.getRowSeat() == passSheet[i].getRowSeat() && passenger.getColSeat() == passSheet[i].getColSeat()){				
				
				return success;
			}
			else if(passenger.getRowSeat() > seatRows || passenger.getColSeat() > seatCols){
				return success;
			}
			//if ID is invalid
			else if(passenger.getID() < 500){
				
				return success;
			}
			//if the added weight to the total weight exceeds the max weight return false 
			else if((passTotalWeight + totalWeight) >= maxWeight){
				
				return success;
			}
		}
		passSheet[passengerCount] = passenger;
		passengerCount++;	
		//update total weight of all passengers * DO HERE
		totalWeight += passenger.getPassengerWeight() + passenger.getLuggageWeight();
		success = true;
		return success;
	}
	
	/**
	This method removes a passenger from the plane.
	@return true or false value on whether or not the passenger has been removed.
	@param passenger; Passing in a passenger object to remove them off the plane.
	*/
	public boolean removePassenger(Passenger passenger){
		boolean success = false;
		
		for(int i= 0; i < passengerCount; i++){
		
			if(passenger.getID() == passSheet[i].getID() ){
		
				//item in that position gets replaced by item in last position
				passSheet[i]= passSheet[passengerCount-1];
				passSheet[passengerCount-1] = null;
				passengerCount--;
				success = true;
				totalWeight-= (passenger.getPassengerWeight() + passenger.getLuggageWeight());
				
			}

		}
		return success;
		
	}
	
	/** 
	This method changes the passenger's luggage weight.
	@return true or false value on whether or not the passenger's luggage weight has been 
	changed
	@param passenger; Passing in a passenger object to change their luggage weight
	@param newWeight the new weight of the passenger's luggage
	*/
	public boolean changeLuggageWeight(Passenger passenger, double newWeight){
		Boolean success = false;
		//for loop to go through the ids
		if(newWeight >= 0){
		for(int i =0; i< passengerCount; i++){
			//check for ID if valid 
			if(passenger.getID() == passSheet[i].getID()){
				if(((totalWeight - passenger.getLuggageWeight()) + newWeight) <= maxWeight){
					totalWeight -= passSheet[i].getLuggageWeight();
					passSheet[i].setLuggageWeight(newWeight);	
					totalWeight += newWeight;
					success = true;
				}
			
				
			}
		}
		}
		return success;
	}	
	/** 
	This method gets the available weight left on the plane.
	@return the available weight on the plane.
	*/
	public double getAvailableWeight(){
	
		double availableWeight = maxWeight - totalWeight;
		return availableWeight;
	}
	/**
	Creates a formated print out of the passenger list.
	@return Formatted print out of the passenger list.
	*/
	public String toString(){
		String result = "";
		for(int i=0; i< passengerCount; i++){
			double total = passSheet[i].getPassengerWeight() + passSheet[i].getLuggageWeight();
			result+= passSheet[i].getID() + "\t" + 
				passSheet[i].getName() + "\t" + 
				total + " kg\t\t" + 
				passSheet[i].getRowSeat() + " - " + 
				passSheet[i].getColSeat() + "\n";
		}
		result += "\nTotal Weight: \t" + totalWeight + " kg";
		return result;
			
	}
	/**
	This method prints out a representation of plane seats on a plane using
	a 2D array. 
	If the seat is occupied, it will be represented with a 1.
	If the seat is vacant, it will be represented with a 0.
	*/
	public void printPlaneSeats(){
	  int [][] planeSeats = new int[seatRows][seatCols];
      //PRINTING OUT TITLE AND COLUMNS ACROSS
      System.out.println("Plane Seats Chart: \n\t");
      System.out.print("\t");
      for(int i= 0; i < seatCols; i++){
      	System.out.print("Col" + (i+1) + "\t");
      }
      //ADDING VALUES FOR SEATS INTO 2D 
      for(int i =0; i< passengerCount; i++){
      	
      	planeSeats[passSheet[i].getRowSeat()-1][passSheet[i].getColSeat()-1] = 1;
      }
      System.out.println();
		//PRINTING OUT BUILT ARRAY AND ROWS
		for(int i= 0; i< seatRows; i++){
			System.out.print("Row" + (i+1));
			System.out.print("\t");
			for(int j = 0; j< seatCols; j ++){
				
				System.out.print(planeSeats[i][j] + "  \t");
			}
		System.out.println();
		}
	}
    	
}

