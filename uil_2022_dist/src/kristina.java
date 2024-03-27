import java.util.*;
import java.io.*;

public class kristina {
    public static void main(String[] args) throws Exception {
        new kristina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("kristina.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
            Stack<Long> s = new Stack<>();
            String st = f.next();
            String[] e = f.nextLine().split("\\s+");
            e = Arrays.copyOfRange(e,1,e.length);
//            System.out.println(Arrays.toString(e));
            if(st.equals("PRE")){
                for (int i = e.length-1; i >= 0; i--) {
                    try{
                        s.push(Long.parseLong(e[i]));
                    }
                    catch(Exception ee){
                        long a = s.pop(),b = s.pop();
                        switch(e[i]){
                            case "^": s.push((long)(Math.pow(a,b)));break;
                            case "*": s.push(a * b);break;
                            case "/": s.push(a/b);break;
                            case "+": s.push(a+b);break;
                            case "-": s.push(a-b);break;
                        }
                    }
                }
                System.out.println(s.get(0));
            }
            else {
                for (int i = 0; i < e.length; i++) {
                    try{
                        s.push(Long.parseLong(e[i]));
                    }
                    catch(Exception ee){
                        long a = s.pop(), b = s.pop();
                        switch(e[i]){
                            case "^": s.push((long)(Math.pow(b,a)));break;
                            case "*": s.push(a * b);break;
                            case "/": s.push(b/a);break;
                            case "+": s.push(a+b);break;
                            case "-": s.push(b-a);break;
                        }
                    }
                }
                System.out.println(s.get(0));
            }
        }
        f.close();
    }
}
