import java.util.*;
import java.io.*;
class multchoice {
    public static void main(String[] args) throws Exception {
        new multchoice().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File("multchoice.dat"));
        //Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        f.nextLine();
        for(int i=1;i<=N;i++){
            System.out.println("Question " + i);
            Map<String,String> orig = new LinkedHashMap<>();
            Map<String, List<String>> m = new HashMap<>();
            Map<String,List<String>> ans = new HashMap<>();
            int max = 0;
            for(int j=0;j<5;j++){
                String a = f.next(), s = f.nextLine();
                orig.put(a,s);
                m.put(a,new ArrayList<>(Arrays.asList(s.replaceAll(" ","").replaceAll("[and,]"," ").split(" "))));
                ans.put(a,new ArrayList<>());
            }
            for(String s : m.keySet()){
                List<String> al = new ArrayList<>(m.get(s));
                for(String ss : m.keySet()){
                    if(!s.equals(ss)){
                        List<String> tmp = new ArrayList<>(m.get(ss));
                        tmp.removeIf(n -> al.contains(n));
                        if(tmp.isEmpty()){
                            ans.get(s).add(ss);
                        }
                    }
                }
                max = Math.max(max,ans.get(s).size());
            }
            for(String s : ans.keySet()){
                if(ans.get(s).size()==max){
                    for(String ss : ans.get(s)){
                        orig.put(ss,orig.get(ss) + " only");
                    }
                }
            }
            for(String s : orig.keySet()){
                System.out.println(s + " " + orig.get(s));
            }
            System.out.println();
        }
        f.close();
    }
}
