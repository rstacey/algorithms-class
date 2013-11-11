/**
 * 
 */
package rstacey.algorithms.unionfind;

public class QuickUnion implements UnionFinder {

    private int[] nodes;
    private int[] sizes;

    public QuickUnion(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        nodes = new int[size];
        sizes = new int[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = i;
            sizes[i] = 1;
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
        if (sizes[firstRoot] < sizes[secondRoot]) {
            nodes[secondRoot] = firstRoot;
            sizes[firstRoot] += sizes[secondRoot];
        } else {
            nodes[firstRoot] = secondRoot;
            sizes[secondRoot] += sizes[firstRoot];
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
