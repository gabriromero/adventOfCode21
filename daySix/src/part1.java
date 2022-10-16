package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class part1 {

    public static List<Integer> parseNumbers(String numbers) {
        numbers+=',';
        List<Integer> bingoNumbers = new LinkedList<>();

        Integer sum = 0;
        for (int i = 0; i < numbers.length()-1; i++) {
            char actual = numbers.charAt(i), next = numbers.charAt(i+1);
            if(actual!=',' && next !=',')
                sum+= Character.getNumericValue(actual) * 10;
            else if(actual!=',' && next == ',')
                sum+= Character.getNumericValue(actual);
            else {
                bingoNumbers.add(sum);
                sum=0;
            }
        }
        bingoNumbers.add(sum);

        return bingoNumbers;
    }


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("daySix//src//input.txt");
        Scanner sc = new Scanner(file);

        List<Integer> numbers = parseNumbers(sc.next());

        Double[] freq = new Double[9];

        for (int i = 0; i < 9; i++)
            freq[i] = 0.0;

        for (Integer n : numbers)
            freq[n]++;

        for(int i = 0; i< 256; i++){
            Double zeros = freq[0];

            for(int j = 1;j<9;j++)
                freq[j-1] = freq[j];

            freq[8] = zeros;
            freq[6] += zeros;


        }

        Double count = 0.0;

        for (int i = 0; i < 9; i++)
            count+= freq[i];

        System.out.printf("count: %f\n",count);
    }


}
