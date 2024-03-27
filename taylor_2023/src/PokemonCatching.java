import java.util.*;
import java.io.*;
public class PokemonCatching
{
	public static void main(String[] args)throws Exception {
		new PokemonCatching().run();
	}
	public void run() throws Exception{
	  Scanner f = new Scanner(new File("PokemonCatching.in"));
	  // Scanner f = new Scanner(System.in);
	  int[] balls = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
	  double[] rate = {1,1.5,2};
	  int times= f.nextInt();
	  while(times-->0){
		  String s =f.next();
		  double rr = f.nextDouble(), nr = rr;
		  int in= 0;
		  for (int i = 0; i < balls.length; i++) {
			  if(balls[i]!=0){
				  nr = rr * rate[i] * .68;
				  in = i;
				  if(nr >= .5){
					  break;
				  }
			  }
		  }
		  System.out.printf("%s %.3f%n",s,nr);
		  balls[in]--;
	  }
	  f.close();
	}
}
