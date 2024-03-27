import java.util.*;
import java.io.*;

public class dasha {
    public static void main(String[] args) throws Exception {
        new dasha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dasha.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			long a = f.nextLong(), b = f.nextLong(), m = f.nextLong(), x0 = f.nextLong(), prev = x0;
			Set<Long> s =new HashSet<>();
			List<Long> al = new ArrayList<>();
			al.add(x0);
			s.add(x0);
			for (int i = 0; i < m; i++) {
				long N  = (a * al.get(al.size()-1) + b) %m;
				//System.out.println(N);
				al.add(N);
				s.add(N);
			}
			System.out.println(s.size() +" / " + m );
        }
        f.close();
    }
}
