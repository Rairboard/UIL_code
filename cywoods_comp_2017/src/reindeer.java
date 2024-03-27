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

public class reindeer {
    public static void main(String[] args) throws Exception {
        new reindeer().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("reindeer").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt();
			List<Reindeer> s = new ArrayList<>();
			Reindeer rd= null;
			for (int i = 0; i < n; i++) {
				String name = f.next();
				int nv = f.nextInt(),sta = f.nextInt(), str = f.nextInt(), fl=f.nextInt(), len =f.nextInt();
				boolean b =f.nextBoolean();
				if(!name.equals("Sammy")){
					if(name.equals("Rudolph")){
						rd = new Reindeer(name,nv,sta,str,fl,len,b);
					}else{
						s.add(new Reindeer(name,nv,sta,str,fl,len,b));
					}
				}
			}
			Collections.sort(s);
			if(rd!=null){
				out.println(rd.n);
				for (int i = 0; i < s.size() && i < 11; i++) {
					out.println(s.get(i).n);
				}
			}
			else{
				for (int i = 0; i < s.size() && i < 12; i++) {
					out.println(s.get(i).n);
				}
			}
			out.println();
        }
        f.close();
    }
	class Reindeer implements Comparable<Reindeer>{
		int nv,sta, str,fl,antLen,spot,nameOrder;
		String n;
		public Reindeer(String name,int navigation, int stamina, int strength, int fluffy, int len, boolean spot){
			n = name;
			nv = navigation;
			sta = stamina;
			str = strength;
			fl = fluffy;
			antLen = len;
			if(spot){
				this.spot = 1;
			}else{
				this.spot = 0;
			}
		}
		@Override
		public int compareTo(Reindeer o) {
				if(nv == o.nv){
					if(sta == o.sta){
						if(str == o.str){
							if(fl == o.fl){
								if(antLen == o.antLen){
									if(spot == o.spot){
										return n.compareTo(o.n);
									}
									return 	spot < o.spot?1 : -1;
								}
								return antLen > o.antLen?1 : -1;
							}
							return fl < o.fl ? 1 : -1;
						}
						return str < o.str ? 1 : -1;
					}
					return sta < o.sta ? 1 : -1;
				}
				return nv < o.nv ? 1 : -1;
		}
	}
}
