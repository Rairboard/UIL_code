import java.util.*;
import java.io.*;
class throatpunch
{
	public static void main(String[] args) throws Exception{
		new throatpunch().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("throatpunch.dat"));
	  while(f.hasNext()){
	    int s = 0;
	    String l = f.nextLine().trim();
	    for(int i= 0;i < l.length();i++){
	        s += Character.isDigit(l.charAt(i)) ? Integer.parseInt(l.substring(i,i+1)) : 0;
	    }
	    System.out.println("Gared will be punch in the throat " + s + " times.");
	  }
	}
}
