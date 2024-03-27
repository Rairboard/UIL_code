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

public class hashcodes {
    Set<String> hs;
    static String alp;
    public static void main(String[] args) throws Exception {
        alp = "";
        for(char c = 'A';c <='Z';c++){
            alp+=c;
        }
        out.println(alp);
        new hashcodes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hashcodes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            hs = new HashSet<>();
            int n = f.nextInt(), s = f.nextInt();
            permu(0,alp,"",n,s);
            out.println(hs.size());
        }
        f.close();
    }
    public void permu(int i,String orig, String ans,int n,int s){
        if(i==orig.length()){
            if(ans.length()==n){
                int sum = 0;
                for (int j = 0; j < ans.length(); j++) {
                    sum+=ans.charAt(j)-64;
                }
                if(sum==s){
                    hs.add(ans);
                }
            }
        }
        else{
            permu(i+1,orig,ans+orig.charAt(i),n,s);
            permu(i+1,orig,ans,n,s);
        }
    }
}
