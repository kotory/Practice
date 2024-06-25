import java.math.BigInteger;

public class Main {

    public static String addStrings(String num1, String num2) {
        BigInteger number1 = new BigInteger(num1);
        BigInteger number2 = new BigInteger(num2);

        BigInteger sum = number1.add(number2);

        return sum.toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789123456789";
        String num2 = "987654321987654321";

        String result = addStrings(num1, num2);
        System.out.println("Сумма: " + result);
    }
}