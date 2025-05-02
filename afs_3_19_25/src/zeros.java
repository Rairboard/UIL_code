import java.util.*;
import java.io.*;
public class zeros {
	public static void main(String[] args)throws Exception {
		new zeros().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("zeros.dat"));
        //Scanner f = new Scanner(System.in);
        long[] dp = new long[(int)1e5+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2;i<=1e5;i++){
            dp[i] = (dp[i-1] + dp[i-2]) %((long)1e9+7);
        }
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int w = f.nextInt();
            f.nextLine();
            System.out.println(dp[w]);
        }
        f.close();
	}
}
