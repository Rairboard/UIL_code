import java.util.*;
import java.io.*;

class FeedStore {
	public static void main(String[] args) throws Exception{
		Scanner f = new Scanner(new File("feed_store.dat"));
		String in = "";
		while(f.hasNext()){
			in += f.nextLine() + "\n";
		}
		FeedDelivery feedDelivery = new FeedDelivery(in);
		feedDelivery.findShortestPath();
		feedDelivery.printShortestPath();
	}
}

class FeedDelivery {
	private int capacity;
	private Map<Character, Integer> feedDict;
	private Map<Character, List<Connection>> connections;
	Map<Character, Integer> distances = new HashMap<>();
	Map<Character, Character> previousNodes = new HashMap<>();
	FeedDelivery(String input) {
		parseInput(input);
	}

	private void parseInput(String input) {
		String[] inputLines = input.trim().split("\n");
		capacity = Integer.parseInt(inputLines[0]);
		feedDict = new HashMap<>();
		connections = new HashMap<>();

		String[] feedData = inputLines[1].split(",");
		for (String item : feedData) {
			feedDict.put(item.charAt(0), Integer.parseInt(item.substring(1)));
		}

		for (int i = 2; i < inputLines.length; i++) {
			String[] parts = inputLines[i].split("-");
			String[] locations = parts[0].split("/");
			char locationA = locations[0].charAt(0);
			char locationB = locations[1].charAt(0);
			int distance = Integer.parseInt(parts[1]);

			connections.computeIfAbsent(locationA, k -> new ArrayList<>()).add(new Connection(locationB, distance));
			connections.computeIfAbsent(locationB, k -> new ArrayList<>()).add(new Connection(locationA, distance));
		}
	}

	void findShortestPath() {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

		for (char node : feedDict.keySet()) {
			distances.put(node, Integer.MAX_VALUE);
			previousNodes.put(node, null);
		}

		distances.put('A', 0);
		priorityQueue.add(new Node('A', 0));

		while (!priorityQueue.isEmpty()) {
			Node currentNode = priorityQueue.poll();

			for (Connection connection : connections.getOrDefault(currentNode.node, Collections.emptyList())) {
				int newDistance = distances.get(currentNode.node) + connection.distance;

				if (newDistance < distances.get(connection.target) && getFeedSum(previousNodes, currentNode.node) <= capacity) {
					distances.put(connection.target, newDistance);
					previousNodes.put(connection.target, currentNode.node);
					priorityQueue.add(new Node(connection.target, newDistance));
				}
			}
		}
	}

	private int getFeedSum(Map<Character, Character> previousNodes, char currentNode) {
		int feedSum = 0;
		while (currentNode != 'A') {
			feedSum += feedDict.get(currentNode);
			currentNode = previousNodes.get(currentNode);
		}
		return feedSum;
	}

	void printShortestPath() {
		int shortestDistance = distances.get('J');
		StringBuilder shortestPath = new StringBuilder("A");
		char currentNode = 'J';

		while (currentNode != 'A') {
			shortestPath.insert(0, currentNode);
			currentNode = previousNodes.get(currentNode);
		}

		System.out.println("(" + shortestDistance + ") - " + shortestPath);
	}
}

class Node {
	char node;
	int distance;

	Node(char node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class Connection {
	char target;
	int distance;

	Connection(char target, int distance) {
		this.target = target;
		this.distance = distance;
	}
}
