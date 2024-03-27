import java.util.*;
import java.io.*;
class loanur
{
	public static void main(String[] args) throws Exception{
		new loanur().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("loanur.dat"));
	  int N =f.nextInt();f.nextLine();
	  while(N -- >0){
	   int s =0, b = 0;
	   String[] S = f.nextLine().trim().split(" ");
	   String[] B = f.nextLine().trim().split(" ");
	   for(int i = 1;i < S.length;i+=2){
	     s += Integer.parseInt(S[i]);
	   }
	   for(int i = 1; i < B.length;i+=2){
	     b += Integer.parseInt(B[i]);
	   }
	   System.out.println(s > b ? "Ha! I'm cooler than you loser!" : s < b ? "Sigh... I gues I'm not that cool." : "Neither of us even have room to talk");
	  }
	}
}
