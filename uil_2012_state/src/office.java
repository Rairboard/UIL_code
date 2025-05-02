import java.util.*;
import java.io.*;
public class office {
	public static void main(String[] args)throws Exception {
		new office().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("office.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int n = f.nextInt();
            f.nextLine();
            Map<String,Double> spent= new HashMap<>();
            Map<String,Double> receive = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String person = f.next();
                double budget = f.nextDouble();
                String[] other = f.nextLine().trim().split("\\s+");
                spent.put(person,budget);
                for (int j = 0; j < other.length; j++) {
                    receive.put(other[j],receive.getOrDefault(other[j],0.)+budget/other.length);
                }
            }
            Map<String,Double> m = new TreeMap<>();
            for(String s : spent.keySet()){
                if(receive.get(s)==null) m.put(s,-spent.get(s));
                else m.put(s,receive.get(s)-spent.get(s));
            }
            for(String s : m.keySet()){
                System.out.printf("%s %.2f\n",s,  m.get(s));
            }
            System.out.println();
        }
        f.close();
	}
}
