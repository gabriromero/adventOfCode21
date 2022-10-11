import java.io.File;
import java.util.Scanner;

public class partOne {
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File("dayTwo//src//input.txt");
        Scanner sc = new Scanner(file);

        String direction;
        int value, depth = 0, forward = 0;

        while (sc.hasNext()){
            direction = sc.next();
            value = Integer.parseInt(sc.next());

            switch (direction) {
                case "forward" -> forward += value;
                case "down" -> depth += value;
                case "up" -> depth -= value;
            }

        }
        System.out.println(forward*depth);


    }
}
