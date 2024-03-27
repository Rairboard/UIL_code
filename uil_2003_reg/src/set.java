import java.util.*;
import java.io.*;

public class set {
  public static void main(String[] args) throws Exception {
      new set().run();
  }
  public void run() throws Exception {
    Scanner f = new Scanner(new File("set.dat"));
    //Scanner f = new Scanner(System.in);
    while(f.hasNext()){
			f.next();
			int p = f.nextInt();
			int[][] m= new int[p][];
			f.nextLine();
			for (int i = 0; i < p; i++) {
				m[i] = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			Map<Integer,Integer> tm = new TreeMap<>();
			for(int c = 0; c < m[0].length;c++){
				int sum =0;
				for(int r = 0; r < m.length;r++){
					sum += m[r][c];
				}
				tm.put(c+1,sum);
			}
			f.next();
			ArrayList<Integer> al = new ArrayList<>();
			int sum = 0, pos = 0;
			for(int i=0;i<3;i++){
			  int best = Integer.MIN_VALUE;
			  for(Integer ll : tm.keySet()){
			    if(tm.get(ll) > best){
			      best = tm.get(ll);
			      pos = ll;
			    }
			  }
			  sum += best;
			  al.add(pos);
			  tm.remove(pos);
			}
			Collections.sort(al);
			al.forEach(n -> System.out.print(n + " "));
			System.out.println(sum);
		}
    f.close();
  }
}
