package by.it.academy;

public class WelcomeTable {
    public static void main(String[] args) {
        System.out.println("Hello Everyone");
        System.out.println("My name is Denis");
        Calculation ob = new Calculation();
        CalculationPlus ob2 = new CalculationPlus();
        System.out.println("Calculation plus "+ob2.pluss(22,3));
        System.out.println(ob.calc(22,2));
    }
}
