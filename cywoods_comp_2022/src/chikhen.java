import java.util.*;
import java.io.*;
class chikhen
{
	public static void main(String[] args) throws Exception{
		new chikhen().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("chikhen.dat"));
	  int N = f.nextInt();f.nextLine();
	  while( N -- >0){
	    System.out.println(f.nextLine().contains("Cluck") ? "Chicken" : "Lunch time");
	  }
	}
}
