//Package imports
package Client;
//Java imports
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws RemoteException {
        Client myClient = new Client();
        try {
        	myClient.start();
        }
        catch (Exception e) {
			System.err.println("[MAIN] Error - Failed to start client: " + e.toString());
			e.printStackTrace();
			return;
        }
		String input = "";
		while(!input.equals("0")){

			System.out.println("\n");
			System.out.println("\n[MAIN] Select an action");
			System.out.println("=======================");
			System.out.println("[0] Close client");
			System.out.println("[1] Add animal");
			System.out.println("[2] Find animal by name");
			System.out.println("[3] Browse current animals");
			System.out.println("[4] Add monkey (codebase test)");
			System.out.println("[5] Add 100 animals (alerts test)");
			System.out.println("=======================\n");

			Scanner scan = new Scanner(System.in);
			input = scan.next();

			if(input.equals("1")) {
				System.out.println("\n- New animal -");
				System.out.print("Name: ");
				String newName = scan.next();
				System.out.print("Owner name: ");
				String newOwnerName = scan.next();
				System.out.print("Species name: ");
				String newSpecies = scan.next();
				System.out.print("Breed name: ");
				String newBreed = scan.next();
                System.out.print("File status: ");
				String newStatus = scan.next();
				System.out.println("");
				myClient.addAnimal(newName, newOwnerName, newSpecies, newBreed, newStatus);
			}
			else if (input.equals("2")) {
				System.out.println("\n- Search for an animal -");
				System.out.print("Animal's name: ");
				String myName = scan.next();
				myClient.searchName(myName);
			}
			else if(input.equals("3")) {
				System.out.println("\n- All animals registered -");
				myClient.browse();
			}
            else if(input.equals("4")){
				myClient.addMonkey();
			}
			else if (input.equals("5")) {
				System.out.println("\n- Adding 100 animals -");
				for (int i = 0; i < 100; i++) {
					myClient.addAnimal(Integer.toString(i+1), Integer.toString(i+1), Integer.toString(i+1), Integer.toString(i+1), Integer.toString(i+1));
				}
			}
			else if (!input.equals("0")) {
				System.out.println("[MAIN] Error - Input not recognized");
			}
		}
		myClient.stop();
		System.out.println("[MAIN] Client closed.");
		System.exit(0);
	}
}
