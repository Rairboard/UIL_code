import java.util.*;
import java.io.*;

class ShipBuilding{
	public static void main(String[] args)throws Exception{
		new ShipBuilding().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("ShipBuilding.txt"));
	   String[] w = "Plastic,Wood,Metal".split(",");
	   int t = f.nextInt();
	   f.nextLine();
	   while(t-->0){
		   boolean[] b = new boolean[3];
		   int x = f.nextInt();
		   for (int i = 0; i < 3; i++) {
			   if(f.nextInt()>=x){
				   b[i] = true;
			   }
		   }
		   for (int i = 0; i < b.length; i++) {
			   if(b[i]){
				   System.out.println(w[i]);
				   break;
			   }
		   }
	   }
	}
}
