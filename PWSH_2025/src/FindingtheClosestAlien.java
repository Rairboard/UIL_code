import java.util.*;
import java.io.*;
import static java.lang.System.*;


public class FindingtheClosestAlien {
    public static void main(String[] args) throws Exception {
        new FindingtheClosestAlien().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("FindingtheClosestAlien").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        String child = f.nextLine().trim();
        String[] bestParent = new String[4];
        Arrays.fill(bestParent,"");
        int times = f.nextInt();
        for (int adsf = 0; adsf < times; adsf++) {
            String parent = f.nextLine().trim();
            String ln = new StringBuilder(parent).reverse().toString();
            int ag = 0, ct = 0;
            for (int i = 0; i < ln.length(); i++) {
                if(ln.charAt(i)=='A'||ln.charAt(i)=='G') ag++;
                else if(ln.charAt(i)=='C'||ln.charAt(i)=='T')ct++;
            }
            int n = ln.length();
            int m = child.length();
            String[][] dp = new String[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if(i==0||j==0) dp[i][j] = "";
                    else if(ln.charAt(i-1)==child.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + ln.charAt(i-1);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            String best = dp[n][m];
            if(ag>ct&& best.length()>bestParent[1].length()){
                bestParent[0] = parent;
                bestParent[1] = best;
            } else if (ct>ag && best.length() > bestParent[3].length()) {
                bestParent[2] = parent;
                bestParent[3] = best;
            }
        }
        out.println(bestParent[0] +"\n" + bestParent[2]);
        f.close();
    }
}
