/**
 * 
 */
package rstacey.algorithms.unionfind;

public class QuickUnion implements UnionFinder {

    private int[] points;

    public QuickUnion(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        points = new int[size];
        for (int i = 0; i < size; i++) {
            points[i] = i;
        }
    }
    
    @Override
    public void union(int first, int second) throws IllegalArgumentException {
        if (first >= points.length || second >= points.length) {
            throw new IllegalArgumentException();
        }
        
        int current = first;
        if (points[first] != second) {
            points[second] = first;
        }
    }

    @Override
    public boolean connected(int first, int second)
            throws IllegalArgumentException {
        if (first >= points.length || second >= points.length) {
            throw new IllegalArgumentException();
        }
        return points[first] == points[second];
    }

}
