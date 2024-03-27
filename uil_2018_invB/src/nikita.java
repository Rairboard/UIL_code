import java.util.*;
import java.io.*;

public class nikita {
	static int[][] m;
    public static void main(String[] args) throws Exception {
        new nikita().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("nikita.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int N = f.nextInt();f.nextLine();
			Map<Double,Set<Character>> degree = new TreeMap<>(), closeness = new TreeMap<>();
			Map<Character,HashMap<Integer,Integer>> time = new HashMap<>();
			m = new int[N][N];
			char c = 'A';
			for (int i = 0; i < N; i++) {
				m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					time.putIfAbsent(c,new HashMap<>());
					time.get(c).putIfAbsent(m[i][j],0);
					time.get(c).put(m[i][j],time.get(c).get(m[i][j])+1);
				}
				c++;
			}
			for(Character character : time.keySet()){
				double d = (double)time.get(character).get(1)/(m.length-1);
				degree.putIfAbsent(d,new TreeSet<>());
				degree.get(d).add(character);
				double cc = 0;
				for(Integer link : time.get(character).keySet()){
					cc += link * time.get(character).get(link);
				}
				cc = (m.length-1)/cc;
				closeness.putIfAbsent(cc,new TreeSet<>());
				closeness.get(cc).add(character);
			}
			List<Double> degreeKey = new ArrayList<>(degree.keySet());
			List<Double> closenessKey = new ArrayList<>(closeness.keySet());
			System.out.printf("%-19s%.2f ","least degree",degreeKey.get(0));
			degree.get(degreeKey.get(0)).forEach(e -> System.out.print(e));
			System.out.println();
			System.out.printf("%-19s%.2f ","greatest degree",degreeKey.get(degreeKey.size()-1));
			degree.get(degreeKey.get(degreeKey.size()-1)).forEach(e -> System.out.print(e));
			System.out.println();
			System.out.printf("%-19s%.2f ","least closeness",closenessKey.get(0));
			closeness.get(closenessKey.get(0)).forEach(e -> System.out.print(e));
			System.out.println();
			System.out.printf("%-19s%.2f ","greatest closeness",closenessKey.get(closenessKey.size()-1));
			closeness.get(closenessKey.get(closenessKey.size()-1)).forEach(e -> System.out.print(e));
			System.out.println("\n---");
		}
        f.close();
    }
}
