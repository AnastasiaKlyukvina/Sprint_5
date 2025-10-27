import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTests {

    @Test
    void getKittensWithoutParametersShouldReturn1() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getFamilyShouldReturnFamilyName() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithParameter3ShouldReturn3(){
        Feline feline = new Feline();
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
}
