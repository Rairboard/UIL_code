import java.util.*;
import java.io.*;

class MutinyOnTheHighSeas{
	public static void main(String[] args)throws Exception{
		new MutinyOnTheHighSeas().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("judgein10.txt"));
	   int N = f.nextInt();
	   long maxStrength = f.nextLong(), maxSword = 0;
	   long[] attackVal = new long[N];
	   long[] sword = new long[N];
	   Set<Pirate> s = new TreeSet<>();
	   for(int i=0;i<N;i++){
	       attackVal[i] = f.nextLong();
	   }
	   for(int i=0;i<N;i++){
	       sword[i] = f.nextLong();
	   }
	   for(int i=0;i<N;i++){
	       s.add(new Pirate(attackVal[i],sword[i]));
	   }
	   for(Pirate pr : s){
	       if(maxStrength - pr.av < 0){
	           break;
	       }
	       maxStrength-= pr.av;
	       maxSword += pr.s;
	   }
	   System.out.println(maxSword);
	}
	class Pirate implements Comparable<Pirate>{
	    long av,s;
	    double percent;
	    public Pirate(long attackVal, long swordNum){
	        av = attackVal;
	        s = swordNum;
	        percent = (double)swordNum / attackVal;
	    }
	    public int compareTo(Pirate p){
	        return percent < p.percent ? 1 : -1;
	    }
	}
}
