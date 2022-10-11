import java.io.File;
import java.util.Scanner;

public class part1
{
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File("src//input.txt");
        Scanner sc = new Scanner(file);

        int counter = 0, nextValue = 0;
        int actualValue = Integer.parseInt(sc.nextLine());

        while (sc.hasNextLine()){
            nextValue = Integer.parseInt(sc.nextLine());
            if(nextValue>actualValue) counter++;
            actualValue = nextValue;
        }

        System.out.println(counter);

    }
}