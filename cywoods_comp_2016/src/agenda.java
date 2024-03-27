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

public class agenda {
	SimpleDateFormat ff = new SimpleDateFormat("MMMM/dd/yyyy - EEEE");
    public static void main(String[] args) throws Exception {
        new agenda().run();
    }

    public void run() throws Exception {
		List<String> al =new ArrayList<>(Arrays.asList("January,February,March,April,May,June,July,August,September,October,November,December".split(",")));
		List<String> dow = new ArrayList<>(Arrays.asList("SUNDAYS,MONDAYS,TUESDAYS,WEDNESDAYS,THURSDAYS,FRIDAYS,SATURDAYS".split(",")));
        Scanner f = new Scanner(new File(("agenda").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		while (times-- > 0) {
			Map<String,String[]> m = new HashMap<>();
			Set<String> classes = new TreeSet<>();
			Calendar c = new GregorianCalendar();
			while(f.hasNext()){
				String ln = f.nextLine();
				if(!ln.contains("-")){
					String[] d = ln.split("[\\s\\,]+");
					if(d.length==2){
						c = new GregorianCalendar(2016,al.indexOf(d[0]),Integer.parseInt(d[1]));
					}
					else{
						c = new GregorianCalendar(Integer.parseInt(d[2]),al.indexOf(d[0]),Integer.parseInt(d[1]));
					}
					break;
				}else{
					String[] l = ln.split("\\s+\\-\\s+");
					m.put(l[0],l[1].split(",\\s+"));
				}
			}
			for(String cl : m.keySet()){
				for(String s : m.get(cl)){
					if(s.equals("ODD DAYS")){
						if(c.get(Calendar.DATE)%2==1){
							classes.add(cl);
						}
					}
					if(s.equals("EVEN DAYS")){
						if(c.get(Calendar.DATE)%2==0){
							classes.add(cl);
						}
					}
					if (s.contains("NOT") && !dow.get(c.get(Calendar.DAY_OF_WEEK)-1).equals(s.split("\\s+")[1])) {
						classes.add(cl);
					}
					if (dow.get(c.get(Calendar.DAY_OF_WEEK)-1).equals(s)) {
						classes.add(cl);
					}
					if (s.contains("WEEK")) {
						if(c.get(Calendar.WEEK_OF_MONTH)==Integer.parseInt(s.split("\\s+")[1])){
							classes.add(cl);
						}
					}
				}
			}
			if(classes.size()==0){
				out.println("NONE");
			}else{
				String ln = "";
				for(String s : classes){
					ln+=s+", ";
				}
				out.println(ln.substring(0, ln.lastIndexOf(",")));
			}
        }
        f.close();
    }
}
