package org.onedigit.algorithms.graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest
{
    public static String ACROBAT;
    public static String NEATO;
    public static String DOT;

    @BeforeClass
    public static void before()
    {
        String os = System.getProperty("os.name");
        System.out.println("Running tests on " + os);
        if (os.equals("Windows")) {
            ACROBAT = "C:\\Program Files\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe";
            NEATO = "C:\\Apps\\Graphviz 2.28\\bin\\neato.exe";
            DOT = "C:\\Apps\\Graphviz 2.28\\bin\\dot.exe";
        } else if (os.equals("Mac OS X")) {
            ACROBAT = "/usr/local/bin/AdobeReader";
            NEATO = "/usr/local/graphviz-2.14/bin/neato";
            DOT = "/usr/local/graphviz-2.14/bin/dot";
        }
    }

    Node<Integer> one = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> three = new Node<>(3);
    Node<Integer> four = new Node<>(4);
    Node<Integer> five = new Node<>(5);
    Node<Integer> six = new Node<>(6);

    // @Test
    public void test() throws IOException
    {
        Graph<Integer> graph = makeGraph();
        System.out.println(graph);
        renderDot(graph);
    }

    @Test
    public void testConnectivity()
    {
        Graph<Integer> graph = makeGraph();
        boolean result = graph.isConnected(three, five);
        Assert.assertTrue(result);
    }

    private Graph<Integer> makeGraph()
    {
        Graph<Integer> graph = new Graph<>();
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

    private <E extends Comparable<? super E>> void renderNeato(Graph<E> graph)
            throws IOException
    {
        String filename = "graph.dot";
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(filename)));
        System.out.println(graph.toString());
        bw.write(graph.neatoFormat());
        bw.close();
        String neatoCmd = NEATO + " -Gepsilon=0.1 -Tpdf " + filename
                + " -o graph.pdf";
        Runtime.getRuntime().exec(neatoCmd);
        // Runtime.getRuntime().exec(ACROBAT + " graph.pdf");
    }

    private <E extends Comparable<? super E>> void renderDot(Graph<E> graph)
            throws IOException
    {
        String filename = "graph.dot";
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(filename)));
        System.out.println(graph.toString());
        bw.write(graph.dotFormat());
        bw.close();
        String neatoCmd = DOT + " -Tpdf " + filename + " -o graph.pdf";
        Runtime.getRuntime().exec(neatoCmd);
        // Runtime.getRuntime().exec(ACROBAT + " graph.pdf");
    }
}
