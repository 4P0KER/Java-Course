/**
 * Класс Documenting предоставляет статические методы для выполнения
 * основных операций с массивами целых чисел, таких как поиск экстремумов,
 * вычисление среднего значения, сортировка и поиск элементов.
 *
 * @author Владислав
 * @version 1.0
 */

public class Documenting{

    /**
     * Находит максимальный элемент в переданном массиве.
     *
     * @param array массив целых чисел
     * @return максимальное значение в массиве
     * @throws IllegalArgumentException если массив пуст или равен null
     */
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    /**
     * Находит минимальный элемент в переданном массиве.
     *
     * @param array массив целых чисел
     * @return минимальное значение в массиве
     * @throws IllegalArgumentException если массив пуст или равен null
     */
    public static int findMin(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    /**
     * Вычисляет среднее арифметическое значение элементов массива.
     *
     * @param array массив целых чисел
     * @return среднее значение элементов массива в виде double
     * @throws IllegalArgumentException если массив пуст или равен null
     */
    public static double calculateAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    /**
     * Сортирует массив целых чисел по возрастанию, используя алгоритм пузырьковой сортировки.
     *
     * @param array массив целых чисел для сортировки (может быть null)
     */
    public static void bubbleSort(int[] array) {
        if (array == null) return;

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Выполняет линейный поиск целевого элемента в массиве.
     *
     * @param array массив целых чисел
     * @param target искомое значение
     * @return индекс первого вхождения target в массиве, либо -1, если элемент не найден или массив равен null
     */
    public static int linearSearch(int[] array, int target) {
        if (array == null) return -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    /**
     * Выполняет бинарный поиск целевого элемента в отсортированном массиве.
     * Предполагается, что массив отсортирован по возрастанию.
     *
     * @param array отсортированный массив целых чисел
     * @param target искомое значение
     * @return индекс target в массиве, либо -1, если элемент не найден или массив равен null
     */
    public static int binarySearch(int[] array, int target) {
        if (array == null) return -1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) return mid;
            if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * Основной метод для демонстрации работы методов класса Documenting.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        int[] sampleArray = {34, 7, 23, 32, 5, 62};

        System.out.println("Исходный массив: " + java.util.Arrays.toString(sampleArray));

        System.out.println("Максимальный элемент: " + findMax(sampleArray));
        System.out.println("Минимальный элемент: " + findMin(sampleArray));
        System.out.println("Среднее значение: " + calculateAverage(sampleArray));

        bubbleSort(sampleArray);
        System.out.println("Отсортированный массив: " + java.util.Arrays.toString(sampleArray));

        int target = 23;
        System.out.println("Линейный поиск " + target + ": индекс = " + linearSearch(sampleArray, target));

        target = 62;
        System.out.println("Бинарный поиск " + target + " (в отсортированном): индекс = " + binarySearch(sampleArray, target));

        target = 99;
        System.out.println("Поиск отсутствующего элемента " + target + ": индекс = " + binarySearch(sampleArray, target));
    }
}

//Создания документации: javadoc -encoding UTF-8 -d docs -author -version Documenting.java