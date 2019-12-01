package by.it.academy;

public class Calculation {
    public Calculation(){
        System.out.println("Hello from calculation module");
    }
    int a;
    int b;
    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return a;
    }
    public void setB(int b){
        this.b = b;
    }
    public int getB(){
        return b;
    }
    public double calc(int a,int b){
        this.a=a;
        this.b = b;
        double x = (double)a/b;
        return x;
    }
}
