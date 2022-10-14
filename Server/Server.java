//Package imports
package Server;
//Java imports
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	public Server() {};
	
	public static void main(String args[]) {
		try {
	        System.setProperty("java.security.policy", "./security.policy");
			SecurityManager securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
			System.setProperty("java.rmi.server.codebase", "file:./Client/obj/");
			
			Registry registry = LocateRegistry.createRegistry(1099);
			Clinic myClinic = new Clinic();
			
			if (registry == null) {
				System.err.println("[SERVER] Error - RmiRegistry not found");
			}
			else {
				registry.bind("myClinic", myClinic);
				System.err.println("[SERVER] Server running...");
			}
		}
		catch (Exception e) {
			System.err.println("[SERVER] Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
