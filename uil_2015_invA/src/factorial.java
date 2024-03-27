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

public class factorial
{
	public static void main(String[] args)throws Exception {
		new factorial().run();
	}
	public void run() throws Exception
	{
	  Scanner f = new Scanner(new File("factorial.dat"));
	  int t = f.nextInt();
	  while(t-->0) {
		  String s= factorial(f.nextBigInteger()).toString();
		  int i = s.replaceAll("[^0]","*").lastIndexOf("*");
		  if(i==-1){
			  out.println(0);
		  } else{
			  out.println(s.substring(i).length()-1);
		  }
	  }
	}
	public static BigInteger factorial (BigInteger bi){
		if(bi.compareTo(new BigInteger("1"))<=0){
			return bi;
		}
		return bi.multiply(factorial(bi.subtract(new BigInteger("1"))));
	}
}
