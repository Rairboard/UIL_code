import java.util.*;
import java.io.*;

public class raghav {
    public static void main(String[] args) throws Exception {
        new raghav().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("raghav.dat"));
        //Scanner f = new Scanner(System.in);
		int p = 1;
		while(f.hasNext()){
			long N = f.nextLong();
			if(p%2==0){
				N*=2;
			}else{
				N+=7;
			}
			if(p % 3==0){
				N*=5;
			}
			if(p%5==0){
				N-=11;
			}
			if(p%7==0){
				N*=N;
			}
			if(p%10==0){
				N/=10;
			}
			if(p%11==0){
				N = (int)Math.sqrt(N);
			}
			System.out.println(N);
			p++;
		}
        f.close();
    }
}
