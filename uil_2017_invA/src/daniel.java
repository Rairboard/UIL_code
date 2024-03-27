import java.util.*;
import java.io.*;

public class daniel {
    public static void main(String[] args) throws Exception {
        new daniel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("daniel.dat"));
        //Scanner f = new Scanner(System.in);

        while (f.hasNext()) {
			List<String> al = new ArrayList<>(Arrays.asList(f.nextLine().split("\\s+")));
			int word = 0;
			while(!al.isEmpty()){
				String s = "";
				int w=0;
				while(!al.isEmpty()&&w<=word){
					s+=al.remove(0)+" ";
					w++;
				}
				s = s.trim();
				if(s.length()<=30){
					System.out.println(s);
					word++;
				}else{
					word=0;
					while(s.length()>30){
						String r = s.substring(s.lastIndexOf(" ")+1);
						s = s.substring(0,s.lastIndexOf(" "));
						al.add(0,r);
					}
					System.out.println(s);
				}
			}
			System.out.println("---------*---------*---------*");
        }
        f.close();
    }
}
