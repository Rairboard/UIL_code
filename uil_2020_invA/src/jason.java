import java.util.*;
import java.io.*;
class jason{
	public static void main(String[] args) throws Exception{
		new jason().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("jason.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       double a = f.nextDouble(), b = f.nextDouble(), c = f.nextDouble(), vertex = (-b) / (2 * a), y = (a * Math.pow(vertex,2)) + (b * vertex) + c;
	       System.out.printf("(%.3f,%.3f)-->%s%n",vertex,y,(a>0?"UPWARD":"DOWNWARD"));
	   }
	}
}
