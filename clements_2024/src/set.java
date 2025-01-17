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

public class set {
    public static void main(String[] args) throws Exception {
        new set().run();
    }

    public void run() throws Exception {
        int stair = 3;
        int[] cost = {1,2,3};
        int[] dp = new int[stair+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= stair;++i){
            for(int step = 1;step <= 3;step++){
                if(i - step >=0 ){
                    dp[i] = Math.min(dp[i], dp[i-step] + cost[i-1]);
                }
            }
        }
        out.println(dp[stair]);
//        Scanner f = new Scanner(new File(("set").toLowerCase() + ".dat"));
//        //Scanner f = new Scanner(System.in);
//        int times = f.nextInt();
//        f.nextLine();
//        for (int asdf = 1; asdf <= times; asdf++) {
//            String painting= "_______________\n" +
//                    "|1111111111111|\n" +
//                    "|1112211111221|\n" +
//                    "|1122221112221|\n" +
//                    "|1111111111111|\n" +
//                    "|1111333111111|\n" +
//                    "|1113333311111|\n" +
//                    "|1113333331111|\n" +
//                    "|1111444111111|\n" +
//                    "|1111441111111|\n" +
//                    "|1111441115555|\n" +
//                    "|5555555555555|\n" +
//                    "===============\n";
//            int cnt = 1;
//            String[] ln = f.nextLine().split(":");
//            for (int i = 0; i < ln.length; i++) {
//                if(cnt >=1 && cnt <= 5 && !ln[i].isEmpty()) painting = painting.replace(cnt + "", ln[i]);
//                cnt++;
//            }
//            out.print(painting);
//        }
//        f.close();
    }
}
