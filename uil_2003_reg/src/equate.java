import java.util.*;
import java.io.*;

public class equate {
    public static void main(String[] args) throws Exception {
        new equate().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("equate.dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			System.out.print(f.next() + " " + f.next() + " ");
			Scanner line = new Scanner(f.nextLine());
			Stack<String> s = new Stack<>();
			Stack<Integer> st = new Stack<>();
			String exp = "";
			while(line.hasNext()){
				String a = line.next();
				try{
					exp += Integer.parseInt(a) + " ";
				}
				catch(Exception e){
					while(!s.isEmpty() && precedence(s.peek()) >= precedence(a)){
						exp += s.pop() + " ";
					}
					s.push(a);
				}
			}
			while(!s.isEmpty()){
				exp += s.pop() +  " ";
			}
			String[] l = exp.trim().split("\\s+");
			for (int i = 0; i < l.length; i++) {
				try{
					st.push(Integer.parseInt(l[i]));
				}
				catch(Exception e){
					int a = st.pop(), b = st.pop();
					switch(l[i]){
						case "+": st.push(b + a);break;
						case "-": st.push(b-a);break;
						case "*": st.push(b*a);break;
						case "/": st.push(b/a);break;
						case "^": st.push((int)Math.pow(b,a));break;
					}
				}
			}
			System.out.println(st.get(0));
		}
        f.close();
    }
	public int precedence(String s){
		switch (s){
			case "+": return 1;
			case "-": return 1;
			case "*": return 2;
			case "/": return 2;
			default: return 3;
		}
	}
}
