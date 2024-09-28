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

public class isha {
    int[][] time = {{0,89,121,0,0},{89,0,130,0,263},{121,130,0,125,174},{0,0,125,0,119},{0,263,174,119,0}};
    Calendar save;
    SimpleDateFormat ff = new SimpleDateFormat("hh:mm a");
    Map<Integer,Integer> timezone;
    public static void main(String[] args) throws Exception {
        new isha().run();
    }

    public void run() throws Exception {
        timezone = new HashMap<>();
        timezone.put(0,0);
        timezone.put(1,0);
        timezone.put(2,1);
        timezone.put(3,2);
        timezone.put(4,2);
        List<String> al = new ArrayList<>(Arrays.asList("Orlando,Charlotte,Houston,Denver,San Diego".split(",")));
        Scanner f = new Scanner(new File(("isha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            save = new GregorianCalendar();
            String[] ln = f.nextLine().split("\\s+");
            String one="",two="",t="";
            Calendar c = new GregorianCalendar();
            if(ln[1].matches("[0-9]{1,2}:[0-9]{1,2}")){
                one = ln[0];
                t=ln[1] + " "+ln[2];
                t = t.replaceAll("A\\.M\\.","AM").replaceAll("P\\.M\\.","PM");
                for(int i = 3;i<ln.length;i++){
                    two+=ln[i]+" ";
                }
            }
            else{
                one = ln[0] + " " + ln[1];
                t=ln[2] + " "+ ln[3];
                t = t.replaceAll("A\\.M\\.","AM").replaceAll("P\\.M\\.","PM");
                for(int i = 4;i<ln.length;i++){
                    two+=ln[i]+" ";
                }
            }
            two = two.trim();
            c.setTime(ff.parse(t));
            out.println(ff.format(c.getTime()));
            Set<Integer> visited = new HashSet<>();
            out.println(al.indexOf(one) +" " + al.indexOf(two));
            recur(al.indexOf(one),al.indexOf(two),c,visited);
            out.println(one + " " + t.replaceAll("AM","A.M.").replaceAll("PM","P.M.") + " " + two +" " + ff.format(save.getTime()).replaceAll("AM","A.M.").replaceAll("PM","P.M."));
        }
        f.close();
    }
    public boolean recur(int cur, int target, Calendar c, Set<Integer> visited){
        if(cur==target){
            save.setTime(c.getTime());
            return true;
        }
        visited.add(cur);
        for (int i = 0; i < time[cur].length; i++) {
            if(!visited.contains(i) && time[cur][i]!=0){
                c.add(Calendar.MINUTE,time[cur][i]);
                if(!timezone.get(cur).equals(timezone.get(i))){
                    c.add(Calendar.MINUTE,60);
                }
                if (recur(i, target, c, visited)) {
                    return true;
                }
                c.add(Calendar.MINUTE,-time[cur][i]);
                if(!timezone.get(cur).equals(timezone.get(i))){
                    c.add(Calendar.MINUTE,-60);
                }
            }
        }
        visited.remove(cur);
        return false;
    }
}
