import java.util.*;
import java.io.*;
class nisha{
	public static void main(String[] args)throws Exception {
		new nisha().run();
	}
	public void run()throws Exception{
	   // Scanner f  =new Scanner(System.in);
	   Scanner f = new Scanner(new File("nisha.dat"));
	   int times = f.nextInt();
	   for(int t=1;t<=times;t++){
		   int k = f.nextInt();
		   System.out.println("Case #" + t + ": " + (1 + (long)(Math.pow(2,k) * (k/2.0))));
	   }
	}
}
