import java.util.*;
import java.io.*;
class micaela{
	public static void main(String[] args)throws Exception{
		new micaela().run();
	}
	public void run()throws Exception{
		// Scanner f = new Scanner(System.in);
		Scanner f = new Scanner(new File("micaela.dat"));
		while(f.hasNext()){
			String a = f.next(), b = f.next();
			int n = a.length();
			int m = b.length();
			String[][] dp = new String[n+1][m+1];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= m; j++) {
					if(i==0||j==0){
						dp[i][j] = "";
					}
					else if(a.charAt(i-1) == b.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
					}
					else{
						int max = Math.max(dp[i-1][j].length(),dp[i][j-1].length());
						if(dp[i-1][j].length()==max){
							dp[i][j] = dp[i-1][j];
						}else{
							dp[i][j] = dp[i][j-1];
						}
					}
				}
			}
			System.out.println(dp[n][m].equals("") ? "NONE":dp[n][m]);
		}
	}

}
