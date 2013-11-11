/**
 * 
 */
package rstacey.algorithms.unionfind;

public class QuickFind implements UnionFinder {

	private int[] nodes;

	public QuickFind(int size) throws IllegalArgumentException {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		nodes = new int[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = i;
		}
	}
	
	@Override
	public void union(int first, int second) throws IllegalArgumentException {
		if (first >= nodes.length || second >= nodes.length) {
			throw new IllegalArgumentException();
		}
		
		if (!connected(first, second)) {
			int oldBase = nodes[second];
			int newBase = nodes[first];
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i] == oldBase) {
					nodes[i] = newBase;
				}
			}
		}		
	}

	@Override
	public boolean connected(int first, int second) throws IllegalArgumentException {
		if (first >= nodes.length || second >= nodes.length) {
			throw new IllegalArgumentException();
		}
		return nodes[first] == nodes[second];
	}

}
