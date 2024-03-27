import java.util.*;
import java.io.*;
class ram {
    public static void main(String[] args) throws Exception {
        new ram().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("ram.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String[] l =f.nextLine().split("\\s+");
            for (int i = 0; i < l.length; i++) {
                if(l[i].matches("\\w+[^a-zA-Z]\\w+")){
                    l[i] = new StringBuilder(l[i]).reverse().toString();
                } else{
                    String s = "";
                    String res = "";
                    for (int j = 0; j < l[i].length(); j++) {
                        if(l[i].substring(j,j+1).matches("\\w")){
                            s= l[i].charAt(j) + s;
                        }
                        if(l[i].substring(j,j+1).matches("\\W")){
                            res += s + l[i].substring(j,j+1);
                            s = "";
                        }
                    }
                    res += s;
                    l[i] = res;  
                }
            }
            for (int i = 0; i < l.length; i++) {
                System.out.print(l[i] + " ");
            }
            System.out.println();
        }
        f.close();
    }
}
