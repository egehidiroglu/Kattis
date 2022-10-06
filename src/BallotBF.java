import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BallotBF {

    public static void solve(int numBallot, int[] population)
    {
        int low = 1, hi = 0, mid;
        for (int j : population) {
            hi = Math.max(hi, j);
        }

        while (low < hi)
        {
            System.out.println("High: " + hi);
            System.out.println("Low: " + low);

            mid = (low + hi) / 2;

            int count = 0;

            for (int i = 0; i < population.length; i++)
            {
                count += (population[i] + mid - 1) / mid;
            }
            if (count > numBallot)
            {
                low = mid + 1;
            } else
            {
                hi = mid;
            }

            System.out.println("Mid: " + mid);
            System.out.println("Count: " + count);
            System.out.println("==================");
        }
        System.out.println(low);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCities = input.nextInt();
        while (numCities != -1)
        {
            int numBallots = input.nextInt();
            int[] populations = new int[numCities];
            for (int i = 0; i < numCities; i++)
            {
                populations[i] = input.nextInt();
            }
            solve(numBallots, populations);
            numCities = input.nextInt();
        }
    }
}
