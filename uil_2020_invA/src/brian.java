import java.util.*;
import java.io.*;
class brian{
	public static void main(String[] args) throws Exception{
		new brian().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("brian.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       int year = f.nextInt();
	       System.out.println("In the year " + year + ", Brian will be coding in Java " + ((year-1995)/2) + "!");
	   }
	}
}
