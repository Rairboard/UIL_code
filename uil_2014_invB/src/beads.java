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

public class beads {
    public static void main(String[] args) throws Exception {
        new beads().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("beads").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
            for(int i = 1;i<=ln.length();i++){
                if(ln.replaceAll(ln.substring(0,i),"").isEmpty()){
                    out.println(ln.substring(0,i));
                    break;
                }
            }
        }
        f.close();
    }
}
