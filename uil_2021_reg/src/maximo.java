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

public class maximo {
    public static void main(String[] args) throws Exception {
        new maximo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("maximo").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.nextLine();
            String b = f.nextLine();
            List<String> A = new ArrayList<>(Arrays.asList(a.substring(a.indexOf("{")+1,a.indexOf("}")).split(",")));
            List<String> B = new ArrayList<>(Arrays.asList(b.substring(b.indexOf("{")+1,b.indexOf("}")).split(",")));
            if (A.containsAll(B) && B.containsAll(A)) {
                out.println("Set A is equal to Set B");
            } else if (A.containsAll(B)) {
                out.println("Set B is a subset of Set A");
            } else if (B.containsAll(A)) {
                out.println("Set A is a subset of Set B");
            }
            else{
                A.retainAll(B);
                List<Integer> al = new ArrayList<>();
                for (int i = 0; i < A.size(); i++) {
                    al.add(Integer.parseInt(A.get(i)));
                }
                Collections.sort(al);
                out.print("Neither set is a subset of the other. Their intersection is: {");
                for (int i = 0; i < al.size(); i++) {
                    out.print(al.get(i));
                    if(i<al.size()-1){
                        out.print(",");
                    }
                }
                out.println("}");
            }
        }
        f.close();
    }
}
