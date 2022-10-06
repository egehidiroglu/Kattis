import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String current = input.nextLine();
        String explosion = input.nextLine();

        String curhour = current.split(":")[0];
        int currentHour = Integer.parseInt(curhour);
        int currentHour12 = currentHour % 12;
        int expHour = Integer.parseInt(explosion.split(":")[0]);
        int expHour12 = expHour % 12;
        System.out.println(currentHour12);

    }
}
