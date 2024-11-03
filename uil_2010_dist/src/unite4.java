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

public class unite4 {
    char[][] board;
    public static void main(String[] args) throws Exception {
        new unite4().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("unite4").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int m = f.nextInt();
            f.nextLine();
            char p = 'R';
            boolean red = false, black = false;
            board = new char[6][7];
            for (int i = 0; i < 6; i++) {
                Arrays.fill(board[i],'O');
            }
            int[] cl = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            outer: for (int i = 0; i < m; i++) {
                int c = cl[i]-1;
                for (int r = board.length-1;r>=0;r--) {
                    if(board[r][c]=='O'){
                        board[r][c] = p;
                        p = p=='R'?'B':'R';
                        int[] vr = {-1,-1,1,1,0,0,-1,1};
                        int[] vc = {-1,1,-1,1,-1,1,0,0};
                        for (int j = 0; j < 8; j++) {
                            int cnt = 0;
                            int nr = r;
                            int nc = c;
                            for (int k = 0; k < 4; k++) {
                                if (valid(nr, nc)) {
                                    if(board[nr][nc]==board[r][c]){
                                        cnt++;
                                    }
                                }
                                else{
                                    break;
                                }
                                nr+=vr[j];
                                nc+=vc[j];
                            }
                            if(cnt==4){
                                if(board[r][c]=='R'){
                                    red = true;
                                }
                                if(board[r][c]=='B'){
                                    black = true;
                                }
                                break outer;
                            }
                        }
                        break;
                    }
                }
            }
            outer: for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 7; c++) {
                    if(board[r][c]=='O') continue;
                    int[] vr = {-1,-1,1,1,0,0,-1,1};
                    int[] vc = {-1,1,-1,1,-1,1,0,0};
                    for (int j = 0; j < 8; j++) {
                        int cnt = 0;
                        int nr = r;
                        int nc = c;
                        for (int k = 0; k < 4; k++) {
                            if (valid(nr, nc)) {
                                if(board[nr][nc]==board[r][c]){
                                    cnt++;
                                }
                            }
                            else{
                                break;
                            }
                            nr+=vr[j];
                            nc+=vc[j];
                        }
                        if(cnt==4){
                            if(board[r][c]=='R'){
                                red = true;
                            }
                            if(board[r][c]=='B'){
                                black = true;
                            }
                            break outer;
                        }
                    }
                }
            }
            out.println(" 1234567");
            for (int k = 0; k < board.length; k++) {
                out.print(k+1);
                out.print(board[k]);
                out.println();
            }
            if(red){
                out.println("RED WINS");
            }
            else if(black){
                out.println("BLACK WINS");
            }
            else{out.println("NO WINNER YET");}
        }
        f.close();
    }
    public boolean valid(int r, int c){
        return r>=0 && r < 6 && c>=0&&c < 7;
    }
}
