import java.util.*;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		Stack<UndirectedGraphNode> toCloneStack = new Stack<UndirectedGraphNode>();
		Set<UndirectedGraphNode> visitedSet = new HashSet<UndirectedGraphNode>();
		Map<UndirectedGraphNode, UndirectedGraphNode> cloneMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		toCloneStack.push(node);
		while (!toCloneStack.empty()) {
			UndirectedGraphNode n = toCloneStack.pop();
			if (visitedSet.contains(n)) {
				continue;
			}

			UndirectedGraphNode clonedN;
			if (cloneMap.containsKey(n)) {
				clonedN = cloneMap.get(n);
			} else {
				clonedN = new UndirectedGraphNode(n.label);
				cloneMap.put(n, clonedN);
			}

			for (UndirectedGraphNode neighbor : n.neighbors) {
				toCloneStack.push(neighbor);

				if (cloneMap.containsKey(neighbor)) {
					clonedN.neighbors.add(cloneMap.get(neighbor));
				} else {
					UndirectedGraphNode clonedNeighbor = new UndirectedGraphNode(
							neighbor.label);
					clonedN.neighbors.add(clonedNeighbor);
					cloneMap.put(neighbor, clonedNeighbor);
				}
			}
			visitedSet.add(n);

		}

		return cloneMap.get(node);
	}
}
