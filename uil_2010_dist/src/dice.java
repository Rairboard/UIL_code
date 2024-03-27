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

public class dice {
    public static void main(String[] args) throws Exception {
        new dice().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dice").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            char[][] m = {"-".repeat(7).toCharArray(),("|" + " ".repeat(5)+"|").toCharArray(),("|" + " ".repeat(5)+"|").toCharArray(),("|" + " ".repeat(5)+"|").toCharArray(),"-".repeat(7).toCharArray()};
            switch(f.nextInt()){
                case 1:
                    m[2][3] = 'o';break;
                case 2:
                    m[1][2] = 'o';
                    m[3][4] = 'o';break;
                case 3:
                    m[2][3] = 'o';
                    m[1][2] = 'o';
                    m[3][4] = 'o';break;
                case 4:
                    m[1][2] = 'o';
                    m[1][4] = 'o';
                    m[3][2] = 'o';
                    m[3][4] = 'o';break;
                case 5:
                    m[1][2] = 'o';
                    m[1][4] = 'o';
                    m[2][3] = 'o';
                    m[3][2] = 'o';
                    m[3][4] = 'o';break;
                case 6:
                    m[1][2] = 'o';
                    m[1][4] = 'o';
                    m[3][2] = 'o';
                    m[3][4] = 'o';
                    m[2][2] = 'o';
                    m[2][4] = 'o';break;
            }
            for(char[] cc : m){
                out.println(cc);
            }
            out.println();
        }
        f.close();
    }
}
