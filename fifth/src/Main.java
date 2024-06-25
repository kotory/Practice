public class Main {

    public static int findMaxSum(int[][] pyramid) {
        int[] maxSums = pyramid[pyramid.length - 1];

        for (int row = pyramid.length - 2; row >= 0; row--) {
            int[] newMaxSums = new int[row + 1];
            for (int col = 0; col <= row; col++) {
                newMaxSums[col] = pyramid[row][col] + Math.max(maxSums[col], maxSums[col + 1]);
            }
            maxSums = newMaxSums;
        }

        return maxSums[0];
    }

    public static void main(String[] args) {
        int[][] pyramid = {
                {3},
                {7, 4},
                {2, 4, 6},
                {8, 5, 9, 3}
        };

        int maxSum = findMaxSum(pyramid);
        System.out.println("Максимальная сумма скольжения: " + maxSum);
    }
}
