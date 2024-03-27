import java.util.*;
import java.io.*;

class fai {
	Map<String, List<String>> m;

	public static void main(String[] args) throws Exception {
		new fai().run();
	}

	public void run() throws Exception {
		// Scanner f = new Scanner(System.in);
		Scanner f = new Scanner(new File("fai.dat"));
		int N = f.nextInt();
		f.nextLine();
		for (int cases = 1; cases <= N; cases++) {
			m = new HashMap<>();
			String[] cities = f.nextLine().split("\\s*,\\s*");
			for (String city : cities) {
				m.put(city, new ArrayList());
			}
			String current = f.nextLine();
			Set<String> list = new LinkedHashSet<>(Arrays.asList(f.nextLine().split("\\s*,\\s*")));
			Set<String> visited = new LinkedHashSet<>();
			for (String pair : list) {
				String[] city = pair.split("\\s*<->\\s*");
				m.get(city[0]).add(city[1]);
				m.get(city[1]).add(city[0]);
			}
			f.nextLine();
			System.out.println("Test case " + cases + ": " + (dfs("", current, current, visited, list) ? "possible" : "impossible"));
		}
	}

	public boolean dfs(String prev, String cur, String goal, Set<String> visited, Set<String> list) {
		list.remove(cur + "<->" + prev);
		visited.add(cur);
		if (cur.equals(goal) && list.isEmpty()) {
			visited.remove(cur);
			return true;
		}
		for (String city : m.get(cur)) {
			if (!visited.contains(city)) {
				if (dfs(cur, city, goal, visited, list)) {
					return true;
				}
			}
		}
		visited.remove(cur);
		return false;
	}
}
