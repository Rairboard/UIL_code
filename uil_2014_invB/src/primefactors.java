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

public class primefactors {
    public static void main(String[] args) throws Exception {
        new primefactors().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("primefactors").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int[] PF = new int[(int)Math.pow(10,6)+1];
        PF[0] = 0;
        PF[1] = 1;
        for(int i =2;i < PF.length;i++){
            if(PF[i] !=0) continue;
            for(int j = i;j<PF.length;j+=i){
                PF[j]= i;
            }
        }
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            int a = f.nextInt(), b = f.nextInt();
            long sum = 0;
            for(int i =a;i<=b;i++){
                int n = i;
                while(n>1){
                    sum+= PF[n];
                    n/=PF[n];
                }
            }
            out.println(sum % 10000009);
        }
        f.close();
    }
}
