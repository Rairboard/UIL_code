import java.util.*;
import java.io.*;
public class count
{
	public static void main(String[] args)throws Exception {
		new count().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File("count.in"));
	  String abc = "abcdefghijklmnopqrstuvwxyz";
	  long t  = f.nextLong();f.nextLine();
	  TreeMap<Character,Integer> tm = new TreeMap<>();
		for (int i = 0; i < abc.length(); i++) {
			tm.put(abc.charAt(i),0);
		}
	  while(t-->0){
		  String[] str  = f.nextLine().split("\\s+");
		  for (String s : str) {
			  for (char c : s.toLowerCase().toCharArray()) {
				  if(((c+"").matches("\\w+"))){
					  tm.putIfAbsent(c,0);
					  tm.put(c,tm.get(c)+1);
				  }
			  }
		  }
	  }
		for (Character c :
				tm.keySet()) {
			System.out.println(c+" " + tm.get(c));
		}
      f.close();
	}
}
