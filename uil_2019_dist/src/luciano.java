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

public class luciano {
    public static void main(String[] args) throws Exception {
        new luciano().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("luciano").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<String> al = new ArrayList<>();
        while (times-- > 0) {
            al.add(f.nextLine());
        }
        List<String> selection = new ArrayList<>(al);
        List<String> bubble = new ArrayList<>(al);
        for (int i = 0; i < 10 && i < selection.size(); i++) {
            int tmp = i;
            for (int j = i+1; j < selection.size(); j++) {
                if(selection.get(j).compareTo(selection.get(tmp))<0){
                    tmp = j;
                }
            }
            String s = selection.get(i);
            selection.set(i,selection.get(tmp));
            selection.set(tmp,s);
        }
        for(int i = bubble.size()-1;i>=bubble.size()-10 && i > -1;i--){
            for(int j = bubble.size()-1;j>0;j--){
                if(bubble.get(j).compareTo(bubble.get(j-1))<0){
                    String s = bubble.get(j-1);
                    bubble.set(j-1,bubble.get(j));
                    bubble.set(j,s);
                }
            }
        }
        out.printf("%-20s:%-20s\n","Selection Sort","Bubble Sort");
        for (int i = 0; i < selection.size() && i < bubble.size(); i++) {
            out.printf("%-20s:%-20s\n",selection.get(i),bubble.get(i));
        }
        f.close();
    }
}
