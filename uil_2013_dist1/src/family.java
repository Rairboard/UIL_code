import java.util.*;
import java.io.*;

public class family {
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("family.dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,Integer> m = new HashMap<>();
        Map<Integer,List<String>> tm = new TreeMap<>();
        while(f.hasNext()){
            String[] l =f.nextLine().split("\\s+");
            if(l[1].equals("MOTHER") || l[1].equals("FATHER")){
                if(!m.containsKey(l[0])){
                    m.put(l[0],1);
                }
                m.put(l[2],m.get(l[0])+1);
            }
            else{
                m.put(l[2],m.get(l[0]));
            }
        }
        for(String s : m.keySet()){
            tm.putIfAbsent(m.get(s),new ArrayList<>());
            tm.get(m.get(s)).add(s);
        }
        for(Integer gen : tm.keySet()){
            System.out.print(gen+ " ");
            tm.get(gen).forEach( e-> System.out.print(e + " "));
            System.out.println();
        }
        f.close();
    }
}
