import java.util.*;
import java.io.*;

public class fa {
    public static void main(String[] args) throws Exception {
        new fa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("fa.dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()){
			int N = f.nextInt();f.nextLine();
			int[] ar  = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int total = Arrays.stream(ar).sum(), before = 0, after = 0, s1,s2;
			Map<Integer,List<int[]>> m = new TreeMap<>();
			for (int i = 0; i < N; i++) {
				before += ar[i];
                after = total-before;
                m.putIfAbsent(Math.abs(before-after),new ArrayList<>());
                m.get(Math.abs(before-after)).add(new int[]{i,i+1});
                s1 = Arrays.stream(Arrays.copyOfRange(ar,0,i)).sum();
                s2 = Arrays.stream(Arrays.copyOfRange(ar,i+1,ar.length)).sum();
                m.putIfAbsent(Math.abs(s1-s2), new ArrayList<>());
                m.get(Math.abs(s1-s2)).add(new int[]{i});
			}
            int[] pos = new ArrayList<>(m.values()).get(0).get(0);
            if(pos.length==1){
                s1 = Arrays.stream(Arrays.copyOfRange(ar,0,pos[0])).sum();
                s2 = Arrays.stream(Arrays.copyOfRange(ar,pos[0]+1,ar.length)).sum();
                System.out.println(s1 + " ^" + pos[0] + " " + s2);
            }else{
                s1 = Arrays.stream(Arrays.copyOfRange(ar,0,pos[1])).sum();
                s2 = Arrays.stream(Arrays.copyOfRange(ar,pos[1],ar.length)).sum();
                System.out.println(s1 + " " + pos[0] + "^" + pos[1] + " " + s2);
            }
		}
        f.close();
    }
}
