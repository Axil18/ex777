import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float number = getFloatInput(scanner);
        System.out.println("Вы ввели число: " + number);
    }

    public static float getFloatInput(Scanner scanner) {
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Пожалуйста, введите дробное число: ");
            if (scanner.hasNextFloat()) {
                result = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Ошибка! Введите корректное дробное число.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return result;
    }
}