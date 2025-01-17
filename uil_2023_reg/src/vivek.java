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

public class vivek {
    public static void main(String[] args) throws Exception {
        new vivek().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("vivek").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double x = f.nextDouble(), y = f.nextDouble(), z = f.nextDouble();
            int g = f.nextInt();
            int n = f.nextInt();
            f.nextLine();
            double[][] m = new double[n+1][3];
            m[0] = new double[]{x,y,z};
            boolean[] have = new boolean[n+1];
            for(int i = 1;i<=n;i++){
                String name = f.next();
                boolean mech = f.nextBoolean();
                double a = f.nextDouble(), b = f.nextDouble(), c = f.nextDouble();
                have[i] = mech;
                m[i] = new double[]{a,b,c};
            }
            double[] shadow =new double[n+1];
            Arrays.fill(shadow, Double.MAX_VALUE);
            Queue<double[]> q= new LinkedList<>();
            q.offer(new double[]{0,0});
            Set<Integer> hs = new HashSet<>();
            while(!q.isEmpty()){
                double[] ar = q.remove();
                int cur = (int)ar[0];
                double d = ar[1];
                if(d >= shadow[cur]) continue;
                if(have[cur]) hs.add(cur);
                for(int i = 1;i<=n;i++){
                    if(cur!=i){
                        double dis = Math.sqrt(Math.pow(m[cur][0] - m[i][0], 2) + Math.pow(m[cur][1] - m[i][1],2) + Math.pow(m[cur][2] - m[i][2],2));
                        if(d + dis <= g){
                            q.offer(new double[]{i, d + dis});
                        }
                    }
                }
            }
            if(hs.isEmpty()){
                out.println("SS Madame de Pompadour");
            }
            else{
                out.println("We made it Rick: " + hs.size());
            }
        }
        f.close();
    }
}
