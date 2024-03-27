import java.util.*;
import java.io.*;
class kimberley{
	public static void main(String[] args) throws Exception{
		new kimberley().run();
	}
	public void run()throws Exception{
		// Scanner f = new Scanner(System.in);
		Scanner f = new Scanner(new File("kimberley.dat"));
		while(f.hasNext()){
			String[] ar = new String[f.nextInt()];
			boolean[] moved = new boolean[ar.length];
			int birds = f.nextInt();
			Arrays.fill(ar,"");
			Arrays.fill(moved,false);
			for(int i=0;i<birds;i++){
				int N = f.nextInt()-1;
				ar[N] = "*";
				moved[N] = true;
			}
			int stages =f.nextInt();
			while(stages-->0){
				for(int i=0;i<ar.length;i++){
					if(i==0 && !moved[ar.length-1]&& ar[i].equals("") && ar[ar.length-1].equals("*")){
						ar[i] = "*";
						ar[ar.length-1] = "";
					}
					else{
						if(!moved[i] &&i+1<ar.length && ar[i].equals("*")&& ar[(i+1)%ar.length].equals("")){
							moved[(i+1)%ar.length] = true;
							ar[(i+1)%ar.length] = "*";
							ar[i] = "";
						}
					}
				}
				Arrays.fill(moved,false);
			}
			for(int i=0;i<ar.length;i++){
				if(ar[i].equals("*")){
					System.out.print(i+1+" ");
				}
			}
			System.out.println();
		}
	}
}