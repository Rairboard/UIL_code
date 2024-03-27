import java.util.*;
import java.io.*;
class lukas{
	public static void main(String[] args) throws Exception{
		new lukas().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("lukas.dat"));
	   List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split(",")));
	   al.add("true");
	   al.add("false");
	   al.add("null");
	   int times = f.nextInt();
	   while(times-->0){
	       System.out.println(valid(f.next(),al)?"Valid":"Invalid");
	   }
	}
	public boolean valid(String s, List<String> al){
	    if(s.substring(0,1).matches("[^a-zA-Z_$]")){
	        return false;
	    }
	    if(s.substring(1).matches(".*[^a-zA-z0-9_$].*")){
	        return false;
	    }
	    if(s.matches(".*\\s.*")){
	        return false;
	    }
	    if(al.contains(s)){
	        return false;
	    }
	    return true;
	}
}
