/**
 * Класс Point представляет точку на плоскости с координатами (x, y).
 *
 * СОГЛАШЕНИЯ ДЛЯ МЕТОДА equals():
 * 1. РЕФЛЕКСИВНОСТЬ:  x.equals(x) всегда true
 * 2. СИММЕТРИЧНОСТЬ: если x.equals(y) true, то y.equals(x) тоже true
 * 3. ТРАНЗИТИВНОСТЬ: если x.equals(y) true и y.equals(z) true, то x.equals(z) true
 * 4. НЕПРОТИВОРЕЧИВОСТЬ: повторные вызовы x.equals(y) возвращают одинаковый результат
 * 5. С NULL: x.equals(null) всегда false
 * 6. СОГЛАСОВАННОСТЬ С hashCode(): если x.equals(y) true, то x.hashCode() == y.hashCode()
 */
class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Переопределенный метод equals().
     * Две точки равны, если их координаты совпадают с учетом погрешности
     * для вещественных чисел (используем epsilon для сравнения double).
     */
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на ссылочное равенство
        if (this == obj) {
            return true;
        }

        // 2. Проверка на null
        if (obj == null) {
            return false;
        }

        // 3. Проверка типа через getClass() для строгого сравнения
        if (getClass() != obj.getClass()) {
            return false;
        }

        // 4. Безопасное приведение типа
        Point other = (Point) obj;

        // 5. Сравнение вещественных чисел с учетом погрешности
        final double EPSILON = 0.00001;
        return Math.abs(this.x - other.x) < EPSILON
                && Math.abs(this.y - other.y) < EPSILON;
    }

    /**
     * hashCode() должен быть согласован с equals().
     * Преобразуем double в long для корректного хэширования.
     */
    @Override
    public int hashCode() {
        // Используем Double.hashCode() для вещественных чисел
        int result = Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        return result;

        // Альтернатива с округлением для согласованности с equals():
        // final double EPSILON = 0.00001;
        // long xScaled = Math.round(x / EPSILON);
        // long yScaled = Math.round(y / EPSILON);
        // return Long.hashCode(xScaled ^ yScaled);
    }

    // Геттеры
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод для вычисления расстояния до другой точки
    public double distanceTo(Point other) {
        if (other == null) return Double.NaN;
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }
}

/**
 * Пример использования и тестирования соглашений:
 */
class GeometryExample {
    public static void main(String[] args) {
        // Создаем точки
        Point p1 = new Point(1.0, 2.0);
        Point p2 = new Point(1.0, 2.0);  // Такие же координаты
        Point p3 = new Point(1.000001, 2.000001);  // Почти такие же
        Point p4 = new Point(3.0, 4.0);  // Другие координаты

        System.out.println("Тестирование equals()");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);

        System.out.println("\n1. Рефлексивность (p1.equals(p1)): " + p1.equals(p1));
        System.out.println("2. Симметричность:");
        System.out.println("   p1.equals(p2): " + p1.equals(p2));
        System.out.println("   p2.equals(p1): " + p2.equals(p1));

        System.out.println("3. Сравнение с почти равной точкой:");
        System.out.println("   p1.equals(p3): " + p1.equals(p3));  // true (в пределах погрешности)

        System.out.println("4. Сравнение с другой точкой:");
        System.out.println("   p1.equals(p4): " + p1.equals(p4));

        System.out.println("5. Сравнение с null:");
        System.out.println("   p1.equals(null): " + p1.equals(null));

        System.out.println("\nПроверка hashCode()");
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p3.hashCode(): " + p3.hashCode());
        System.out.println("p1.hashCode() == p2.hashCode(): " +
                (p1.hashCode() == p2.hashCode()));

        System.out.println("\nТестирование транзитивности");
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.000005, 1.000005);  // Почти равно a
        Point c = new Point(1.000009, 1.000009);  // Почти равно b

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("b.equals(c): " + b.equals(c));
        System.out.println("a.equals(c): " + a.equals(c));\
    }
}