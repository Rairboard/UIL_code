import java.util.*;
import java.io.*;

public class william{
	public static void main(String[] args) throws Exception{
		new william().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("william.dat"));
	   Map<String,String> tm = new TreeMap<>();
	   while(f.hasNext()){
	       String a = f.next();
	       tm.put(f.next(), a);
	   }
	   for(String lastName : tm.keySet()){
	       System.out.println(tm.get(lastName) + " " + lastName);
	   }
	}
}
