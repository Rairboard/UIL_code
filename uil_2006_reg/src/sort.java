import java.util.*;
import java.io.*;

public class sort {
    public static void main(String[] args) throws Exception {
        new sort().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("sort.in"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        for (int i =1; i <= t; i++) {
            HashMap<String,String> hm = new HashMap();
            ArrayList<String> al = new ArrayList<>();
            long n = f.nextLong();
            f.nextLine();
            for (int j = 0; j < n; j++) {
                String str1 = f.nextLine();
                StringBuilder str= new StringBuilder(str1).reverse();
                al.add(str.toString().toLowerCase());
                hm.put(str.toString().toLowerCase(),str1);
            }
            Collections.sort(al);
            System.out.println("Data Set #" + i);
            for (String str :
                    al) {
                System.out.println(hm.get(str));
            }
        }

        f.close();
    }
}