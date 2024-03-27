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

public class ghoulgreens {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);
        out.println(dq.poll());
//        new ghoulgreens().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ghoulgreens").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int[] coin = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int c = f.nextInt() - f.nextInt();
            if(f.hasNext()){
                f.nextLine();
            }
			int[] dp = new int[c+1];
			Arrays.fill(dp,c+1);
			Arrays.sort(coin);
            dp[0] = 0;
			for (int i = 1; i <= c; i++) {
				for (int j = 0; j < coin.length; j++) {
					if(coin[j]<=i){
                        dp[i] = Math.min(dp[i],1 + dp[i-coin[j]]);
                    }
				}
			}
            out.println(dp[c]);
        }
        f.close();
    }
}
