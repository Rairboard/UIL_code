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

public class rank {
    public static void main(String[] args) throws Exception {
        new rank().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rank").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] smallCount = new int[ar.length-1];
            List<Integer> al = new ArrayList<>();
            for(int i = 0;i<ar.length-1;i++){
                al.add(ar[i]);
                Collections.sort(al);
                smallCount[i] = al.indexOf(ar[i]);
            }
//            out.println(Arrays.toString(ar));
//            out.println(Arrays.toString(smallCount));
            for (int i = 0; i < ar.length - 1; i++) {
                if(ar[i]==ar[ar.length-1]){
                    out.println(i+1+smallCount[i]);
                    break;
                }
            }
        }
        f.close();
    }
}
