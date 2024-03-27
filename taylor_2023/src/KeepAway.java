import java.util.*;
import java.io.*;

public class KeepAway {
    public static void main(String[] args) throws Exception {
        new KeepAway().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("KeepAway.in"));
        //Scanner f = new Scanner(System.in);
        int person = f.nextInt(), round = f.nextInt(), script = 0;
		List<String> al = new ArrayList<>();
		List<Double> power = new ArrayList<>();
		for (int i = 0; i < person; i++) {
			al.add(f.next());
			power.add((double)f.nextInt());
		}
		for (int i = 0; i < round; i++) {
			double max = 0;
			int in = 0;
			for (int j = 0; j < person; j++) {
				double loss = power.get(j) *f.nextDouble();
				if(loss >  max){
					max = Math.max(max,loss);
					in = j;
				}
				power.set(j,power.get(j)-loss);
			}
			if(in != script){
				System.out.println(al.get(in) + " steals the script from " + al.get(script)+ "!");
				script = in;

			}else{
				System.out.println(al.get(script) + " keeps the script!");
			}
		}
		System.out.println(al.get(script) + " is the winner!");
        f.close();
    }
}
