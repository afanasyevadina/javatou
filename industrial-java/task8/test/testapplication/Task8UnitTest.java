package testapplication;

import org.junit.Test;
import static org.junit.Assert.*;

import static testapplication.Task8Unit.myExp;

public class Task8UnitTest {

    @Test
    public void test1MyExp() throws Exception {
        assertTrue("X > 5 не прошел", myExp(7, 4, 5, 2, 7) == 54);
        assertTrue("X = 5 не прошел", myExp(7, 4, 5, 2, 5) == 51.8);
        assertTrue("X < 5 не прошел", myExp(7, 4, 5, 2, 6) == 41);
        assertTrue("Все единицы не прошел", myExp(1, 1, 1, 1, 1) == 1);
    }

    @Test
    public void test2MyExp() throws Exception {
        try {
            assertTrue("Нет ошибки при делении на 0", myExp(5, 0, 0, 0, 0) == 0);
        } catch (Exception thrown) {
            assertEquals("Неправильный формат сообщения об ошибке при делении на 0", "Нельзя делить на 0.", thrown.getMessage());
        }
    }

}
