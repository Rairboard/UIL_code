import java.util.*;
import java.io.*;
class WereInForSomeChop{
	public static void main(String[] args)throws Exception{
		new WereInForSomeChop().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f =new Scanner( new File("WereInForSomeChop.txt"));
	   int times =f.nextInt();
	   while(times-->0){
	       int[] ar= new int[f.nextInt()];
	       for(int i=0;i<ar.length;i++){
	           ar[i] = f.nextInt();
	       }
	       int cnt= 0;
	       for(int i=1;i<ar.length-1;i++){
	           if(ar[i] > ar[i-1] && ar[i] > ar[i+1]){
	               cnt++;
	           }
	       }
	       System.out.println(cnt);
	   }
	}
}
