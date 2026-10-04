import sys, Ice
import Demo
 
communicator = Ice.initialize(sys.argv)

base = communicator.stringToProxy("SimplePrinter:tcp -h 34.203.80.210 -p 5678")
printer = Demo.PrinterPrx.checkedCast(base)
if not printer:
    raise RuntimeError("Invalid proxy")

res = printer.printString("Hello World!")
print(f"Resultado de printString: {res}")

res_add = printer.add(10, 5)
print(f"Resultado de add(10, 5): {res_add}")

res_upper = printer.toUppercase("hello ice python")
print(f"Resultado de toUppercase('hello ice python'): {res_upper}")
