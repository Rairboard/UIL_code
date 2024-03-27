import java.util.*;
import java.io.*;
class joenathan
{
	public static void main(String[] args) throws Exception{
		new joenathan().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("joenathan.dat"));
	  while(f.hasNext()){
	    String s = f.nextLine();
	    if(s.length() > 0){
	      Map<String, Integer> m = new TreeMap<>();
	      m.put("BLUE",0);
	      m.put("BROWN", 0);
	      m.put("YELLOW",0);
	      String[] l = s.trim().split(" ");
	      m.put("BLUE",m.get("BLUE") + Collections.frequency(Arrays.asList(l), "PURPLE"));
	      m.put("BLUE", m.get("BLUE") + Collections.frequency(Arrays.asList(l) , "BLUE"));
	      m.put("BROWN",m.get("BROWN") + Collections.frequency(Arrays.asList(l), "RED"));
	      m.put("BROWN",m.get("BROWN") + Collections.frequency(Arrays.asList(l), "GREEN"));
	      m.put("BROWN",m.get("BROWN") + Collections.frequency(Arrays.asList(l), "BROWN"));
	      m.put("YELLOW",m.get("YELLOW") + Collections.frequency(Arrays.asList(l), "YELLOW"));
	      m.put("YELLOW",m.get("YELLOW") + Collections.frequency(Arrays.asList(l), "ORANGE"));
	      for(String i : m.keySet()){
	        if(m.get(i) != 0){
	          System.out.print(i + ": " + m.get(i) + " ");
	        }
	      }
	      System.out.println();
	    }
	  }
	}
}
