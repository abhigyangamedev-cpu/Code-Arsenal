package Graphs;

import Stacks.StackNode;

import java.util.*;

public class Graphs {

    private int nodes;
    private List<Integer>[] adjacencyList;

    public Graphs(int nodes){
        this.nodes = nodes;
        adjacencyList = new LinkedList[nodes];

        for(int i = 0; i < nodes; i++) adjacencyList[i] = new LinkedList<>();
    }

    public void addEdge(int source,int destination){
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    public List<Integer> Bfs(int startVertex) {
        boolean[] visited = new boolean[nodes];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()){
            int vertex = queue.remove();

            result.add(vertex);

            for(int neighbour : adjacencyList[vertex]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }


    public ArrayList<Integer> DfsRecursive(int startVertex) {
        boolean[] visited = new boolean[nodes];
        ArrayList<Integer> result = new ArrayList<>();
        dfsUtil(startVertex,visited,result);
        return result;
    }

    private void dfsUtil(int vertex, boolean[] visited, ArrayList<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        for(int neighbour : adjacencyList[vertex]){
            if(!visited[neighbour]){
                dfsUtil(neighbour,visited,result);
            }
        }
    }



    public ArrayList<Integer> DfsIterative(int startVertex) {
        boolean[] visited = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        visited[startVertex] = true;
        stack.push(startVertex);

        while(!stack.isEmpty()){
            int vertex = stack.pop();
            result.add(vertex);

            for(int neighbour : adjacencyList[vertex]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }

        }

        return result;
    }



    public static void main(String[] args){
        Graphs graph = new Graphs(6);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

        List<Integer> bfs = graph.Bfs(0);
        System.out.println("Bfs traversal");
        System.out.println(bfs);

        List<Integer> dfs_r = graph.DfsRecursive(0);
        System.out.println("Dfs Recursive");
        System.out.println(dfs_r);

        List<Integer> dfs_i = graph.DfsIterative(0);
        System.out.println("Dfs Iterative");
        System.out.println(dfs_i);
    }


}
