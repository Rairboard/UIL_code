import java.util.*;
import java.io.*;
class kirill{
	public static void main(String[] args)throws Exception{
	    new kirill().run();
	}
	public void run()throws Exception{
	    //Scanner f= new Scanner(System.in);
        Scanner f= new Scanner(new File("kirill.dat"));
        int N = f.nextInt();
        for(int cases = 1; cases <= N;cases++){
            long num = f.nextLong();
            for(long x = num; x >=1;x--){
                boolean notSelf = false;
                for(long i = 0; i <=x;i++){
                    if(i + SOD(i) == x){
                        notSelf = true;
                        break;
                    }
                }
                if(!notSelf){
                    System.out.println("Case #" + cases + ": " + x);
                    break;
                }
            }
        }
	}
	public long SOD(long n){
	    long sum = 0;
	    while(n>0){
	        sum+=n%10;
	        n/=10;
	    }
	    return sum;
	}
}
