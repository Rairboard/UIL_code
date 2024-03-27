import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class GridArrangements {
    public static void main(String[] args) throws Exception {
        new GridArrangements().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("GridArrangements").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		long[] ar = new long[(int)Math.pow(10,5)+1];
		ar[0] = 0;
		ar[1] = 1;
		for(int i = 2; i < ar.length;i++){
			long amt = F(i);
			ar[i] = ar[i-1] + amt;
		}
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int N = f.nextInt();
			out.println(ar[N]);
        }
        f.close();
    }
	public long F(int N){
		if(N==1) return 1;
		long cnt = 0;
		for(long i  = 1; i <= Math.sqrt(N);i++){
			if(N%i==0){
				if(i == N/i){
					cnt++;
				}
				else{
					cnt+=2;
				}
			}
		}
		return cnt;
	}
}
