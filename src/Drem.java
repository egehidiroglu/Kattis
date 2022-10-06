import java.util.Scanner;

public class Drem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int N = input.nextInt();

        int sum = a + b + c;

        if (a >= 1 && b >= 1 && c >= 1 && sum >= N)
        {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
