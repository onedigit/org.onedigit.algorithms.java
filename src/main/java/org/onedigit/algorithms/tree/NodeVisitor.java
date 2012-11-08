package org.onedigit.algorithms.tree;

public interface NodeVisitor<T extends Comparable<? super T>>
{
    void visit(Node<T> node);
}
