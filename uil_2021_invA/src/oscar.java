import java.util.*;
import java.io.*;

public class oscar
{
	public static void main(String[] args) throws Exception{
		Scanner ok = new Scanner(new File("oscar.dat"));
		int times = ok.nextInt();
		ok.nextLine();
		for(int i = 0; i < times; i++){
		    Scanner line = new Scanner(ok.nextLine());
		    String skip = "";
		    String ans = "";
		    int size = 0;
		    int last = 0;
		    int check = 0;
		    while(line.hasNext()){
		        skip = line.next();
		        check = line.nextInt();
		        if(check > last){
		            if(check >= size){
		                ans += skip;
		                ans += " ";
		                size = check;
		            }
		        }
		        last = check;
		    }
		    System.out.println(ans.trim());
		}
	}
}
