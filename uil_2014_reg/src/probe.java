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

public class probe {
    public static void main(String[] args) throws Exception {
        new probe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("probe").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            int sum = 0;
            f.nextLine();
            int[][] m = new int[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            List<Node> al = new ArrayList<>();
            for(int i = 0;i <= n-3;i++){
                for(int j =0;j<=n -3;j++){
                    HashSet<String> hs = new HashSet<>();
                    int area = 0;
                    for(int r = i;r<i+3;r++){
                        for(int c = j;c<j+3;c++){
                            area += m[r][c];
                            hs.add(r+""+c);
                        }
                    }
                    al.add(new Node(area,hs));
                }
            }
            for (int i = 0; i < al.size(); i++) {
                sum = Math.max(al.get(i).val, sum);
                for (int j = 0; j < al.size(); j++) {
                    if(i!=j){
                        int newArea = al.get(j).val;
                        for(String coor : al.get(j).hs){
                            if (al.get(i).hs.contains(coor)) {
                                int r = Integer.parseInt(coor.substring(0,1));
                                int c = Integer.parseInt(coor.substring(1,2));
                                newArea-=m[r][c];
                            }
                        }
                        sum = Math.max(sum, al.get(i).val + newArea);
                    }
                }
            }
            out.println(sum);
        }
        f.close();
    }
    class Node {
        int val;
        HashSet<String> hs;
        public Node(int v, HashSet<String> h){
            val = v;
            hs = h;
        }
    }
}
