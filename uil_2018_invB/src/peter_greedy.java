import java.util.*;
import java.io.*;

public class peter_greedy {
    public static void main(String[] args) throws Exception {
        new peter_greedy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("peter.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int money = f.nextInt();f.nextLine();
			System.out.print(money + " " );
			int[] c = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			Map<Integer,Integer> m = new TreeMap<>();
			for (int i = c.length-1;i>=0;i--) {
				m.put(c[i],money/c[i]);
				money%=c[i];
			}
			int time = 0;
			for(Integer i : m.keySet()){
				time+=m.get(i);
			}
			System.out.print(time + " ");
			for(Integer unit: m.keySet()){
				for(int i=0;i<m.get(unit);i++){
					System.out.print(unit + " ");
				}
			}
			System.out.println();
		}
        f.close();
    }
}
