import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class partTwo {

    public static Integer binToDec(String binary){
        Integer actualSquare = (int) Math.pow(2,binary.length());
        Integer sum = 0;

        for(int i = 0; i< binary.length(); i++){
            actualSquare/=2;
            if(binary.charAt(i) == '1')
                sum+= actualSquare;
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("dayThree//src//input.txt");
        Scanner sc = new Scanner(file);

        List<String> oxigenAllValues = new ArrayList<String>();
        List<String> co2AllValues = new ArrayList<String>();

        List<String> oxigenZeroValues = new ArrayList<String>();
        List<String> oxigenOneValues = new ArrayList<String>();
        List<String> co2ZeroValues = new ArrayList<String>();
        List<String> co2OneValues = new ArrayList<String>();

        while(sc.hasNextLine())
            oxigenAllValues.add(sc.nextLine());

        co2AllValues.addAll(oxigenAllValues);

        Integer bitLength = oxigenAllValues.get(0).length();

        for(int i = 0; i<bitLength;i++) {

            for (int j = 0; j < oxigenAllValues.size(); j++) {
                if(oxigenAllValues.get(j).charAt(i) == '0')
                    oxigenZeroValues.add(oxigenAllValues.get(j));
                else
                    oxigenOneValues.add(oxigenAllValues.get(j));
            }
            oxigenAllValues.clear();


            if(co2AllValues.size()!=1) {
                for (int j = 0; j < co2AllValues.size(); j++) {
                    if (co2AllValues.get(j).charAt(i) == '0')
                        co2ZeroValues.add(co2AllValues.get(j));
                    else
                        co2OneValues.add(co2AllValues.get(j));
                }
                co2AllValues.clear();
            }


            if(oxigenZeroValues.size() > oxigenOneValues.size())
                oxigenAllValues.addAll(oxigenZeroValues);
            else
                oxigenAllValues.addAll(oxigenOneValues);


            if(co2ZeroValues.size() <= co2OneValues.size() || (!co2ZeroValues.isEmpty() && co2OneValues.isEmpty()))
                co2AllValues.addAll(co2ZeroValues);
            else
                co2AllValues.addAll(co2OneValues);

            oxigenZeroValues.clear();
            oxigenOneValues.clear();
            co2ZeroValues.clear();
            co2OneValues.clear();

        }

        System.out.println(binToDec(oxigenAllValues.get(0)) * binToDec(co2AllValues.get(0)));

    }
}
