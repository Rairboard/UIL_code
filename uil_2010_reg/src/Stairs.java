import java.util.*;
import java.io.*;
public class Stairs{
	public static void main(String[] args)throws Exception{
	  int N = 14;
	  for(int i=1;i<=10;i++){
	    for(int j=0;j<N;j++){
	      System.out.print("*");
	    }
	    System.out.println();
	    for(int j=0;j<N;j++){
	      System.out.print("*");
	    }
	    N+=4;
	    System.out.println();
	  }
	}
}
