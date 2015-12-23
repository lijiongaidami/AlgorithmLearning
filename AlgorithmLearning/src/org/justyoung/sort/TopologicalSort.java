package org.justyoung.sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;

public class TopologicalSort {

	static class Node {
		String i;
		boolean isMarked;
		ArrayList<Node> adjList;

		public Node(String i) {
			adjList = new ArrayList<>();
			this.i = i;
			this.isMarked = false;
		}

		public void addAdjacentNode(Node e) {
			adjList.add(e);
		}
	}

	public static class Gragh {
		public LinkedHashMap<String, Node> vMap;
		Stack<Node> stack;

		public Gragh(int vnum) {
			vMap = new LinkedHashMap<>();
			stack = new Stack<>();
		}

		public void dfs(Node node) {
			if (!node.isMarked) {
				node.isMarked = true;
				ArrayList<Node> adj = node.adjList;
				for (Node e : adj) {
					dfs(e);
				}
				stack.push(node);
			}
		}

		public void topologicalSort(String startNode) {
			stack.clear();
			for (Entry<String, Node> pair : vMap.entrySet()) {
				Node node = pair.getValue();
				dfs(node);
			}
			StringBuilder sb = new StringBuilder();
			Node e;
			while (!stack.isEmpty() && (e = stack.pop()) != null) {
				sb.append(e.i);
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(
					"/Users/lijiong/git/AlgorithmLearning/AlgorithmLearning/src/org/justyoung/sort/TopologicsortInput"));
			int vnum = Integer.valueOf(br.readLine());
			Gragh g = new Gragh(vnum);
			@SuppressWarnings("unused")
			int edge = Integer.valueOf(br.readLine());
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] nodes = s.split(" ");
				if (nodes.length >= 1) {
					String i = nodes[0];
					Node node = g.vMap.get(i);
					if (node == null) {
						node = new Node(i);
						g.vMap.put(i, node);
					}
					if (nodes.length >= 2) {
						String j = nodes[1];
						Node node2 = g.vMap.get(j);
						if (node2 == null) {
							node2 = new Node(j);
							g.vMap.put(j, node2);
						}
						node.addAdjacentNode(node2);
					}
				}
			}
			g.topologicalSort("A");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
	}
}
