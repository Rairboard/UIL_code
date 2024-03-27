import java.util.*;
import java.io.*;
class sillybilly
{
	public static void main(String[] args) throws Exception{
		new sillybilly().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("sillybilly.dat"));
	  int N = f.nextInt();f.nextLine();
	  while(N -- >0){
	    String s =f.nextLine(), n = s.substring(s.indexOf("vs.") + 4);
	    System.out.println(f.nextLine().matches(".*LLY") ? "SILLY BILLY WINS" : n + " WINS");
	  }
	}
}
