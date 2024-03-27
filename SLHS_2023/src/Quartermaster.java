import java.util.*;
import java.io.*;

public class Quartermaster {
    public static void main(String[] args) throws Exception {
        new Quartermaster().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("Quartermaster.txt"));
        //Scanner f = new Scanner(System.in);
        double money = f.nextDouble();
        int p = f.nextInt();
        int totshare = 0;
        Map<String,Map<String,Integer>> m = new LinkedHashMap<>();
        int[] length = new int[3];
        for (int i = 0; i < p; i++) {
            String n = f.next(),j = f.next();
            int s = f.nextInt();
            totshare += s;
            m.put(n,new HashMap<>());
            m.get(s).put(j,s);
            length[0] = Math.max(n.length(),length[0]);
            length[1] = Math.max(j.length(),length[1]);
        }
        for(String n : m.keySet()){
            for(String j : m.get(n).keySet()){
                int s = m.get(n).get(j);
                int share = String.format("$%.2f",money/totshare * s).length();
                length[2] = Math.max(length[2],share);
                break;
            }
        }
        System.out.printf("| %-" + length[0] + "s | %-" + length[1] + "s | # of Shares | % of Total | %-" + length[2] + "s |","Name","Role","Money");
        System.out.printf("| %s | %s | %s | %s | %s |","-".repeat(length[0]),"-".repeat(length[1]),"-".repeat(11),"-".repeat(10),"-".repeat(length[2]));
        for(String n : m.keySet()){
            for(String j : m.get(n).keySet()){
                int s = m.get(n).get(j);
                String percent = String.format("%.2f%s",(double)s/totshare*100,"%");
                String share = String.format("$%.2f",(double)s/totshare*100 * money);
//                System.out.printf("| %-" + length[0] + "s",);
            }
        }
        f.close();
    }
}
