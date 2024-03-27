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

public class blow {
    public static void main(String[] args) throws Exception {
        new blow().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blow").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        List<String> scale = new ArrayList<>(Arrays.asList("AWESOME SAUCE!,Pretty Good,Alright,Lame,Only For Dinosaurs".split(",")));
        int[] p = {50,150,300,500,1000};
        int times = f.nextInt();
        f.nextLine();
        o: for (int asdf = 1; asdf <= times; asdf++) {
            Map<String,String> type = new HashMap<>();
            Map<String,Integer> people = new TreeMap<>();
            List<String> blow = new ArrayList<>();
            int d = f.nextInt(), s = f.nextInt();
            f.nextLine();
            for (int i = 0; i < d; i++) {
                String[] ln = f.nextLine().split("\"\\s+");
                type.put(ln[0].substring(1),ln[1]);
            }
            out.println(type);
            for (int i = 0; i < s; i++) {
                String[] ln = f.nextLine().split("\"\\s+");
                String song = ln[0].substring(1);
                people.putIfAbsent(song,0);
                people.put(song,people.get(song)+Integer.parseInt(ln[1]));
                int score = p[scale.indexOf(type.get(song))];
                if(people.get(song)>=score){
                    blow.add(song);
                }
                out.println(people);
            }
            if(!blow.isEmpty()){
                out.println(blow.get(0));
            }
            else{
                out.println("False Alarm");
            }
        }
        f.close();
    }
}
