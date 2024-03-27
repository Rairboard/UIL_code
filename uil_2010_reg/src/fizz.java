import java.util.*;
import java.io.*;
public class fizz{
	public static void main(String[] args)throws Exception{
		Scanner f = new Scanner(new File("fizz.dat"));
		int N = f.nextInt(),s,e;
		for(int i=1;i<=N;++i){
		  System.out.println("Data Set "+ i);
		  s = f.nextInt();e=f.nextInt();
		  for(int j=s;j<=e;++j){
		    System.out.println(j%3==0&&j%5==0?"FizzBang":j%3==0&&j%5!=0?"Fizz":j%5==0&&j%3!=0?"Bang":j);
		  }
		}
	}
}
