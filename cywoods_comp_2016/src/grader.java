import java.util.*;
import java.io.File;

public class grader {
	public static void main(String[] args)throws Exception {
		new grader().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File(("grader").toLowerCase() + ".dat"));
	  //Scanner f = new Scanner(System.in);
	  int times = f.nextInt();
	  f.nextLine();
	  for(int t = 1;t<=times;++t){
		  List<Student> al = new ArrayList<>();
		  String orig = f.nextLine();
		  int n = f.nextInt(), r = f.nextInt(), w = f.nextInt(), s = f.nextInt(), l = f.nextInt();
		  f.nextLine();
		  for (int i = 0; i < n; i++) {
			  String name = f.next();
			  String ans = f.nextLine().substring(1);
			  int score = 0;
			  for (int j = 0; j < ans.length(); j++) {
				  if(ans.charAt(j)!=orig.charAt(j)){
					  if(ans.charAt(j)==' '){
						  score+=s;
					  }else{
						  score+=w;
					  }
				  }
				  else{
					  score+=r;
				  }
			  }
			  al.add(new Student(name,score));
		  }
		  Collections.sort(al, (a,b) ->{
			  if(a.s == b.s){
				  return a.n.compareTo(b.n);
			  }
			  return b.s - a.s;
		  });
		  System.out.println("Test #" + t + ":");
		  boolean pass = false;
		  while(al.size()>0){
			  if(al.get(0).s >= l){
				  pass = true;
				  System.out.println(al.get(0).s + " : " + al.remove(0).n + " lives to see another day");
			  }
			  else{
				  break;
			  }
		  }
		  if(pass && al.size() > 0){
			  System.out.println();
		  }
		  while(al.size()>0){
			  System.out.println(al.get(0).s + " : " + al.remove(0).n + " gets the meter stick");
		  }
		  System.out.println();
	  }
	  f.close();
	}
	class Student{
		String n;
		int s;
		public Student(String name,int score){
			n = name;
			s = score;
		}
	}
}
