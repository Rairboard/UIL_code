import java.util.*;
import java.io.*;

public class menu {
    public static void main(String[] args) throws Exception {
        new menu().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("menu.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            int c = f.nextInt(), r=f.nextInt();
            f.nextLine();
            Queue<String> al = new LinkedList<>(Arrays.asList(f.nextLine().split("\\s+")));
            System.out.println("-".repeat(c));
            for (int i = 0; i < r - 2; i++) {
                String s = "";
                while(!al.isEmpty() && (s+al.peek()).length() <= c-2){
                    s+=al.poll();
                    if((s+" ").length() <= c-2){
                        s+=" ";
                    }
                }
                System.out.printf("|%-" + (c-2) + "s|\n",s);
            }
            System.out.println("-".repeat(c));
        }
        f.close();
    }
}