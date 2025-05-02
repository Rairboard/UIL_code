import java.util.*;
import java.io.*;
public class maite {
	public static void main(String[] args)throws Exception {
		new maite().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("maite.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n  =f.nextInt(), k = f.nextInt();
            f.nextLine();
            Map<Long,Integer> count = new HashMap<>();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = f.nextLong();
                count.put(ar[i], 0);
            }
//            System.out.println(Arrays.toString(ar));
//            System.out.println(count);
            int i = 0, j = 0;
            int mx = 0;
            while(j < n){
                while(i < j && count.get(ar[j]) > k - 1){
                    count.put(ar[i], count.get(ar[i])-1);
                    i++;
                }
                mx = Math.max(mx, j-i+1);
                count.put(ar[j], count.get(ar[j])+1);
                j++;
            }
            System.out.printf("Case #%d: %d\n", asdf, mx);
        }
        f.close();
	}
}
