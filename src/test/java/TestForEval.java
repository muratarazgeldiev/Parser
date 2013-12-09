import org.junit.Test;

import static org.junit.Assert.*;

public class TestForEval {
    @Test
    public void TestTrueEval()  {
        Result test = new Result();
        assertEquals(String.valueOf(14.787762068944536),test.result("12+5 - sqrt(min(64;4;16)+sin(60+max(4;15;15*2)))"));   // проверка на правильность вычислений при множественном вложении
        assertTrue(String.valueOf(-1.0) == test.result("-1"));                           // проверка при вводе отрицательного числа
        assertEquals(String.valueOf(125), test.result("min(5/5*126;5^(5-2);5*(6^6))"));  // проверка вычисления функции с вложенными операциями
    }
    @Test
    public void TestFalseEval(){
        Result test = new Result();
        assertFalse(String.valueOf(14.787762068944) == test.result("12.23+2.32-5^(5-2)"));  // ошибка сравнения результатов при недостающих чисел после запятой
        assertFalse(String.valueOf(60) == test.result("min(60;150;15)"));                   // проверка функции
    }
}
