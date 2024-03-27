import java.util.*;
import java.io.*;
class money{
	public static void main(String[] args)throws Exception{
		new money().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("money.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       int combination = 0;
	       int tgt = f.nextInt();
	       for(int gf = 0; gf <= tgt/77;gf++){
	           for(int sh = 0;sh <= tgt/7;sh++){
	               for(int s = 0;s <= tgt;s++){
	                   if(gf * 77 + sh * 7 + s == tgt){
	                       combination++;
	                   }
	               }
	           }
	       }
	       System.out.println(combination);
	   }
	}
}
