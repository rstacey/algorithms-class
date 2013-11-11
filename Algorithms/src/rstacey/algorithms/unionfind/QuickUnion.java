/**
 * 
 */
package rstacey.algorithms.unionfind;

public class QuickUnion implements UnionFinder {

    private int[] nodes;

    public QuickUnion(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        nodes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
        }
    }
    
    private int getRoot(int node) {
        int currentNode = node;
        while(nodes[currentNode] != currentNode) {
            currentNode = nodes[currentNode];
        }
        return currentNode;
    }
      
    @Override
    public void union(int first, int second) throws IllegalArgumentException {
        if (first >= nodes.length || second >= nodes.length) {
            throw new IllegalArgumentException();
        }
        int firstRoot = getRoot(first);
        int secondRoot = getRoot(second);
        if (firstRoot != secondRoot) {
            nodes[secondRoot] = firstRoot;
        }
    }

    @Override
    public boolean connected(int first, int second)
            throws IllegalArgumentException {
        if (first >= nodes.length || second >= nodes.length) {
            throw new IllegalArgumentException();
        }
        
        
        
        return getRoot(first) == getRoot(second);
    }

}
