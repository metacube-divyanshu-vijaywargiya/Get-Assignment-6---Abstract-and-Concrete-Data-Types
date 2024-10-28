package com.metacube;
//import java.util.Arrays;

public class IntSet {
    private final boolean[] set;

    // Constructor to initialize the set with given elements
    public IntSet(int[] elements) {
    	set = new boolean[1001];    // by default constructor to initialize  empty set  , Index 0 is unused, to keep it simple   
    	for (int element : elements) {
            if (element >= 1 && element <= 1000) {
                set[element] = true;
            }
        }
    }
    
    /**
     * To check if x is a member of  set
     * @param x number to check in set
     * @return boolean true if member of set else false
     */
    public boolean isMember(int x) {
        return (x >= 1 && x <= 1000) && set[x];
    }

     
    /**
     * To find the size of the set
     * @return size of set
     */
    public int size() {
        int count = 0;
        for (boolean b : set) {
            if (b) count++;
        }
        return count;
    }
    

    /**
     * To check whether s is a subset of the set
     * @param inputSet to check is subset or not 
     * @return boolean , true if subset else false
     */
    public boolean isSubSet(IntSet inputSet) {
        for (int i = 1; i <= 1000; i++) {
            if (inputSet.isMember(i) && !this.isMember(i)) {
                return false; // Found an element in s that is not in this set
            }
        }
        return true; // All elements of s are in this set
    }
    

    /**
     * To return the complement set
     * @return complement set
     */
    public IntSet getComplement() {
        int[] complementElements = new int[1000 - this.size()];
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!isMember(i)) {
                complementElements[index++] = i; // Add non-member elements to complement
            }
        }
        return new IntSet(complementElements); // Return new IntSet with only valid elements
    }
    
    
    /**
     * To find the union set , Set of members that belong to the first set "or" the second set 
     * @param inputSet input to find union
     * @return union of both sets
     */
    public IntSet union(IntSet inputSet) {
        int[] unionElements = new int[this.size() + inputSet.size()];
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (this.isMember(i) || inputSet.isMember(i)) {
                unionElements[index++] = i;
            }
        }
        return new IntSet(unionElements);
    }
    
     
    /**
     * To find the intersection set , Set of members that belong to both the first set "and" second set
     * @param inputSet input to find intersection
     * @return intersection of both sets
     */
    public IntSet intersection(IntSet inputSet) {
        int[] intersectionElements = new int[Math.min(this.size(), inputSet.size())];
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (this.isMember(i) && inputSet.isMember(i)) {
                intersectionElements[index++] = i;
            }
        }
        return new IntSet(intersectionElements);
    }
    
    
    /**
     * To find the difference set , Set of members that belong to the first set "and not" the second set
     * @param inputSet
     * @return difference set
     */
    public IntSet difference(IntSet inputSet) {
        int[] differenceElements = new int[this.size()];
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (this.isMember(i) && !inputSet.isMember(i)) {
                differenceElements[index++] = i;
            }
        }
        return new IntSet(differenceElements);
    }
    
     
    /**
     * To find the complement of s with respect to this set 
     * @param inputSet whose complement needs to be find 
     * @return complement set wrt this set
     */
    public IntSet complement(IntSet inputSet) {
        int[] complementElements = new int[inputSet.size()];
        int index = 0;
        for (int i = 1; i <= 1000; i++) {
            if (inputSet.isMember(i) && !this.isMember(i)) {
                complementElements[index++] = i;
            }
        }
        return new IntSet(complementElements);
    }
      
	
}
