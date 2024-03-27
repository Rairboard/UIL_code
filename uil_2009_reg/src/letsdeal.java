import java.util.*;
import java.io.*;
class letsdeal{
	public static void main(String[] args)throws Exception{
		new letsdeal().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("letsdeal.dat"));
	   int times = f.nextInt();
	   while(times-->0){
	       int[] door = new int[3];
	       int max = 0;
	       for(int i=0;i<3;i++){
	           door[i] = f.nextInt();
	           max = Math.max(door[i],max);
	       }
	       int c1 = f.nextInt(), c2 = f.nextInt(), c3 = f.nextInt();
	       int finalChoice = -1;
	       if(door[c2-1] > door[c1-1]){
	           finalChoice = c2;
	       }else{
	           finalChoice = c3;
	       }
	       System.out.println(finalChoice  + (door[finalChoice-1]==max?" WON" : " LOST"));
	   }
	}
}
