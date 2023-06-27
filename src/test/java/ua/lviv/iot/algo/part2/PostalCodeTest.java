package ua.lviv.iot.algo.part2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PostalCodeTest {
    @Test
    public void testPostalCode() {
        String text = "Поштовий індекс 79067 це Львів. Індекс 79045 це мій поштовий індекс теж Львів. 79100 це поштовий індекс Дніпра";
        Pattern pattern = Pattern.compile("(?<!\\d)790\\d{2}(?!\\d)");
        Matcher matcher = pattern.matcher(text);
        List<String> expectedPostalCodes = Arrays.asList("79067", "79045");
        List<String> actualPostalCodes = new ArrayList<>();
        while (matcher.find()) {
            actualPostalCodes.add(matcher.group());
        }
        assertEquals(expectedPostalCodes, actualPostalCodes);
    }
//перевірка чи правильно визначається індекс Львова
    @Test
    public void testNoPostalCode() {
        String text = "Поштовий індекс 79100 це поштовий індекс Дніпра";
        Pattern pattern = Pattern.compile("(?<!\\d)790\\d{2}(?!\\d)");
        Matcher matcher = pattern.matcher(text);
        assertFalse(matcher.find());
    }
    //Перевірка відсутності результату, якщо немає потрібного індексу
    @Test
    public void testInvalidPostalCodeFormat() {
        String text = "Поштовий індекс 790674 це Львів";
        Pattern pattern = Pattern.compile("(?<!\\d)790\\d{2}(?!\\d)");
        Matcher matcher = pattern.matcher(text);
        assertFalse(matcher.find());
    }
    //перевірка чи відсутній результат якщо є неправильний формат індексу
}