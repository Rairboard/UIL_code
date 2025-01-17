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

public class code {
    public static void main(String[] args) throws Exception {
        new code().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("code").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String alphabet = "";
        for(char c = 'a';c<='z';c++){
            alphabet += c;
        }
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String shift = f.next();
            int offset = f.nextInt();
            int direction = (int)Math.signum(offset);
            offset = Math.abs(offset);
            f.nextLine();
            int n = f.nextInt();
            f.nextLine();
            out.println("Protocol " + asdf);
            for (int i = 0; i < n; i++) {
                char ch = f.next().charAt(0);
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int j = 0; j < ln.length; j++) {
                    char[] s = ln[j].toCharArray();
                    for (int k = 0; k < s.length; k++) {
                        if(Character.isLowerCase(s[k])){
                            char cur = shift.charAt(alphabet.indexOf(s[k]));
                            if(ch=='E'){
                                if(direction == 1){
                                    s[k] = alphabet.charAt((alphabet.indexOf(cur) + offset)%26);
                                }
                                else{
                                    s[k] = alphabet.charAt(((alphabet.indexOf(cur) - offset)+26)%26);
                                }
                            }
                            else{

                                if(direction == 1){
                                    s[k] = alphabet.charAt(shift.indexOf(alphabet.charAt(((alphabet.indexOf(s[k]) - offset)+26)%26)));
                                }
                                else{
                                    s[k] = alphabet.charAt(shift.indexOf(alphabet.charAt(((alphabet.indexOf(s[k]) + offset)+26)%26)));
                                }
                            }
                        }
                    }
                    out.print(new String(s)+ " ");
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
}
