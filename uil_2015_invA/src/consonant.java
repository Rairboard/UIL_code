import java.util.*;
import java.io.*;

public class consonant {
    public static void main(String[] args) throws Exception {
        new consonant().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("consonant.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();f.nextLine();
        while (times-- > 0) {
			String s = f.nextLine().toLowerCase().replaceAll("[^a-z]","").replaceAll("[aeiou]","");
			System.out.println(s.isEmpty() ? 0: Math.max(ascend(s),descend(s)));
        }
        f.close();
    }
	public int ascend(String s){
		int max = 0, cur = 1;
		char last = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i) >= last){
				cur++;
			} else{
				max = Math.max(max,cur);
				cur = 1;
			}
			last = s.charAt(i);
		}
		return Math.max(cur,max);
	}
	public int descend(String s){
		int max = 0, cur = 1;
		char last = s.charAt(0);
		for(int i= 1;i<s.length();i++){
			if(s.charAt(i) <= last){
				cur++;
			} else{
				max = Math.max(max,cur);
				cur = 1;
			}
			last = s.charAt(i);
		}
		return Math.max(max,cur);
	}
}
