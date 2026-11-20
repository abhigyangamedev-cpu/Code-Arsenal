package Graphs;

public class GraphMatrix {
    private int nodes;
    private int[][] adjacencyMatrix;

    public GraphMatrix(int nodes) {
        this.nodes = nodes;
        adjacencyMatrix = new int[nodes][nodes];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void printMatrix() {
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        GraphMatrix graph = new GraphMatrix(6);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

        System.out.println("Adjacency Matrix:");
        graph.printMatrix();
    }

}
