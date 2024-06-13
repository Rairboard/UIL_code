import java.util.*;
import java.io.File;

public class eui {
    public static void main(String[] args) throws Exception {
        new eui().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("eui").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int N =f.nextInt();
            f.nextLine();
            Map<String,List<List<Integer>>> m = new HashMap<>();
            int max = 0;
            int min = 0;
            for (int i = 0; i < N; i++) {
                String[] ln = f.nextLine().split("\\s+");
                String name = ln[0];
                m.putIfAbsent(name,new ArrayList<>());
                int a = Integer.parseInt(ln[1]);
                int b = Integer.parseInt(ln[3]);
                if(m.get(name).isEmpty()){
                    List<Integer> tmp = new ArrayList<>();
                    for (int j = a; j <= b; j++) {
                        tmp.add(j);
                    }
                    m.get(name).add(tmp);
                }
                else{
                    boolean found = false;
                    for (int j = 0; j < m.get(name).size(); j++) {
                        if (fit(a, b, m.get(name).get(j))) {
                            found = true;
                            for (int x = a; x <= b; x++) {
                                if (!m.get(name).get(j).contains(x)) {
                                    m.get(name).get(j).add(x);
                                }
                            }
                        }
                    }
                }
            }
        }
        f.close();
    }
    public boolean fit(int a,int b,List<Integer> al ){
        return b>= al.getFirst() || a<=al.getLast();
    }
}
