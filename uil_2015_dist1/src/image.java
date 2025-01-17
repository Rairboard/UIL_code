import java.util.*;
import java.io.File;

public class image {
    public static void main(String[] args) throws Exception {
        new image().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("image").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), c = f.nextInt(), r = f.nextInt();
            f.nextLine();
            List<A> computer =new ArrayList<>();
            List<A> site =new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = f.nextLine();
                String[][] value = new String[r][c];
                for (int j = 0; j < r; j++) {
                    value[j] = f.nextLine().trim().split("\\s+");
                }
                computer.add(new A(name, value));
            }
            for (int i = 0; i < n; i++) {
                String name = f.nextLine();
                String[][] value = new String[r][c];
                for (int j = 0; j < r; j++) {
                    value[j] = f.nextLine().trim().split("\\s+");
                }
                site.add(new A(name, value));
            }
            for (int i = 0; i < computer.size(); i++) {
                System.out.println(computer.get(i).name + " " + Arrays.deepToString(computer.get(i).value));
            }
            for (int i = 0; i < site.size(); i++) {
                System.out.println(site.get(i).name + " " + Arrays.deepToString(site.get(i).value));
            }
            for (int i = 0; i < computer.size(); i++) {
                System.out.print(computer.get(i).name + ": ");
                A best = site.get(0);
                for(int j = 1;j<site.size();j++){
                    best = compare(best, site.get(j), computer.get(i));
                }
                System.out.println(best.name);
            }
            System.out.println();
        }
        f.close();
    }
    class A{
        String name;
        String[][] value;
        public A(String n, String[][] v){
            name = n;
            value = v;
        }
    }
    public A compare(A a, A b, A master){
        long diff1 = 0, diff2 = 0;
        for (int i = 0; i < master.value.length ; i++) {
            for (int j = 0; j < master.value[i].length; j++) {
                for (int k = 0; k < 6; k+=2) {
                    diff1 += Math.abs(Long.parseLong(a.value[i][j].substring(k,k+2), 16) - Long.parseLong(master.value[i][j].substring(k,k+2),16));
                    diff2 += Math.abs(Long.parseLong(b.value[i][j].substring(k,k+2), 16) - Long.parseLong(master.value[i][j].substring(k,k+2),16));
                }
            }
        }
        if(diff1 < diff2) return a;
        return b;
    }
}
