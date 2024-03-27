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

public class hiro {
    public static void main(String[] args) throws Exception {
        new hiro().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hiro").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String w = "IVXLCDM";
        int[] v = {1,5,10,50,100,500,1000};
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine();
            int tot = 0;
            for(int i=ln.length()-1;i>-1;i--){
                if(i-1>-1&&w.indexOf(ln.charAt(i-1))<w.indexOf(ln.charAt(i))){
                    int j = i-1, tmp = v[w.indexOf(ln.charAt(i))];
                    while(j-1>-1&&ln.charAt(j-1) == ln.charAt(j)){
                        tmp-=v[w.indexOf(ln.charAt(j))];
                        j--;
                    }
                    tmp-=v[w.indexOf(ln.charAt(j))];
                    tot+=tmp;
                    i=j;
                }else{
                    tot += v[w.indexOf(ln.charAt(i))];
                }
            }
            out.println(tot);
        }
        f.close();
    }
}
