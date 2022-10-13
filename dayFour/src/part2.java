import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class part2 {

    class Pair
    {
        public static <T, U> Map.Entry<T, U> of(T first, U second) {
            return new AbstractMap.SimpleEntry<>(first, second);
        }
    }

    public static List<Integer> parseBingoNumbers(String numbers) {
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

    private static void readBoards(List<Map.Entry<List<List<Map.Entry<Integer, Boolean>>>, Boolean>> boards, Scanner sc) {
        while (sc.hasNextLine()){
            List<List<Map.Entry<Integer, Boolean>>> board = new LinkedList<>();
            for(int i = 0; i< 5; i++) {
                List<Map.Entry<Integer, Boolean>> boardEntry = new ArrayList<>();
                for (int j = 0; j < 5; j++)
                    boardEntry.add(Pair.of(Integer.parseInt(sc.next()), false));

                board.add(boardEntry);

            }
            boards.add(Pair.of(board,false));
        }
    }

    public static void markBoard(List<List<Map.Entry<Integer, Boolean>>> board, Integer num){
        for (List< Map.Entry<Integer,Boolean>> entryBoard : board){
            for (Map.Entry<Integer,Boolean> entryNumber : entryBoard){
                if(entryNumber.getKey().equals(num))
                    entryNumber.setValue(true);
            }
        }
    }

    public static Integer checkWin(List<List< Map.Entry<Integer,Boolean>>> board){

        Integer sum = 0;
        Boolean win = false, line = true , col1 = true, col2 = true, col3 = true,
                col4 = true, col5 = true;

        for (List< Map.Entry<Integer,Boolean>> entryBoard : board){
            for (int i = 0; i < entryBoard.size(); i++) {
                Map.Entry<Integer, Boolean> entryNumber = entryBoard.get(i);
                if (entryNumber.getValue().equals(false))
                    line = false;
                if (entryNumber.getValue().equals(false) && i==0)
                    col1 = false;
                else if (entryNumber.getValue().equals(false) && i==1)
                    col2 = false;
                else if (entryNumber.getValue().equals(false) && i==2)
                    col3 = false;
                else if (entryNumber.getValue().equals(false) && i==3)
                    col4 = false;
                else if (entryNumber.getValue().equals(false) && i==4)
                    col5 = false;
            }

            if(line) win = true;
            else    line = true;

        }
        if(col1 || col2 || col3 || col4 || col5) win = true;

        if (win){
            for (List< Map.Entry<Integer,Boolean>> entryBoard : board){
                for (Map.Entry<Integer,Boolean> entryNumber : entryBoard){
                    if(entryNumber.getValue().equals(false))
                        sum+= entryNumber.getKey();
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dayFour//src//input.txt");
        Scanner sc = new Scanner(file);

        List<Integer> bingoNumbers = parseBingoNumbers(sc.next());
        List<Map.Entry<List<List<Map.Entry<Integer,Boolean>>>,Boolean>> boards = new LinkedList<>();

        readBoards(boards,sc);

        Integer winCount = 0;
        for(Integer n : bingoNumbers){
            for(Map.Entry<List<List<Map.Entry<Integer,Boolean>>>,Boolean> board: boards){
                markBoard(board.getKey(),n);
                if(checkWin(board.getKey())>0 && !board.getValue()){
                    board.setValue(true);
                    winCount++;
                    if(winCount.equals(100))
                        System.out.println(checkWin(board.getKey())* n );
                }

            }
        }

    }




}