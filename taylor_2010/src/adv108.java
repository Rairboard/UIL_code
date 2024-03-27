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

public class adv108 {
    char[][] m;
    Map<Integer,List<Edge>> hm;
    int[][] shadow;
    int min;
    public static void main(String[] args) throws Exception {
        
        new adv108().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv108").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<Point> loc = new ArrayList<>();
            int row = f.nextInt(), col = f.nextInt(), ck = 0;
            f.nextLine();
            m = new char[row][col];
            shadow = new int[row][col];
            hm = new HashMap<>();
            min = Integer.MAX_VALUE;
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='>' || m[i][j] == '<'){
                        loc.add(new Point(i,j,-1));
                    }
                    if(m[i][j] == 'C'){
                        loc.add(new Point(i,j,++ck));
                    }
                    if(m[i][j] == 'S'){
                        loc.add(new Point(i,j,-2));
                    }
                    if(m[i][j] == 'F'){
                        loc.add(new Point(i,j,-3));
                    }
                }
            }
            for(int i = loc.size()-1;i>-1;i--){
                if(m[loc.get(i).x][loc.get(i).y]=='<'){
                    int R = loc.get(i).x, C = loc.get(i).y-1;
                    while(C > -1 && m[R][C] != '*'){
                        m[R][C--] = '*';
                    }
                    loc.remove(i);
                }
                else if(m[loc.get(i).x][loc.get(i).y] == '>'){
                    int R = loc.get(i).x, C = loc.get(i).y+1;
                    while(C<col && m[R][C] != '*'){
                        m[R][C++] = '*';
                    }
                    loc.remove(i);
                }
            }
            for(Point point : loc){
                int r = point.x , c = point.y;
                for (int i = 0; i < row; i++) {
                    Arrays.fill(shadow[i],Integer.MAX_VALUE);
                }
                fill(r,c,0);
                List<Edge> edges = new ArrayList<>();
                for(Point p : loc){
                    if(!point.equals(p) && shadow[p.x][p.y] != Integer.MAX_VALUE){
                        edges.add(new Edge(point,p,shadow[p.x][p.y]));
                    }
                }
                hm.put(point.id, edges);
            }
            HashSet<Integer> visited = new HashSet<>();
            recur(-2,0,0,ck,visited);
            out.println(min);
        }
        f.close();
    }
    public void recur(int cur, int step,int ck,int total,HashSet<Integer> visited){
        if(!visited.contains(cur)){
            if(cur==-3){
                if(ck == total){
                    min = Math.min(min,step);
                }
                return;
            }
            if(hm.get(cur)==null) return;
            visited.add(cur);
            for(Edge e : hm.get(cur)){
                if(cur>=0){
                    recur(e.b.id,step+e.w,ck+1,total,visited);
                }
                else{
                    recur(e.b.id,step+e.w,ck,total,visited);
                }
            }
            visited.remove(cur);
        }
    }
    public void fill(int r, int c, int step){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]!='*'&&m[r][c]!='<' && m[r][c]!='>' && step<shadow[r][c]){
            char save = m[r][c];
            shadow[r][c] = step;
            fill(r-1,c,step+1);
            fill(r+1,c,step+1);
            fill(r,c-1,step+1);
            fill(r,c+1,step+1);
            m[r][c] = save;
        }
    }
    class Edge{
        Point a,b;
        int w;
        public Edge(Point a, Point b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    class Point{
        int x, y, id;
        public Point(int x, int y, int id){
            this.x = x;
            this.y = y;
            this.id = id;
        }
        public boolean equals(Point p){
            return x == p.x && y == p.y;
        }
        public String toString(){
            return "(" + x + "," + y + ")" + " - " + id;
        }
    }
}
