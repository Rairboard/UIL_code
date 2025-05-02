import java.util.*;
import java.io.*;
public class eszter {
	public static void main(String[] args)throws Exception {
		new eszter().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("eszter.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            String ln = f.nextLine().trim();
            double[] value= Arrays.stream(ln.substring(1,ln.length()-1).split(",")).mapToDouble(Double::parseDouble).toArray();
            int n = value.length;
            double[] dp = new double[n+1];
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=i;j++){
                    dp[i] = Math.max(dp[i], dp[i-j] + value[j-1]);
                }
            }
            System.out.printf("Maximum profit is $%.2f\n", dp[n]);
        }
        f.close();
	}
}
