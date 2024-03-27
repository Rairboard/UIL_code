import java.util.*;
import java.io.*;

public class sendforthearmada {
    public static void main(String[] args) throws Exception {
        new sendforthearmada().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("sendforthearmada.txt"));
        //Scanner f = new Scanner(System.in);
        String orig = "";
        for(char c = 'A';c<='Z';c++){
            orig+=c;
        }
        String rev = new StringBuilder(orig).reverse().toString();
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
            String[] ln = f.nextLine().split("\\s+");
            int N =Integer.parseInt(ln[0]);
            for(int j = 1; j<ln.length;j++){
                char[] c = ln[j].toUpperCase().toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if(Character.isAlphabetic(c[i])){
                        if(N < 0){
                            long shift = (((long)rev.indexOf(c[i]) + Math.abs(N)) + rev.length())%rev.length();
                            c[i] = rev.charAt((int)shift);
                        }
                        else if(N > 0){
                            long shift =((long)orig.indexOf(c[i]) + N) % orig.length();
                            c[i] = orig.charAt((int)shift);
                        }
                    }
                }
                ln[j] = new String(c);
            }
            for (int i = 1; i < ln.length; i++) {
                if(i<ln.length-1){
                    System.out.print(ln[i]+" ");
                }
                else{
                    System.out.print(ln[i]);
                }
            }
            System.out.println();
        }
        f.close();
    }
}