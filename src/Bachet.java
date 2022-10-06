import java.util.ArrayList;
import java.util.Scanner;

public class Bachet {

    public static boolean stanWins(int numStones, int[] legalMoves)
    {
        // Create an array with size = n + 1
        // To keep track of Win = true or Lose = false based on
        // each num of stones in the game
        boolean[] gameResultPerNumStone = new boolean[numStones + 1];
        // For each number of stones...
        for (int stones = 1; stones <= numStones; stones++)
        {
            for (int legalMove : legalMoves) {
                // Check if subtracted by a legalMove, num of stone is greater than 0
                // and
                // Check if the result of the prev game is loss
                // then wins
                int rem = stones - legalMove;
                if (rem >= 0 && !gameResultPerNumStone[stones - legalMove]) {
//                    System.out.println("legal: " + legalMove);
//                    System.out.println("stones: " + stones);
//                    System.out.println("index: " + (stones - legalMove));
                    gameResultPerNumStone[stones] = true;
                    break;
                }
            }
        }
        return gameResultPerNumStone[numStones];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // n stones on the table
        // two players - Stan Olie, Stan starts always
        // legal move: num stones removed must be a member of set m
        // winner: one to take the last stone
        while (input.hasNext())
        {
            // Get the number of stones in the game
            int numStones = input.nextInt();
            // Make an array of legal moves in the game
            int[] legalMoves = new int[input.nextInt()];
            // Put legal moves in the legalMoves array
            for (int i = 0; i < legalMoves.length; i++)
            {
                legalMoves[i] = input.nextInt();
            }
            if (stanWins(numStones, legalMoves))
                System.out.println("Stan wins");
            else
                System.out.println("Ollie wins");
        }
        input.close();

    }

}
