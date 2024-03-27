import java.util.*;
import java.io.File;

public class Decoder_ThanhLe {
    public static void main(String[] args) throws Exception {
        new Decoder_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("decoder.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Stack<String> s = new Stack<>();
            String[] l = f.nextLine().split(" ");
            for (int i = 0; i < l.length; i++) {
                if(l[i].toLowerCase().matches("[a-z]")){
                    s.push(l[i]);
                }
                else if(!s.isEmpty()){
                    if (l[i].equals("%")) {
                        String a = s.pop(), b = s.pop();
                        s.push(a);
                        s.push(b);
                    }else if(l[i].equals("+")){
                        s.push(" ");
                    } else if (l[i].equals("1")) {
                        s.pop();
                    }else if(l[i].equals("2")){
                        String a = s.pop(), b = s.pop();
                        s.push(a);
                    }
                }
            }
            StringBuilder ln = new StringBuilder();
            while(!s.isEmpty()){
                ln.append(s.pop().toUpperCase());
            }
            System.out.println(ln.reverse());
        }
        f.close();
    }
}
