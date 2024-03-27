import java.util.*;
import java.io.*;

public class fourkind {
    public static void main(String[] args) throws Exception {
        new fourkind().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("fourkind.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            Map<String, Map<Integer,Integer>> m = new HashMap<>();
            Map<Integer,List<String>> dice = new TreeMap<>();
            Map<String, int[]> personDices = new HashMap<>();
            for (int i = 0; i < 3; i++) {
                String s = f.next();
                String[] l = f.nextLine().split("\\s+");
                int[] ar = Arrays.stream(Arrays.copyOfRange(l, 1, l.length)).mapToInt(Integer::parseInt).toArray();
                m.put(s, new HashMap<>());
                personDices.put(s,ar);
                for (int j = 0; j < ar.length; j++) {
                    m.get(s).putIfAbsent(ar[j], 0);
                    m.get(s).put(ar[j],m.get(s).get(ar[j])+1);
                }
                if(m.get(s).containsValue(4)) {
                    List<Integer> key = new ArrayList<>(m.get(s).keySet()), val = new ArrayList<>(m.get(s).values());
                    dice.putIfAbsent(key.get(val.indexOf(4)),new ArrayList<>());
                    dice.get(key.get(val.indexOf(4))).add(s);
                }
            }
//            System.out.println(dice);
//            for(String p : personDices.keySet()){
//                System.out.println(p + " " + Arrays.toString(personDices.get(p)));
//            }
            if(!dice.isEmpty()){
                List<Integer> key = new ArrayList<>(dice.keySet());
                List<String> person = new ArrayList<>(dice.get(key.get(key.size()-1)));
                int max = 0;
                for(String p : person){
                    max = Math.max(max,personDices.get(p)[4]);
                }
                int finalMax = max;
                person.removeIf(e -> personDices.get(e)[4] < finalMax);
                Collections.sort(person);
                if(person.size() > 1){
                    System.out.print("TIE ");
                    person.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                }else{
                    System.out.println(person.get(0));
                }
            } else{
                System.out.println("NO WINNER");
            }
        }
        f.close();
    }
}
