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

public class xor {
    public static void main(String[] args) throws Exception {
        new xor().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("xor").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            Map<Integer,Integer> m =new HashMap<>();
            for (int i = 0; i < n; i++) {
                int price = f.nextInt();
                m.put(price, m.getOrDefault(price,0)+1);
            }
            for(Integer price : m.keySet()){
                if(m.get(price)%2==1){
                    out.println(price);
                    break;
                }
            }
        }
        f.close();
    }
}
