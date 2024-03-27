import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.io.*;

public class swimLanes {
    static SimpleDateFormat ff = new SimpleDateFormat("m.ss.SS");
    public static void main(String[] args) throws Exception {
        new swimLanes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("swimLanes.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Map<Time,String> m = new TreeMap<>();
            for (int i = 0; i < 7; i++) {
                String s = f.next();
                m.put(new Time(f.next()),s);
            }
            List<String> al = new ArrayList<>(m.values());
            String[] ar = {al.get(5),al.get(3),al.get(1),al.get(0),al.get(2),al.get(4),al.get(6)};
            for (int i = 0; i < ar.length; i++) {
                System.out.println("Lane " + (i+1)+": " + ar[i]);
            }
            System.out.println();
        }
        f.close();
    }
    class Time implements Comparable<Time>{
        int min, sec, milli;
        Calendar c = new GregorianCalendar();
        public Time(String time){
            String[] l = time.split("\\.");
            min = Integer.parseInt(l[0]);
            sec = Integer.parseInt(l[1]);
            milli = Integer.parseInt(l[2]);
            c.set(c.MINUTE,min);
            c.set(c.SECOND,sec);
            c.set(c.MILLISECOND,milli);
        }
        public int compareTo(Time t){
            if(t.min==min){
                if(t.sec==sec){
                    return Integer.compare(milli,t.milli);
                }
                return Integer.compare(sec,t.sec);
            }
            return Integer.compare(min,t.min);
        }
        public String toString(){
            return ff.format(c.getTime());
        }
    }
}
