import java.util.*;
import java.io.*;
public class chef
{
	public static void main(String[] args)throws Exception {
		new chef().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File("chef.dat"));
      //Scanner f = new Scanner(System.in);
	  int times = f.nextInt();
	  while(times -- > 0){
	    int t = f.nextInt();
		f.nextLine();
		String s = "";
		boolean fired = false;
		for (int i = 0; i < t; i++) {
			String dish = f.next(), cook = f.next();
			if (dish.equals("Asparagus") && !cook.equals("Green")) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Steak") && (Integer.parseInt(cook)< 165 ||Integer.parseInt(cook) > 175) ) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Roast-Chicken") && (Integer.parseInt(cook)< 165 ||Integer.parseInt(cook) > 180)) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Broccoli") && !cook.equals("Green")) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Potatoes") && !cook.equals("Golden-Brown")) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Carrots") && !cook.equals("Light-Orange")) {
				fired = true;
				s+=dish+",";
			}
			if (dish.equals("Pork-Chops") &&(Integer.parseInt(cook)< 150 ||Integer.parseInt(cook) > 165)) {
				fired = true;
				s+=dish+",";
			}
		}
		if(!fired){
			System.out.println("Very Good Chef.");
		}else{
			System.out.println("You're Fired.");
			System.out.println(s.substring(0,s.length()-1));
		}
	  }
      f.close();
	}
}
