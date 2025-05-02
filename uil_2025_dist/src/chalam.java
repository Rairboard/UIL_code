import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class chalam {
	public static void main(String[] args)throws Exception {
		new chalam().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("chalam.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            long n = f.nextLong();
            Map<Long,Integer> count = new TreeMap<>();
            while(n%2==0){
                count.put(2L,count.getOrDefault(2L,0)+1);
                n/=2;
            }
            for(long i = 3;i * i <= n;i+=2){
                while (n % i == 0){
                    count.put(i,count.getOrDefault(i,0)+1);
                    n/=i;
                }
            }
            if(n>1) count.put(n,1);
            for(long factor : count.keySet()){
                if (count.get(factor) > 1) {
                    System.out.print(factor+"^"+count.get(factor)+" ");
                }
                else System.out.print(factor+" ");
            }
            System.out.println();
        }
        f.close();
	}
}
