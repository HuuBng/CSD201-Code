package Graph;

import java.util.LinkedList;
import java.util.Stack;

class Graph {
    private int vertices;
    private int[][] adjMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    public void addEdge(int start, int dest) {
        // undirected graph
        adjMatrix[start][dest] = 1;
        adjMatrix[dest][start] = 1;
    }

    public void removeEdge(int start, int dest) {
        // undirected graph
        adjMatrix[start][dest] = 0;
        adjMatrix[dest][start] = 0;
    }

    public void printGraph() {
        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class GraphList {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int start, int dest) {
        // Undirected Graph
        adjList[start].add(dest);
        adjList[dest].add(start);
    }

    public void removerEdge(int start, int dest) {
        // Undirected Graph
        adjList[start].remove(dest);
        adjList[dest].remove(start);
    }

    public void printGraph() {
        System.out.println("Adjacency List: ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Integer neighbor : adjList[i]) {
                System.out.print(neighbor + " --> ");
            }
            System.out.println();

        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for (int neighbor : adjList[temp]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }

            }
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            if (!visited[temp]) {
                System.out.print(temp + " ");
                visited[temp] = true;
            }

            for (int neighbor : adjList[temp]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}

class GraphMain {
    public static void main(String[] args) {
//        Graph myGraph = new Graph(6);
//        myGraph.addEdge(0, 1);
//        myGraph.addEdge(0, 3);
//        myGraph.addEdge(0, 2);
//        myGraph.addEdge(1, 3);
//        myGraph.addEdge(3, 4);
//        myGraph.addEdge(2, 5);
//        myGraph.printGraph();
        GraphList myGraphList = new GraphList(6);
        myGraphList.addEdge(0, 1);
        myGraphList.addEdge(0, 3);
        myGraphList.addEdge(0, 2);
        myGraphList.addEdge(1, 3);
        myGraphList.addEdge(3, 4);
        myGraphList.addEdge(2, 5);
        myGraphList.printGraph();
        myGraphList.dfs(0);
    }
}
