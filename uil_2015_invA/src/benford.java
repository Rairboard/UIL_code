import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class benford
{
	public static void main(String[] args)throws Exception {
		new benford().run();
	}
	public void run() throws Exception
	{
	  Scanner f = new Scanner(new File("benford.dat"));
	  int t = f.nextInt();
	  while(t-->0){
		  int N =f.nextInt();
		  double count = 0;
		  for(int i=0;i<N;i++){
			  if(Integer.toString(f.nextInt()).substring(0,1).equals("1")){
				  count++;
			  }
		  }
		  count = (count / N) * 100;
		  if(count >= 25 && count <= 35){
			  out.println("PASSED");
		  } else{
			  out.printf("FAILED: %.2f", count);
			  out.println("%");
		  }
	  }
	}
}
