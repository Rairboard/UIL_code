import java.util.*;
import java.io.*;

public class pankaj {
	Map<String,Set<String>> hm;
    public static void main(String[] args) throws Exception {
        new pankaj().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("pankaj.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
		f.nextLine();
		for (int t = 1; t <= times ; t++) {
			String[] p = f.nextLine().split("\\,");
			String[] relationships = f.nextLine().split("\\,");
			hm = new HashMap<>();
			for (int i = 0; i < p.length; i++) {
				hm.put(p[i],new HashSet<>());
			}
			for (int i = 0; i < relationships.length; i++) {
				String[] pair = relationships[i].split("<->");
				hm.get(pair[0]).add(pair[1]);
				hm.get(pair[1]).add(pair[0]);
			}
			boolean beAble = true;
			Queue<String> q = new LinkedList<>();
			Set<String> one = new HashSet<>();
			Set<String> two =new HashSet<>();
			q.offer(p[0]);
			one.add(p[0]);
			while(!q.isEmpty()){
				String camper = q.poll();
				for(String known : hm.get(camper)){
					if(one.contains(known) && one.contains(camper)){
						beAble = false;
					}
					if(two.contains(known) && two.contains(camper)){
						beAble = false;
					}
					if(!one.contains(known) && !two.contains(known)){
						if(one.contains(camper)){
							two.add(known);
						}
						else{
							one.add(known);
						}
						q.offer(known);
					}
				}
			}
			System.out.println("Test case " + t + ": " + (beAble?"possible":"impossible"));
		}
        f.close();
    }

}
