package org.onedigit.algorithms.graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class PriorityQueueTest
{
    @Test
    public void test()
    {
        PriorityQueue<Node<Integer>> pQ = new PriorityQueue<>(1,
                new Comparator<Node<Integer>>() {
                    @Override
                    public int compare(Node<Integer> o1, Node<Integer> o2)
                    {
                        return o1.getDistance() - o2.getDistance();
                    }
                });
        Graph<Integer> graph = makeGraph();
        System.out.println(graph);      
        pQ.addAll(graph.getAllNodes());
        int i = 0;
        int j = 0;
        while (!pQ.isEmpty()) {
            Node<Integer> u = pQ.remove();
            System.out.println(u);
            List<Edge<Integer>> edges = graph.getAdjacency(u);
            System.out.println(edges);
            if (edges != null) {
                for (Edge<Integer> e : edges) {
                    Node<Integer> v = e.getTarget();
                    v.setDistance(v.getDistance() + 100);
                    pQ.remove(v);
                    pQ.add(v);
                }
            }
            i++;
            if (i == 2) {
                break;
            }
        }

        System.out.println("-----------------");
        while (!pQ.isEmpty()) {
            Node<Integer> u = pQ.remove();
            System.out.println(u + ": " + u.getDistance());
        }
    }
    
    private Graph<Integer> makeGraph()
    {
        Graph<Integer> graph = new Graph<>();
        Node<Integer> one = new Node<>(1); one.setDistance(10);
        Node<Integer> two = new Node<>(2); two.setDistance(20);
        Node<Integer> three = new Node<>(3); three.setDistance(30);
        Node<Integer> four = new Node<>(4); four.setDistance(40);
        Node<Integer> five = new Node<>(5); five.setDistance(50);
        Node<Integer> six = new Node<>(6); six.setDistance(60);
        graph.addEdge(one, two, 7); 
        graph.addEdge(one, three, 9);
        graph.addEdge(one, six, 14);
        graph.addEdge(two, three, 10);
        graph.addEdge(two, four, 15);
        graph.addEdge(three, four, 11);
        graph.addEdge(three, six, 2);
        graph.addEdge(six, five, 9);
        graph.addEdge(four, five, 6);
        return graph;
    }
}
