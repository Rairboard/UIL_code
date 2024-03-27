import java.util.*;
import java.io.File;

public class countdown {
    public static void main(String[] args) throws Exception {
        new countdown().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("countdown").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Calendar d = new GregorianCalendar(2017,Calendar.DECEMBER,15);
        while (times-- > 0) {
            String[] ln = f.nextLine().split("/");
            Calendar c = new GregorianCalendar(Integer.parseInt(ln[2]),Integer.parseInt(ln[1])-1,Integer.parseInt(ln[0]));
            if (c.equals(d)) {
                System.out.println("It's Today!");
            }else{
                int days = 0;
                while(c.compareTo(d)<0){
                    c.add(Calendar.DATE,1);
                    days++;
                }
                System.out.println(days + " days(s) left!");
            }
        }
        f.close();
    }
}
