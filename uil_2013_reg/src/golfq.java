import java.util.*;
import java.io.*;
class golfq {
    public static void main(String[] args) throws Exception {
        new golfq().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("golfq.dat"));
        //Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        Map<String,Integer> m =new LinkedHashMap<>();
        int tw = 0;
        for(int i=1;i<=N;i++){
            String s = f.next(), in = f.next();
            int p = f.nextInt();
            m.put(s + " " + in,p);
            if(i==12){
                tw = p;
            }
        }
        for(String s : m.keySet()){
            if(m.get(s) < tw){
                System.out.println(s);
            }
        }
        f.close();
    }
}
