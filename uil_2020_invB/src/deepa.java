import java.util.*;
import java.io.*;
class deepa{
	public static void main(String[] args) throws Exception{
		new deepa().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("deepa.dat"));
	   int N  = f.nextInt();
	   for(int cases = 1; cases <=N;cases++){
	       int t = f.nextInt(), money = f.nextInt();
	       double txm = 0;
	       int[] dollar = new int[t];
	       double[] txr = new double[t];
	       for(int i=0;i<t;i++){
	           dollar[i] = f.nextInt();
	           txr[i] = f.nextInt()/100.0;
	       }
	       int i;
	       for(i=t-1;i>-1;i--){
	           if(money > dollar[i]){
	               break;
	           }
	       }
	       txm += (money - dollar[i]) * txr[i];
	       while(i > 0){
	           txm += (dollar[i] - dollar[i-1]) * txr[i-1];
	           i--;
	       }
	       System.out.printf("Case #%d: $%,.2f %.3f%s%n", cases,txm,txm/money*100,"%");
	   }
	}
}
