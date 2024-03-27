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

public class magic {
    public static void main(String[] args) throws Exception {
        new magic().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("magic").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
         while(times-->0){
            int[][]  m= new int[4][4];
            int[] value = new int[6];
             for (int i = 0; i < m.length; i++) {
                 m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
             }
             boolean solved = true;
             for (int i = 0; i < m.length; i++) {
                 int row = 0, col = 0;
                 for (int j = 0; j < m[i].length; j++) {
                     row+=m[i][j];
                     col+=m[j][i];
                 }
                 if(value[0]!=0 && value[0] != row){
                     solved = false;
                     break;
                 }
                 else{
                     value[0] = row;
                 }
                 if(value[1]!=0 && value[1]!=col){
                     solved = false;
                     break;
                 }
                 else{
                     value[1] = col;
                 }
             }
             int v = 0, h = 0;
             for (int i = 1; i < m.length-1; i++) {
                 v += m[0][i] + m[m.length-1][i];
                 h+=m[i][0] + m[i][m.length-1];
             }
             value[2] = v;
             value[3] = h;
             value[4] = m[1][1] + m[1][2] + m[2][1] + m[2][2];
             value[5] = m[0][0] + m[0][3] + m[3][0] + m[3][3];
             for (int i = 0; i < value.length-1; i++) {
                 solved = value[i] == value[i+1];
             }
             out.println(solved? value[0] + " MAGIC":"NOT MAGIC");
         }
        f.close();
    }
}
