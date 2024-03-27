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

public class MagicJellyfishField {
    int[][] m;
    public static void main(String[] args) throws Exception {
        new MagicJellyfishField().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("MagicJellyfishField").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            int r = f.nextInt(), c = f.nextInt();
            f.nextLine();
            m = new int[r][c];
            for (int i = 0; i < r; i++) {
                m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            double max = 0;
            for(int i = 0; i < r;i++){
                for(int j = 0;j < c;j++){
                    for(int x = i;x < r;x++){
                        for(int y = j; y < c;y++){
                            int area = (x-i + 1) * (y - j + 1);
                            int jelly = sum(i,j,x,y);
                            double avg = (double)jelly/area;
                            max = Math.max(max,avg);
                        }
                    }
                }
            }
            out.println(Math.round(max));
        }
        f.close();
    }
    public int sum(int sr, int sc, int er ,int ec){
        int s = 0;
        for (int i = sr; i <= er; i++) {
            for(int j = sc;j<=ec;j++){
                s+=m[i][j];
            }
        }
        return s;
    }
}
