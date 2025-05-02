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

    public class alienrobbery {
        public static void main(String[] args) throws Exception {
            new alienrobbery().run();
        }

        public void run() throws Exception {
    //        Scanner f = new Scanner(new File(("alienrobbery").toLowerCase() + ".dat"));
            Scanner f = new Scanner(System.in);
            BigDecimal balance = f.nextBigDecimal();
            int times = f.nextInt();
            f.nextLine();
            for (int asdf = 1; asdf <= times; asdf++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                int k = Integer.parseInt(ln[0]);
                if(k==0) continue;
                String[] time = ln[1].split(":");
                int hour = Integer.parseInt(time[0]);
                int min = Integer.parseInt(time[1]);
                if (ln[2].equals("PM")) {
                    hour+=12;
                }
                hour*=60;
                min+=hour;
                if(min>=0&&min<=480 || min>=1200){
                    out.printf("%.3f\n" ,balance.multiply(BigDecimal.valueOf(.15 *k)));
                    balance = balance.multiply(BigDecimal.valueOf(.85 *k));
                }
                else{
                    out.printf("%.3f\n" ,balance.multiply(BigDecimal.valueOf(.1*k )));
                    balance = balance.multiply(BigDecimal.valueOf(.9 *k));
                }
            }
            out.printf("%.3f\n" ,balance);

            f.close();
        }
    }
