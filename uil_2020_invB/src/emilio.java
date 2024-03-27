import java.util.*;
import java.io.*;
class emilio{
	public static void main(String[] args) throws Exception{
		new emilio().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("emilio.dat"));
	   int N  = f.nextInt();
	   for(int cases = 1; cases <=N;cases++){
	       int run = f.nextInt();
	       double sum = 0;
	       List<Double> al = new ArrayList<>();
	       while(run-->0){
	           al.add(f.nextDouble());
	       }
	       Collections.sort(al);
	       Collections.reverse(al);
	       for(int i=0;i<10;i++){
	           sum+=al.get(i);
	       }
	       System.out.printf("%d: %.1f%n", cases, sum/10);
	       Collections.reverse(al);
	       sum=0;
	       for(int i=0;i<10;i++){
	           sum+=al.get(i);
	       }
	       System.out.printf("%d: %.1f%n",cases, sum/10);
	       System.out.println("------");
	   }
	}
}
