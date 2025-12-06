enum Day {
    MONDAY("Понедельник", 8, true),
    TUESDAY("Вторник", 8, true),
    WEDNESDAY("Среда", 8, true),
    THURSDAY("Четверг", 8, true),
    FRIDAY("Пятница", 7, true),
    SATURDAY("Суббота", 0, false),
    SUNDAY("Воскресенье", 0, false);

    private final String russianName;
    private final int workHours;
    private final boolean isWorkingDay;

    // Конструктор
    Day(String russianName, int workHours, boolean isWorkingDay) {
        this.russianName = russianName;
        this.workHours = workHours;
        this.isWorkingDay = isWorkingDay;
    }

    // Метод для получения русского названия
    public String getRussianName() {
        return russianName;
    }

    // Метод для проверки, рабочий ли это день
    public boolean isWorkingDay() {
        return isWorkingDay;
    }

    // Метод для расчета зарплаты за день
    public double calculateSalary(double hourlyRate) {
        return workHours * hourlyRate;
    }

    // Метод для получения следующего дня
    public Day nextDay() {
        Day[] days = values();
        int nextIndex = (this.ordinal() + 1) % days.length;
        return days[nextIndex];
    }
}

// Использование
class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        System.out.println("Сегодня: " + today.getRussianName());
        System.out.println("Рабочий день? " + today.isWorkingDay());

        double salary = today.calculateSalary(15.5);
        System.out.println("Зарплата за день: " + salary + "$");

        System.out.println("Завтра: " + today.nextDay().getRussianName());

        // Перебор всех дней
        for (Day day : Day.values()) {
            System.out.println(day.getRussianName() +
                    " - рабочих часов: " + day.calculateSalary(1)/1);
        }
    }
}