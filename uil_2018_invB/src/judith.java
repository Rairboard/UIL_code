import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class judith {
    public static void main(String[] args) throws Exception {
        new judith().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("judith.dat"));
        //Scanner f = new Scanner(System.in);
        List<BigDecimal> al = new ArrayList<>();
		while(f.hasNext()){
			al.add(f.nextBigDecimal());
		}
		Collections.sort(al);
		al.forEach(n -> System.out.println(n));
        f.close();
    }
}
