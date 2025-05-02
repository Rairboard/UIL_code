import java.util.*;
import java.io.*;
public class jacinta {
	public static void main(String[] args)throws Exception {
		new jacinta().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("jacinta.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int[] nums = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int n = nums.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum+=nums[i];
            }
            if(sum%2!=0) {
                System.out.println("Indeed here I come.");
                continue;
            }
            int target = sum/2;
            boolean[] dp = new boolean[target+1];
            dp[0] = true;
            for(int i = 0;i < n;i++){
                for(int j = target;j>=nums[i];j--){
                    dp[j] |= dp[j-nums[i]];
                }
            }
            System.out.println(dp[target] ? "Job secured.":"Indeed here I come.");
        }
        f.close();
	}
}
