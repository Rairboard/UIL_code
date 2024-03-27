import java.util.*;
import java.io.File;

public class Homework {
	Map<String,Double> avg;
    public static void main(String[] args) throws Exception {
        new Homework().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("homework").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int t = 1; t<=times;t++) {
			avg = new HashMap<>();
			Set<homework> s =new TreeSet<>();
			List<String> hw = new ArrayList<>();
			String[] ln = f.nextLine().split("\\s+");
			for (int i = 0; i < ln.length; i+=2) {
				avg.put(ln[i],Double.parseDouble(ln[i+1]));
			}
			int m =f.nextInt();
			for (int i = 0; i < m; i++) {
				s.add(new homework(f.next(),f.next(),f.nextInt(),f.nextInt(),f.nextInt()));
			}
			int brain = f.nextInt(),time =f.nextInt();
			f.nextLine();
			for(homework h : s){
				if(brain>0&&time>0){
					hw.add(h.n);
					brain-=h.b;
					time-=h.t;
				}
			}
			System.out.println("DATASET: "  + t);
			for (int i = 0; i < hw.size(); i++) {
				System.out.println(hw.get(i));
			}
			System.out.println();
        }
        f.close();
    }
	class homework implements Comparable<homework>{
		String n,c;
		int w, t, b;
		public homework(String cl,String name,int brain,int time, int weight){
			c = cl;
			n = name;
			w = weight;
			t = time;
			b = brain;
		}
		public int compareTo(homework o){
			if(w == o.w){
				if(avg.get(c).equals(avg.get(o.c))){
					if(t == o.t){
						if(b == o.b){
							return n.compareTo(o.n);
						}
						return Integer.compare(b,o.b);
					}
					return Integer.compare(t,o.t);
				}
				return Double.compare(avg.get(c),avg.get(o.c));
			}
			return Integer.compare(o.w,w);
		}
		public String toString(){
			return c + " " + n + " " + b + " " + t + " " + w;
		}
	}
}
