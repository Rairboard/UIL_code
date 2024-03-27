import java.util.*;
import java.io.*;
class harmony{
	public static void main(String[] args)throws Exception {
		new harmony().run();
	}
	public void run()throws Exception{
	   // Scanner f  =new Scanner(System.in);
	   Scanner f = new Scanner(new File("harmony.dat"));
	   int times = f.nextInt();
	   f.nextLine();
	   while(times-->0){
	       String s = f.nextLine().trim();
	       int odd =0, even = 0, count = 0;
	       for(int i=0;i<s.length()-1;i++){
			   int N = Integer.parseInt(s.substring(i,i+1));
	           if((i+1)%2==1){
	               odd += N;
	               if(N > 4){
	                   count++;
	               }
	           } else{
	               even += N;
	           }
	       }
	       int sum = odd * 3 + even + count;
	       sum%=10;
		   if(sum==0){
			   System.out.println(s +" " + (s.substring(s.length()-1).equals(Integer.toString(0)) ? "VALID":"INVALID " + 0));
		   }
		   else{
			   System.out.println(s + " " + (s.substring(s.length()-1).equals(Integer.toString(10-sum))?"VALID":"INVALID " + (10-sum)));
		   }
	   }
	}
}
