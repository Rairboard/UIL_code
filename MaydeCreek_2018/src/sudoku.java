import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class sudoku {
    boolean[][] v;
    String[][][] need ;
    List<int[]> pos;

    public static void main(String[] args) throws Exception {
        new sudoku().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sudoku").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int[][] board = new int[9][9];
            v = new boolean[9][9];
            need = new String[9][9][2];
            pos = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                Arrays.fill(v[i],false);
                board[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            for (int r = 0; r < 9; r++) {
                need[r] = new String[9][2];
                for (int c = 0; c < 9; c++) {
                    need[r][c]= new String[2];
                    if(board[r][c]==0){
                        pos.add(new int[]{r,c});
                        List<Integer> al = new ArrayList<>();
                        for (int i = 0; i < 9; i++) {
                            al.add(board[i][c]);
                        }
                        for (int i = 1; i <= 9; i++) {
                            if(!al.contains(i)){
                                need[r][c][0]+=i+"";
                            }
                        }
                        al.clear();
                        for (int i = 0; i < 9; i++) {
                            al.add(board[r][i]);
                        }
                        for (int i = 1; i <= 9; i++) {
                            if (!al.contains(i)) {
                                need[r][c][1]+=i+"";
                            }
                        }
                    }
                }
            }
            List<Integer> al = new ArrayList<>();
            for(int i  = 1;i<=9;i++){
                al.add(i);
            }
            for (int i = 0; i < pos.size(); i++) {
                recur(i,al,new HashSet<Integer>());
            }
        }
        f.close();
    }
    public void recur(int index, List<Integer> al, Set<Integer> visited){
        if(index==pos.size()) return;
        
    }
}
