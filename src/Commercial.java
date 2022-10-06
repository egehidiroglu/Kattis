import java.util.Scanner;

public class Commercial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numBreaks = input.nextInt();
        int priceBreaks = input.nextInt();
        input.nextLine();
        String[] listeners = input.nextLine().split(" ");
        // Initialize current and maximum sums
        int current = 0, max = Integer.MIN_VALUE;
        // Max sub-array sum problem - Using Kadane's Algorithm
        for (int i = 0; i < numBreaks; i++)
        {
            // Calculate revenue based on price per commercial break.
            int revenue = Integer.parseInt(listeners[i]) - priceBreaks;
            // Add revenue to the current sum.
            current += revenue;
            // If current sum is greater than max sum then cur is the new max sum
            if (current > max)
            {
                max = current;
            }
            // If current is negative then we can't be icnreasing value
            // so reset cur sum.
            if (current < 0)
            {
                current = 0;
            }
        }
        System.out.println(max);
    }

}
