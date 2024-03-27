import java.util.*;
class alfonso{
	public static void main(String[] args){
	   String orig = "ACEGIKMOQSUWY";
	   for(int start = 0;start < orig.length();start+=2){
	       String s = orig.substring(start);
	       for(int i=0;i<s.length();i++){
	           System.out.println(s.substring(i));
	       }
	   }
	}
}
