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

public class math {
    public static void main(String[] args) throws Exception {
        String s;
        s = "the black parade";
        String[] list;
        list = s.split("[^a]a");

        out.println(list[3]);
        out.println(Arrays.toString(list));

        list = s.split("");
        out.println(list.length);
        out.println(list[0]);
//        new math().run();
    }
    public int xx(Object b1, Object b2){
        int ret = 1;
        if(b1==b2){
            ret+=3;
        }
        else{
            ret-=3;
        }
        return ret;
    }
    public void run() throws Exception {
        out.println(xx(2L,2.0f));

    }

}
