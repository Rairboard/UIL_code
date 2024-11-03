import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class stealingschedule {
    public static void main(String[] args) throws Exception {
        new stealingschedule().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("JUDGEstealingschedule").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int S = f.nextInt(), time = 1, total = 0;
			f.nextLine();
			List<School> al = new ArrayList<>();
			for (int i = 0; i < S; i++) {
				al.add(new School(f.next(), f.nextInt(), f.nextInt()));
				time = Math.max(time, al.get(i).deadline);
			}
			Collections.sort(al, (a,b) -> b.profit - a.profit);
			boolean[] spot = new boolean[time];
			List<String> order = new ArrayList<>();
			for(int i = 0;i<S;i++){
				for(int t = al.get(i).deadline-1;t>-1;t--){
					if(!spot[t]){
						spot[t] = true;
						order.add(al.get(i).name);
						total += al.get(i).profit;
						break;
					}
				}
			}
			out.print("Order: ");
			Collections.sort(order);
			for(String s : order){
				out.print(s+ " ");
			}
			out.println("\nMax Profit: $" + total);
        }
        f.close();
    }
	class School {
		int deadline, profit;
		String name;
		public School(String n, int dl, int p){
			name = n;
			deadline = dl;
			profit = p;
		}
	}
}
