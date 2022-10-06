import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UnionFind {

    static HashMap<String, UnionFind> group = new HashMap<>();
    UnionFind parent;
    int size;

    UnionFind()
    {
        this.parent = this;
        this.size = 1;
    }

    public static UnionFind find(UnionFind x)
    {
        if (x.parent == x)
        {
            return x;
        }
        return find(x.parent);
    }

    public static void union(UnionFind x, UnionFind y)
    {
        UnionFind xset = find(x);
        UnionFind yset = find(y);

        if (xset == yset)
        {
            System.out.println(xset.size);
        } else if (xset.size > yset.size) {
            yset.parent = xset;
            xset.size += yset.size;
            System.out.println(xset.size);
        } else {
            xset.parent = yset;
            yset.size += xset.size;
            System.out.println(yset.size);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numTest = input.nextInt();
        int numFriends = input.nextInt();

        int loop = 0;
        while (loop < numTest)
        {
            input.nextLine();
            for (int i = 0; i < numFriends; i++)
            {
                String[] friends = input.nextLine().split(" ");
                group.putIfAbsent(friends[0], new UnionFind());
                group.putIfAbsent(friends[1], new UnionFind());
                union(group.get(friends[0]), group.get(friends[1]));
            }
            loop++;
        }
    }
}
