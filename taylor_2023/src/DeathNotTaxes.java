import java.util.*;
import java.io.*;

public class DeathNotTaxes {
    public static void main(String[] args) throws Exception {
        new DeathNotTaxes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("DeathNotTaxes.in"));
        //Scanner f = new Scanner(System.in);
        Map<Double,Double> m = new TreeMap<>(Collections.reverseOrder());
        double income = f.nextLong();
        double charity = f.nextLong();
        double save_percent = f.nextLong();
        double divide = f.nextLong();
        double donation = charity;
        while(income > 0){
            income -= charity;
            double save = income * (save_percent/100);
            income -= save;
            double iat = income;
            if(iat > 1000){
                iat *= .70;
            } else if (iat >= 500) {
                iat *= .50;
            }else if(iat >= 200 && iat <= 250){
                iat *= .01;
            }
            iat += save;
            m.put(iat, donation);
            donation +=charity;
            save_percent/=divide;
        }
        List<Double> a = new ArrayList<>(m.keySet());
        List<Double> b = new ArrayList<>(m.values());
        System.out.printf("%.1f%n%.1f%n",b.get(0),a.get(0));
        f.close();
    }
}
