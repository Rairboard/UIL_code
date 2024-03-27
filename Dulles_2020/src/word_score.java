import java.util.*;
import java.io.*;

public class word_score {
    public static void main(String[] args) throws Exception {
        new word_score().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("word_score.dat"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stu.out")));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Map<Long,String> m = new TreeMap<>(Collections.reverseOrder());
            String[] l = f.nextLine().split("\\s+");
            long max = 0;
            for (int i = 0; i < l.length; i++) {
                String s =l[i].toLowerCase();
                long score = s.length()/2;
                long vowel = s.replaceAll("[^aeiou]","").length();
                long z = s.replaceAll("[^z]","").length() *2;
                long xq = s.replaceAll("[^xq]","").length()*3;
                score += vowel+z+xq;
                m.put(score,l[i]);
                max = Math.max(max,score);
            }
            out.println(m.get(max) + " - " + max);
        }
        out.flush();
        out.close();
        f.close();
    }
}
