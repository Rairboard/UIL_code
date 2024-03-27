import java.util.*;
import java.io.*;
class jose{
	public static void main(String[] args)throws Exception{
		new jose().run();
	}
	public void run()throws Exception{
	   // Scanner f = new Scanner(System.in);
	   Scanner f = new Scanner(new File("jose.dat"));
	   Map<String,Integer> word = new HashMap<>();
	   Map<Integer,Integer> weight = new HashMap<>();
	   for(int i=0;i<23;i++){
	       word.put(f.next(),f.nextInt());
	   }
	   for(int i=0;i<17;i++){
	       weight.put(f.nextInt(),f.nextInt());
	   }
	   int times = f.nextInt();
	   while(times-->0){
	       String vin = f.next();
	       int p = 0;
	       for(int i=0;i<vin.length();i++){
	           if(!vin.substring(i,i+1).equals("_")){
	               try{
	                   p += Integer.parseInt(vin.substring(i,i+1)) * weight.get(i+1);
	               }
	               catch(Exception e){
	                   p += word.get(vin.substring(i,i+1)) * weight.get(i+1);
	               }
	           }
	       }
	       p%=11;
	       if(p<10){
	           System.out.println(vin.substring(0,vin.indexOf("_")) + p + vin.substring(vin.indexOf("_")+1));
	       } else{
	           System.out.println(vin.substring(0,vin.indexOf("_")) + "X" + vin.substring(vin.indexOf("_")+1));
	       }
	   }
	}
}
