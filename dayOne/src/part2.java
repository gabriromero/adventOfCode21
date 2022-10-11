import java.io.File;
import java.util.Scanner;

public class part2
{
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File("dayOne//src//input.txt");
        Scanner sc = new Scanner(file);

        int counter = 0, nextValue = 0,
                firstWindowValue = Integer.parseInt(sc.nextLine()),
                secondWindowValue = Integer.parseInt(sc.nextLine()),
                thirdWindowValue = Integer.parseInt(sc.nextLine());

        while (sc.hasNextLine()){
            nextValue = Integer.parseInt(sc.nextLine());
            if(secondWindowValue+thirdWindowValue+nextValue >
                    firstWindowValue+secondWindowValue+thirdWindowValue) counter++;
            firstWindowValue = secondWindowValue;
            secondWindowValue = thirdWindowValue;
            thirdWindowValue = nextValue;
        }

        System.out.println(counter);

    }
}