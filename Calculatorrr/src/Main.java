import java.io.*;
import java.nio.file.*;
import java.util.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Main {
    private static final String HISTORY_FILE = "calculator_history.txt";

    private static void saveToHistory(String record) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(record);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории: " + e.getMessage());
        }
    }

    private static void printHistory() {
        try {
            List<String> history = Files.readAllLines(Paths.get(HISTORY_FILE));
            if (history.isEmpty()) {
                System.out.println("История пуста.");
            } else {
                for (String record : history) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении истории: " + e.getMessage());
        }
    }

    private static String evaluateExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\|(.+?)\\|", "abs($1)");
        expression = expression.replaceAll("(\\d+)\\s*\\^\\s*(\\d+)", "$1^$2");
        expression = expression.replaceAll("(\\d+)\\s*//\\s*(\\d+)", "floor($1/$2)");

        Expression e = new ExpressionBuilder(expression).build();
        double result = e.evaluate();

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в калькулятор!");
        System.out.println("Введите уравнение или команду (history, exit):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                printHistory();
            } else {
                try {
                    String result = evaluateExpression(input);
                    saveToHistory(input + " = " + result);
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            }
        }

        scanner.close();
    }
}
