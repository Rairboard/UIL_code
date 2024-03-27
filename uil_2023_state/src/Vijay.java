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

public class Vijay {
    char[][][] m;
    int[][][] identity;
    int[][][] shadow;
    int min;
    boolean solved;
    HashMap<Integer,List<Point>> hm;
    public static void main(String[] args) throws Exception {
        new Vijay().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Vijay").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int l = f.nextInt(), r = f.nextInt(), c = f.nextInt(), o = f.nextInt(),t = f.nextInt();
            int sl = -1, sr = -1, sc = -1,O = 1;
            f.nextLine();
            m =new char [l][r][c];
            shadow = new int[l][r][c];
            identity = new int[l][r][c];
            min = Integer.MAX_VALUE;
            solved = false;
            hm = new HashMap<>();
            // loc list for storing position of starting, ending, and cds
            List<Point> loc = new ArrayList<>();
            for (int ll = 0; ll < l; ll++) {
                for (int i = 0; i < r; i++) {
                    String ln = f.nextLine();
                    for (int j = 0; j < ln.length(); j++) {
                        if(ln.charAt(j)=='S'){
                            sl = ll;
                            sr = i;
                            sc = j;
                            loc.add(new Point(ll,i,j));
                            identity[ll][i][j]=-1;
                        }
                        if(ln.charAt(j)=='O'){
                            loc.add(new Point(ll,i,j));
                            identity[ll][i][j]=O++;
                        }
                        if(ln.charAt(j)=='E'){
                            loc.add(new Point(ll,i,j));
                        }
                        m[ll][i][j]= ln.charAt(j);
                    }
                }
            }
            for (int layer = 0; layer < l; layer++) {
                for (int row = 0; row < r; row++) {
                    for (int col = 0; col < c; col++) {
                        // checking if current point is the starting position or a cd we must pick up
                        if("OS".contains(m[layer][row][col]+"")){
                            for (int i = 0; i < l; i++) {
                                for (int j = 0; j < r; j++) {
                                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                                }
                            }
                            // finding minimum step from current point to start,end,other cds
                            find(layer,row,col,0);
                            List<Point> edges = new ArrayList<>();
                            for(Point p : loc){
                                // checking if point p is not our current location and check if we can actually reach point p -> by checking != Integer.MAX_VALUE
                                if (!p.equals(layer, row, col) && shadow[p.l][p.x][p.y]!=Integer.MAX_VALUE) {
                                    edges.add(new Point(p.l,p.x,p.y,shadow[p.l][p.x][p.y],identity[p.l][p.x][p.y]));
                                }
                            }
                            hm.put(identity[layer][row][col],edges);
                        }
                    }
                }
            }
            HashSet<Integer> visited = new HashSet<>();
            recur(identity[sl][sr][sc],sl,sr,sc,0,o,visited);
            // if we can reach E and minimum step is less than or equal to required time then we pass
            out.println(solved && min<=t? "# of steps achieved: " + min :"None shall pass.");
        }
        f.close();
    }
    class Point{
        int l,x,y,dis, id;
        public Point(int ll, int r, int c){
            l = ll;
            x = r;
            y = c;
        }
        public Point(int ll,int r,int c, int distance,int ids){
            l = ll;
            x = r;
            y = c;
            dis = distance;
            id = ids;
        }
        public boolean equals(int ll,int r,int c){
            return l == ll && x == r && y == c;
        }
        public String toString(){
            return id + " - (" + l + "," + x + "," + y + ") -> " + dis;
        }
    }
    public void find(int l, int r, int c, int step){
        if(l>=0&&l<m.length&&r>=0&&r<m[l].length&&c>=0&&c<m[l][r].length&&m[l][r][c]!='#'&&step<shadow[l][r][c]){
            char save = m[l][r][c];
            m[l][r][c] = '#';
            shadow[l][r][c] = step;
            find(l-1,r,c,step+1);
            find(l+1,r,c,step+1);
            find(l,r-1,c,step+1);
            find(l,r+1,c,step+1);
            find(l,r,c-1,step+1);
            find(l,r,c+1,step+1);
            m[l][r][c] = save;
        }
    }
    public void recur(int cur, int l, int r, int c, int step,int jw,HashSet<Integer> visited){
        if(m[l][r][c]=='E'){
            solved = true; // solved checking if we can reach E
            if(jw==0){
                min = Math.min(min,step); // min is storing the minimum step to get to E
            }
            return;
        }
        visited.add(cur);
        for(Point p : hm.get(cur)){
            if (!visited.contains(p.id)) {
                if(m[l][r][c]=='O'){
                    recur(p.id,p.l,p.x,p.y,step+p.dis,jw-1,visited);
                }else{
                    recur(p.id,p.l,p.x,p.y,step+p.dis,jw,visited);
                }
            }
        }
        visited.remove(cur);
    }
}
