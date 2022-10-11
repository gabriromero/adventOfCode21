import java.io.File;
import java.util.Scanner;

public class partTwo {
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File("dayTwo//src//input.txt");
        Scanner sc = new Scanner(file);

        String direction;
        int value, depth = 0, position = 0, aim = 0;

        while (sc.hasNext()){
            direction = sc.next();
            value = Integer.parseInt(sc.next());

            switch (direction) {
                case "forward" -> {
                    position += value;
                    depth += value * aim;
                }
                case "down" -> aim += value;
                case "up" -> aim -= value;
            }

        }
        System.out.println(position*depth);


    }
}
