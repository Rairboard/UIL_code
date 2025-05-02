import java.util.*;
import java.io.*;
public class remy {
	public static void main(String[] args)throws Exception {
		new remy().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("remy.dat"));
        //Scanner f = new Scanner(System.in);
        HashMap<String,Integer> IP = new HashMap<>();
        HashMap<String,Integer> URL = new HashMap<>();
        int error = 0, request = 0;
        while(f.hasNext()){
            request++;
            String[] ln = f.nextLine().trim().split("\\s+");
            IP.put(ln[2], IP.getOrDefault(ln[2],0)+1);
            URL.put(ln[4], URL.getOrDefault(ln[4], 0)+1);
            if (ln[5].matches("4[0-9]+") || ln[5].matches("5[0-9]+")) {
                error++;
            }
        }
        int mx = 0;
        String ans = "";
        for(String ip: IP.keySet()){
            if(IP.get(ip)>mx){
                mx = IP.get(ip);
                ans = ip;
            }
        }
        System.out.println("Total requests: " + request);
        System.out.println("Unique IP addresses: " + IP.keySet().size());
        System.out.println("Most frequent IP address: " + ans + " (" + IP.get(ans) + " requests)");
        System.out.printf("Error rate: %.2f%%\n", 100.0* error/request);
        mx = 0;
        ans = "";
        for(String url : URL.keySet()){
            if(URL.get(url)>mx){
                mx = URL.get(url);
                ans = url;
            }
        }
        System.out.println("Most requested URL :" + ans + " (" + URL.get(ans) + " requests)");

        f.close();
	}
}
