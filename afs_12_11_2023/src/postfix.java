import java.util.*;
import java.io.File;

import static java.lang.System.*;

public class postfix {
    public static void main(String[] args) throws Exception {
        new postfix().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("postfix.dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			String[]l = f.nextLine().split("\\s+");
			Stack<Integer> s = new Stack<>();
			for (int i = 0; i <l.length; i++) {
				try{
					s.push(Integer.parseInt(l[i]));
				}catch(Exception e){
					int a =s.pop(), b = s.pop();
					switch(l[i]){
						case "*":s.push(b*a);break;
						case "/":s.push(b/a);break;
						case "+":s.push(b+a);break;
						case "-":s.push(b-a);break;
					}
				}
			}
			out.println(s.peek());
		}
        f.close();
    }
}
