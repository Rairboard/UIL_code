import java.util.*;
import java.io.*;
class CannonBallRun{
	public static void main(String[] args)throws Exception{
		new CannonBallRun().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f =new Scanner( new File("CannonBallRun.txt"));
	   int times =f.nextInt();
	   while(times-->0){
	      long[] cannon = new long[f.nextInt()];
	      long cap =f.nextLong();
	      long sum=0;
	      for(int i=0;i<cannon.length;i++){
	          cannon[i] = cap - f.nextLong();
	          sum+=cannon[i];
	      }
	      long price = f.nextLong(),balls =f.nextLong();
	      if(sum%balls==0){
	          System.out.println(price * (sum/balls) + " coins");
	      }else{
	          System.out.println(price * (sum/balls + 1) + " coins");
	      }
	   }
	}
}
