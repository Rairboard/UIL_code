import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class fullhouse {
    public static void main(String[] args) throws Exception {
        new fullhouse().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fullhouse").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			List<Player> al = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				String name = f.next();
				int[] val = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(val);
				al.add(new Player(name, val));
			}
			Collections.sort(al);
			int FH = 0;
			for (int i = 0; i < al.size(); i++) {
				if(al.get(i).FH){
					FH++;
				}
			}
			if(FH>0){
				int BFH = 1;
				int[] best = al.getLast().val;
				List<String> name = new ArrayList<>();
				name.add(al.getLast().name);
				for(int i = 0;i < al.size()-1;i++){
					if(Arrays.equals(best, al.get(i).val)){
						BFH++;
						name.add(al.get(i).name);
					}
				}
				if(BFH>1){
					out.print("TIE ");
					Collections.sort(name);
					for(String s : name){
						out.print(s + " ");
					}
					out.println();
				}
				else{
					out.println(name.getFirst());
				}
			}
			else{
				out.println("NO WINNER");
			}
        }
        f.close();
    }
	class Player implements Comparable<Player>{
		String name;
		boolean FH;
		int[] val;
		int three, two;
		public Player(String n,  int[] v){
			name = n;
			val = v;
			Map<Integer,Integer> m = new HashMap<>();
			for (int i = 0; i < val.length; i++) {
				m.put(val[i], m.getOrDefault(val[i], 0) + 1);
			}
			if(m.size()==2){
				List<Integer> values =new ArrayList<>(m.values());
				int min = Math.min(values.getFirst(), values.getLast());
				int max = Math.max(values.getFirst(), values.getLast());
				FH =  min == 2 && max == 3;
			}
			else{
				FH = false;
			}
			if(FH){
				List<Integer> key =new ArrayList<>(m.keySet());
				if(m.get(key.getFirst())==2){
					two = key.getFirst();
					three = key.getLast();
				}
				else{
					two = key.getLast();
					three = key.getFirst();
				}
			}
		}
		public int compareTo(Player o){
			if(FH && o.FH){
				if(three == o.three){
					if(two == o.two){
						return 0;
					}
					return two - o.two;
				}
				return three - o.three;
			}
			if(FH){
				return 1;
			}
			if(o.FH){
				return -1;
			}
			return 0;
		}
	}
}
