import java.util.*;
import java.io.File;

public class encrypt_ThanhLe {
    public static void main(String[] args) throws Exception {
        new encrypt_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("encryptJ").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String key = f.nextLine();
            String[] ln = f.nextLine().trim().split("\\s+");
            List<String> al = new ArrayList<>();
            for (int i = 0; i < ln.length; i++) {
                char[] encrypted = new char[key.length()];
                for (int j = 0; j < ln[i].length(); j++) {
                    int a = ln[i].charAt(j) - 'A';
                    int b = key.charAt(j) - 'A';
                    int c = a ^ b;
                    c = Math.abs(c%26);
                    encrypted[j] = (char)('A' + c);
                }
                al.add(new String(encrypted));
            }
            Collections.sort(al);
            al.forEach(e -> System.out.print(e+" "));
            System.out.println();
        }
        f.close();
    }
}
