package com.mvnikitin.lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(1, 4);
        graph.addEdge(2, 6);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);


        BreadthFirstPath bfp = new BreadthFirstPath(graph,1);
        System.out.println("To 3: " + bfp.hasPathTo(3) + ", Path: " + bfp.pathTo(3));
        System.out.println("To 5: " + bfp.hasPathTo(5) + ", Path: " + bfp.pathTo(5));
        System.out.println("To 8: " + bfp.hasPathTo(8) + ", Path: " + bfp.pathTo(8));
    }
}

//    To 3: true, Path: [0, 6, 3]
//    To 5: true, Path: [0, 6, 5]
//    To 8: false, Path: null