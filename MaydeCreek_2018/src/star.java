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

public class star {
    public static void main(String[] args) throws Exception {
        new star().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("star").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int num = f.nextInt();
            f.nextLine();
            long bestScore = 0;
            String stu = "";
            for (int i = 0; i < num; i++) {
                String name = f.next();
                int score = f.nextInt();
                if(f.hasNext()){
                    f.nextLine();
                }
                if(score>bestScore){
                    bestScore = score;
                    stu = name;
                }
            }
            out.println(stu);
        }
        f.close();
    }
}
