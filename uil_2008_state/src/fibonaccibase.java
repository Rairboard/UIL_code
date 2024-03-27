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

public class fibonaccibase {
    public static void main(String[] args) throws Exception {
        new fibonaccibase().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fibonaccibase").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
            int n = f.nextInt();
            List<Integer> al = new ArrayList<>();
            al.add(0);
            al.add(1);
            while(al.get(al.size()-1)<n){
                al.add(al.get(al.size()-1)+al.get(al.size()-2));
            }
            out.print(n+" = ");
            while(n>0){
                for(int i = al.size()-1;i>-1;i--){
                    if(al.get(i)<=n){
                        n-=al.get(i);
                        if(n==0){
                            out.print(al.get(i));
                        }
                        else{
                            out.print(al.get(i) + " + ");
                        }
                        break;
                    }
                }
            }
            out.println();
        }
        f.close();
    }
}
