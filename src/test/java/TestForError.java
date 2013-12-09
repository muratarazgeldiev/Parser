import org.junit.Test;

public class TestForError {
    @Test
    public void TestError(){
        Result test = new Result();
        assertEquals("Неверное записанное выражение +-", test.result("2+-4"));      // проверка на случайно введенные операции
        assertEquals("Неверно описана функция max(;)" , test.result("min(max)"));   // проверка функций
        assertEquals("Неверно описана функция min(;)", test.result("max(min)"));
        assertEquals("Неизвестный токен sqr",test.result("sqr(64)"));               // проверка на неправильно введенные функции либо на наличие неизвестных функций
        assertEquals("Вы ничего не ввели!", test.result(""));                       // ошибка при том что мы ничего не ввели
        assertEquals("Вы ничего не ввели!", test.result("()"));
        assertEquals("Недостаточно открывающих скобок!", test.result("2+4*5)^2"));  // на недостающие скобки
    }
}
