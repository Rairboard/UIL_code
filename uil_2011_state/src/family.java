import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class family {
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("family").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        List<List<String>> al = new ArrayList<>();
		while(f.hasNext()){
			String[] ln  =f.nextLine().trim().split("\\s+");
			if (ln[1].equals("MOTHER") || ln[1].equals("FATHER")) {
				// 0 is the parent and 2 is the child
				int parent = indexOf(al, ln[0]);
				int child = indexOf(al, ln[2]);
				if(parent == -1 && child == -1){
					al.add(new ArrayList<>());
					al.add(new ArrayList<>());
					al.get(0).add(ln[0]);
					al.get(1).add(ln[2]);
				}
				else if(parent!= -1){
					if(parent + 1 >= al.size()) al.add(parent + 1, new ArrayList<>());
					al.get(parent +1 ).add(ln[2]);
				}
				else{
					if(child - 1 < 0){
						al.add(0, new ArrayList<>());
						al.get(0).add(ln[0]);
					}
					else{
						al.get(child-1).add(ln[0]);
					}
				}
			}
			else if (ln[1].equals("DAUGHTER") || ln[1].equals("SON")) {
				// 0 is the child and 2 is the parent
				int child = indexOf(al, ln[0]);
				int parent = indexOf(al, ln[2]);
				if(parent == -1 && child == -1){
					al.add(new ArrayList<>());
					al.add(new ArrayList<>());
					al.get(0).add(ln[2]);
					al.get(1).add(ln[0]);
				}
				else if(parent!= -1){
					if(parent + 1 >= al.size()) al.add(parent + 1, new ArrayList<>());
					al.get(parent + 1).add(ln[0]);
				}
				else{
					if(child - 1 < 0){
						al.add(0, new ArrayList<>());
						al.get(0).add(ln[2]);
					}
					else{
						al.get(child-1).add(ln[2]);
					}
				}
			}
			else{
				int a = indexOf(al, ln[0]);
				int b = indexOf(al, ln[2]);
				if(a == -1 && b == -1){
					al.add(new ArrayList<>());
					al.get(0).add(ln[0]);
					al.get(0).add(ln[2]);
				}
				else if(a != -1){
					al.get(a).add(ln[2]);
				}else{
					al.get(b).add(ln[0]);
				}
			}
//			out.println(al);
		}
		String[] post = "st,nd,rd,th".split(",");
		for(int i = 0;i < al.size();i++){
			if(al.get(i).isEmpty()) continue;
			out.print(i+1);
			if(i >= post.length-1){
				out.print("th Generation: ");
			}
			else{
				out.print(post[i] + " Generation: ");
			}
			TreeSet<String> ts = new TreeSet<>(al.get(i));
			for(String s : ts){
				out.print(s + " ");
			}
			out.println();
		}
        f.close();
    }
	public int indexOf(List<List<String>> al, String cur){
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).contains(cur)) {
				return i;
			}
		}
		return -1;
	}
}
