import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class part1 {
    class Pair<L,R> {
        private L l;
        private R r;
        public Pair(L l, R r){
            this.l = l;
            this.r = r;
        }
        public L getL(){ return l; }
        public R getR(){ return r; }
        public void setL(L l){ this.l = l; }
        public void setR(R r){ this.r = r; }
    }

    public class global {
        public static int counter = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {

        //Parsear cada linea en Pares <0,9> <1,9>

        File file = new File("dayFive//src//input.txt");
        Scanner sc = new Scanner(file);

        List<List<Integer>> inputNumbers = new ArrayList<>();
        Integer maxX = 0, maxY = 0;

        while (sc.hasNextLine()){
            List<Integer> line = new ArrayList<>();
            String[] x1x2 = sc.next().split(",");

            line.add(Integer.parseInt(x1x2[0]));
            line.add(Integer.parseInt(x1x2[1]));
            sc.next();

            String[] y1y2 = sc.next().split(",");
            line.add(Integer.parseInt(y1y2[0]));
            line.add(Integer.parseInt(y1y2[1]));
            inputNumbers.add(line);

            if(maxX< Math.max(Integer.parseInt(x1x2[0]),Integer.parseInt(x1x2[1])))
                maxX = Math.max(Integer.parseInt(x1x2[0]),Integer.parseInt(x1x2[1]));

            if(maxY< Math.max(Integer.parseInt(y1y2[0]),Integer.parseInt(y1y2[1])))
                maxY = Math.max(Integer.parseInt(y1y2[0]),Integer.parseInt(y1y2[1]));
        }

        Integer[][] gridNumbers = new Integer[maxX][maxY];

        initializeGrid(gridNumbers,maxX,maxY);

        for(List<Integer> line : inputNumbers){
            Integer x1 = line.get(0) , x2 = line.get(1) , y1 = line.get(2), y2 = line.get(3);

            if(x1.equals(y1)){
                Integer maxN = Math.max(x2,y2) , minN = Math.min(x2,y2);

                while(!maxN.equals(minN-1)){
                    markPair(x1,maxN,gridNumbers);
                    maxN--;
                }
            }
            else if (x2.equals(y2)) {
                Integer maxN = Math.max(x1,y1) , minN = Math.min(x1,y1);

                while(!maxN.equals(minN-1)){
                    markPair(maxN,x2,gridNumbers);
                    maxN--;
                }
            }


        }

        System.out.println(global.counter);
    }

    private static void initializeGrid(Integer[][] gridNumbers, Integer maxX, Integer maxY) {
        for (int i = 0; i<maxX; i++)
            for (int j = 0; j<maxY; j++)
                gridNumbers[i][j] = 0;
    }

    private static void markPair(Integer col, Integer fil, Integer[][] grid) {
        grid[col-1][fil-1]++;
        if(grid[col-1][fil-1].equals(2))
            global.counter++;

    }
}
