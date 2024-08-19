import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
final private int parametr;
final private  int result;

    public FelineParametrizedTest(int parametr, int result) {
        this.parametr = parametr;
        this.result = result;
    }


    @Parameterized.Parameters
    public static Object[][] getTestOrderData() {
        return new Object[][]{
                {1,1},
                {14,14},
                {0,0},
        };
    }

    @Test
    public  void testGetKittensWihtParam(){
        Feline feline = new Feline();
    assertEquals(result,feline.getKittens(parametr));
    }
}
