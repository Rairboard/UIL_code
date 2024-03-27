import java.util.*;
import java.io.*;

public class notes {
    public static void main(String[] args) throws Exception {
        new notes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("notes.in"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int s = f.nextInt(), e = f.nextInt(), sg = -1;
            Map<Integer,Map<Integer,List<Integer>>> group = new LinkedHashMap<>();
            for (int i = 0; i < 10; i++) {
                int remain = f.nextInt();
                group.put(i,new HashMap<>());
                for (int j = 1; j <= 100; j++) {
                    if(j==s && i == 0){
                        sg = j%remain;
                    }
                    group.get(i).putIfAbsent(j%remain,new ArrayList<>());
                    group.get(i).get(j%remain).add(j);
                }
            }
            int[][] dp = new int[group.size()][101];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],-1);
                if(i==0){
                    for(Integer p : group.get(i).get(sg)){
                        dp[i][p] = 0;
                    }
                }
                else{
                    for(Integer remainder : group.get(i).keySet()){
                        for(Integer p : group.get(i).get(remainder)){
                            if(group.get(i).get(remainder).contains(s) && dp[i-1][p] > -1){
                                dp[i][p] = Math.min(dp[i-1][p] + 5, 5);
                                continue;
                            }
                            if(dp[i-1][p] > -1){
                                dp[i][p] = dp[i-1][p] + 5;
                            }
                        }
                    }
                }
                for(int[] n : dp) {
                    for (int in : n) {
                        System.out.print(in);
                    }
                    System.out.println();
                }
                System.out.println();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                min = Math.min(dp[i][e],min);
            }
            System.out.println(min);
        }
        f.close();
    }
}