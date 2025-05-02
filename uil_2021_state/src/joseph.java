import java.util.*;
import java.io.*;
public class joseph {
	public static void main(String[] args)throws Exception {
		new joseph().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("joseph.dat"));
        //Scanner f = new Scanner(System.in);
        String[] a = f.nextLine().trim().split("\\s+");
        long[] score1 = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        String[] b = f.nextLine().trim().split("\\s+");
        long[] score2 = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
        Map<Long, List<String[]>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                m.putIfAbsent(Math.abs(score1[i] - score2[j]), new ArrayList<>());
                m.get(Math.abs(score1[i] - score2[j])).add(new String[]{a[i], b[j]});
            }
        }
        for(long i = 1;i<=10;i++){
            if (m.containsKey(i)) {
                Collections.sort(m.get(i), (one,two)-> one[0].compareTo(two[0]) == 0 ? one[1].compareTo(two[1]) : one[0].compareTo(two[0]));
                for(String[] each : m.get(i)){
                    System.out.println(each[0] + " " + each[1] + " " + i);
                }
            }
        }
        f.close();
	}
}
