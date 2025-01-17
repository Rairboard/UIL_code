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

public class odd {
    public static void main(String[] args) throws Exception {
        new odd().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("odd").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int oddNum = f.nextInt();
            int n = 0;
            for(int i = 1;i<=oddNum;i+=2){
                n+=i;
            }
            out.println(n * n - (n-3) * (n-3));
        }
        f.close();
    }
}
