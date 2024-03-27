import java.util.*;
import java.io.*;
class tatiana{
	public static void main(String[] args)throws Exception{
		new tatiana().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("tatiana.dat"));
	   List<Double> al = new ArrayList<>();
	   int months = f.nextInt();
	   double sum = 0;
	   for(int m=1;m<=months;m++){
	       int days = f.nextInt();
	       double monthlySum = 0;
	       while(days-->0){
	           monthlySum+=f.nextDouble();
	       }
	       al.add(monthlySum);
	       sum += monthlySum;
	   }
	   sum/=months;
	   for(int i=0;i<al.size();i++){
	       System.out.printf("%02d   %.2f   %+.2f%n", i+1,al.get(i),al.get(i)-sum);
	   }
	}
}
