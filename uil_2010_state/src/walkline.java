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

public class walkline {
    public static void main(String[] args) throws Exception {
        new walkline().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("walkline").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[][] point = new int[4][2];
            for (int i = 0; i < 4; i++) {
                point[i] = new int[]{f.nextInt(),f.nextInt()};
            }
            int collinearPoint = 2;
            for(int i = 0;i < point.length;i++){
                for(int j = i+1;j<point.length;j++){
                    double dy = point[i][1] - point[j][1];
                    double dx = point[i][0] - point[j][0];
                    try{
                        double slope = dy/dx;
                        double b = slope * (-point[i][0]) + point[i][1];
                        int cnt = 0;
                        for(int k = 0;k < point.length;k++){
                            if(k!=i && k != j){
                                if(point[k][0] * slope + b == point[k][1]){
                                    cnt++;
                                }
                            }
                        }
                        collinearPoint = Math.max(collinearPoint, 2+cnt);
                    }
                    catch(Exception e){}
                }
            }
            int pointOnHorizontal = 1;
            for(int i = 1;i<point.length;i++){
                double dx = point[0][0] - point[i][0];
                if(dx==0){
                    pointOnHorizontal++;
                }
            }
            collinearPoint = Math.max(collinearPoint, pointOnHorizontal);
            if(collinearPoint == 4){
                out.println(1);
            }
            else if(collinearPoint == 3){
                out.println(4);
            }
            else if(collinearPoint == 2){
                out.println(6);
            }
        }
        f.close();
    }
}
