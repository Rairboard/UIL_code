import java.util.*;
import java.io.*;
class jaireme
{
	public static void main(String[] args) throws Exception{
		new jaireme().run();
	}
	public void run()throws Exception{
	  Scanner f = new  Scanner(new File("jaireme.dat"));
	  int N = f.nextInt();
	  while(N -- >0){
	   int R = f.nextInt(),r = 0, c = 0;f.nextLine();
	   String s = f.nextLine();
	   String[][] m = new String[R][];
	   for(int i = 0;i < R;i++){
	     m[i] = f.nextLine().trim().split(" ");
	   }
	   boolean a = false;
	   for(int i= 0; i < m.length;i++){
	     for(int j = 0; j < m[i].length;j++){
	       if(m[i][j].equals(s)){
	         r = i+1;
	         c = j+1;
	         a = true;
	         break;
	       }
	     }
	   }
	   System.out.println(a == true? r + " " + c : "No Word");
	  }
	}
}
