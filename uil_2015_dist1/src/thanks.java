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

public class thanks {
    public static void main(String[] args) throws Exception {
        new thanks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("thanks").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt();
            f.nextLine();
            int[] count = new int[3];
            for (int i = 0; i < c; i++) {
                count[0] += f.nextInt();
                count[1] += f.nextInt();
                count[2] += f.nextInt();
            }
            int N = f.nextInt();
            f.nextLine();
            int[][] m = new int[N][4];
            for (int i = 0; i < N; i++) {
                String name = f.next();
                m[i] = new int[]{f.nextInt(),f.nextInt(),f.nextInt(),name.charAt(0)};
            }
            int best = 1000;
            String bestSpecie = null;
            out : for (int i = 0; i < N; i++) {
                int ans = 0;
                for (int j = 0; j < 3; j++) {
                    if(count[j]==0) continue;
                    if(m[i][j]==0) continue out;
                    int require = count[j] / m[i][j];
                    if(count[j] % m[i][j]!=0) require++;
                    ans = Math.max(ans, require);
                }
                if(ans < best){
                    bestSpecie = (char)m[i][3] + "";
                    best = ans;
                }
            }
            out.println(bestSpecie);
        }
        f.close();
    }
}
