import java.util.*;
import java.io.File;
import java.text.*;

import static java.lang.System.*;

public class friday_ThanhLe {
    public static void main(String[] args) throws Exception {
        new friday_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("friday.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int m =f.nextInt(), d= f.nextInt(),y =f.nextInt();
			Calendar c = new GregorianCalendar(y,m-1,d);
			out.println(c.get(Calendar.DAY_OF_WEEK) == 6  && d == 13 ? "DON'T TEST YOUR LUCK!":"NO WORRIES!");
        }
        f.close();
    }
}
