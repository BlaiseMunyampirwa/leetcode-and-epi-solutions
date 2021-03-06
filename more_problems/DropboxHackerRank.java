package more_problems;
import java.util.*;

public class DropboxHackerRank {
    public static void main(String[] args) {
        int[] firstTest = {1, 5, 3, 2};
        int[] secondTest = {1,3,-1,-3,5,3,6,7};

        System.out.println(slidingWindowMin(firstTest, 2));
        System.out.println(slidingWindowMin(secondTest, 3));
    }
    
    public static int slidingWindowMin(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1 || k == 1) return arr[0];
        int len = arr.length;
        int[] output = new int[len-k+1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i+1>=k) {
                output[i+1-k] = arr[deque.peekFirst()];
            }
        }
        return findMax(output);
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}