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

public class hsilgnE {
    public static void main(String[] args) throws Exception {
        new hsilgnE().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hsilgnE").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			out.print(new StringBuilder(f.next()).reverse()+" ");
		}
        f.close();
    }
}
