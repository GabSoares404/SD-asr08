import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("SimpleAdapter", "default -p 5678");
            com.zeroc.Ice.Object object = new PrinterI();
            adapter.add(object, Util.stringToIdentity("SimplePrinter"));
            adapter.activate();
            System.out.println("Servidor Java aguardando conexões...");
            communicator.waitForShutdown();
        }
    }
}
