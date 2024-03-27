import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class calendar {
    SimpleDateFormat ff = new SimpleDateFormat("MMMM d, yyyy");
    public static void main(String[] args) throws Exception {
        new calendar().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("calendar.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            String[] date = f.next().split("/");
            int N = f.nextInt();
            Calendar c = new GregorianCalendar(Integer.parseInt(date[2]),Integer.parseInt(date[0])-1,Integer.parseInt(date[1]));
            c.add(Calendar.DATE,N);
            System.out.println(ff.format(c.getTime()));
        }
        f.close();
    }
}