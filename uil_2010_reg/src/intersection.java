import java.util.*;
import java.io.*;
public class intersection{
	public static void main(String[] args)throws Exception{
		Scanner f = new Scanner(new File("intersection.dat"));
		int p = f.nextInt();
		while(p-->0){
		  int c = f.nextInt();
		  f.nextLine();
		  Set<String> s = new LinkedHashSet<>(Arrays.asList(f.nextLine().split(" "))),temp;
		  for(int i=1;i<c;++i){
		    temp = new HashSet<>(Arrays.asList(f.nextLine().split(" ")));
		    temp.retainAll(s);
		    s = temp;
		  }
		  if(s.isEmpty()){
		    System.out.println("NO COMMON ELEMENT FOUND");
		  }
		  else{
		    List<Integer> al = new ArrayList<>();
		    for(String st : s){
		      al.add(Integer.parseInt(st));
		    }
		    Collections.sort(al);
		    al.forEach(el -> System.out.print(el + " "));
		    System.out.println();
		  }
		}
	}
}
