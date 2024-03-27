import java.util.*;
import java.io.*;
public class Ivy {
	String orig = "portwefiylskdgmnjbvcxzaqhu";
	List<String> special = new ArrayList<>(Arrays.asList("penn yale harvard columbia dartmouth cornell brown princeton".split(" ")));
	public static void main(String[] args)throws Exception {
		new Ivy().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File("Ivy".toLowerCase() + ".dat"));
      //Scanner f = new Scanner(System.in);
		Set<Email> normie =new TreeSet<>();
		Set<Email> ivy = new TreeSet<>();
	  while(f.hasNext()){
		  String ln = f.nextLine();
		  ln = ln.substring(ln.indexOf("@")+1,ln.indexOf(".edu"));
		  if (special.contains(ln)) {
			  ivy.add(new Email(ln));
		  }else{
			  normie.add(new Email(ln));
		  }
	  }
	  for(Email e : ivy){
		  System.out.println(e);
	  }
	  for(Email e : normie){
		  System.out.println(e);
	  }
      f.close();
	}
	class Email implements Comparable<Email>{
		String n;
		public Email(String name){
			n = name;
		}
		public int compareTo(Email o){
			for (int i = 0; i < Math.min(n.length(),o.n.length()); i++) {
				if (orig.indexOf(n.charAt(i)) != orig.indexOf(o.n.charAt(i))) {
					return orig.indexOf(n.charAt(i)) - orig.indexOf(o.n.charAt(i));
				}
			}
			return n.length() > o.n.length() ? 1 : -1;
		}
		public String toString(){
			return "admissions@" + n + ".edu";
		}
	}
}
