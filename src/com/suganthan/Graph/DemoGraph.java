package com.suganthan.Graph;

import java.util.*;

/**
 * Created by msuganthan on 23/7/17.
 */
public class DemoGraph {

    public static void main(String[] args) {

        Graph graph = new Graph();


        //initialize some vertices and add them to the graph
        Vertex[] vertices = new Vertex[5];
        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Vertex("" + i);
            graph.addVertex(vertices[i], true);
        }

        //illustrate the fact that duplicate edges aren't added
        for(int i = 0; i < vertices.length - 1; i++){
            for(int j = i + 1; j < vertices.length; j++){
                graph.addEdge(vertices[i], vertices[j]);
                graph.addEdge(vertices[i], vertices[j]);
                graph.addEdge(vertices[j], vertices[i]);
            }
        }

        //display the initial setup- all vertices adjacent to each other
        for(int i = 0; i < vertices.length; i++){
            System.out.println(vertices[i]);

            for(int j = 0; j < vertices[i].getNeighborCount(); j++){
                System.out.println(vertices[i].getNeighbor(j));
            }

            System.out.println();
        }

        //overwritte Vertex 3
        graph.addVertex(new Vertex("3"), true);
        for(int i = 0; i < vertices.length; i++){
            System.out.println(vertices[i]);

            for(int j = 0; j < vertices[i].getNeighborCount(); j++){
                System.out.println(vertices[i].getNeighbor(j));
            }

            System.out.println();
        }


        System.out.println("Vertex 5: " + graph.getVertex("5")); //null
        System.out.println("Vertex 3: " + graph.getVertex("3")); //Vertex 3

        //true
        System.out.println("Graph Contains {1, 2}: " +
                graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

        //true
        System.out.println(graph.removeEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

        //false
        System.out.println("Graph Contains {1, 2}: " + graph.containsEdge(new Edge(graph.getVertex("1"), graph.getVertex("2"))));

        //false
        System.out.println("Graph Contains {2, 3} " + graph.containsEdge(new Edge(graph.getVertex("2"), graph.getVertex("3"))));

        System.out.println(graph.containsVertex(new Vertex("1"))); //true
        System.out.println(graph.containsVertex(new Vertex("6"))); //false
        System.out.println(graph.removeVertex("2")); //Vertex 2
        System.out.println(graph.vertexKeys()); //[3, 1, 0, 4]
    }
}

class Vertex {
    private List<Edge> neighborhood;
    private String label;

    Vertex(String label) {
        this.label = label;
        this.neighborhood = new ArrayList<>();
    }

    public void addNeighbor(Edge edge) {
        if (this.neighborhood.contains(edge))
            return;
        this.neighborhood.add(edge);
    }

    public boolean containsNeighbor(Edge other) {
        return this.neighborhood.contains(other);
    }

    public Edge getNeighbor(int index) {
        return this.neighborhood.get(index);
    }

    Edge removeNeighbor(int index) {
        return this.neighborhood.remove(index);
    }

    public void removeNeighbor(Edge e) {
        this.neighborhood.remove(e);
    }

    public int getNeighborCount() {
        return this.neighborhood.size();
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex " + label;
    }

    @Override
    public int hashCode() {
        return this.label.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Vertex)) {
            return false;
        }
        Vertex v = (Vertex) other;
        return this.label.equals(v.label);
    }

}

class Edge implements Comparable<Edge> {
    private Vertex one, two;
    private int weight;

    public Edge(Vertex one, Vertex two) {
        this(one, two, 1);
    }

    public Edge(Vertex one, Vertex two, int weight) {
        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0 ) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }

    public Vertex getNeighbor(Vertex current) {
        if (!(current.equals(one) || current.equals(two))) {
            return null;
        }
        return (current.equals(one)) ? two : one;
    }

    public Vertex getOne() {
        return one;
    }

    public Vertex getTwo() {
        return two;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "({" + one + ", " + two + "}, " + weight + ")";
    }

    @Override
    public int hashCode() {
        return (one.getLabel() + two.getLabel()).hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Edge))
            return false;
        Edge edge = (Edge) other;
        return edge.one.equals(this.one) && edge.two.equals(this.two);
    }
}

class Graph {
    private Map<String, Vertex> vertices;
    private Map<Integer, Edge> edges;

    public Graph(){
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    public Graph(ArrayList<Vertex> vertices){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new HashMap<Integer, Edge>();

        for(Vertex v: vertices){
            this.vertices.put(v.getLabel(), v);
        }

    }

    public boolean addEdge(Vertex one, Vertex two){
        return addEdge(one, two, 1);
    }

    public boolean addEdge(Vertex one, Vertex two, int weight){
        if(one.equals(two)){
            return false;
        }

        //ensures the Edge is not in the Graph
        Edge e = new Edge(one, two, weight);
        if(edges.containsKey(e.hashCode())){
            return false;
        }

        //and that the Edge isn't already incident to one of the vertices
        else if(one.containsNeighbor(e) || two.containsNeighbor(e)){
            return false;
        }

        edges.put(e.hashCode(), e);
        one.addNeighbor(e);
        two.addNeighbor(e);
        return true;
    }

    public boolean containsEdge(Edge e){
        if(e.getOne() == null || e.getTwo() == null){
            return false;
        }

        return this.edges.containsKey(e.hashCode());
    }

    public Edge removeEdge(Edge e){
        e.getOne().removeNeighbor(e);
        e.getTwo().removeNeighbor(e);
        return this.edges.remove(e.hashCode());
    }

    public boolean containsVertex(Vertex vertex){
        return this.vertices.get(vertex.getLabel()) != null;
    }

    public Vertex getVertex(String label){
        return vertices.get(label);
    }

    public boolean addVertex(Vertex vertex, boolean overwriteExisting){
        Vertex current = this.vertices.get(vertex.getLabel());
        if(current != null){
            if(!overwriteExisting){
                return false;
            }

            while(current.getNeighborCount() > 0){
                this.removeEdge(current.getNeighbor(0));
            }
        }


        vertices.put(vertex.getLabel(), vertex);
        return true;
    }

    public Vertex removeVertex(String label){
        Vertex v = vertices.remove(label);

        while(v.getNeighborCount() > 0){
            this.removeEdge(v.getNeighbor((0)));
        }

        return v;
    }

    public Set<String> vertexKeys(){
        return this.vertices.keySet();
    }

    public Set<Edge> getEdges(){
        return new HashSet<Edge>(this.edges.values());
    }

}

enum TYPE {
    DIRECTED, UNDIRECTED;
}