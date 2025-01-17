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
    int[] vr = {-1,1,0,0,-1,-1,1,1};
    int[] vc = {0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) throws Exception {
        new wordsearch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wordsearch").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        f.nextLine();
        String[][] m = new String[n][n];
        for (int i = 0; i < n; i++) {
            m[i] = f.nextLine().trim().split("\\s+");
        }
        int test = f.nextInt();
        f.nextLine();
        for (int t = 0; t < test; t++) {
            String ln = f.nextLine().trim();
            int[] point = new int[2];
            out: for(int r = 0; r < n;r++){
                for(int c = 0;c < n;c++){
                    for(int k = 0;k< 8;k++){
                        String search = "";
                        for(int i =0 ;i < ln.length();i++){
                            int nr = r + vr[k] * i;
                            int nc = c + vc[k] * i;
                            if(nr>=0&&nc>=0&&nr<n&&nc<n){
                                search+=m[nr][nc];
                            }
                        }
                        if (search.equals(ln)) {
                            point = new int[]{r+1,c+1};
                            break out;
                        }
                    }
                }
            }
            out.println(ln + " " + point[0] + " " + point[1]);
        }
        f.close();
    }
}
