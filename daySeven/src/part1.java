import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class part1 {
    public static List<Integer> parseNumbers(String numbers) {
        global.maxValue = 0;
        List<Integer> bingoNumbers = new LinkedList<>();

        for( String part : numbers.split(",")){
            Integer n = Integer.parseInt(part);
            if(global.maxValue < n) global.maxValue = n;
            bingoNumbers.add(n);
        }

        return bingoNumbers;
    }

    public class global {
        public static List<Integer> numbers = new ArrayList<>();
        public static Integer maxValue;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("daySeven//src//input.txt");
        Scanner sc = new Scanner(file);

        global.numbers = parseNumbers(sc.next());
        Integer minNumber = sumDiff(0);

        Integer i =1;

        while(minNumber> sumDiff(i)){
            minNumber = sumDiff(i);
            i++;
        }

        System.out.println(minNumber);

    }

    private static Integer sumDiff(int i) {
        Integer sum = 0;
        for(Integer n : global.numbers)
            sum+= Math.abs(i-n);

        return sum;
    }
}
