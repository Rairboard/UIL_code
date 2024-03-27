import java.util.*;
import java.io.*;

public class vlad {
    public static void main(String[] args) throws Exception {
        new vlad().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("vlad.dat"));
        //Scanner f = new Scanner(System.in);
        Set<Student> s = new TreeSet<>();
       while(f.hasNext()) {
            String[] l = f.nextLine().replaceAll("[,\\.]","").split("\\s+");
            if(l.length==3){
                s.add(new Student(l[2],"",l[1]));
            }else{
                s.add(new Student(l[2],l[3],l[1]));
            }
        }
        for(Student ss : s){
            System.out.println(ss);
        }
        f.close();
    }
    static class Student implements Comparable<Student>{
        String first,middle, last;
        public Student(String ff, String m, String l){
            first = ff;
            middle = m;
            last = l;
        }
        public int compareTo(Student o){
            if (!last.equals(o.last)) {
                return last.compareTo(o.last) > 0 ? 1 :-1;
            }
            if (!first.equals(o.first)) {
                return first.compareTo(o.first) > 0 ? 1 : -1;
            }
            if (middle.equals("") && !o.middle.equals("")) {
                return -1;
            }
            if (!middle.equals("") && o.middle.equals("")) {
                return 1;
            }
            return middle.compareTo(o.middle) > 0 ? 1 : -1;
        }
        public String toString(){
            if(middle.equals("")){
                return first + " " + last;
            }
            return first + " " + middle + " " + last;
        }
    }
}
