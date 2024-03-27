import java.util.*;
import java.io.*;
class sebastian{
	public static void main(String[] args) throws Exception{
		new sebastian().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("sebastian.dat"));
	   Map<Integer,TreeSet<String>> m = new TreeMap<>();
	   while(f.hasNext()){
	       String s = f.next();
	       m.putIfAbsent(sumAscii(s),new TreeSet());
	       m.get(sumAscii(s)).add(s);
	   }
	   for(Integer i : m.keySet()){
	       for(String s : m.get(i)){
	           System.out.println(s);
	       }
	   }
	}
	public int sumAscii(String s){
	    int sum = 0;
	    for(int i=0;i<s.length();i++){
	        sum += s.charAt(i);
	    }
	    return sum;
	}
}
