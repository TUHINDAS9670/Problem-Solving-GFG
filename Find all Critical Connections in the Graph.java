import java.util.*;

public class Main {
	// Function to find critical connections in a graph
	static List<List<Integer>> criticalConnections(int V, List<Integer>[] adj) {
		List<List<Integer>> ans = new ArrayList<>();
		int[] rank = new int[V];
		Arrays.fill(rank, -1);
		int[] vis = new int[V];
		dfs(0, -1, rank, 0, adj, ans, vis);

		// Sort each edge in ascending order of nodes
		for (List<Integer> edge : ans) {
			Collections.sort(edge);
		}

		// Sort the list of edges
		ans.sort((a, b) -> {
			if (a.get(0).equals(b.get(0))) {
				return a.get(1) - b.get(1);
			}
			return a.get(0) - b.get(0);
		});

		return ans;
	}

	// Depth-first search to find critical connections
	static int dfs(int i, int p, 
				int[] rank, 
				int k, 
				List<Integer>[] adj, 
				List<List<Integer>> ans, 
				int[] vis) {
		rank[i] = k;
		vis[i] = 1;
		int minDepth = Integer.MAX_VALUE;

		for (int ch : adj[i]) {
			if (ch != p) {
				if (vis[ch] == 1) {
					minDepth = Math.min(minDepth, rank[ch]);
				} else {
					int minRank = dfs(ch, i, rank, k + 1, adj, ans, vis);

					if (rank[i] < minRank) {
						List<Integer> edge = new ArrayList<>();
						edge.add(i);
						edge.add(ch);
						ans.add(edge);
					}

					minDepth = Math.min(minRank, minDepth);
				}
			}
		}
		return minDepth;
	}

	public static void main(String[] args) {
		int V = 3;
		List<Integer>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}

		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(0, 1));
		edges.add(Arrays.asList(0, 2));

		for (List<Integer> edge : edges) {
			adj[edge.get(0)].add(edge.get(1));
			adj[edge.get(1)].add(edge.get(0));
		}

		List<List<Integer>> ans = criticalConnections(V, adj);

		// Print the critical connections
		for (List<Integer> edge : ans) {
			System.out.println(edge.get(0) + " " + edge.get(1));
		}
	}
}
