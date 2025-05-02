import java.util.*;
import java.io.*;
public class jasmine {
	public static void main(String[] args)throws Exception {
		new jasmine().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("jasmine.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.nextLine().trim();
            if(ln.length()%3!=0){
                int size = ln.length()/3;
                String a = ln.substring(0,size);
                String b = ln.substring(size,size* 2);
                char[] ar = b.toCharArray();
                Arrays.sort(ar);
                String c = ln.substring(size* 2);
                System.out.print(a +" "+ b +" "+ c + " ==> ");
                a = new StringBuilder(a).reverse().toString().toLowerCase();
                b = new String(ar).toUpperCase();
                c = c.toUpperCase();
                System.out.println(c + a+ b);
            }
            else{
                int size = ln.length()/3;
                String a = ln.substring(0,size);
                String b = ln.substring(size,size* 2);
                String c = ln.substring(size * 2);
                System.out.print(a + " " + b + " " + c + " ==> ");
                a = a.toUpperCase();
                b = new StringBuilder(b).reverse().toString().toLowerCase();
                char[] ar = c.toCharArray();
                Arrays.sort(ar);
                c = new String(ar).toUpperCase();
                System.out.println(a + b + c);
            }

        }
        f.close();
	}
}
