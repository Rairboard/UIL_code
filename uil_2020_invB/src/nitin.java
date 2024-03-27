import java.util.*;
import java.io.*;
class nitin{
	public static void main(String[] args) throws Exception{
		new nitin().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("nitin.dat"));
	   int N  = f.nextInt();
	   Queue<String> dog = new LinkedList<>(), cat = new LinkedList<>();
	   while(N-->0){
	       String name = f.next();
	       if(f.next().equals("D")){
	           dog.offer(name);
	       } else{
	           cat.offer(name);
	       }
	   }
	   N = f.nextInt();
	   while(N-->0){
	       String name = f.next();
	       if(f.next().equals("D")){
	           if(!dog.isEmpty()){
	               System.out.println(name + " DOG " + dog.poll());
	           } else{
	               System.out.println(name + " WAIT LIST DOG");
	           }
	       } else{
	           if(!cat.isEmpty()){
	               System.out.println(name + " CAT " + cat.poll());
	           } else{
	               System.out.println(name + " WAIT LIST CAT");
	           }
	       }
	   }
	}
}
