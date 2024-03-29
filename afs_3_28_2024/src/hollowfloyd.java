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

public class hollowfloyd {
    public static void main(String[] args) throws Exception {
        new hollowfloyd().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hollowfloyd").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            int n = f.nextInt();
            for (int i = 1; i <= n; i++) {
                for(int j = 1;j<=i;j++){
                    if(i > 1 && i < n){
                        if(j == 1 || j == i){
                            out.print("*");
                        }
                        else{
                            out.print(" ");
                        }
                    }
                    else{
                        out.print("*");
                    }
                }
                out.println();
            }
        }
        f.close();
    }
}
