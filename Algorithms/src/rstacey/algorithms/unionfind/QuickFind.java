/**
 * 
 */
package rstacey.algorithms.unionfind;

public class QuickFind implements UnionFinder {

	private int[] points;

	public QuickFind(int size) throws IllegalArgumentException {
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
		
		if (!connected(first, second)) {
			int oldBase = points[second];
			int newBase = points[first];
			for (int i = 0; i < points.length; i++) {
				if (points[i] == oldBase) {
					points[i] = newBase;
				}
			}
		}		
	}

	@Override
	public boolean connected(int first, int second) throws IllegalArgumentException {
		if (first >= points.length || second >= points.length) {
			throw new IllegalArgumentException();
		}
		return points[first] == points[second];
	}

}
