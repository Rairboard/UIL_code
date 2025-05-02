import java.util.*;
import java.io.*;
public class kamalika {
	public static void main(String[] args)throws Exception {
		new kamalika().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("kamalika.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double a = f.nextDouble(), b = f.nextDouble();
            List<Object[]> al = new ArrayList<>();
            al.add(new Object[]{"Dif", a-b});
            al.add(new Object[]{"Div", a/b});
            al.add(new Object[]{"Mod", a%b});
            al.add(new Object[]{"Sum", a + b});
            al.add(new Object[]{"Prd", a* b});
            al.add(new Object[]{"A^B", Math.pow(a,b)});
            al.add(new Object[]{"B^A", Math.pow(b,a)});
            Collections.sort(al, (c,d) -> Double.compare((double) c[1], (double)d[1]));
            System.out.print("|");
            for (int i = 0; i < al.size(); i++) {
                System.out.printf("%s%6.2f|", al.get(i)[0], (double)al.get(i)[1]);
            }
            System.out.println();
        }
        f.close();
	}
}
