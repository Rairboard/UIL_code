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

public class platform {
    char[][] m;
    String sign = "^v<>";
    int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    boolean reach;
    Map<Integer,List<int[]>> point;
    public static void main(String[] args) throws Exception {
        new platform().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("platform").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            int[][] id = new int[row][col];
            reach = false;
            int cnt = 0;
            int start = -1;
            point = new HashMap<>();
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if ("^v<>x".contains(m[i][j] + "")) {
                        id[i][j] = cnt++;
                        if(i==0 && j==0){
                            start = cnt;
                        }
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='x'){
                        point.put(id[i][j], new ArrayList<>());
                        for (int k = 0; k < 4; k++) {
                            int r = i + direction[k][0], c = j + direction[k][1];
                            if(r>=0&&c>=0&&r<m.length&&c<m[r].length && "^v<>x".contains(m[r][c]+"")){
                                point.get(id[i][j]).add(new int[]{r,c,id[r][c]});
                            }
                        }
                    } else if ("^v<>".contains(m[i][j] + "")) {
                        point.put(id[i][j], new ArrayList<>());
                        int index = sign.indexOf(m[i][j]);
                        int r = i + direction[index][0], c = j + direction[index][1];
                        while(r < m.length&&c<m[r].length){
                            if(m[r][c]!='.'){
                                point.get(id[i][j]).add(new int[]{r,c,id[r][c]});
                                break;
                            }
                            r += direction[index][0];
                            c += direction[index][1];
                        }
                    }
                }
            }
            if(start==-1) out.println("NO");
            else {
                recur(start,0,0, new HashSet<Integer>());
                if(reach) out.println("YES");
                else out.println("NO");
            }
        }
        f.close();
    }
    public void recur(int cur,int r,int c,Set<Integer> visited){
        if(visited.contains(cur)) return;
        if(r==m.length-1&&c==m[r].length-1){
            reach = true;
            return;
        }
        visited.add(cur);
        if(point.get(cur)==null) return;
        for(int[] neighbor : point.get(cur)){
            recur(neighbor[2],neighbor[0],neighbor[1],visited);
        }
        visited.remove(cur);
    }
}
