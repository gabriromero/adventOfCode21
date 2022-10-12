import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part1 {

    public static List<Integer> parseBingoNumbers(String numbers) {
        List<Integer> bingoNumbers = new LinkedList<>();
        Integer sum = Character.getNumericValue(numbers.charAt(0))*10;

        for(int i = 1; i<numbers.length();i++){
            char cprev = numbers.charAt(i-1), c = numbers.charAt(i);

            if(c == ',') {
                bingoNumbers.add(sum);
                sum=0;
            }
            else if(cprev!=',')
                sum+= Character.getNumericValue(c);
            else
                sum+= Character.getNumericValue(c)*10;
        }

        bingoNumbers.add(sum);

        return bingoNumbers;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dayFour//src//input.txt");
        Scanner sc = new Scanner(file);

        List<Integer> bingoNumbers = parseBingoNumbers(sc.next());

        List<Map<Integer,Map<Integer,Boolean>>> boards = new LinkedList<Map<Integer,Map<Integer,Boolean>>>();

        while (sc.hasNextLine()){
            HashMap<Integer, Map<Integer, Boolean>> board = new HashMap<>();
            Map<Integer,Boolean> nestedBoard = new HashMap<Integer,Boolean>();
            for(int i = 0; i< 5; i++)
                for(int j = 0; j<5;j++){
                    nestedBoard.put(Integer.parseInt(sc.next()),false);
                    board.put(Integer.parseInt(sc.next()),nestedBoard);
                }
            boards.add(board);
        }

        System.out.println("fi");

    }
}