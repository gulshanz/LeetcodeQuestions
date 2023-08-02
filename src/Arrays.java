import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Arrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        System.out.println(java.util.Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] longArr ;
        int [] smallArr;
        if (nums1.length>nums2.length){
            longArr = nums1;
            smallArr = nums2;
        }else{
            longArr = nums2;
            smallArr = nums1;
        }

        for (int num : longArr) {
            map.merge(num, 1, Integer::sum);
        }

        for (int secNum : smallArr) {
            if (map.get(secNum) != null) {
                if (map.get(secNum) == 1) {
                    result.add(secNum);
                    map.remove(secNum);
                } else {
                    map.put(secNum, map.get(secNum) - 1);
                    result.add(secNum);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
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
        System.arraycopy(tempArr, 0, arr, 0, n);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int curr : nums) {
            if (map.contains(curr))
                return true;
            map.add(curr);
        }
        return false;
    }
}
