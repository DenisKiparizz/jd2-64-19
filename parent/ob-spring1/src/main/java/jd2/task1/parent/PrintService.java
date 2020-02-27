package jd2.task1.parent;

public class PrintService {
    private Printer printer;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }
    public void printMassage(String massage){
        System.out.println(massage);
        printer.print();
    }
}
