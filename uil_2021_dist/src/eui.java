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
			int N =f.nextInt();f.nextLine();
            Map<String,List<int[]>> m = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] ln = f.nextLine().split("\\s+");
                int[] a = {Integer.parseInt(ln[1]),Integer.parseInt(ln[3])};
                m.putIfAbsent(ln[0],new ArrayList<>());
                m.get(ln[0]).add(a);
                boolean dup = false;
                for(int j =m.get(ln[0]).size()-1;j>-1;j--){
                    int[] b = m.get(ln[0]).get(j);
                    if(a[0]<=b[1] && a[1]>= b[0]){
                        m.get(ln[0]).set(j,adjust(a,b));
                    }
                }
            }
            for(String s : m.keySet()){
                Set<String> tmp = new HashSet<>();
                List<int[]> al = new ArrayList<>();
                for(int[] i : m.get(s)){
                    String str = i[0] + "-" + i[1];
                    if (!tmp.contains(str)) {
                        tmp.add(str);
                        al.add(i);
                    }
                }
                m.put(s,al);
            }
            int min = 0;
            int max = 0;
            for(String s : m.keySet()){
                System.out.println(s);
                min+=m.get(s).size();
                for(int[] i : m.get(s)){
                    System.out.println(Arrays.toString(i));
                    max += i[1]-i[0]+1;
                }
            }
            min = Math.min(min,N);
            if(N < max){
                max = N;
            }
            System.out.println("Case #" + asdf + ": " + min + " " + max);
        }
        f.close();
    }
    public int[] adjust(int[] a, int[] b){
        int[] ret = new int[2];
        ret[0] = Math.min(a[0],Math.min(a[1],Math.min(b[0],b[1])));
        ret[1] = Math.max(a[0],Math.max(a[1],Math.max(b[0],b[1])));
        return ret;
    }
}
