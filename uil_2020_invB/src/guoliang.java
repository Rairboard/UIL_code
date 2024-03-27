import java.util.*;
import java.io.*;

public class guoliang
{
	public static void main(String[] args)throws Exception {
		new guoliang().run();
	}
	public void run()throws Exception{
	  Scanner ok = new Scanner(new File("guoliang.dat"));
	  while(ok.hasNext()){
	    String[] line = ok.nextLine().trim().split(" ");
	    for(int i = 0; i < line.length;i++){
	      if(helper(line[i]) == true){
	        System.out.println(line[i]);
	      }
	    }
	  }
	}
	public static boolean  helper(String line){
	  for(int i = 0; i < line.length();i++){
	    char w = line.charAt(i);
	    int count = 0;
	    for(int x = 0; x < line.length();x++){
	      if(line.charAt(x) == w){
	        count++;
	      }
	    }
	    if(count > 1){
	      return false;
	    }
	  }
	  return true;
	}
}
