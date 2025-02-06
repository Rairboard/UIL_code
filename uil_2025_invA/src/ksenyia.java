import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class ksenyia {
    List<String> USER, PASS;
    public static void main(String[] args) throws Exception {
        new ksenyia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ksenyia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        USER = new ArrayList<>();
        PASS = new ArrayList<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String user = f.nextLine();
            String pass = f.nextLine();
            boolean u = usercheck(user);
            boolean p = passcheck(pass);
            if(!u && !p) out.println("Both Invalid");
            else if(u && p) {
                out.println("Valid");
                USER.add(user);
                PASS.add(pass);
            }
            else if(!u && p) out.println("Username Invalid");
            else out.println("Password Invalid");
        }
        f.close();
    }
    public boolean usercheck(String user){
        if(user.matches("[^A-Z].*")) return false;
        if(user.matches(".*[^a-zA-Z0-9].*")) return false;
        if(user.length() > 20 || user.length() < 8) return false;
        if(USER.contains(user)) return false;
        return true;
    }
    public boolean passcheck(String pass){
        if(!(pass.matches(".*[0-9].*") && pass.matches(".*[A-Z].*") && pass.matches(".*[a-z].*") && pass.matches(".*[!@#$%^&*?+].*"))) return false;
        if(pass.length() > 30 || pass.length() < 10) return false;
        if(pass.matches(".*\\s.*")) return false;
        for (int i = 0; i < pass.length() - 2; i++) {
            if(pass.charAt(i)==pass.charAt(i+1) && pass.charAt(i)==pass.charAt(i+2)) return false;
        }
        return true;
    }
}
