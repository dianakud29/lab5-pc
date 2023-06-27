package ua.lviv.iot.algo.part2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostalCode {
    public static void main(String[] args) {
        String text = "Поштовий індекс 79067 це Львів. Індекс 79045 це мій поштовий індекс теж Львів. 79100 це поштовий індекс Дніпра";

        Pattern pattern = Pattern.compile("(?<!\\d)790\\d{2}(?!\\d)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String postalCode = matcher.group();
            System.out.println("Поштовий індекс міста Львова: " + postalCode);
        }
    }
}


