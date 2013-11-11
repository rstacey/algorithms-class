package rstacey.algorithms.unionfind;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnionFindTest {
    @Test
    public void testQuickFind() {
        QuickFind quickFind = new QuickFind(10);

        quickFind.union(0, 1);
        quickFind.union(0, 2);

        assertTrue(quickFind.connected(0, 1));
        assertTrue(quickFind.connected(0, 2));
        assertTrue(quickFind.connected(1, 2));
        assertFalse(quickFind.connected(2, 3));

        quickFind.union(4, 5);
        quickFind.union(5, 6);
        assertTrue(quickFind.connected(4, 5));
        assertTrue(quickFind.connected(5, 6));
        assertTrue(quickFind.connected(4, 6));
        assertFalse(quickFind.connected(0, 4));

        quickFind.union(2, 5);
        assertTrue(quickFind.connected(0, 1));
        assertTrue(quickFind.connected(4, 5));
        assertTrue(quickFind.connected(1, 4));
        assertTrue(quickFind.connected(2, 6));
        assertTrue(quickFind.connected(0, 5));
        assertFalse(quickFind.connected(0, 3));
        assertFalse(quickFind.connected(5, 7));

    }

    @Test
    public void testQuickUnion() {
        QuickUnion quickUnion = new QuickUnion(10);

        quickUnion.union(0, 1);
        quickUnion.union(0, 2);
        

        assertTrue(quickUnion.connected(0, 1));
        assertTrue(quickUnion.connected(0, 2));
        assertTrue(quickUnion.connected(1, 2));
        assertFalse(quickUnion.connected(2, 3));

        quickUnion.union(4, 5);
        quickUnion.union(5, 6);
        quickUnion.union(5, 7);
        quickUnion.union(5, 8);
        quickUnion.union(7, 9);
        
        assertTrue(quickUnion.connected(4, 5));
        assertTrue(quickUnion.connected(5, 6));
        assertTrue(quickUnion.connected(4, 6));
        assertFalse(quickUnion.connected(0, 4));

        quickUnion.union(2, 5);
        assertTrue(quickUnion.connected(0, 1));
        assertTrue(quickUnion.connected(4, 5));
        assertTrue(quickUnion.connected(1, 4));
        assertTrue(quickUnion.connected(2, 6));
        assertTrue(quickUnion.connected(0, 5));
        assertFalse(quickUnion.connected(0, 3));
    }

}
