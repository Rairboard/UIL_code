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

public class wordsearch {
    char[][] m;
    Point p;
    int[] vr = {-1,-1,-1,0,0,1,1,1};
    int[] vc = {-1,0,1,1,-1,1,0,-1};
    public static void main(String[] args) throws Exception {
        new wordsearch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wordsearch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        m = new char[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = f.nextLine().replaceAll("\\s+","").toCharArray();
        }
        n = f.nextInt();
        f.nextLine();
        while(n-->0){
            p = new Point();
            String ln = f.nextLine();
            outer : for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    if (m[i][j] == ln.charAt(0)) {
                        if (find(i, j, ln, 0)) {
                            p = new Point(i,j);
                            break outer;
                        }
                    }
                }
            }
            out.println(ln + " " + p);
        }
        f.close();
    }
    public boolean find(int r, int c, String s, int in){
        for (int i = 0; i < 8; i++) {
            int cr = r,cc = c, ind = in;
            while (cr >= 0 && cr < m.length && cc >= 0 && cc < m[cr].length && m[cr][cc] == s.charAt(ind)) {
                if(ind==s.length()-1){
                    return true;
                }
                cr+=vr[i];
                cc+=vc[i];
                ind++;
            }
        }
        return false;
    }
    class Point{
        int x , y;
        public Point(){
            x = 0;
            y = 0;
        }
        public Point(int r, int c){
            x = r+1;
            y = c+1;
        }
        public String toString(){
            return x + " " + y;
        }
    }
}
