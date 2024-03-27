import java.util.*;
import java.io.*;
class maciej{
	public static void main(String[] args) throws Exception{
		new maciej().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("maciej.dat"));
	   int N  = f.nextInt();
	   for(int cases = 1; cases <=N;cases++){
	       String a = f.next().substring(1), b = f.next().substring(1), res = "#";
	       while(!a.isEmpty() && !b.isEmpty()){
	           int x = Integer.parseInt(a.substring(0,2),16), y = Integer.parseInt(b.substring(0,2),16);
	           if((x+y)/2<10){
	               res +="0";
	           }
	           res += Integer.toString((x+y)/2,16).toUpperCase();
	           a = a.substring(2);
	           b = b.substring(2);
	       }
	       System.out.println(res);
	   }
	}
}
