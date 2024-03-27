import java.util.*;
import java.io.*;

public class richa {
    static Map<Character, Double> grade ;
    public static void main(String[] args) throws Exception {
        new richa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("richa.dat"));
        grade = new HashMap<>();
        grade.put('A',4.5);
        grade.put('B',3.5);
        grade.put('C',2.5);
        grade.put('D',1.0);
        grade.put('F',0.0);
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        Map<String, Map<String, Character>>m = new HashMap<>();
        f.nextLine();
        while (times-- > 0) {
            String[] l = f.nextLine().split("\\s+");
            String N = l[0];
            String s =l[1];
            m.put(N, new HashMap<String,Character>());
            m.get(N).put("honor",s.charAt(0));
            m.get(N).put("year",s.charAt(1));
        }
        while(f.hasNext()){
            String[] l = f.nextLine().split("\\s+");
//            System.out.println(Arrays.toString(l));
            double credit = 0, point = 0;
            for (int i = 0; i < l.length; i+=2) {
                double p = calc(l[i]);
                char a = m.get(l[i+1]).get("honor");
                char b = m.get(l[i+1]).get("year");
                if(a=='Y'){
                    if(l[i].charAt(0) <= 'C'){
                        p+=.5;
                    }
                    switch(b){
                        case 'Y': credit += 4;point += p * 4;break;
                        case 'S': credit += 2; point += p * 2;break;
                        case 'Q': credit +=1;point += p * 1;break;
                    }
                }
                else{
                    switch(b){
                        case 'Y': credit += 4;point += p * 4;break;
                        case 'S': credit += 2; point += p * 2;break;
                        case 'Q': credit +=1;point += p * 1;break;
                    }
                }
            }
            System.out.printf("%.3f%n",point/credit);
        }
        f.close();
    }
    public double calc(String s){
        if(s.contains("+") || s.contains("-")){
            if(s.charAt(1) == '+'){
                return grade.get(s.charAt(0))+.25;
            }
            return grade.get(s.charAt(0))-.25;
        }
        return grade.get(s.charAt(0));
    }
}
