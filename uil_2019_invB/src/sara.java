import java.util.*;
import java.io.*;
class sara{
	public static void main(String[] args) throws Exception{
		new sara().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("sara.dat"));
	   int times = f.nextInt();
	   	   f.nextLine();
	   while(times-->0){
	       List<String> one = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+"))), two = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
	       Set<String> guest = new TreeSet<>();
	       guest.addAll(one);
	       guest.addAll(two);
	       Set<String> both = new TreeSet<>(one);
	       both.retainAll(two);
	       List<String> bride = new ArrayList<>(one);
	       bride.removeIf(n -> two.contains(n));
	       Collections.sort(bride);
	       List<String> groom = new ArrayList<>(two);
	       groom.removeIf(n -> one.contains(n));
	       Collections.sort(groom);
	       System.out.print("Guests: ");
	       if(guest.isEmpty()){
			   System.out.println("none");
		   }
		   else{
			   guest.forEach(n -> System.out.print(n + " "));
			   System.out.println();
		   }
	       System.out.print("Guests of Both: ");
		   if(both.isEmpty()){
			   System.out.println("none");
		   }
		   else{
			   both.forEach(n -> System.out.print(n + " "));
			   System.out.println();
		   }
	       System.out.print("Bride's Guests: ");
		   if (bride.isEmpty()) {
			   System.out.println("none");
		   }
		   else{
			   bride.forEach(n -> System.out.print(n + " "));
			   System.out.println();
		   }
	       System.out.print("Groom's Guests: ");
	       if(groom.isEmpty()){
			   System.out.println("none");
		   }
		   else{
			   groom.forEach(n -> System.out.print(n + " "));
			   System.out.println();
		   }
	       System.out.println("-".repeat(20));
	   }
	}
}
