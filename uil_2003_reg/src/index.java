import java.util.*;
import java.io.*;

public class index {
  public static void main(String[] args) throws Exception {
      new index().run();
  }
  public void run() throws Exception {
    Scanner f = new Scanner(new File("index.dat"));
    //Scanner f = new Scanner(System.in);
    while(f.hasNext()){
			f.next();
			ArrayList<Integer> al =new ArrayList<>();
			String n = f.next();
			int N = f.nextInt();
			for(int i=0;i<N;i++){
			  al.add(f.nextInt());
			}
			f.next();
			for(int i=0;i<al.size();i++){
			  int tmp = al.get(i), p = i+1;
			  n += ","+tmp;
			  while(p < al.size() && al.get(p) - 1 == tmp){
			    tmp = al.get(p);
			    p++;
			  }
			  if(p-1!=i){
			    n+="-"+tmp;
			    i = p - 1;
			  }
			}
			System.out.println(n);
		}
    f.close();
  }
}
