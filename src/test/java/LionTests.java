import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTests {

    @Mock
    Feline feline;

    @Test
    void doesHaveManeWhenLionIsMaleShouldReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean hasMane = lion.doesHaveMane();
        assertTrue(hasMane);
    }

    @Test
    void doesHaveManeWhenLionIsFemaleShouldReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        assertFalse(hasMane);
    }

    @Test
    void getKittensShouldCallFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    void getKittensWhenFelineReturns5ShouldReturn5() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самка", feline);
        int kittens = lion.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    void getFoodShouldCallFelineGetFoodWithPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    void getFoodWhenFelineReturnsFoodShouldReturnSameFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
    }

    @Test
    void lionConstructorWithNullSexShouldThrowException() {
        Exception exception = assertThrows(Exception.class,
        () -> new Lion(null, feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
        exception.getMessage());
    }

}

