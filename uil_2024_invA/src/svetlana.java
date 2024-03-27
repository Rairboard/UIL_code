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

public class svetlana {
    char[][]m;
    Map<Character,int[]> hm = new HashMap<>();
    public static void main(String[] args) throws Exception {
        new svetlana().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("svetlana").toLowerCase() + ".dat"));
        Scanner f = new Scanner(in);
        int times = f.nextInt();
        f.nextLine();
        for(int t=1;t<=times;t++){
            m = new char[8][];
            f.nextLine();
            Queue<Integer> red = new LinkedList<>(), black = new LinkedList<>();
            for (int i = 0; i < m.length; i++) {
                m[i] = f.nextLine().replaceAll("\\s+","").toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='R'||m[i][j]=='r'){
                        red.add(i);
                        red.add(j);
                    }
                    else if(m[i][j]=='b'||m[i][j]=='B'){
                        black.add(i);
                        black.add(j);
                    }
                }
            }
//            for(char[] cc : m){
//                out.println(cc);
//            }
            int r = move(red,"Bb");
            int b = move(black,"Rr");
            out.println("Test case: " + t);
            out.println("Red valid single moves: " + r);
            out.println("Black valid single moves: " + b);
        }
        f.close();
    }
    public int move(Queue<Integer> q,String opp){
        HashSet<String> nonKing = new HashSet<>();
        HashSet<String> king = new HashSet<>();
        int[] vr = {-1,-1,1,1,};
        int[] vc = {-1,1,-1,1};
        while(!q.isEmpty()){
            int r = q.remove(), c = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = r + vr[i];
                int nc = c + vc[i];
                if(nr>=0&&nr<m.length&&nc>=0&&nc<m[nr].length){
                    if(m[nr][nc]=='_'){
                        if (Character.isLowerCase(m[r][c])) {
                            nonKing.add(nr+""+nc);
                        }else{
                            king.add(nr+""+nc);
                        }
                    }
                    else if(opp.contains(m[nr][nc]+"")){
                        nr+=vr[i];
                        nc+=vc[i];
                        if(nr>=0&&nr<m.length&&nc>=0&&nc<m[nr].length && m[nr][nc]=='_'){
                            if (Character.isLowerCase(m[r][c])) {
                                nonKing.add(nr+""+nc);
                            }else{
                                king.add(nr+""+nc);
                            }
                        }
                    }
                }
            }
        }
        return nonKing.size()+king.size();
    }
}
