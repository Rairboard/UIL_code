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

public class inscribe {
    public static void main(String[] args) throws Exception {
        new inscribe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("inscribe.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int N = f.nextInt();
            char[][] m = new char[N][N];
            char ch = (char)('A' + N/2);
            for (int i = 0; i <= N/2; i++){
                for (int j = i; j < N-i; j++) {
                    m[i][j] = ch;
                    m[j][i] =ch;
                    m[N-i-1][j] = ch;
                    m[j][N-i-1] = ch;
                }
                ch--;
            }
            for(char[] c:m){
                out.println(c);
            }
            out.println();
        }
        f.close();
    }
}
