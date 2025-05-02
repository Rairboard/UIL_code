import java.util.*;
import java.io.*;
public class khushi {
	public static void main(String[] args)throws Exception {
		new khushi().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("khushi.dat"));
        //Scanner f = new Scanner(System.in);
        int[] coin = {2000, 1000, 500, 100, 25, 10, 5, 1};
        Arrays.sort(coin);
        int n = coin.length;
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            double a = f.nextDouble(), b = f.nextDouble();
            if(a == b) {
                System.out.println("No Change Owed");
                continue;
            }
            int target = (int)(b - a) * 100;
            long[][] dp = new long[n+1][target+1];
            for(int i = 0;i <= n;i++) Arrays.fill(dp[i], target+1);
            for(int i = 0;i<=n;i++){
                for(int j = 0;j <= target;j++){
                    if(i == 0 && j ==0){
                        dp[i][j] = 0;
                    }
                    else if(i == 0){
                        dp[i][j] = j;
                    }
                    else if(j==0){
                        dp[i][j] = 0;
                    }
                    else if(j - coin[i-1] >=0 ){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-coin[i-1]] + 1);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            for(long[] each : dp){
                System.out.println(Arrays.toString(each));
            }
            System.out.println();
        }
        f.close();
	}
}
