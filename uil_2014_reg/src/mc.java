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

public class mc {
    public static void main(String[] args) throws Exception {
        new mc().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mc").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int P = f.nextInt(), M = f.nextInt();
        f.nextLine();
        double[][] m = new double[P][2];
        for (int i = 0; i < P; i++) {
            m[i] = new double[]{f.nextDouble(), f.nextDouble()};
        }
        for (int i = 0; i < M; i++) {
            int p = f.nextInt()-1;
            double dx = f.nextDouble(), dy = f.nextDouble();
            double nx = m[p][0] + dx, ny = m[p][1] + dy;
            boolean canMove = true;
            for (int j = 0; j < P; j++) {
                if(j!=p){
                    double distance = Math.sqrt(Math.pow(nx - m[j][0],2) + Math.pow(ny-m[j][1],2));
                    if(distance<1){
                        canMove = false;
                        break;
                    }
                }
            }
            if(canMove){
                m[p] = new double[]{nx,ny};
            }
        }
        for (int i = 0; i < P; i++) {
            out.printf("%.3f %.3f\n", m[i][0], m[i][1]);
        }
        f.close();
    }
}
