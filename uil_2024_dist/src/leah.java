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

public class leah {
    List<Integer> al;
    public static void main(String[] args) throws Exception {
        new leah().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("leah").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        al = new ArrayList<>();
        generate(8);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            for(int i = 0;i < 1 << n;i++){
                out.print(al.get(i)+" ");
            }
            out.println();
        }
        f.close();
    }
    public void generate(int w){
        for(int i = 0;i < (1 << w);i++){
            al.add(i ^ (i>>1));
        }
    }
}
