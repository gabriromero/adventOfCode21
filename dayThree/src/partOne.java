import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class partOne {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("dayThree//src//input.txt");
        Scanner sc = new Scanner(file);

        String actualValue = sc.nextLine();

        int totalEntries = 0, bitLength = actualValue.length();
        int[] bitCounter = new int[bitLength];

        do{
            if(totalEntries>0)
                actualValue = sc.nextLine();

            for (int i = 0; i < actualValue.length(); i++)
                if(Character.getNumericValue(actualValue.charAt(i)) == 1) bitCounter[i] ++;
            totalEntries++;

        } while(sc.hasNextLine());

        int gammaRate = 0, epsilonRate = 0;
        int actualSquare = (int) Math.pow(2,bitLength);

        for(int i = 0; i< bitCounter.length; i++){
            actualSquare/=2;
            if(bitCounter[i] > totalEntries/2)
                    gammaRate+=actualSquare;
            else    epsilonRate+= actualSquare;
        }

        System.out.println(gammaRate*epsilonRate);

    }
}
