package org.onedigit.algorithms.graph;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import org.onedigit.algorithms.graph.Graph;
import org.onedigit.algorithms.graph.Node;

public class GraphTest
{
	public static String ACROBAT = "C:\\Program Files\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe";
	public static String NEATO = "C:\\Apps\\Graphviz 2.28\\bin\\neato.exe";
	public static String DOT = "C:\\Apps\\Graphviz 2.28\\bin\\dot.exe";
	
    @Test
    public void test() throws IOException
    {
        Graph<Integer> graph = new Graph<>();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);

        graph.addEdge(one, two, 7);
        graph.addEdge(one, three, 9);
        graph.addEdge(one, six, 14);
        graph.addEdge(two, three, 10);
        graph.addEdge(two, four, 15);
        graph.addEdge(three, four, 11);
        graph.addEdge(three, six, 2);
        graph.addEdge(six, five, 9);
        graph.addEdge(four, five, 6);
        
        System.out.println(graph);
        
        renderDot(graph);
    }
    
	private void renderNeato(Graph graph) throws IOException
	{
		String filename = "graph.dot";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
		System.out.println(graph.toString());
		bw.write(graph.neatoFormat());
		bw.close();
		String neatoCmd = NEATO + " -Gepsilon=0.1 -Tpdf " + filename + " -o graph.pdf";
		Runtime.getRuntime().exec(neatoCmd);
		Runtime.getRuntime().exec(ACROBAT + " graph.pdf");
	}
	
	private void renderDot(Graph graph) throws IOException
	{
		String filename = "graph.dot";
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)));
		System.out.println(graph.toString());
		bw.write(graph.dotFormat());
		bw.close();
		String neatoCmd = DOT + " -Tpdf " + filename + " -o graph.pdf";
		Runtime.getRuntime().exec(neatoCmd);
		Runtime.getRuntime().exec(ACROBAT + " graph.pdf");
	}	    
}
