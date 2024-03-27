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

public class opus {
    public static void main(String[] args) throws Exception {
        new opus().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("opus").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,List<Student>> m = new HashMap<>();
        String[] division = new String[6];
        for (int i = 0; i < division.length; i++) {
            division[i] = i + 1 + "A";
        }
        String key = f.nextLine().replace("KEY","").replaceAll("\\s+","");
        while(f.hasNext()) {
            String first = f.next(), last = f.next(), school = f.next(), div=f.next();
            String ans = f.nextLine().replaceAll("\\s+","");
            int r = 0, w = 0, s = 0;
            for (int i = 0; i < ans.length(); i++) {
                if(ans.charAt(i)=='S'){
                    s++;
                }else{
                    if(ans.charAt(i) == key.charAt(i)){
                        r++;
                    }else{
                        w++;
                    }
                }
            }
            m.putIfAbsent(div,new ArrayList<>());
            m.get(div).add(new Student(first, last, school,r,w,s));
        }
        for (int i = 0; i < division.length; i++) {
            List<Student> al = new ArrayList<>(m.get(division[i]));
            Collections.sort(al);
            out.println(division[i]);
            int in = 1;
            for (int j = 0; j < al.size()-1; j++) {
                if (al.get(j).tie(al.get(j + 1))) {
                    al.get(j).p = in;
                    al.get(j+1).p = in;
                    in+=2;
                    j++;
                }else{
                    al.get(j).p = in;
                    in++;
                }
            }
            if(al.get(al.size()-1).p == Integer.MAX_VALUE){
                al.get(al.size()-1).p = in;
            }
            for (int j = 0; j < al.size(); j++) {
                out.println(al.get(j).p + " " + al.get(j));
            }
        }
        f.close();
    }
    class Student implements Comparable<Student>{
        String f,l,sc;
        int score;
        double rp;
        int r, w, s, p;
        public Student(String f,String l,String school,int r,int w,int s){
            this.f = f;
            this.l = l;
            sc = school;
            score = r * 6 - w * 2;
            rp = (double)r / (40-s);
            this.r = r;
            this.w = w;
            this.s = s;
            p = Integer.MAX_VALUE;
        }
        public int compareTo(Student o){
            if(score == o.score){
                if(rp == o.rp){
                    return (l + f).compareTo(o.l + o.f);
                }
                return Double.compare(o.rp,rp);
            }
            return o.score - score;
        }
        public boolean tie(Student o){
            return score == o.score && rp == o.rp;
        }
        public String toString(){
            return l + ", " + f + " - " + sc + ": " + score;
        }
    }
}
