import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class filip {
    public static void main(String[] args) throws Exception {
        new filip().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("filip").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            char c = f.next().charAt(0);
            boolean fill = f.nextBoolean();
            char[][] m = new char[row][col];
            for (int i = 0; i < row; i++) {
                Arrays.fill(m[i], c);
            }
            if(!fill){
                for(int i = 1; i < row-1;i++){
                    for(int j = 1;j<col-1;j++){
                        m[i][j]=' ';
                    }
                }
            }
            for(char[] cc : m)
                out.println(cc);
        }
        f.close();
    }
}
