import java.util.*;
import java.io.*;
public class beerds
{
	public static void main(String[] args)throws Exception {
		new beerds().run();
	}
	public void run()throws Exception{
	  Scanner f = new Scanner(new File(" beerds.dat"));
	  Map<Long, String>  m = new TreeMap<>();
	  while(f.hasNext()){
	    String[] l = f.nextLine().trim().split(" ");
	    m.put(Long.parseLong(l[1]), l[0]);
	  }
	  for(Long i : m.keySet()){
	    System.out.println(m.get(i) + " " + i);
	  }
	}
}
