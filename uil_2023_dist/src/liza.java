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

public class liza {
    public static void main(String[] args) throws Exception {
        new liza().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("liza").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.println(f.nextLine());
            double sum = 0;
            List<Student> al = new ArrayList<>();
            int m = f.nextInt();
            if(f.hasNext())f.nextLine();
            for (int i = 0; i <m ; i++) {
                String[] ln = f.nextLine().trim().split(",");
                al.add(new Student(ln[0],ln[1],Long.parseLong(ln[2])));
                sum+=Long.parseLong(ln[2]);
            }
            sum/=m;
            Collections.sort(al);
            for(int i = 0;i < 3 && i < al.size();i++){
                out.println(al.get(i).last + " " + al.get(i).first + ": " + (long)al.get(i).grade);
            }
            out.printf("MEAN SCORE: %.2f\n", sum);
            if (al.size() % 2 == 0){
                double median = (al.get(al.size()/2).grade + al.get(al.size()/2-1).grade) / 2;
                out.printf("MEDIAN SCORE: %.1f\n", median);
            }
            else{
                out.printf("MEDIAN SCORE: %.1f\n", al.get(al.size()/2).grade);
            }
            out.println();
        }
        f.close();
    }
    class Student implements Comparable<Student>{
        double grade;
        String first, last;
        public Student(String ff, String ll, double gr){
            first = ff;
            last = ll;
            grade = gr;
        }
        public int compareTo(Student o){
            if(grade ==o.grade){
                if(o.first.compareTo(first)==0){
                    return last.compareTo(o.last);
                }
                return first.compareTo(o.first);
            }
            return Double.compare(o.grade,grade);
        }
    }
}
