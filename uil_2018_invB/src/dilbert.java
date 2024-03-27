import java.util.*;
import java.io.*;
import java.text.*;
class dilbert{
    static SimpleDateFormat ff = new SimpleDateFormat("MM/dd/yyyy");
	public static void main(String[] args)throws Exception{
		new dilbert().run();
	}
	public void run()throws Exception{
	   //Scanner f = new Scanner(System.in);
	   Scanner f =new Scanner(new File("dilbert.dat"));
	   Map<String,TreeMap<DD,Double>> m = new HashMap<>();
	   Set<PP> dude = new TreeSet<>();
	   double grandTotal = 0;
	   while(f.hasNext()){
	       String[] people = f.nextLine().split("\\s+");
	       String name = people[0] + " " + people[1];
	       m.putIfAbsent(name,new TreeMap<>());
	       m.get(name).put(new DD(people[2]),Double.parseDouble(people[3]));
	   }
	   for(String people : m.keySet()){
	       List<Double> money = new ArrayList<>(m.get(people).values());
	       double total = 0;
	       for(int i=0;i<money.size();i++){
	           total+=money.get(i);
	       }
	       dude.add(new PP(people,total));
	       grandTotal += total;
	   }
	   for(PP people : dude){
	       System.out.println(people.n);
	       List<Double> money = new ArrayList<>(m.get(people.n).values());
	       for(DD d : m.get(people.n).keySet()){
	           System.out.printf("%s $%.2f%n", d.toString(),money.remove(0));
	       }
	       System.out.printf("Total Sales $%.2f%n", people.total);
	       System.out.println();
	   }
	   System.out.printf("Grand Total $%.2f%n",grandTotal);
	}
	static class PP implements Comparable<PP>{
	    String n;
	    double total;
	    public PP(String name, double m){
	        n = name;
	        total = m;
	    }
	    public int compareTo(PP p){
	        return total < p.total ? 1 : -1;
	    }
	    public String toString(){
	        return n;
	    }
	}
	static class DD implements Comparable<DD>{
	    Calendar c;
	    public DD(String d){
	        String[] date = d.split("/");
	         c = new GregorianCalendar(Integer.parseInt(date[2]),Integer.parseInt(date[0])-1,Integer.parseInt(date[1]));
	    }
	    public int compareTo(DD d){
	        if(c.get(Calendar.YEAR) == d.c.get(Calendar.YEAR)){
	            if(c.get(Calendar.MONTH) == d.c.get(Calendar.MONTH)){
	                return c.get(Calendar.DAY_OF_MONTH) > d.c.get(Calendar.DAY_OF_MONTH) ? 1 : -1;
	            }
	            return c.get(Calendar.MONTH) > d.c.get(Calendar.MONTH)? 1:-1;
	        }
	        return c.get(Calendar.YEAR) > d.c.get(Calendar.YEAR)?1:-1;
	    }
	    public String toString(){
	        return ff.format(c.getTime());
	    }
	}
}
