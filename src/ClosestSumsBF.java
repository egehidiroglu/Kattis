import java.util.Arrays;
import java.util.Scanner;

public class ClosestSumsBF {


    public static void solve(int[] set, int[]queries)
    {
        for (int query : queries) {
            int theSum = 0, minDif = Integer.MAX_VALUE;
            for (int j = 0; j < set.length; j++) {
                for (int k = 0; k < set.length; k++) {
                    if (j != k) {
                        int sum = set[j] + set[k];
                        int distToZero = Math.abs(sum - query);
                        if (distToZero < minDif) {
                            minDif = distToZero;
                            theSum = sum;
                        }
                    }
                }
            }
            System.out.println("Closest sum to " + query + " is " + theSum + ".");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int j = 1;
        while (input.hasNext())
        {
            int numLines = input.nextInt();
            int[] nums_n = new int[numLines];
            for (int i = 0; i < nums_n.length; i++)
            {
                nums_n[i] = input.nextInt();
            }
            int numQueries = input.nextInt();
            int[] nums_m = new int[numQueries];
            for (int i = 0; i < nums_m.length; i++)
            {
                nums_m[i] = input.nextInt();
            }
            System.out.println("Case " + j + ":");
            solve(nums_n, nums_m);
            j++;
        }
    }

}
