import java.util.*;
import java.io.*;
class eduardo{
	public static void main(String[] args)throws Exception{
	   new eduardo().run();
	}
	public void run()throws Exception{
        // Scanner f = new Scanner(System.in);
        Scanner f = new Scanner(new File("eduardo.dat"));
        while(f.hasNext()){
            String[] l = f.nextLine().split("\\s+");
            for(int i=0;i<l.length;i++){
                char[] s = l[i].toCharArray();
                for(int j=0;j<s.length;j++){
                    if(s[j] + l[0].length() > 122){
                        s[j] = (char)(((s[j]+l[0].length())%122)+96);
                    }else{
                        s[j] = (char)(s[j] + l[0].length());
                    }
                }
                l[i] = new String(s);
            }
            System.out.println(new String().join(" ",l));
        }
    }
}
