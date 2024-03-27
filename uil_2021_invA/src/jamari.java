import java.util.*;
import java.io.*;
public class jamari{
	public static void main(String[] args)throws Exception{
	    new jamari().run();
	}
	public void run()throws Exception{
	    //Scanner f= new Scanner(System.in);
		Scanner f = new Scanner(new File("jamari.dat"));
		Queue<String> q = new LinkedList<>();
		int remove = 0;
		while(f.hasNext()){
		    String a = f.next();
		    if(a.equals(">>>")){
		        int noDonuts =  q.size()-remove;
		        if(remove == 0){
		            System.out.println("No one got a donut today.");
		        }
		        else if(remove == q.size()){
		            System.out.println("Everyone got a donut today.");
		        }
		        else{
		            String last = "";
    		        while(remove-->0){
    		            last = q.peek();
    		            q.poll();
    		        }
    		        System.out.println("The last person to get a donut was " + last + ".");
    		        System.out.println(noDonuts + " customers did not get a donut today.");
		        }
		        remove = 0;
		        q = new LinkedList<>();
		    }
		    else{
		        try{
		            int N = Integer.parseInt(a);
		            remove+=N;
		        }
		        catch(Exception e){
		            q.offer(a);
		        }
		    }
		}
	}
}
