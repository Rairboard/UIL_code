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

public class michelle {
    public static void main(String[] args) throws Exception {
        new michelle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("michelle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int total = 0;
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            List<Integer> range = new ArrayList<>();
            range.add(1);
            for (int i = 0; i < ar.length; i++) {
                range.add(ar[i]);
                range.add(ar[i]+1);
            }
            range.add(50);
            double[] cnt = new double[ar.length+1];
            while(f.hasNext()){
                String s = f.nextLine().trim();
                if(s.equals("#")){
                    break;
                }
                String[] ln = s.split("\\s+");
                total+=ln.length;
                for (int i = 0; i < ln.length; i++) {
                    for (int j = 0; j < cnt.length; j++) {
                        int a = range.get(j*2);
                        int b = range.get(j*2+1);
                        if(ln[i].length() >= a && ln[i].length() <= b){
                            cnt[j]++;
                            break;
                        }
                    }
                }
            }
            out.println("Test case #" + asdf);
            for (int i = 0; i < cnt.length; i++) {
                out.printf("%02d:%02d -> %-6d", range.get(i*2), range.get(i*2+1), Math.round(cnt[i]/total*100));
                if(cnt[i]>0){
                    out.println("x".repeat((int)Math.round(cnt[i]/total*100)));
                }
                else{
                    out.println();
                }
            }
            out.println("=".repeat(15));
        }
        f.close();
    }
}
