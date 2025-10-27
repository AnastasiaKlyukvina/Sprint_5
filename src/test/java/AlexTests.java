import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AlexTests {

    @Mock
    Feline feline;

    @Test
    void alexConstructorShouldCreateMaleLion() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void getFriendsReturnFriendsName() throws Exception {
        Alex alex = new Alex(feline);
        List<String> friends = alex.getFriends();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, friends);
    }

    @Test
    void getPlaceOfLivingShouldReturnNewYorkZoo() throws Exception {
        Alex alex = new Alex(feline);
        String place = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", place);
    }

    @Test
    void getKittensShouldReturnZero() throws Exception {
        Alex alex = new Alex(feline);
        int kittens = alex.getKittens();
        assertEquals(0, kittens);
    }
}
