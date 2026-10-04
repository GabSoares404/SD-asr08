import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Util;
import Demo.PrinterPrx;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {
            // Mude o IP para o endereço do servidor se não estiver rodando localmente
            com.zeroc.Ice.ObjectPrx base = communicator.stringToProxy("SimplePrinter:tcp -h 127.0.0.1 -p 5678");
            PrinterPrx printer = PrinterPrx.checkedCast(base);
            
            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            String res = printer.printString("Hello World!");
            System.out.println("Resultado de printString: " + res);

            int resAdd = printer.add(10, 5);
            System.out.println("Resultado de add(10, 5): " + resAdd);

            String resUpper = printer.toUppercase("hello ice java");
            System.out.println("Resultado de toUppercase('hello ice java'): " + resUpper);
        }
    }
}
