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

public class manisha {
    public static void main(String[] args) throws Exception {
        new manisha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("manisha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().replaceAll("\\s+","").split("\\+");
            List<Whole> al = new ArrayList<>();
            for (int i = 0; i < ln.length; i++) {
                List<Product> asdf = new ArrayList<>();
                for (int j = 0; j < ln[i].length(); j++) {
                    if(ln[i].charAt(j)=='/'){
                        asdf.add(new Product(ln[i].substring(j,j+2)));
                        j++;
                    }
                    else{
                        asdf.add(new Product(ln[i].substring(j,j+1)));
                    }
                }
                Collections.sort(asdf);
                String s = "";
                for (int j = 0; j < asdf.size(); j++) {
                    s+=asdf.get(j).n;
                }
                al.add(new Whole(s));
            }
            Collections.sort(al);
            for(int i=0;i<al.size();i++){
                if(i==al.size()-1){
                    out.print(al.get(i).n);
                }
                else{
                    out.print(al.get(i).n+"+");
                }
            }
            out.println();
        }
        f.close();
    }
    class Product implements Comparable<Product>{
        String n, alp;
        int sl;
        public Product(String orig) {
            n = orig;
            alp = orig.replaceAll("[^a-zA-Z]", "");
            sl = alp.indexOf("/");
        }
        public int compareTo(Product o){
            if(alp.compareTo(o.alp)==0){
                return sl - o.sl;
            }
            return alp.compareTo(o.alp);
        }
    }
    class Whole implements Comparable<Whole>{
        String n, alp;
        int sl ;
        public Whole(String orig){
            n = orig;
            alp = orig.replaceAll("[^a-zA-Z]", "");
            sl = alp.indexOf("/");
        }
        public int compareTo(Whole o){
            if(alp.length()==o.alp.length()){
                if(alp.compareTo(o.alp)==0){
                    return sl - o.sl;
                }
                return alp.compareTo(o.alp);
            }
            return alp.length()-o.alp.length();
        }
    }

}
