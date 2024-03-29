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

public class chemicals {
    char[][] m;
    int cnt;
    public static void main(String[] args) throws Exception {
        new chemicals().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("chemicals").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), max = 0;
            int[] cor = new int[3];
            f.nextLine();
            m= new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] =f.nextLine().toCharArray();
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(m[i][j]!='.'){
                        cnt = 0;
                        recur(i,j,m[i][j]);
                        if(cnt>  max){
                            max = cnt;
                            cor = new int[]{i,j,m[i][j]-'A'};
                        }
                    }
                }
            }
            if(f.hasNext()) f.nextLine();
            out.println("The biggest spill is " + ((char)(cor[2]+'A') == 'I'? "Iodine":"Phosphorus") + " at (" + cor[0] + ","+ cor[1]+ ")");
        }
        f.close();
    }
    public void recur(int r, int c, char ch){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]==ch){
            m[r][c] = '.';
            cnt++;
            recur(r-1,c,ch);
            recur(r+1,c,ch);
            recur(r,c-1,ch);
            recur(r,c+1,ch);
        }
    }
}
