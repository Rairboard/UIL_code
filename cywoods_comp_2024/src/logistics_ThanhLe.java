import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class logistics_ThanhLe {
	double[][] shadow;
	boolean[][][] m;
    Map<String,String> org;
    List<String> site;
    List<String> person;
    public static void main(String[] args) throws Exception {
        new logistics_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("JUDGElogistics").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            org = new HashMap<>();
            site = new ArrayList<>();
            person = new ArrayList<>();
            int o = f.nextInt(), s = f.nextInt(), j = f.nextInt();
            f.nextLine();
            for (int i = 0; i < o; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int k = 1; k < ln.length; k++) {
                    person.add(ln[k]);
                    org.put(ln[k],ln[0]);
                }
            }
            int np = person.size();
            m = new boolean[s][np][np];
            shadow = new double[s][np];
            for (int i = 0; i < s; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                site.add(ln[0]);
                for (int k = 1; k < ln.length; k++) {
                    for (int l = k; l < ln.length; l++) {
                        int a = person.indexOf(ln[k]);
                        int b = person.indexOf(ln[l]);
                        m[i][a][b] = true;
                        m[i][b][a] = true;
                    }
                }
            }
            for (int i = 0; i < j; i++) {
                for (int k = 0; k < shadow.length; k++) {
                    Arrays.fill(shadow[k],Double.MAX_VALUE);
                }
                String[] ln = f.nextLine().trim().split("\\s+");
                int startPerson = person.indexOf(ln[0]);
                int startSite = site.indexOf(ln[1]);
                int endPerson = person.indexOf(ln[3]);
                int endSite = site.indexOf(ln[4]);
                Queue<Double> q = new LinkedList<>();
                q.offer((double)startPerson);
                q.offer((double)startSite);
                q.offer(0.0);
                while(!q.isEmpty()){
                    double curPerson = q.remove(), curSite = q.remove(), cost = q.remove();
                    int cur = (int)curPerson, site = (int)curSite;
                    if(cost >= shadow[site][cur]) continue;
                    shadow[site][cur] = cost;
                    for (int people = 0; people < np; people++) {
                        if(m[site][cur][people]){
                            String a = org.get(person.get(cur));
                            String b = org.get(person.get(people));
                            if (a.equals(b)) {
                                q.offer((double)people);
                                q.offer((double)site);
                                q.offer(cost + 12.50);
                            } else {
                                q.offer((double)people);
                                q.offer((double)site);
                                q.offer(cost + 19.75);
                            }
                        }
                    }
                    for (int siteNum = 0; siteNum < s; siteNum++) {
                        if(m[siteNum][cur][cur]){
                            q.offer((double)cur);
                            q.offer((double)siteNum);
                            q.offer(cost + 7.50);
                        }
                    }
                }
                out.printf("%s %s -> %s %s $%.2f\n", ln[1], ln[0], ln[4], ln[3], shadow[endSite][endPerson]);
            }
        }
        f.close();
    }
}
