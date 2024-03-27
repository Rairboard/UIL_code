import java.util.*;
import java.io.*;
class CrewMorale{
	public static void main(String[] args)throws Exception{
		new CrewMorale().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f =new Scanner( new File("CrewMorale.txt"));
	   int times =f.nextInt();
	   f.nextLine();
	   while(times-->0){
	       double w = f.nextDouble(), c = f.nextDouble(), l = f.nextDouble();
	       System.out.printf("%.2f%n", Math.pow(w,2)/Math.sqrt(c) + l);
	   }
	}
}
