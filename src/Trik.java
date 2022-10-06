import java.util.Objects;
import java.util.Scanner;

public class Trik {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String moves[] = input.nextLine().split("");
        int location = 1;
        for (int i=0; i < moves.length; i++)
        {
            if (Objects.equals(moves[i], moves[i + 1]))
            {
                continue;
            }
            if (Objects.equals(moves[i], "A"))
            {
                location = 2;
            }

            if (Objects.equals(moves[i], "B"))
            {
                location = 3;
            }
            if (Objects.equals(moves[i], "C"))
            {
                location = 1;
            }
        }
        System.out.println(location);
    }
}
