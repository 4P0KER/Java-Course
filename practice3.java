import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class TimeFormatSpecifiers {
    public static void main(String[] args) {

        // Создаем объект Date с конкретной датой
        // 15 июля 2024 года, 14:30:45 (понедельник)
        Calendar calendar = new GregorianCalendar(2024, Calendar.JULY, 15, 14, 30, 45);
        Date date = calendar.getTime();

        System.out.println("Примеры спецификаторов времени и даты\n");

        // Пример 1: %tH - час в 24-часовом формате (00-23)
        System.out.printf("1. %%tH: Текущий час (24ч формат): %tH%n", date);

        // Пример 2: %tM - минуты (00-59)
        System.out.printf("2. %%tM: Минуты: %tM%n", date);

        // Пример 3: %tS - секунды (00-59)
        System.out.printf("3. %%tS: Секунды: %tS%n", date);

        // Пример 4: %tY - год в четырехзначном формате
        System.out.printf("4. %%tY: Год (4 цифры): %tY%n", date);

        // Пример 5: %tB - полное название месяца
        System.out.printf("5. %%tB: Месяц: %tB%n", date);

        System.out.println("\n=== Дополнительные примеры ===\n");

        // Пример 6: %tI - час в 12-часовом формате (01-12)
        System.out.printf("6. %%tI: Час (12ч формат): %tI%n", date);

        // Пример 7: %tA - полное название дня недели
        System.out.printf("7. %%tA: День недели: %tA%n", date);

        // Пример 8: %tm - месяц в двузначном формате (01-12)
        System.out.printf("8. %%tm: Месяц (цифры): %tm%n", date);

        // Пример 9: %tL - миллисекунды
        // Добавим миллисекунды
        calendar.set(Calendar.MILLISECOND, 123);
        Date dateWithMs = calendar.getTime();
        System.out.printf("9. %%tL: Миллисекунды: %tL%n", dateWithMs);

        // Пример 10: Комбинированный формат времени
        System.out.printf("%n10. Комбинированный формат:%n");
        System.out.printf("   Время: %tH:%tM:%tS%n", date, date, date);
        System.out.printf("   Дата: %td.%tm.%tY%n", date, date, date);
        System.out.printf("   Полная дата: %tA, %td %tB %tY года%n",
                date, date, date, date);

        // Пример 11: Работа с текущей датой
        Date currentDate = new Date();
        System.out.printf("%n11. Текущая дата и время:%n");
        System.out.printf("   Сейчас: %tH:%tM:%tS %td.%tm.%tY%n",
                currentDate, currentDate, currentDate,
                currentDate, currentDate, currentDate);

        // Пример 12: Форматирование для разных сценариев
        System.out.printf("%n12. Примеры для разных сценариев:%n");

        // Для журналирования
        System.out.printf("   [Лог] %tY-%tm-%td %tH:%tM:%tS - Событие%n",
                date, date, date, date, date, date);

        // Для пользовательского интерфейса
        System.out.printf("   Сегодня: %tA, %td %tB%n", date, date, date);

        // Для технических нужд (точное время)
        System.out.printf("   Точное время: %tH:%tM:%tS.%tL%n",
                dateWithMs, dateWithMs, dateWithMs, dateWithMs);

        // Пример 13: Спецификатор %tY vs %ty
        System.out.printf("%n13. Разница %%tY и %%ty:%n");
        System.out.printf("   Полный год (%%tY): %tY%n", date);
        System.out.printf("   Короткий год (%%ty): %ty%n", date);

        // Пример с годом 2000-м
        Calendar year2000 = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        System.out.printf("   Год 2000 (%%tY): %tY%n", year2000.getTime());
        System.out.printf("   Год 2000 (%%ty): %ty%n", year2000.getTime());
    }
}