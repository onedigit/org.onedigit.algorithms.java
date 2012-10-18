package org.onedigit.algorithms.tree.rb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.onedigit.algorithms.tree.Node;
import org.onedigit.algorithms.tree.Node.Colour;

/**
 * An implementation of a Red Black Tree.
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition
 * 
 * @author ahmed
 *
 */
public class RedBlackTree<E extends Comparable<? super E>>
{
	private Node<E> root;

	/**
	 * Insert the given key in the tree whilst maintaining the red-black
	 * properties of the tree
	 * 
	 * @param key value to be inserted
	 */
	public void insert(E key)
	{
		Node<E> y = null;
		Node<E> x = root;
		while (x != null) {
			y = x;
			if (key.compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			} else {
				x = x.getRight();
			}
		}
		Node<E> z = new Node<E>(key);
		z.setParent(y);
		if (y == null) {
			root = z;
		} else if (z.getKey().compareTo(y.getKey()) < 0) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
		z.setColour(Colour.RED);
		insertFixup(z);
	}
	
	/**
	 * Search the tree for the given key. 
	 * Complexity of this operation is O(h) where h is the height of
	 * the tree.  Since it can be proven that h = O(log N) where N is
	 * the number of nodes in the tree, search is also O(log N).
	 * 
	 * @param key value to be searched for
	 * @return {@link Node} containing the given key
	 */
	public Node<E> search(E key)
	{
		Node<E> node = root;
		while (node != null && !key.equals(node.getKey())) {
			if (key.compareTo(node.getKey()) < 0) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			} 
		}
		return node;
	}
	
	/**
	 * Find the lowest common ancestor of the nodes corresponding to the keys
	 * given by k1 and k2
	 * 
	 * @param k1 key of {@link Node}
	 * @param k2 key of {@link Node}
	 */
	public Node<E> findLowestCommonAncestor(E k1, E k2)
	{
		Node<E> result = null;
		Node<E> u = search(k1);
		Node<E> v = search(k2);
		List<Node<E>> uTree = getParentTree(u);
		List<Node<E>> vTree = getParentTree(v);
		if (uTree != null) {
			uTree.retainAll(vTree); // get the intersection
			if (!uTree.isEmpty()) {
				result = uTree.get(uTree.size() - 1);
			}
		}
		return result;
	}
	
	/**
	 * Get the tree from the root to the given node
	 * 
	 * @param node 
	 * @return the set of nodes starting from root to
	 * the given node
	 */
	public List<Node<E>> getParentTree(Node<E> node)
	{
		List<Node<E>> list = new ArrayList<>();
		while (node != null) {
			list.add(0, node);
			node = node.getParent();
		}
		return list;
	}

	public String dotFormat()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("digraph G {\n");
		sb.append("\tnodesep=1.0;\n");
		sb.append("\tnode [shape=circle];\n");
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			Node<E> node = stack.pop();
			if (node != null) {
				if (node.getLeft() != null) {
					sb.append("\t\"" + node + "\" -> \"" + 
							node.getLeft() + "\";\n");
					stack.push(node.getLeft());
				}
				if (node.getRight() != null) {
					sb.append("\t\"" + node + "\" -> \"" + 
							node.getRight() + "\";\n");
					stack.push(node.getRight());
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public String neatoFormat()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("graph G {\n");
		// sb.append("{edge [len=3];\n")
		sb.append("{edge;\n");
		Stack<Node<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			Node<E> node = stack.pop();
			if (node != null) {
				if (node.getLeft() != null) {			
					sb.append("\t" + node + " -- " + node.getLeft() + ";\n");
					stack.push(node.getLeft());
				}
				if (node.getRight() != null) {
					sb.append("\t" + node + " -- " + node.getRight() + ";\n");
					stack.push(node.getRight());
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}	
	
	// ------------------------------------------------------------------------
	
	private void rotateLeft(Node<E> x)
	{
		Node<E> y = x.getRight();
		// turn y's left subtree into x's right subtree
		x.setRight(y.getLeft());
		if (y.getLeft() != null) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent()); // link x's parent to y
		if (x.getParent() == null) {
			root = y;
		} else if (x.equals(x.getParent().getLeft())) {
			x.getParent().setLeft(y);
		} else {
			x.getParent().setRight(y);
		}
		y.setLeft(x); // put x on y's left
		x.setParent(y);
	}

	private void rotateRight(Node<E> y)
	{
		Node<E> x = y.getLeft();
		y.setLeft(x.getRight());
		if (x.getRight() != null) {
			x.getLeft().setParent(y);
		}
		x.setParent(y.getParent()); // link y's parent to x
		if (y.getParent() == null) {
			root = x;
		} else if (y.equals(y.getParent().getRight())) {
			y.getParent().setRight(x);
		} else {
			y.getParent().setLeft(x);
		}
		x.setRight(y); // put y on x's right
		y.setParent(x);
	}

	private Colour colourOf(Node<E> node)
	{
		if (node == null) {
			return Colour.BLACK;
		} else {
			return node.getColour();
		}
	}

	private void setColour(Node<E> node, Node.Colour colour)
	{
		if (node != null) {
			node.setColour(colour);
		}
	}

	private Node<E> parentOf(Node<E> node)
	{
		if (node == null) {
			return null;
		} else {
			return node.getParent();
		}
	}

	private void insertFixup(Node<E> z)
	{
		while (z != null && z != root && colourOf(parentOf(z)) == Colour.RED) {
			// fix-up red-red in left subtree
			if (parentOf(z) == parentOf(parentOf(z)).getLeft()) {
				Node<E> y = parentOf(parentOf(z)).getRight();
				// parent has two red children, blacken both
				if (colourOf(y) == Colour.RED) {
					setColour(parentOf(z), Colour.BLACK);
					setColour(y, Colour.BLACK);
					setColour(parentOf(parentOf(z)), Colour.RED);
					// z moves two levels up in the tree
					z = parentOf(parentOf(z));
				} else { // parent has red and black children
					// rotate right child to left
					if (z == parentOf(z).getRight()) {
						z = parentOf(z);
						rotateLeft(z);
					}
					// propagate red up
					setColour(parentOf(z), Colour.BLACK);
					setColour(parentOf(parentOf(z)), Colour.RED);
					rotateRight(parentOf(parentOf(z)));
				}
			} else { // fix-up red-red in right subtree
				Node<E> y = parentOf(parentOf(z)).getLeft();
				// parent has two red children, blacken both
				if (colourOf(y) == Colour.RED) {
					setColour(parentOf(z), Colour.BLACK);
					setColour(y, Colour.BLACK);
					setColour(parentOf(parentOf(z)), Colour.RED);
					z = parentOf(parentOf(z));
				} else { // parent has red and black children
					// rotate left child to right
					if (z == parentOf(z).getLeft()) {
						z = parentOf(z);
						rotateRight(z);
					}
					// propagate red up
					setColour(parentOf(z), Colour.BLACK);
					setColour(parentOf(parentOf(z)), Colour.RED);
					rotateLeft(parentOf(parentOf(z)));
				}
			}
		}
		root.setColour(Colour.BLACK);
	}
}
