import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    private String sex;
    private boolean hasMane;


    public LionParametrizedTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestOrderData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Не понятно", false},
        };
    }

    @Test
    public void testConstructor() {
        try {
            Lion lion = new Lion(sex, feline);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }
}
