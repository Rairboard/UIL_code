import java.util.*;
import java.io.*;
class aran{
	public static void main(String[] args) throws Exception{
		new aran().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   //Scanner f = new Scanner(new File(".dat"));
	   char c = 'A';
	   String s = "";
	   for(int i=1;i<=26;i++){
	       s+= c + "" + Character.toLowerCase(c);
	       System.out.println("Day " + i + ": " + s);
	       c++;
	   }
	}
}
