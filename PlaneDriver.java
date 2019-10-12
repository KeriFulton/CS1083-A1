/**
This class is a driver program to test methods from the Plane class
@author Keri Fulton 3616473
*/
public class PlaneDriver{
	public static void main(String[]args){
	
	/** CREATION OF PLANE OBJECT*/
	Plane fcsPlane = new Plane(6, 5, 550.0);
	
	/** CREATION OF PASSENGER OBJECTS*/
	Passenger bob = new Passenger("Bob", 70.5, 25.0, 6, 1);
	Passenger mary = new Passenger("Mary", 45.0, 12.0, 4, 4);
	Passenger spencer = new Passenger("Spencer", 35.0, 11.0, 1, 3);
	Passenger sean = new Passenger("Sean", 55.0, 20.0, 2, 2);
	Passenger leah = new Passenger("Leah", 35.0, 23.0, 2, 5);
	Passenger mark = new Passenger("Mark", 55.0, 20.0, 7, 10);
	Passenger lisa = new Passenger("Lisa", 30.0, 11.0, 3, 3);
	Passenger josh = new Passenger("Josh", 111.1, 33.0, 2, 2);
	Passenger julia = new Passenger("Julia", 212.0, 15.0, 1, 1);
	
	/** ADDING PASSENGERS ONTO THE PLANE*/
	fcsPlane.addPassenger(bob);
	fcsPlane.addPassenger(mary);
	fcsPlane.addPassenger(spencer);
	fcsPlane.addPassenger(sean);
	fcsPlane.addPassenger(leah);
	
	/** PRINTING OUT PLANE LIST AND PLANE SEATS FOR THE FIRST TIME*/
	System.out.println("Passengers added to the plane's list: -");
	
	System.out.println(fcsPlane.toString());
	
	fcsPlane.printPlaneSeats();
	
	/** TRY ADDING A PASSENGER WHO IS ALREADY ON PLANE */
	System.out.println("\nTry adding Bob again: ");
	
	
	if(fcsPlane.addPassenger(bob) == false){
		System.out.println(bob.getName() + " cannot be added twice!");
	}
	
	System.out.println(fcsPlane.toString());
	
	fcsPlane.printPlaneSeats();
	
	/** TRY ADDING A PASSENGER WITH INVALID SEAT NUMBER */
	System.out.println("\nTry adding a passenger with invalid seat number: ");
	
	if(fcsPlane.addPassenger(mark) == false){
		System.out.println("Passenger " + mark.getName() + " with invalid seat number was \nNOT added to the passenger list!");
	}
	else{
		System.out.println("Passenger " + mark.getName() + " was added successfully.");
	}	
	
	System.out.println(fcsPlane.toString());
	
	fcsPlane.printPlaneSeats();
	
	/** TRY ADDING A PASSENGER WITH SEAT NUMBER THAT IS ALREADY 
	TAKEN BY ANOTHER PASSENGER */
	System.out.println("\nTry adding a passenger with a seat number that is \nalready taken by another passenger: ");
	
	if(fcsPlane.addPassenger(josh) == false){
		System.out.println("\nPassenger " + josh.getName() + " with a seat number that is already taken by \nanother passenger was NOT added to the passenger list!");
	}
	else{
		System.out.println("Passenger " + josh.getName() + " was added successfully.");
	}
	/** TRY ADDING A PASSENGER THAT PUTS PLANE OVER WEIGHT LIMIT */
	System.out.println("\nTry adding a passenger that would put the plane over its weight limit: ");
	
	if(fcsPlane.addPassenger(julia) == false){
		System.out.println(julia.getName() + " NOT added to passenger list");
	}
	else{
		System.out.println(julia.getName() + " was added successfully.");
	}
		
	/** CHANGE WEIGHT OF PASSENGERS LUGGAGE (SUCCESSFUL)*/
	System.out.println("\nChange weight of " + mary.getName() + "'s luggage weight to 24: ");
	
	if(fcsPlane.changeLuggageWeight(mary, 24.0) == true){
		System.out.println(mary.getName() + "'s luggage weight changed");
	}
	else{
		System.out.println(mary.getName() + "'s luggage weight NOT changed");
	}
	/** CHANGE WEIGHT OF PASSENGERS LUGGAGE (NEGATIVE NOT SUCCESSFUL)*/
	System.out.println("\nChange weight of " + sean.getName() + "'s luggage weight to -250 (should result in failure) : ");
	if(fcsPlane.changeLuggageWeight(sean, -250.0) == true){
			System.out.println(sean.getName() + "'s luggage weight changed");
	}
	else{
		System.out.println(sean.getName() + "'s luggage weight NOT changed");
	}
	/** CHANGE WEIGHT OF PASSENGERS LUGGAGE (OVER LIMIT  NOT SUCCESSFUL)*/
	System.out.println("\nChange weight of " + spencer.getName() + "'s luggage weight to 280 (should result in failure) : ");
	if(fcsPlane.changeLuggageWeight(spencer, 280) == true){
			System.out.println(spencer.getName() + "'s luggage weight changed");
	}
	else{
		System.out.println(spencer.getName() + "'s luggage weight NOT changed");
	}
		
	/** CHANGE WEIGHT OF PASSENGERS LUGGAGE (NOT ON PLANE)*/
		System.out.println("\nChange weight of " + josh.getName() + "'s luggage weight to 30 (NOT on the plane!) : ");
	if(fcsPlane.changeLuggageWeight(josh, 30.0) == true){
			System.out.println(josh.getName() + "'s luggage weight changed");
	}
	else{
		System.out.println(josh.getName() + "'s luggage weight NOT changed");
	}
	
	System.out.println(fcsPlane.toString());
	
	/** REMOVING PASSENGER FROM PLANE LIST (SUCESSFUL)*/
	System.out.println("\nRemove " + spencer.getName() + " from passenger list : ");
	if(fcsPlane.removePassenger(spencer) == true){
		System.out.println("Successfully removed " + spencer.getName());
	}
	else{
		System.out.println("Did NOT remove " + spencer.getName() + " from passenger list.");
	}
	
	System.out.println(fcsPlane.toString());
	
	double availableWeight = fcsPlane.getAvailableWeight();
	
	/** PRINTING OUT MAXIMUM WEIGHT AND AVAILABLE WEIGHT ON PLANE*/
	System.out.println("\n\nPlane's Maximum Weight limit: " + fcsPlane.getMaxWeight() + " kg \t\t" + availableWeight + " kg left");
	
	fcsPlane.printPlaneSeats();
	
	
	
	}
	
	
	
	
}
