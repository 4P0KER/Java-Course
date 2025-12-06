import java.util.Scanner;

class Greeting{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя:");
        String name = scanner.nextLine();
        System.out.println("Привет," + name);

        scanner.close();
    }
}