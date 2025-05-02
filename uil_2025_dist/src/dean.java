import java.util.*;
import java.io.*;
public class dean {
	public static void main(String[] args)throws Exception {
		new dean().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("dean.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long s = System.currentTimeMillis();
            String ln = f.nextLine();
            int n = ln.length();
            long count = 0;
            boolean[][] dp =new boolean[n][n];
            for(int i = 0;i < n;i++){
                dp[i][i] = true;
                count++;
                if (i + 1 < n && ln.charAt(i) == ln.charAt(i + 1)) {
                    dp[i][i+1] = true;
                    count++;
                }
            }
            for(int l = 3;l<=n;l++){
                for(int i = 0;i < n-l+1;i++){
                    int j = i + l - 1;
                    if(ln.charAt(i)==ln.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
            System.out.println(count);
            long e = System.currentTimeMillis();
            System.out.println(asdf + " tooks " + (e-s) + " milliseconds");
        }
        f.close();
	}
}
