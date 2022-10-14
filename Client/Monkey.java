//Package imports
package Client;
import Vet.*;
//Java imports
import java.rmi.RemoteException;

public class Monkey extends Species {

    private String name;

    public Monkey() throws RemoteException {
        super("Monkey");
    }
}