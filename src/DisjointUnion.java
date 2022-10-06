import java.util.*;

public class DisjointUnion {

    public Map<String, String> people = new HashMap<>();
    public Map<String, Integer> sizes = new HashMap<>();

    public DisjointUnion(ArrayList<String> people)
    {
        for (String p : people)
        {
            this.people.put(p, p);
            this.sizes.put(p, 1);
        }
    }

    public void union(String x, String y)
    {

        String xTree = find(x);
        String yTree = find(y);

        if (xTree == yTree)
        {
            return;
        }

        int xSize = getSize(xTree);
        int ySize = getSize(yTree);

        if (xSize < ySize)
        {
            people.put(xTree, yTree);
            sizes.put(yTree, xSize + ySize);
        } else {
            people.put(yTree, xTree);
            sizes.put(xTree, xSize + ySize);
        }
    }

    public String find(String x)
    {
        for (String parent, grandparent; (parent = people.get(x)) != x; x = grandparent) {
            people.put(x, grandparent = people.get(parent));
        }
        return x;
    }

    public int getSize(String x)
    {
        return sizes.get(x);
    }

    public boolean connected(String x, String y)
    {
        return find(x).equals(find(y));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for (int i = 0; i < numTestCases; i++)
        {
            DisjointUnion friends = new DisjointUnion(new ArrayList<>());
            int numFriendShips = scan.nextInt();
            String l = scan.nextLine();
            String track = "";
            for (int j = 0; j < numFriendShips; j++)
            {
                String line = scan.nextLine();
                String[] words = line.split(" ");
                if (j==0)
                {
                    track = words[0];
                }
                friends.people.putIfAbsent(words[0], words[0]);
                friends.people.putIfAbsent(words[1], words[1]);
                friends.sizes.putIfAbsent(words[0], 1);
                friends.sizes.putIfAbsent(words[1], 1);
                friends.union(words[0], words[1]);
                System.out.println(friends.getSize(track));
            }
        }
        scan.close();
    }
}
