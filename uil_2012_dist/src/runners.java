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

public class runners {
    char[][]m;
    int[][] shadow;
    List<Point> loc;
    List<Runner> al;
    public static void main(String[] args) throws Exception {
        new runners().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("runners").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c= f.nextInt();
            f.nextLine();
            m =new char[r][c];
            shadow = new int[r][c];
            loc = new ArrayList<>();
            al = new ArrayList<>();
            int pr = -1, pc = -1, er = -1, ec = -1;
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                for (int j = 0; j < c; j++) {
                    if ("RTS".contains(m[i][j]+"")) {
                        al.add(new Runner(new Point(i,j),Integer.MAX_VALUE,m[i][j]));
                    }
                    if(ln.charAt(j)=='P'){
                        pr = i;
                        pc = j;
                    }
                    if(ln.charAt(j) == 'J'){
                        er = i;
                        ec = j;
                    }
                }
            }
            int[] vr = {-1,1,0,0};
            int[] vc = {0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                int nr = pr + vr[i];
                int nc = pc + vc[i];
                if(nr>=0&&nc>=0&&nr<r&&nc<c && m[nr][nc]=='.'){
                    loc.add(new Point(nr,nc));
                }
            }
            for(Runner runner : al){
                for(Point p : loc){
                    for (int i = 0; i < r; i++) {
                        Arrays.fill(shadow[i],Integer.MAX_VALUE);
                    }
                    recur(runner.p.x,runner.p.y,0);
                    if(shadow[p.x][p.y]!=Integer.MAX_VALUE){
                        int step =shadow[p.x][p.y];
                        for (int i = 0; i < r; i++) {
                            Arrays.fill(shadow[i],Integer.MAX_VALUE);
                        }
                        recur(p.x,p.y,0);
                        if(shadow[er][ec]!=Integer.MAX_VALUE){
                            step+=shadow[er][ec];
                            runner.s = Math.min(runner.s,step);
                        }
                    }
                }
            }
            int minStep = Integer.MAX_VALUE;
            Map<Integer,List<String>> fastrunner = new TreeMap<>();
            for(Runner runner : al){
                fastrunner.putIfAbsent(runner.s,new ArrayList<>());
                fastrunner.get(runner.s).add(runner.n);
                minStep = Math.min(runner.s,minStep);
            }
            List<String> name = new ArrayList<>(fastrunner.get(minStep));
            Collections.sort(name);
            out.print(minStep +" ");
            for (int i = 0; i < name.size(); i++) {
                out.print(name.get(i) +" ");
            }
            out.println();
        }
        f.close();
    }
    public void recur(int r, int c, int step){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='*' && m[r][c]!='P' &&step<shadow[r][c]){
            if("RTS".contains(m[r][c]+"") && step > 0){
                return;
            }
            char save = m[r][c];
            shadow[r][c] = step;
            m[r][c] = '*';
            recur(r-1,c,step+1);
            recur(r+1,c,step+1);
            recur(r,c-1,step+1);
            recur(r,c+1,step+1);
            m[r][c] = save;
        }
    }
    class Point{
        int x,y;
        public Point(int r,int c){
            x = r;
            y = c;
        }
        public String toString(){
            return "(" + x + "," + y + ")";
        }
    }
    class Runner{
        Point p;
        int s;
        String n;
        public Runner(Point point, int step,char name){
            p = point;
            s = step;
            if(name=='R'){
                n = "RUSSELL";
            }
            if(name == 'T'){
                n = "THOMAS";
            }
            if(name == 'S'){
                n = "SETH";
            }
        }
        public String toString(){
            return n + " - " + p + " - " + s;
        }
    }
}
