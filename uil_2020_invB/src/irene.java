import java.math.*;
import java.util.*;
import java.io.*;
class irene{
	public static void main(String[] args) throws Exception{
		new irene().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("irene.dat"));
	   int N  = f.nextInt();
	   for(int cases = 1; cases <=N;cases++){
	       int num = f.nextInt(), f1 = -1,f2 = -2;
	       String res = "";
	       for(int brr = 2;brr < num;brr++){
	           if(num % brr == 0 && BigInteger.valueOf(brr).isProbablePrime(1)){
	               f1 = brr;
	               f2 = num/brr;
	               if(!BigInteger.valueOf(f2).isProbablePrime(1)){
	                   res = "NOT SEMIPRIME";
	               }
	               else if(f1==f2){
	                   res = "SEMIPRIME";
	               }
	               else{
	                   res = "DISCRETE SEMIPRIME";
	               }
	               
	           }
	       }
	       if(f1<0 || f2 < 0){
	           res = "NOT SEMIPRIME";
	       }
	       System.out.println(num + " " + res);
	   }
	}
}
