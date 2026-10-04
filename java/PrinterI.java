import Demo.Printer;
import com.zeroc.Ice.Current;

public class PrinterI implements Printer {
    @Override
    public String printString(String s, Current current) {
        System.out.println(s);
        return s + "*";
    }

    @Override
    public int add(int a, int b, Current current) {
        return a + b;
    }

    @Override
    public String toUppercase(String s, Current current) {
        return s.toUpperCase();
    }
}
