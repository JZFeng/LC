/*
 http://lintcode.com/en/problem/topological-sorting/

 127. Topological Sorting 
 
 */
package jz.lintcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class DirectedGraphNode {
	int label;
	ArrayList<DirectedGraphNode> neighbors;

	DirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}

public class TopologicalSorting {

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        
        //build up adjecent table;
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                if ( indegree.containsKey(neighbor) ) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1 );
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node: graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }
        
        while ( !queue.isEmpty()) {
            DirectedGraphNode tmp = queue.poll();
            result.add(tmp);
            for (DirectedGraphNode neighbor : tmp.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1 );
                if (indegree.get(neighbor) == 0 ) {
                    queue.offer(neighbor);
                }
            }
        }
        
        if (result.size() == graph.size()) {
            return result;
        }
        
        return null;
    }

}
