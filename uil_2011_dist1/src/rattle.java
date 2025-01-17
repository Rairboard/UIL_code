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

public class rattle {
    public static void main(String[] args) throws Exception {
        new rattle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rattle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            int size = 1;
            while(size * size < ln.length()){
                size++;
            }
            char[][] m = new char[size][size];
            int index = 0;
            char filler = 'A';
            for (int i = 0; i < size; i++) {
                for(int j = 0;j < size;j++){
                    if(index<ln.length()){
                        m[i][j] = ln.charAt(index);
                    }
                    else if(index==ln.length()){
                        m[i][j] = '*';
                    }
                    else{
                        m[i][j] = filler++;
                    }
                    index++;
                }
            }
            for(int j = 0;j < size;j++){
                String col = "";
                for(int i =0;i < size;i++){
                    col+=m[i][j];
                }
                if((j+1)%2==1){
                    col = col.substring(1 ) + col.charAt(0);
                }
                else{
                    col = col.charAt(col.length()-1) + col.substring(0,col.length()-1);
                }
                index = 0;
                for(int i =0 ;i < size;i++){
                    m[i][j] = col.charAt(index++);
                }
            }
            String res = "";
            for(char[] c : m){
                res+=new String(c);
            }
            if (res.contains("*")) {
                res = res.substring(0,res.indexOf("*"));
            }
            out.println(res);
        }
        f.close();
    }
}
