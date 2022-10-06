import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class SolitaireDP {

    public static int solve(String[] game, HashMap<String, Integer> memory)
    {
        String key = Arrays.toString(game);
        if (memory.containsKey(key))
        {
            return memory.get(key);
        }

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
            if (Objects.equals(game[i], "o"))
            {
                if (i+2 < game.length && Objects.equals(game[i + 1], "o") && Objects.equals(game[i + 2], "-"))
                {
                    game[i] = "-";
                    game[i+1] = "-";
                    game[i+2] = "o";

                    pebbles = Math.min(pebbles, solve(game, memory));

                    game[i] = "o";
                    game[i+1] = "o";
                    game[i+2] = "-";
                }
                if (i-2 >= 0 && Objects.equals(game[i], "o") && Objects.equals(game[i - 1], "o") && Objects.equals(game[i - 2], "-"))
                {
                    game[i] = "-";
                    game[i-1] = "-";
                    game[i-2] = "o";

                    pebbles = Math.min(pebbles, solve(game, memory));

                    game[i] = "o";
                    game[i-1] = "o";
                    game[i-2] = "-";
                }
            }
        }
        memory.put(key, pebbles);
        return pebbles;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numGames = input.nextInt();
        input.nextLine();
        for (int i = 0; i < numGames; i++)
        {
            String[] game = input.nextLine().split("");
            HashMap<String, Integer> memory = new HashMap<>();
            System.out.println(solve(game, memory));
        }
    }
}
