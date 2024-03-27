import java.util.*;
import java.io.*;
public class vectors{
	public static void main(String[] args)throws Exception{
	  Scanner f = new Scanner(new File("vectors.dat"));
	  int N=f.nextInt();
	  f.nextLine();
	  String[] l;
	  while(N-->0){
	    int x=0,y=0;
	    l=f.nextLine().split("[,()]");
	    for(int i=1;i<l.length;i+=3){
	      x+=Integer.parseInt(l[i]);
	      y+=Integer.parseInt(l[i+1]);
	    }
	    System.out.println("(" + x + "," + y + ")");
	  }
	}
}
