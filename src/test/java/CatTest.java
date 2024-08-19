import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline feline;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Кошка должна делать Мяу", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline1 = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline1);
        cat.getFood();
        Mockito.verify(feline1, Mockito.times(1)).eatMeat();
    }


    @Test
    public void testConstructor() {
        Cat cat = new Cat(feline);
        assertNotNull("Конструктор сломався", cat);
    }
}

