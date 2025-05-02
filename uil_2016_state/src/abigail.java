import java.util.*;
import java.io.*;
public class abigail {
	public static void main(String[] args)throws Exception {
		new abigail().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("abigail.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            long a = f.nextLong(), b = f.nextLong(), c = f.nextLong();
            boolean negative = c < 0;
            c = Math.abs(c);
            long maxF = 1;
            for(long i = 2;i<=c;i++){
                if(c %i == 0){
                    if (Math.sqrt(i) == (long) Math.sqrt(i)) {
                        maxF = Math.max(maxF, i);
                    }
                }
            }
            c/=maxF;
            b*= Math.sqrt(maxF);
            if(!negative && c==1){
                a+=b;
                b = c = 0;
            }
            if(negative && c ==1){
                c = 0;
            }
            System.out.print(a+" ");
            if(b==0){
                System.out.print(0 + " ");
            }
            else{
                System.out.print(b + (negative ? "i ":" "));
            }
            if(c==0){
                System.out.println(0);
            }
            else{
                System.out.println(c);
            }
        }
        f.close();
	}
}
