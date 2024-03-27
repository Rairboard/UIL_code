import java.util.*;
import java.io.*;
public class TopTen{
	public static void main(String[] args)throws Exception{
	  Scanner f = new Scanner(new File("topten.dat"));
	  ArrayList<String> al = new ArrayList<>();
	  for(int i=1;i<=10;++i){
	    al.add(f.nextLine());
	  }
	  Collections.reverse(al);
	  al.forEach(s -> System.out.println(s));
	}
}
