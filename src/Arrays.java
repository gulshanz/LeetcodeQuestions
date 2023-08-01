public class Arrays {

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(maxProfit);
    }
    public static int maxProfit(int[] arr) {
        int lastConsidered = arr[0]; // 3
        int totalProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            if (curr > lastConsidered) {
                totalProfit += curr-lastConsidered;
            }
            lastConsidered = curr;
        }
        return totalProfit;
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] tempArr = new int[n];

        // Copy elements to tempArr after rotation
        for (int i = 0; i < n; i++) {
            tempArr[(i + k) % n] = arr[i];
        }

        // Copy the rotated elements back to the original array
        for (int i = 0; i < n; i++) {
            arr[i] = tempArr[i];
        }
    }
}
