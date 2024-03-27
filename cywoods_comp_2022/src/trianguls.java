import java.util.*;
import java.io.*;
class trianguls
{
	public static void main(String[] args) throws Exception{
		new trianguls().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("trianguls.dat"));
	  int N = f.nextInt();
	  String s = "";
	  while(f.hasNext()){
	    s += f.nextLine();
	  }
	  s = s.replaceAll("\\s","");
	  int p = 0;
	  for(int i= 0; i < N;i++){
	    for(int j = 0;j<=i;j++){
	      System.out.print(s.substring(p,++p));
	    }
	    System.out.println();
	  }
	}
}
