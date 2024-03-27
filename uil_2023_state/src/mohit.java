import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class mohit {
List<String> al = new ArrayList<>(Arrays.asList("PhD,Master's,Bachelor's,None".split(",")));
    public static void main(String[] args) throws Exception {
        new mohit().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mohit").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int m = f.nextInt(), n = f.nextInt();
		f.nextLine();
		List<Applicant> applicant = new ArrayList<>();
		while(m-->0) {
			String[] ln = f.nextLine().split(";\\s*");
			String name = ln[0].replace("Name: ", "");
			String[] education = ln[1].replace("Education: ", "").split("\\s*of\\s*");
			String[] skill = ln[2].split(",\\s*");
			String[] award = ln[3].replace("Awards: ", "").split(",\\s+");
			applicant.add(new Applicant(name, education, skill, award));
		}
		while(n-->0){
			List<Applicant> accepted = new ArrayList<>();
			String[] ln = f.nextLine().replace("Job: ","").replace("Education: ","").split(";\\s*");
			String jobName = ln[0];
			String[] education = ln[1].split("\\s*of\\s*");
			String[] skill = ln[2].split(",\\s*");
			String[] award = ln[3].split(",\\s*");
			for(Applicant a : applicant){
				int ss = 0;
				boolean[] poss = new boolean[3];
				if(education[0].equals("None") || (a.e <= al.indexOf(education[0]) && a.degree.equals(education[1]))){
					poss[0] = true;
				}
				if (skill[0].equals("None")) {
					poss[1] = true;
				}else{
					boolean check = false;
					 for (int i = 0; i < skill.length; i++) {
						String[] tmp = skill[i].split(":\\s+");
						String sn = tmp[0];
						int year = Integer.parseInt(tmp[1].replaceAll("[^0-9]",""));
						if(!a.skill.containsKey(sn)){
							check = true;
							break;
						}
						if(a.skill.get(sn)<year){
							check = true;
							break;
						}
						ss += a.skill.get(sn) - year;
					}
					if(!check){
						poss[1] = true;
					}
				}
				if (award[0].equals("None")) {
					poss[2] = true;
				}else{
					boolean check = false;
					for (int i = 0; i < award.length; i++) {
						if (!a.award.contains(award[i])) {
							check = true;
							break ;
						}
					}
					if(!check){
						poss[2] = true;
					}
				}
				if(poss[0]&&poss[1]&&poss[2]){
					a.ss = ss;
					accepted.add(a);
				}
			}
			Collections.sort(accepted);
			out.println(jobName + ":");
			if(accepted.size()>0){
				for (int i = 0; i < accepted.size() && i < 3; i++) {
					out.println(i + 1  + ": " + accepted.get(i).n);
				}
			}else{
				out.println("No Applicants meets Requirements.");
			}
			out.println();
		}
        f.close();
    }
	class Applicant implements Comparable<Applicant>{
		String n,degree,edu;
		int e;
		int ss;
		Map<String,Integer> skill = new HashMap<>();
		List<String> award = new ArrayList<>();
		public Applicant(String name,String[] education,String[] skill,String[] award){
			n = name;
			if (!education[0].equals("None")) {
				edu = education[0];
				degree = education[1];
			}else{
				edu = "None";
			}
			e = al.indexOf(education[0]);
			if (!skill[0].equals("None")) {
				for (int i = 0; i < skill.length; i++) {
					String[] tmp = skill[i].split(":\\s+");
					this.skill.put(tmp[0],Integer.parseInt(tmp[1].replaceAll("[^0-9]","")));
				}
			}
			if (!award[0].equals("None")) {
				for (int i = 0; i < award.length; i++) {
					if(!award[i].isEmpty()){
						this.award.add(award[i]);
					}
				}
			}
		}
		public int compareTo(Applicant o){
			if(e == o.e){
				if(ss == o.ss){
					return n.compareTo(o.n);
				}
				return ss < o.ss ? 1 : -1;
			}
			return e > o.e ? 1 : -1;
		}
		public String toString(){
			String s =  n + " " + edu + " of " + degree + " ";
			if(skill.size()>0){
				for(String a : skill.keySet()){
					if (a.equals("None")) {
						break;
					}
					s+= a + " " + skill.get(a) + " ";
				}
			}else{
				s+="No skill ";
			}
			if(award.size()>0){
				for(String a : award){
					s+=a + " ";
				}
			}else{
				s+="No award";
			}
			return s;
		}
	}
}
