import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sun.security.provider.certpath.AdjacencyList;

public class CriticalRouters {
    /*
     * You are given an undirected connected graph. An articulation point (or cut
     * vertex) is defined as a vertex which, when removed along with associated
     * edges, makes the graph disconnected (or more precisely, increases the number
     * of connected components in the graph). The task is to find all articulation
     * points in the given graph.
     * 
     * Input: The input to the function/method consists of three arguments:
     * 
     * numNodes, an integer representing the number of nodes in the graph. numEdges,
     * an integer representing the number of edges in the graph. edges, the list of
     * pair of integers - A, B representing an edge between the nodes A and B.
     * Output: Return a list of integers representing the critical nodes.
     * 
     * Example:
     * 
     * Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3],
     * [2, 5], [5, 6], [3, 4]]
     * 
     * 
     * Output: [2, 3, 5]
     */

    public static void DFS(int startNode, Map<Integer, List<Integer>> graph, List<Integer> nodeList) {
        int numNodes = nodeList.size();
        Map<Integer, Boolean> visited = new HashMap<>();
        for (Integer node : nodeList) {
            visited.put(node, false);
        }
        DFSaux(startNode, graph, nodeList);
    }

    public static void DFSaux(int node, Map<Integer, List<Integer>> graph, List<Integer> nodeList) {
        //TODO
    }

    public static List<Integer> criticalRouters(int numNodes, int numEdges, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < numNodes; i++) {
            List<Integer> nodeList = new ArrayList<>();
            for (int j = 0; j < numNodes; j++) {
                if(i != j){
                    nodeList.add(i);
                }
            }
        }

        System.out.println(graph.toString());
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int numNodes = 7;
        int numEdges = 7;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 5, 6 }, { 3, 4 } };

        System.out.println(criticalRouters(numNodes, numEdges, edges));
    }
}