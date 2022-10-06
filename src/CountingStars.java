import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CountingStars {

    // Solution: BFS to find connected areas

    // counts the number of stars visible in a bitmap image

    // image consists of pixels

    // each pixel is either black "#" or white "-"

    // black pixels are part of the sky

    // white pixels are part of the star

    // vertically adjacent white pixels are part of the same star

    public static boolean checkRange(String[][] stars, int row, int column)
    {
        return row >= 0 && column >= 0 && row < stars.length && column < stars[0].length;
    }

    public static void fill(String[][] image, int row, int col)
    {
        System.out.println("=============");
        for (String[] strings : image) {
            System.out.println(Arrays.toString(strings));
        }
        if (!checkRange(image, row, col))
            return;
        if (Objects.equals(image[row][col], "#"))
            return;
        image[row][col] = "#";
        if (checkRange(image, row+1, col))
            fill(image, row+1, col);
        if (checkRange(image, row-1, col))
            fill(image, row-1, col);
        if (checkRange(image, row, col+1))
            fill(image, row, col+1);
        if (checkRange(image, row, col-1))
            fill(image, row, col-1);
    }


    public static int solve(String[][] image)
    {
        int stars = 0;
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image[i].length; j++)
            {
                if (Objects.equals(image[i][j], "-"))
                {
                    fill(image, i, j);
                    stars++;
                }
            }
        }

        return stars;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (input.hasNext())
        {
            int numLines = input.nextInt();
            System.out.println("numLines: " + numLines);
            int numPixels = input.nextInt();
            System.out.println("numPixels: " + numPixels);
            input.nextLine();
            String[][] image = new String[numLines][numPixels];
            for (int i = 0; i < numLines; i++)
            {
                String[] line = input.nextLine().split("");
                System.arraycopy(line, 0, image[i], 0, numPixels);
            }

//            for (String[] strings : image) {
//                System.out.println(Arrays.toString(strings));
//            }

            System.out.println(solve(image));
        }
    }
}
