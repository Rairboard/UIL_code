import java.util.*;
import java.io.*;
class hyun{
	public static void main(String[] args)throws Exception {
		new hyun().run();
	}
	public void run()throws Exception{
	   // Scanner f  =new Scanner(System.in);
	   Scanner f = new Scanner(new File("hyun.dat"));
	   int times = f.nextInt();f.nextLine();
	   for(int t=1;t<=times;t++){
	       String[] s = f.nextLine().split("\\s+");
	       String[] b = new String[4];
	       for(int i=0;i<s.length;i++){
	           for(int j=0;j<s[i].length();j++){
	               b[pos(s[i].substring(j,j+1))] = row(pos(s[i].substring(j,j+1)));
	           }
	       }
	       System.out.print("Case #" + t + ": ");
	       for(int i=0;i<b.length;i++){
	           if(b[i]!=null){
	               System.out.print(b[i] + " ");
	           }
	       }
	       System.out.println();
	   }
	}
	public int pos(String s){
	    if("0123456789".contains(s)){
	        return 0;
	    }
	    if("qwertyuiop".contains(s)){
	        return 1;
	    }
	    if("asdfghjkl".contains(s)){
	        return 2;
	    }
	    return 3;
	}
	public String row(int p){
	    if(p==0){
	        return "NUMBER";
	    }
	    if(p==1){
	        return "TOP";
	    }
	    if(p==2){
	        return "HOME";
	    }
	    return "BOTTOM";
	}
}
