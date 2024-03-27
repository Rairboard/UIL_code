import java.util.*;
import java.io.*;

public class hai{
	public static void main(String[] args) throws Exception{
		new hai().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("hai.dat"));
	   List<String> txt = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
	   int N = f.nextInt();
	   while(N-->0){
	       String pattern = f.next();
	       System.out.printf("%-10s", pattern);
	       boolean match = false;
	       for(int i=0;i<txt.size();i++){
	           if(txt.get(i).matches(pattern)){
	               match = true;
	               System.out.print(txt.get(i) + " ");
	           }
	          
	       }
	       if(!match){
	           System.out.println("No matches.");
	       } else{
	          System.out.println(); 
	       }
	   }
	}
}
