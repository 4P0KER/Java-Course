// Собственный класс исключения
class InvalidTemperatureException extends Exception {

    // Конструктор по умолчанию
    public InvalidTemperatureException() {
        super("Некорректная температура");
    }

    // Конструктор с сообщением
    public InvalidTemperatureException(String message) {
        super(message);
    }

    // Конструктор с сообщением и причиной
    public InvalidTemperatureException(String message, Throwable cause) {
        super(message, cause);
    }
}

// Пример использования
class TemperatureValidator {
    public static void setTemperature(double temp) throws InvalidTemperatureException {
        if (temp < -273.15) {
            throw new InvalidTemperatureException("Температура ниже абсолютного нуля: " + temp);
        }
        if (temp > 10000) {
            throw new InvalidTemperatureException("Температура слишком высокая: " + temp);
        }
        System.out.println("Температура установлена: " + temp + "°C");
    }

    public static void main(String[] args) {
        try {
            setTemperature(20.5);     // Корректная температура
            setTemperature(-300);     // Выбросит InvalidTemperatureException
        } catch (InvalidTemperatureException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}