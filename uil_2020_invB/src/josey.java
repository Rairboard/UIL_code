import java.util.*;
import java.io.*;
public class josey{
    static Map<String,List<String>> m;
	public static void main(String[] args) throws Exception{
		new josey().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   BufferedReader f = new BufferedReader(new FileReader("josey.dat"));
	   int N = Integer.parseInt(f.readLine());
	   for(int cases = 1; cases <= N;cases++){
	       m = new LinkedHashMap<>();
	       Set<String> al = new TreeSet<>();
	       int cp = Integer.parseInt(f.readLine());
	       for(int i=0;i<cp;i++){
	           String[] countries = f.readLine().split("\\s+");
	           m.putIfAbsent(countries[0],new ArrayList());
	           m.putIfAbsent(countries[1],new ArrayList());
	           m.get(countries[0]).add(countries[1]);
	           m.get(countries[1]).add(countries[0]);
	       }
	       for(String country : m.keySet()){
	           if(!m.get("OCEAN").contains(country)){
	               boolean dbl = true;
	               for(String neighbor : m.get(country)){
	                   if(m.get("OCEAN").contains(neighbor)){
	                       dbl = false;
	                       break;
	                   }
	               }
	               if(dbl){
	                   al.add(country);
	               }
	           }
	       }
           if(al.isEmpty()){
               System.out.println("Case #" + cases + ": " + 0);
           }
           else{
               System.out.println("Case #" + cases + ": " + al.size());
               for(String country : al){
                   System.out.println(country);
               }
           }
	   }
	}
}
