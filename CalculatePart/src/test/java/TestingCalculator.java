import by.it.academy.Calculation;
import org.junit.Assert;
import org.junit.Test;

public class TestingCalculator {
    Calculation part = new Calculation();
    @Test
    public void testDivideZero(){
        part.calc(22,2);
        if(part.getA()<=0 || part.getB()<=0){
            Assert.fail();
        }
    }
}
