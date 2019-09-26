import java.util.List;
import java.util.Scanner;

import controller.VehicleHelper;
import model.Vehicle;

public class StartVehicleProgram {

	static Scanner in = new Scanner(System.in);
	static VehicleHelper veh = new VehicleHelper();

	// Main method with the menuRun() method
	public static void main(String[] args) {
		menuRun();
	}

	// This is the method that will act as our user interface
	// To add, edit, and remove vehicles, as well as view all vehicles
	// from the carshop database
	public static void menuRun() {
		boolean runAgain = true;
		System.out.println("------- Welcome to the Used Car Lot! -------");
		while (runAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a vehicle");
			System.out.println("*  2 -- Edit a vehicle");
			System.out.println("*  3 -- Remove a vehicle");
			System.out.println("*  4 -- View the lot");
			System.out.println("*  5 -- Exit Program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			// Send user's selection to appropriate method
			// contained within this class file
			if (selection == 1) {
				addVehicle();
			} else if (selection == 2) {
				editVehicle();
			} else if (selection == 3) {
				deleteVehicle();
			} else if (selection == 4) {
				viewInventory();
			} else {
				veh.cleanUp();
				System.out.println("|*****************************|");
				System.out.println("|   Please come again soon!   |");
				System.out.println("|*****************************|");
				runAgain = false;
			}

		}
	}

	// Selection 1 - This method allows user to add a new vehicle to the inventory table
	private static void addVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Make: ");
		String make = in.nextLine();
		System.out.println("Model: ");
		String model = in.nextLine();
		System.out.println("Year: ");
		int year = in.nextInt();
		System.out.println("Price: ");
		double price = in.nextDouble();
		
		// Create Vehicle object to pass into insertVehicle()
		Vehicle toAdd = new Vehicle(model, make, year, price);
		veh.insertVehicle(toAdd);
	}

	// Selection 2 - This method will allow user to find an existing vehicle in inventory table and edit any of the attributes (except for the ID)
	private static void editVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Let's locate the vehicle you would like to edit!");
		System.out.println("What is the model you are looking for? ");
		String model = in.nextLine();
		List<Vehicle> vehiclesFound;
		vehiclesFound = veh.findVehiclesByModel(model);

		if (!vehiclesFound.isEmpty()) {
			System.out.println("I think we found 'em!");
			for (Vehicle v : vehiclesFound) {
				System.out.println(v.getId() + " : " + v.toString());
			}
			
			// The "ID" requested below actually pertains to the ID retrieved from the inventory table
			System.out.println("\nWhich ID would you like to edit? ");
			int id = in.nextInt();

			Vehicle editedVehicle = veh.searchForVehicleById(id);
			System.out.println("Retrieved: " + editedVehicle.returnVechicleDetails());
			System.out.println("\nWhat would you like to update? ");
			System.out.println("1 : Make");
			System.out.println("2 : Model");
			System.out.println("3 : Year");
			System.out.println("4 : Price");
			int selection = in.nextInt();

			if (selection == 1) {
				System.out.println("New Make: ");
				String editMake = in.nextLine();
				editedVehicle.setMake(editMake);
			} else if (selection == 2) {
				System.out.println("New Model: ");
				String editModel = in.nextLine();
				editedVehicle.setModel(editModel);
			} else if (selection == 3) {
				System.out.println("New Year: ");
				int editYear = in.nextInt();
				editedVehicle.setYear(editYear);
			} else if (selection == 4) {
				System.out.println("New Price: ");
				double editPrice = in.nextDouble();
				editedVehicle.setPrice(editPrice);
			}

			veh.updateVehicle(editedVehicle);

		} else {
			System.out.println("\nSorry, Charlie! No vehicle here..\n");
		}
	}

	// Selection 3 - This method will prompt user to search for desired vehicle
	// in inventory table and delete it.
	private static void deleteVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Vehicle's make: ");
		String make = in.nextLine();
		System.out.println("Vehicle's model: ");
		String model = in.nextLine();
		System.out.println("Vehicle's year: ");
		int year = in.nextInt();
		System.out.println("Vehicle's price: ");
		double price = in.nextDouble();
		Vehicle toRemove = new Vehicle(make, model, year, price);
		veh.removeVehicle(toRemove);
	}

	// Selection 4 - Allows user to view the current inventory
	private static void viewInventory() {
		// TODO Auto-generated method stub
		List<Vehicle> allVehicles = veh.showInventory();
		for (Vehicle singleVehicle : allVehicles) {
			System.out.println(singleVehicle.returnVechicleDetails());
		}

	}

}
