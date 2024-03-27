import java.util.*;
import java.io.*;
class keith{
	public static void main(String[] args) throws Exception{
		new keith().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("keith.dat"));
	   double max = 0, min = Double.MAX_VALUE;
	   while(f.hasNext()){
	      double d = f.nextDouble(), t = f.nextDouble();
	      max = Math.max(max,d/t);
	      min = Math.min(min,d/t);
	      System.out.printf("%.2f%n",d/t);
	   }
	   System.out.printf("Min = %.2f%nMax = %.2f%n", min,max);
	}
}
