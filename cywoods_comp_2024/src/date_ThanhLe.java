import java.util.*;
import java.io.File;

public class date_ThanhLe {
    public static void main(String[] args) throws Exception {
        new date_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("date").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int m = f.nextInt() - 1, d = f.nextInt(), y = f.nextInt();
            Calendar c = new GregorianCalendar(y,m,d);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            c.add(Calendar.DATE,1);
            System.out.println(c.get(Calendar.MONTH) + 1 + " " + c.get(Calendar.DATE) + " " + c.get(Calendar.YEAR));
            if( dayOfWeek>=2 && dayOfWeek<=6 && c.get(Calendar.DAY_OF_MONTH)==1){
                System.out.println("TODAY IS THE DAY!");
            }
            else{
                System.out.println("NO ROBBING!");
            }
        }
        f.close();
    }
}
