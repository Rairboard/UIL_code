import java.util.*;
import java.io.*;
public class maxconsecutiveoneIII {
	public static void main(String[] args)throws Exception {
		new maxconsecutiveoneIII().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("prob31"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int[] nums = Arrays.stream(f.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
            int k = f.nextInt();
            f.nextLine();
            int ans = longestOnes(nums, k);
            System.out.println(ans);
        }
        f.close();
	}
    public int longestOnes(int[] nums, int k) {
        int mx = 0;
        int i = 0, j = 0;
        int z = 0;
        while( j < nums.length){
            if(nums[j]==1){
                mx = Math.max(mx , j-i+1);
                j++;
            }
            else if(nums[j]==0){
                if(z+1 <=k){
                    z++;
                }
                else{
                    while(z > k-1){
                        if(nums[i]==0){
                            z--;
                        }
                        i++;
                    }
                    z++;
                }
                mx = Math.max(mx, j-i+1);
                j++;
            }
        }
        return mx;
    }
}
