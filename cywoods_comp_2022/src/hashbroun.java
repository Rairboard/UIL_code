import java.util.*;
import java.io.*;
public class hashbroun
{
	public static void main(String[] args)throws Exception {
		new hashbroun().run();
	}
	public void run()throws Exception{
	  Scanner f = new Scanner(new File("hashbroun.dat"));
	  int N = f.nextInt();f.nextLine();
	  while(N -- >0){
	    int m = 0;String s= "";
	    String[] l = f.nextLine().trim().split(" ");
	    if(Integer.parseInt(l[0]) / 10 > m){
	     m = Integer.parseInt(l[0]) / 10; 
	     s = "B";
	    }
	    if(Integer.parseInt(l[0]) / 5 > m){
	     m = Integer.parseInt(l[0]) / 5; 
	     s = "H";
	    }
	    if(Integer.parseInt(l[0]) / 2 > m){
	     m = Integer.parseInt(l[0]) / 2; 
	     s = "C";
	    }
	    if(Integer.parseInt(l[0]) / 1 > m){
	     m = Integer.parseInt(l[0]) / 1; 
	     s = "F";
	    }
	    if(Integer.parseInt(l[0]) / 3 > m){
	     m = Integer.parseInt(l[0]) / 3; 
	     s = "W";
	    }
	    for(int i= 0;i < m;i++){
	      System.out.print(s);
	    }
	    System.out.println();
	  }
	}
}
