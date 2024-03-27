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

public class kelly
{
	public static void main(String[] args)throws Exception {
		new kelly().run();
	}
	public void run() throws Exception{
	  Scanner ok = new Scanner(new File("kelly.dat"));
	  char[][] mat = {{' '},{' ','A','B','C','D','E'},{' ','F','G','H','I','J'},{' ','L','M','N','O','P'},{' ','Q','R','S','T','U'},{' ','V','W','X','Y','Z'}};
	  while(ok.hasNext()){
	    Scanner line = new Scanner(ok.nextLine());
	    String ans = "";
	    while(line.hasNext()){
	      int r= line.nextInt();
	      int c= line.nextInt();
	      ans += mat[r][c];
	    }
	    System.out.println(ans);
	  }
	}
}
