import java.util.*;
import java.io.*;
public class paola{
	public static void main(String[] args)throws Exception{
		new paola().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("paola.dat"));
	   int N = f.nextInt();
	   while(N-->0){
	       char c = f.next().charAt(0);
	       int time = f.nextInt();
	       int space = time - 1;
	       for(int t = 1;t <= time ;t++){
	           for(int i=0;i<space;i++){
	               System.out.print(" ");
	           }
	           for(int i=0;i<t;i++){
	               System.out.print(c);
	               if(c=='Z'){
	                   c = 'A';
	               }
	               else{
	                   c++;
	               }
	           }
	           System.out.println();
	           space--;
	       }
	   }
	}
}
