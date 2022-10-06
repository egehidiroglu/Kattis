import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CountingSubsequence {

    public static void solve(int[] nums, HashMap<Integer, Integer> map)
    {
        int count = 0, curSum = 0;
        for (int num : nums) {
            curSum += num;
            int remSum = curSum - 47;
            if (map.containsKey(remSum)) {
                count += map.get(remSum);
            }
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int testCases = input.nextInt();
        int loop = 0;
        while (loop < testCases)
        {
            int size = input.nextInt();
            input.nextLine();
            int[] nums = new int[size];
            for (int i = 0; i < size; i++)
            {
                nums[i] = input.nextInt();
            }
            HashMap<Integer, Integer> sumMap = new HashMap<>();
            solve(nums, sumMap);
            loop++;
        }
    }
}
