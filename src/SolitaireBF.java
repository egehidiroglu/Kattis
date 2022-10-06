import java.util.Objects;
import java.util.Scanner;

public class SolitaireBF {

    public static int solve(String[] game)
    {
        int pebbles = 0;
        for (String str : game)
        {
            if (Objects.equals(str, "o"))
            {
                pebbles++;
            }
        }

        for (int i = 0; i < game.length; i++)
        {
            boolean inGameRight = (i+2) < game.length;
            boolean inGameLeft = (i-2) >= 0;
            if (inGameRight)
            {
                if (Objects.equals(game[i], "o") && Objects.equals(game[i + 1], "o") && Objects.equals(game[i + 2], "-"))
                {
                    game[i] = "-";
                    game[i+1] = "-";
                    game[i+2] = "o";

                    pebbles = solve(game);

                    game[i] = "o";
                    game[i+1] = "o";
                    game[i+2] = "-";
                }
            }
            if (inGameLeft)
            {
                if (Objects.equals(game[i], "o") && Objects.equals(game[i - 1], "o") && Objects.equals(game[i - 2], "-"))
                {
                    game[i] = "-";
                    game[i-1] = "-";
                    game[i-2] = "o";

                    pebbles = solve(game);

                    game[i] = "o";
                    game[i-1] = "o";
                    game[i-2] = "-";
                }
            }
        }
        return pebbles;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numGames = input.nextInt();
        input.nextLine();
        for (int i = 0; i < numGames; i++)
        {
            String[] game = input.nextLine().split("");
            System.out.println(solve(game));
        }
    }
}
