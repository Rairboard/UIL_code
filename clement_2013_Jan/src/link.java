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

public class link {
    public static void main(String[] args) throws Exception {
        new link().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("link").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            Arrays.sort(ar);
            Map<Long,Integer> diff = new HashMap<>();
            long maxDiff = -1, cnt = 0;
            for (int i = 0; i < ar.length - 1; i++) {
                long d = -ar[i] + ar[i+1];
                diff.put(d,diff.getOrDefault(d,0)+1);
            }
            for(Long ll : diff.keySet()){
                if(diff.get(ll)>cnt){
                    cnt = diff.get(ll);
                    maxDiff = ll;
                }
            }
            for (int i = 0; i < ar.length - 1; i++) {
                if(ar[i]+maxDiff!=ar[i+1]){
                    out.println(ar[i]+maxDiff);
                    break;
                }
            }
        }
        f.close();
    }
}
