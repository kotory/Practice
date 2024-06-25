import java.util.Arrays;

public class Main {
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static int nextGreaterNumber(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int i = digits.length - 2;

        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        swap(digits, i, j);

        Arrays.sort(digits, i + 1, digits.length);

        long result = Long.parseLong(new String(digits));

        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterNumber(23));
        System.out.println(nextGreaterNumber(523));
        System.out.println(nextGreaterNumber(2018));
        System.out.println(nextGreaterNumber(1));
        System.out.println(nextGreaterNumber(532));
    }
}
