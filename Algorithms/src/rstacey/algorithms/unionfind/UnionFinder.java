package rstacey.algorithms.unionfind;

public interface UnionFinder {
	
	public void union(int first, int second) throws IllegalArgumentException;
	
	public boolean connected(int first, int second) throws IllegalArgumentException;
}
