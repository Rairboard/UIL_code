import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class farkle{
	public static void main(String[] args)throws Exception {
		new farkle().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File(("farkle").toLowerCase() + ".dat"));
	  //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			long seed = f.nextLong();
			int k = f.nextInt();
			double total = 0;
			f.nextLine();
		  for (int round = 0; round < 100; round++) {
			  Random r = new Random(seed);
			  double roundTotal = 0;
			  int cnt = 0;
			  String firstround = "";
			  while(true){
				  cnt++;
				  int rand = r.nextInt();
				  roundTotal += Math.abs(rand) +"".length();
				  firstround = rand+"";
//				  out.println(rand);
				  if(appear(rand, k)) break;
			  }
			  roundTotal/=cnt;
			  if(round == 0) out.println(firstround);
			  total+=roundTotal;
		  }
		  total/=100;
		  out.printf("%.2f\n", total);
	  }
	  f.close();
	}
	public boolean appear(int s, int k){
		Stack<Character> st = new Stack<>();
		String ln = Math.abs(s) + "" ;
		int cnt = 0;
		for (int i = 0; i < ln.length()-1; i++) {
			if(st.isEmpty()){
				st.push(ln.charAt(i));
				cnt++;
			}
			else{
				if(ln.charAt(i) == st.peek()){
					cnt++;
				}
				else{
					cnt = 1;
				}
				st.push(ln.charAt(i));
			}
			if(cnt >= k){
				return true;
			}
		}
		return false;
	}
}
