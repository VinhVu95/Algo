package codepractice;

/**
 * Created by Vu Anh Vinh on 4/11/2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakesAndLadders {
    static int minMoves;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try{
            File f = new File("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\codepractice\\SnakesAndLadders.txt");
            Scanner scan = new Scanner(f);
            int T = scan.nextInt();
            for (int i = 0; i < T; i++)
            {
                int N = scan.nextInt();
                Map<Integer,Integer> ladders = new HashMap<Integer,Integer>();
                for(int j = 0; j < N;j++)
                {
                    int start = scan.nextInt();
                    int end = scan.nextInt();
                    ladders.put(start,end);
                }
                int M = scan.nextInt();
                Map<Integer,Integer> snakes = new HashMap<Integer,Integer>();
                for(int j = 0; j < M; j++)
                {
                    int start = scan.nextInt();
                    int end = scan.nextInt();
                    snakes.put(start,end);
                }
                minMoves = Integer.MAX_VALUE;
                int[] moves = {0};
                makeAMove(ladders,snakes,1,moves);
                if(minMoves < 10000)
                    System.out.println(minMoves);
                else
                    System.out.println(-1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void makeAMove(Map<Integer,Integer> ladders,Map<Integer,Integer> snakes,int cell,int[] moves){
        if(cell == 100)
        {
            minMoves = Math.min(minMoves,moves[0]);
            System.out.println(minMoves);
            return;
        }
        if(moves[0] > 10000)
        {
            System.out.println("infinite loop");
            return;
        }
        for(int i = 1; i <= 6;i++)
        {
            if(cell + i <= 100)
            {
                cell += i;
                moves[0]++;
                int preMove = moves[0];
                int prev = cell;
                if(ladders.containsKey(cell))
                    cell = ladders.get(cell);
                if(snakes.containsKey(cell))
                    cell = snakes.get(cell);
                makeAMove(ladders,snakes,cell,moves);
                cell = prev - i;
                moves[0] = preMove - 1;
            }
        }
    }


}
