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

public class shekhar {
    public static void main(String[] args) throws Exception {
        new shekhar().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shekhar").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char[] ar = f.nextLine().trim().toCharArray();
            Stack<Character> st = new Stack<>();
            for(char ch : ar){
                if("({[".contains(ch+"")){
                    st.push(ch);
                } else if (")}]".contains(ch + "") && st.size() > 0) {
                    String rev = new StringBuilder(st.peek()+"").reverse().toString();
                    if(rev.charAt(0) - ch < 0){
                        st.pop();
                    }
                }
                else if (")}]".contains(ch + "") && st.size() <= 0){
                    st.push(ch);
                }
            }
            if(st.isEmpty()){
                out.println(new String(ar) + " is nested correctly");
            }
            else{
                out.println(new String(ar) + " is nested incorrectly");
            }
        }
        f.close();
    }
}
