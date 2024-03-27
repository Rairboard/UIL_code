import java.util.*;
import java.io.*;
public class Tabuls
{
	public static void main(String[] args) throws Exception{
	  new Tabuls().run();
	}
	public void run()throws Exception{
	  BufferedReader f = new BufferedReader(new FileReader("tabuls.dat"));
	  Map<String, TreeSet<String>> m =new TreeMap<>();
		Map<String, Integer> N = new HashMap<>();
		String s = "";
		while((s = f.readLine()) != null){
		  String[] l = s.split(" ");
		  l[1] = l[1].replaceAll("\\_"," ");
		  l[1] = l[1].replaceAll("\\-"," ");
		  l[1] = l[1].toLowerCase();
		  String[] t= l[1].split(" ");
  		for(int i= 0;i < t.length;i++){
  		  t[i] = t[i].substring(0,1).toUpperCase() + t[i].substring(1);
  		}
  		l[1] = l[1].join(" ", t);
  		TreeSet<String> temp = new TreeSet<>();
  		temp.add(l[1]);
  		if(!m.containsKey(l[0])){
    		m.put(l[0],temp);
    		N.put(l[1],1);
  		}
  		else{
  		  temp.addAll(m.get(l[0]));
  		  m.put(l[0],temp);
  		  if(N.containsKey(l[1])){
  		    N.put(l[1],N.get(l[1]) + 1);
  		  }
  		  else{
  		    N.put(l[1],1);
  		  }
  		}
		}
		for(Map.Entry<String, TreeSet<String>> e : m.entrySet()){
		  System.out.println(e.getKey() + " has ordered:");
		  TreeSet<String> S = new TreeSet<>(e.getValue());
		  for(String i : S){
		    System.out.printf("7%s%d %s\n","x",N.get(i),i);
		  }
		  System.out.println();
		}
	}
}
