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

public class Like {
    List<String> al = new ArrayList<>(Arrays.asList("like um uh".split(" ")));
    public static void main(String[] args) throws Exception {
        new Like().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Like").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<String> line = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            line.removeIf(e -> al.contains(e.toLowerCase()));
            if(!line.isEmpty()){
                for (int i = 0; i < line.size(); i++) {
                    out.print(line.get(i) + " ");
                }
                out.println();
            }
        }
        f.close();
    }
}
