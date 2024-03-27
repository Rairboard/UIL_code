import java.util.*;
import java.io.File;

public class Alb {
    public static void main(String[] args) throws Exception {
        new Alb().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Alb").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
            Collections.sort(al, (a,b) ->{
                int best1 = 0,best2 = 0;
                String[] one = a.toLowerCase().split("[^aeiou]");
                String[] two = b.toLowerCase().split("[^aeiou]");
                for (int i = 0; i < one.length; i++) {
                    if(one[i]!=null){
                        best1 = Math.max(best1,one[i].length());
                    }
                }for (int i = 0; i < two.length; i++) {
                    if(two[i]!=null){
                        best2 = Math.max(best2,two[i].length());
                    }
                }
                return Integer.compare(best1,best2);
            });
            for (int i = 0; i < al.size(); i++) {
                System.out.print(al.get(i) + " ");
            }
            System.out.println();
        }
        f.close();
    }
}
