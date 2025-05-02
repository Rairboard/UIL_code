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

public class ruth {
    public static void main(String[] args) throws Exception {
        new ruth().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ruth").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] height = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            int n = height.length;
            long L = 0, R = 0;
            long[] left = new long[n];
            long[] right = new long[n];
            for (int i = 0; i < n; i++) {
                L = Math.max(L,height[i]);
                left[i] = L;
                R = Math.max(R,height[n-1-i]);
                right[n-1-i] = R;
            }
            long total = 0;
            for(int i =0; i < n;i++){
                long maxHeight = Math.min(left[i],right[i]);
                if(maxHeight - height[i] >=0){
                    total+=maxHeight-height[i];
                }
            }
            out.println(total);
        }
        f.close();
    }
}
