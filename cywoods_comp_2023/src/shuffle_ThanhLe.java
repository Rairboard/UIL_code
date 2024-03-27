import java.util.*;
import java.io.File;

public class shuffle_ThanhLe {
    public static void main(String[] args) throws Exception {
        new shuffle_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("shuffle.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            Collections.rotate(al,Integer.parseInt(al.remove(al.size()-1)));
            String ln = "";
            for (int i = 0; i < al.size(); i++) {
                ln += al.get(i) + " ";
            }
            System.out.println(ln.substring(0,ln.length()-1));
        }
        f.close();
    }
}
