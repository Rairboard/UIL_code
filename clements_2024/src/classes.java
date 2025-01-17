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

public class classes {
    List<String> time = new ArrayList<>(List.of("11:00-15:00,15:00-18:00,9:00-11:00,18:00-20:00,7:00-9:00".split(",")));
    static SimpleDateFormat ff = new SimpleDateFormat("HH:mm");
    List<String> sub = new ArrayList<>(List.of("Writing,Lighting,Sound-Design,Casting,Set-Design".split(",")));
    public static void main(String[] args) throws Exception {
        new classes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("classes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<String> pre = new ArrayList<>(Arrays.asList(f.nextLine().trim().split("\\s+")));
        List<Item> al = new ArrayList<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            boolean good = true;
            String[] ln = f.nextLine().trim().split("\\|");
            String code = ln[0];
            String coursename = ln[1];
            int hour = Integer.parseInt(ln[2]);
            String subject = ln[3];
            double rating = Double.parseDouble(ln[4]);
            String time = ln[5];
            String[] precourse = ln[6].split(",\\s+");
            for (int i = 0; i < precourse.length; i++) {
                if (!pre.contains(precourse[i])) {
                    good = false;
                    break;
                }
            }
            if(good){
                al.add(new Item(code, coursename, hour, subject, rating, time));
            }
        }
        Collections.sort(al);
        int total = 0;
        for (int i = 0; i < al.size(); i++) {
            if(total + al.get(i).hour < 21){
                out.println(al.get(i).code + ": " + al.get(i).name);
                total+=al.get(i).hour;
            }
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        String code, name;
        int hour, timeIndex, subject;
        double rating;
        public Item (String c, String n, int h, String sj, double r, String t) throws ParseException {
            code = c;
            name = n;
            hour = h;
            subject = sub.indexOf(sj);
            rating = r;
            for (int i = 0; i < time.size() ; i++){
                String[] ln = time.get(i).split("-");
                Calendar a = new GregorianCalendar(), b = new GregorianCalendar(), cal = new GregorianCalendar();
                a.setTime(ff.parse(ln[0]));
                b.setTime(ff.parse(ln[1]));
                cal.setTime(ff.parse(t));
                if(cal.compareTo(a) >=0 && cal.compareTo(b) < 0){
                    timeIndex = i;
                    break;
                }
            }
        }
        public int compareTo(Item o){
            if(subject == o.subject){
                if(rating == o.rating){
                    if(timeIndex == o.timeIndex){
                        if(hour == o.hour){
                            return code.compareTo(o.code);
                        }
                        return hour - o.hour;
                    }
                    return timeIndex - o.timeIndex;
                }
                return Double.compare(o.rating, rating);
            }
            return subject - o.subject;
        }
    }
}
