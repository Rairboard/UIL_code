import java.util.*;
import java.io.File;

public class elven {
    public static void main(String[] args) throws Exception {
        new elven().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("elven").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split("\\s+");
                for(int j = ln.length-1;j>-1;j--){
                    for(int k = ln[j].length()-1;k>-1;k--){
                        if(ln[j].substring(k,k+1).matches("[AEIOU]")){
                            System.out.print(ln[j].substring(k,k+1).toLowerCase());
                        }
                        else{
                            System.out.print(ln[j].charAt(k));
                        }
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        f.close();
    }
}
