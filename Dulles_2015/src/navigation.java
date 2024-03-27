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

public class navigation {
    char[][][]m;
    int[][][] shadow;
    int min;
    boolean solved;
    Map<Integer,List<Point>> hm;
    Map<Integer,Integer> end;
    int[] vl = {-1,1,0,0,0,0};
    int[] vr = {0,0,-1,1,0,0};
    int[] vc = {0,0,0,0,-1,1};
    class Point{
        int l,x,y,d,id;
        public Point(int layer,int row ,int col,int identity){
            l = layer;
            x = row;
            y = col;
            id = identity;
        }
        public Point(int layer, int row, int col, int distance,int identity){
            l = layer;
            x = row;
            y = col;
            d = distance;
            id = identity;
        }
        public boolean equals(Point o){
            return l == o.l && x == o.x && y == o.y;
        }
        public String toString(){
            return id + " " + "(" + l + "," + x + "," + y + ") -> " + d;
        }
    }
    public static void main(String[] args) throws Exception {
        new navigation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("navigation.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while(times-->0){
            int N = f.nextInt(),sl = -1, sr = -1, sc = -1,star = 1;
            f.nextLine();
            m = new char[N][N][N];
            shadow = new int[N][N][N];
            solved = false;
            min = Integer.MAX_VALUE;
            hm = new HashMap<>();
            end = new HashMap<>();
            List<Point> loc = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    String ln = f.nextLine();
                    for (int k = 0; k < ln.length(); k++) {
                        if(ln.charAt(k)=='B'){
                            sl = i;
                            sr = j;
                            sc = k;
                            loc.add(new Point(i,j,k,-1));
                        }
                        if(ln.charAt(k)=='*'){
                            loc.add(new Point(i,j,k,star++));
                        }
                        m[i][j][k] = ln.charAt(k);
                    }
                }
            }
            // setting adjacent point of an asteroid to @ to account for extra step
            for(Point p : loc){
                if(m[p.l][p.x][p.y]=='*'){
                    for (int i = 0; i < 6; i++) {
                        int nl = p.l + vl[i];
                        int nr = p.x + vr[i];
                        int nc = p.y + vc[i];
                        try{
                            if(m[nl][nr][nc]!='*'&&m[nl][nr][nc]!='x'){
                                m[nl][nr][nc] = '@';
                            }
                        }catch(Exception e){}
                    }
                }
            }
            for(Point p : loc){
                // resetting shadow
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                    }
                }
                // finding minimum distance between current point to other point (starting point and other asteroid)
                find(p.l,p.x,p.y,0);
                List<Point> edges = new ArrayList<>();
                for(Point point : loc){
                    // checking if it's not the same as our current point and if that point is reachable
                    if(!p.equals(point) && shadow[point.l][point.x][point.y]!=Integer.MAX_VALUE){
                        edges.add(new Point(point.l,point.x,point.y,shadow[point.l][point.x][point.y],point.id));
                    }
                }
                hm.put(p.id,edges);
            }
            // finding distance between each point back to starting point
            for(Point p : hm.get(-1)){
                end.put(p.id,p.d);
            }
            HashSet<Integer> visited = new HashSet<>();
            recur(-1,sl,sr,sc,0,0,visited);
            out.println(min);
        }
        f.close();
    }
    public void find(int l,int r, int c, int step){
        if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&step<shadow[l][r][c]&&m[l][r][c]!='x'){
            char save = m[l][r][c];
            m[l][r][c] = 'x';
            shadow[l][r][c] = step;
            for (int i = 0; i < 6; i++) {
                // if point adjacent to an asteroid take 3 step instead of 2
                if(save == '@'){
                    find(l+vl[i],r + vr[i],c + vc[i],step+3);
                }else{
                    // otherwise take only 2 step
                    find(l+vl[i],r + vr[i],c + vc[i],step+2);
                }
            }
            m[l][r][c] = save;
        }
    }
    public void recur(int cur,int l, int r, int c, int step,int ast,HashSet<Integer> visited){
        if(m[l][r][c]=='*' && ast + 1== 6){
            min = Math.min(step+end.get(cur),min);
            return;
        }
        visited.add(cur);
        for(Point p : hm.get(cur)){
           if(!visited.contains(p.id)){
               if(m[l][r][c]=='*'){
                   recur(p.id,p.l,p.x,p.y,step+p.d,ast+1,visited);
               }else{
                   recur(p.id,p.l,p.x,p.y,step+p.d,ast,visited);
               }
           }
        }
        visited.remove(cur);
    }
}
