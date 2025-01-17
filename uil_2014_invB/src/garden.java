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

public class garden {
    public static void main(String[] args) throws Exception {
        new garden().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("garden").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int col = f.nextInt(), row = f.nextInt(), w = f.nextInt(), h = f.nextInt();
            f.nextLine();
            char[][] m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            int maxArea = 0;
            for (int i = 0; i <= row-h; i++) {
                for (int j = 0; j <= col-w; j++) {
                    int sum = 0;
                    for(int r = i;r < i + h;r++){
                        for (int c = j; c < j+w; c++) {
                            if(m[r][c]=='S') sum++;
                        }
                    }
                    maxArea = Math.max(maxArea, sum);
                }
            }
            out.println(maxArea);
        }
        f.close();
    }
}
