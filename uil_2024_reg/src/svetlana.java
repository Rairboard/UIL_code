import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class svetlana {
    public static void main(String[] args) throws Exception {
        new svetlana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("svetlana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        String target = "12345678 ";
        int[] vr = {-1,1,0,0};
        int[] vc = {0,0,-1,1};
        for (int asdf = 1; asdf <= times; asdf++) {
            f.nextLine();
            String[][] m = new String[3][3];
            for (int i = 0; i < 3; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int j = 0; j < 3; j++) {
                    if (ln[j].equals("-1")) {
                        m[i][j] = " ";
                    }
                    else{
                        m[i][j] = ln[j];
                    }
                }
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(new Node(m, 0));
            Map<String,Integer> shadow = new HashMap<>();
            shadow.put(q.peek().config,Integer.MAX_VALUE);
            shadow.put(target, Integer.MAX_VALUE);
            while(!q.isEmpty()){
                Node n = q.remove();
                int r = n.r;
                int c = n.c;
                String[][] board = n.board;
//                for (int i = 0; i < board.length; i++) {
//                    out.println(Arrays.toString(board[i]));
//                }
//                out.println(n.move);
                if(shadow.get(n.config)!=null && n.move >= shadow.get(n.config)) continue;
                shadow.put(n.config,n.move);
                if(n.config.equals(target)) break;
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    if(nr>=0&&nc>=0&&nr<board.length&&nc<board[nr].length){
                        String[][] copy = new String[3][3];
                        for (int j = 0; j < 3; j++) {
                            for (int k = 0; k < 3; k++) {
                                copy[j][k] = board[j][k];
                            }
                        }
                        String tmp = copy[nr][nc];
                        copy[nr][nc] = " ";
                        copy[r][c] = tmp;
                        q.offer(new Node(copy, n.move+1));
                    }
                }
            }
            if(shadow.get(target)==Integer.MAX_VALUE) out.println("No solution exists.");
            else out.println("Number of steps needed to solve: " + shadow.get(target));
        }
        f.close();
    }
    class Node{
        String[][] board;
        int move;
        String config;
        int r, c;
        public Node(String[][] m, int mo){
            board = m;
            move = mo;
            config = "";
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    config+=board[i][j];
                    if (board[i][j].equals(" ")) {
                        r = i;
                        c = j;
                    }
                }
            }
        }
    }
}
