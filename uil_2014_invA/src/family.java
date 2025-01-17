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

public class family {
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("family").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<String, List<List<String>>> m = new TreeMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            int ind = index(ln[1]);
            if (!m.containsKey(ln[0])) {
                m.put(ln[0], new ArrayList<>());
                for(int i = 0;i < 3;i++){
                    m.get(ln[0]).add(new ArrayList<>());
                }
            }
            if (!m.containsKey(ln[2])) {
                m.put(ln[2], new ArrayList<>());
                for(int i = 0;i < 3;i++){
                    m.get(ln[2]).add(new ArrayList<>());
                }
            }
            m.get(ln[0]).get(ind).add(ln[2]);
            if(ind==2){
                m.get(ln[2]).get(ind).add(ln[0]);
            }
        }
        for(String s : m.keySet()){
            out.println(s);
            String[] relationship = "Father,Mother,Sibling".split(",");
            for (int i = 0; i < relationship.length ; i++) {
                if(i < 2){
                    out.print(relationship[i] + ": ");
                    if(!m.get(s).get(i).isEmpty()){
                        out.println(m.get(s).get(i).getFirst());
                    }
                    else{
                        out.println("Unknown");
                    }
                }
                else{
                    if(!m.get(s).get(i).isEmpty()){
                        Collections.sort(m.get(s).get(i));
                        for(String st : m.get(s).get(i)){
                            out.println(relationship[i] + ": " + st);
                        }

                    }
                }
            }
        }

        f.close();
    }
    public int index(String s){
        if (s.equals("father")) {
            return 0;
        }
        if (s.equals("mother")) {
            return 1;
        }
        return 2;
    }
}
