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

    public class anagramai {
        public static void main(String[] args) throws Exception {
            new anagramai().run();
        }

        public void run() throws Exception {
//            Scanner f = new Scanner(new File(("anagramai").toLowerCase() + ".dat"));
            Scanner f = new Scanner(System.in);
            int times = f.nextInt();
            int count = 0;
            if(times>0) f.nextLine();
            for (int asdf = 1; asdf <= times; asdf++) {
                char[] a = f.next().toCharArray();
                char[] b = f.next().toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if(new String(a).equals(new String(b))){
                    count++;
                }
            }
            out.println(count);
            f.close();
        }
    }
