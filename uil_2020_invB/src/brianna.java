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

public class brianna
{
	public static void main(String[] args)throws Exception {
		new brianna().run();
	}
	public void run() throws Exception{
	  Scanner ok = new Scanner(new File("brianna.dat"));
	  int min = Integer.MAX_VALUE;
	  int max = Integer.MIN_VALUE;
	  while(ok.hasNext()){
	    int temp = ok.nextInt();
	    if(temp < min){
	      min = temp;
	    }
	    if(temp > max){
	      max = temp;
	    }
	  }
	  int diff = max-min;
	  System.out.println(min + " " + max + " " + diff);
	}
}
