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

public class emily {
    char[][] m;
    List<Point> al;
    int[] vr = {-1,-1,0,1,1,1,0,-1};
    int[] vc = {0,1,1,1,0,-1,-1,-1};
    String[] dir = "N,NE,E,SE,S,SW,W,NW".split(",");
    public static void main(String[] args) throws Exception {
        new emily().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("emily").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        m = new char[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = f.nextLine().replaceAll("[^0-9]","").toCharArray();
        }
        while(f.hasNext()){
            al = new ArrayList<>();
            String ln = f.nextLine();
            out.println("<" + ln + ">");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(m[i][j]==ln.charAt(0)){
                        recur(i,j,ln,0);
                    }
                }
            }
            if(al.isEmpty()){
                out.println("NOT FOUND");
            }
            else{
                for (int i = 0; i < al.size(); i++) {
                    out.println(al.get(i));
                }
            }
        }
        f.close();
    }
    class Point{
        int x,y;
        String d;
        public Point(int r,int c, String direction){
            x = r+1;
            y = c+1;
            d = direction;
        }
        public String toString(){
            return "(" + x + "," + y + ") " + d;
        }
    }
    public boolean recur(int r, int c, String s, int i){
        if(i==s.length()) return false;
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]!='#' && m[r][c] == s.charAt(i)){
            if(i==s.length()-1){
                return true;
            }
            char save = m[r][c];
            m[r][c] = '#';
            for (int j = 0; j < 8; j++) {
                int nr = (r + vr[j])%m.length,nc = (c + vc[j]%m.length);
                if(vr[j]<0){
                    nr = ((r+vr[j])+m.length)%m.length;
                }
                if(vc[j]<0){
                    nc = ((c+vc[j])+m.length)%m.length;
                }
                if (recur(nr, nc, s, i + 1)) {
                    if(i==0){
                        al.add(new Point(r,c,dir[j]));
                    }
                    return true;
                }
            }
            m[r][c] = save;
        }
        return false;
    }
}
