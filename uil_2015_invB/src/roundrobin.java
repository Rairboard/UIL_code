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

public class roundrobin {
    public static void main(String[] args) throws Exception {
        new roundrobin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("roundrobin").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n= f.nextInt(), m = f.nextInt();
			f.nextLine();
			List<String> al = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				al.add(f.nextLine());
			}
			HashSet<String> order = new HashSet<>();
			HashSet<String> played = new HashSet<>();
			HashSet<String> dup = new HashSet<>();
			boolean invalid = false;
			for(int i = 1;i<=n;i++){
				for(int j = i+1;j<=n;j++){
					order.add(i + " v " + j);
				}
			}
			for (int i = 0; i < m; i++) {
				String[] ln = f.nextLine().trim().split("\\s+v\\s+");
				int a = Integer.parseInt(ln[0]);
				int b = Integer.parseInt(ln[1]);
				if(a >= 30 || b >= 30 || a == b || a < 1 || b < 1) {
					invalid = true;
					continue;
				}
				int A = Math.min(a,b);
				int B = Math.max(a,b);
				String match = A + " v " + B;
				if (played.contains(match)) {
					dup.add(match);
				}
				else{
					played.add(match);
				}
			}
			for(String s : played){
				order.remove(s);
			}
			if(order.isEmpty() && !invalid && dup.isEmpty()){
				out.println("YES");
			}
			else{
				out.println("NO");
				if(invalid) {
					out.println("INVALID GAMES");
					out.println();
					continue;
				}
				List<String> pair = new ArrayList<>();
				for(String p : order){
					String[] ln = p.split(" v ");
					String one = al.get(Integer.parseInt(ln[0]) -1);
					String two = al.get(Integer.parseInt(ln[1])-1);
					if(one.compareTo(two) < 0){
						pair.add(one + " v " + two);
					}
					else{
						pair.add(two + " v " + one);
					}
				}
				Collections.sort(pair);
				if(!pair.isEmpty()){
					out.println("MISSING GAMES");
					for(String s : pair){
						out.println(s);
					}
				}
				if(!dup.isEmpty()){
					out.println("DUPLICATE GAMES");
					pair = new ArrayList<>();
					for(String p : dup){
						String[] ln = p.split(" v ");
						String one = al.get(Integer.parseInt(ln[0]) -1);
						String two = al.get(Integer.parseInt(ln[1])-1);
						if(one.compareTo(two) < 0){
							pair.add(one + " v " + two);
						}
						else{
							pair.add(two + " v " + one);
						}
					}
					Collections.sort(pair);
					for(String s : pair){
						out.println(s);
					}
				}
            }
			out.println();
        }
        f.close();
    }
}
