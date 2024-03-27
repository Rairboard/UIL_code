import java.util.*;
import java.io.*;
public class encryption{
	public static void main(String[] args)throws Exception{
	  Scanner f = new Scanner(new File("encryption.dat"));
	  int N=f.nextInt();f.nextLine();
	  while(N-->0){
	    String s =f.nextLine(),ret="";
	    String[] part;
	    while(!s.isEmpty()){
	      part = s.substring(0,4).split("");
	      String part1 = part[0],part2=part[1];
	      part[0]=(Integer.parseInt(part[2])+7)%10 + "";
	      part[1]=(Integer.parseInt(part[3])+7)%10 + "";
	      part[2]=(Integer.parseInt(part1)+7)%10 + "";
	      part[3]=(Integer.parseInt(part2)+7)%10 + "";
	      s = s.length()==4?"":s.substring(4);
	      ret += String.join("",part);
	    }
	    System.out.println(ret);
	  }
	}
}
