import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Mock
    Feline feline;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    void getFoodShouldCallPredatorEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    void getFoodWhenPredatorReturnsFoodShouldReturnSameFood() throws Exception {
        List<String> expectedFood = List.of("Мясо", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(feline);
        List<String> food = cat.getFood();
        assertEquals(expectedFood, food);
    }
}
