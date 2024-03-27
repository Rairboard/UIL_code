import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
public class HitTheRack{
	SimpleDateFormat ff = new SimpleDateFormat("hh:mm a");
	public static void main(String[] args)throws Exception{
		new HitTheRack().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f =new Scanner( new File("HitTheRack.txt"));
	   int N =f.nextInt();f.nextLine();
	   while(N-->0){
		   String[] a = f.next().split(":"), b = f.next().split(":");
		   long c = Long.parseLong(a[0]) * 60 + Long.parseLong(a[1]);
		   long d = Long.parseLong(b[0]) * 60 + Long.parseLong(b[1]);
		   c = 720-c;
		   System.out.println(c+d<480?"gonna take a nap":"getting the ZZZs");
	   }
	}
}
