package com.metacube;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClass {
    @Test
    public void testIsMember() {
        IntSet set = new IntSet(new int[]{1, 2, 3, 4, 5});
        assertTrue(set.isMember(3)) ; //"3 should be a member of the set."
        assertFalse(set.isMember(6)) ; //"6 should not be a member of the set."
    }
    
    @Test
    public void testSize() {
        IntSet set = new IntSet(new int[]{1, 2, 3, 4, 5});
        assertEquals(5, set.size()); // "Size should be 5."
        IntSet emptySet = new IntSet(new int[] {});
        assertEquals(0, emptySet.size()); // "Size of empty set should be 0."
    }
    
    @Test
    public void testIsSubSet() {
        IntSet setA = new IntSet(new int[]{1, 2, 3});
        IntSet setB = new IntSet(new int[]{1, 2});
        IntSet setC = new IntSet(new int[]{4, 5});
        assertTrue(setA.isSubSet(setB));// "B should be a subset of A."
        assertFalse(setA.isSubSet(setC));// "C should not be a subset of A."
    }
    
    @Test
    public void testGetComplement() {
        IntSet set = new IntSet(new int[]{1, 2, 3});
        IntSet complement = set.getComplement();
        assertEquals(997, complement.size());// "Complement size should be 997."
        assertTrue(complement.isMember(4)); //"4 should be in the complement."
        assertFalse(complement.isMember(1));// "1 should not be in the complement."
    }
    
    @Test
    public void testUnion() {
        IntSet setA = new IntSet(new int[]{1, 2, 3});
        IntSet setB = new IntSet(new int[]{3, 4, 5});
        IntSet unionSet = setA.union(setB);
        assertEquals(5, unionSet.size()); // "Union set of setA and setB size will be 5."
        assertTrue(unionSet.isMember(1)); // "1 should be in the union."
        assertFalse(unionSet.isMember(6)); // "4 should be in the union."
    }
    
    @Test
    public void testIntersection() {
        IntSet setA = new IntSet(new int[]{1, 2, 3});
        IntSet setB = new IntSet(new int[]{2, 3, 4});
        IntSet intersectionSet = setA.intersection(setB);
        assertEquals(2, intersectionSet.size()); // "Intersection size should be 2."
        assertTrue(intersectionSet.isMember(2)); // "2 should be in the intersection."
        assertFalse(intersectionSet.isMember(1)); // "1 should not be in the intersection."
    }
    
    @Test
    public void testDifference() {
        IntSet setA = new IntSet(new int[]{1, 2, 3, 4});
        IntSet setB = new IntSet(new int[]{3, 4, 5});
        IntSet differenceSet = setA.difference(setB);
        assertEquals(2, differenceSet.size());  // "Difference size should be 2."
        assertTrue(differenceSet.isMember(1));  // "1 should be in the difference."
        assertFalse(differenceSet.isMember(3)); // "3 should not be in the difference."
    }

}
