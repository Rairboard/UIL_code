import java.util.*;
import java.io.*;

public class daria {
    public static void main(String[] args) throws Exception {
        new daria().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("daria.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for (int time = 1; time <= times; time++) {
            int a = f.nextInt(), b = f.nextInt();
            double sum = 0;
            List<Double> al = new ArrayList<>();
            String key = f.next();
            for (int j = 0; j < a; j++) {
                String ans = f.next();
                double right = 0;
                for (int i = 0; i < b; i++) {
                    if(key.charAt(i)==ans.charAt(i)){
                        right++;
                    }
                }
                al.add(right/b);
                sum += right/b;
            }
            Collections.sort(al);
            System.out.println("Assignment #" + time + ":");
            System.out.printf("Mean Score: %.2f%n", (sum/a * 100));
            if(al.size()%2==0){
                System.out.printf("Median Score: %.1f%n",((al.get(al.size()/2) + al.get(al.size()/2-1))/2)*100);
            }else{
                System.out.printf("Median Score: %.1f%n",(al.get(al.size()/2))*100);
            }
            System.out.println();
        }
        f.close();
    }
}
