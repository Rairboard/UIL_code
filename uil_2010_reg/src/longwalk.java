import java.util.*;
import java.io.*;
public class longwalk{
	public static void main(String[] args)throws Exception{
		Scanner f = new Scanner(new File("longwalk.dat"));
		int N = f.nextInt();f.nextLine();
		while(N-->0){
		  String n=f.nextLine();
		  int h=f.nextInt();
		  List<Integer> al = new ArrayList<>();
		  while(h-->0){
		    al.add(f.nextInt());
		  }
		  Collections.sort(al);
		  System.out.println("The two houses farthest apart on " + n + " are\n" + al.get(0) +" "+ n + " and " + al.get(al.size()-1) + " " + n);
		  if(f.hasNext()){
		    f.nextLine();
		  }
		}
	}
}
