import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FriendSet {
    static HashMap<String, FriendSet> people = new HashMap<>();
    FriendSet parent;
    int size;

    FriendSet()
    {
        this.parent = this;
        this.size = 1;
    }

    static FriendSet find(FriendSet x)
    {
        if (x.parent == x) {
            return x;
        }
        else {
            x.parent = find(x.parent);
            return x.parent;
        }
    }

    static int union(FriendSet x, FriendSet y)
    {
        FriendSet yRoot = find(y);
        FriendSet xRoot = find(x);

        if (xRoot == yRoot)
        {
            return xRoot.size;
        } else if (xRoot.size > yRoot.size) {
            yRoot.parent = xRoot;
            xRoot.size += yRoot.size;
            return xRoot.size;
        } else {
            xRoot.parent = yRoot;
            yRoot.size += xRoot.size;
            return yRoot.size;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 0; i < numTestCases; i++)
        {
            int numFriendShips = scan.nextInt();
            String l = scan.nextLine();
            for (int j = 0; j < numFriendShips; j++)
            {
                String line = scan.nextLine();
                String[] words = line.split(" ");

                people.putIfAbsent(words[0], new FriendSet());
                people.putIfAbsent(words[1], new FriendSet());

                System.out.println(union(people.get(words[0]), people.get(words[1])));
            }
            people = new HashMap<>();
        }

        scan.close();
    }
}
