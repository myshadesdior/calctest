import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение (например, 3 + 4): ");
        String input = scanner.nextLine();
        try {
            System.out.println("Результат: " + calculate(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calculate(String input) throws Exception {
        input = input.trim().replaceAll("\\s+", " ");
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат выражения. Используйте формат: a + b");
        }

        int a, b;
        String operator = parts[1];

        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами от 1 до 10.");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Недопустимая операция: " + operator);
        };
    }
}