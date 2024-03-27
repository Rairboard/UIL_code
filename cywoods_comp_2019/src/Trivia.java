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

public class Trivia {
    public static void main(String[] args) throws Exception {
        new Trivia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Trivia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] p= f.nextLine().split("\\s+");
            int[] cor = new int[p.length];
            String[] ans = f.nextLine().split("\\s+");
            for (int i = 0; i < ans.length; i++) {
                String a = f.next(), b = f.next();
                if(a.equals(ans[i])){
                    cor[0]++;
                }
                if(b.equals(ans[i])){
                    cor[1]++;
                }
            }
            if(f.hasNext()){
                f.nextLine();
            }
            if(cor[0]==cor[1]){
                out.println(p[0] + " and " + p[1] + " are tied this round!");
            }else if(cor[0] > cor[1]){
                out.println(p[0] + " has won this round!");
            }
            else{
                out.println(p[1] + " has won this round!");
            }
        }
        f.close();
    }
}
