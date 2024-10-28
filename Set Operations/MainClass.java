package com.metacube;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Size of first Array : ");
		int sizeOfFirstArray = scanner.nextInt();
			
		if (sizeOfFirstArray <= 0) {
			System.out.println("Size of Array must be greater than 0.");
		}
			
		int[] firstArray =new int[sizeOfFirstArray];
			
		for ( int i=0; i<sizeOfFirstArray; i++ ) {
			System.out.print("Enter " + (i+1) + " element of array : ");
			firstArray[i]= scanner.nextInt();
		}
			
		System.out.print("Enter Size of second Array : ");
		int sizeOfSecondArray = scanner.nextInt();
			
		if (sizeOfSecondArray <= 0) {
			System.out.println("Size of Array must be greater than 0.");
		}
			
		int[] secondArray =new int[sizeOfSecondArray];
			
		for ( int i=0; i<sizeOfSecondArray; i++ ) {
			System.out.print("Enter " + (i+1) + " element of array : ");
			secondArray[i]= scanner.nextInt();
		}
			
	    // Create two sets A and B
	    IntSet firstSet = new IntSet(firstArray);
	    IntSet secondSet = new IntSet(secondArray);
			
		System.out.println("First Array : ");
		printSet(firstSet);
		
		System.out.println("Second Array : ");
		printSet(secondSet);
		
		boolean continueProgram = true;
		
		while(continueProgram) {
			
		System.out.println("\n\n 1. Size of both sets. \n 2. Is Member? \n 3. Is Subset? \n 4. Get Complement of a set. \n 5. Union of both sets. \n 6. Intersection of both sets. \n 7. Difference of both sets. \n 8. Complement wrt to other set.");
		System.out.print("Enter a choice : ");
		int choice = scanner.nextInt();
		
		
		switch (choice) {
		
		case 1: 
			// Display the size of sets A and B
			System.out.println("Size of First Set: " + firstSet.size());
			System.out.println("Size of Second Set: " + secondSet.size());
			break;
			
		case 2:
			//To check member of set or not 
			System.out.println("Enter element to find member in both array : ");
			int elementToFindMember = scanner.nextInt();
			System.out.println("Is" + elementToFindMember +" a member of First Set? " + firstSet.isMember(elementToFindMember));
			System.out.println("Is" + elementToFindMember +" a member of Second Set? " + secondSet.isMember(elementToFindMember));
			break;
			
		case 3:
			//To find size of subset
			System.out.print("Enter Size of subset to check : ");
			int sizeOfSubsetToCheck = scanner.nextInt();
				
			int[] subsetArray =new int[sizeOfSubsetToCheck];
				
			for ( int i=0; i<sizeOfSubsetToCheck; i++ ) {
				System.out.print("Enter " + (i+1) + " element of subset array : ");
				subsetArray[i]= scanner.nextInt();
			}
				
		    IntSet subsetToCheck = new IntSet(subsetArray);
		    System.out.println("Is this subset of First set? " + firstSet.isSubSet(subsetToCheck));
		    System.out.println("Is this subset of Second set? " + secondSet.isSubSet(subsetToCheck));
		    break;
		    
		case 4: 
			// Perform complement of A with respect to the universal set
			IntSet firstComplementSet = firstSet.getComplement();
			System.out.print("Complement of First Set: ");
			printSet(firstComplementSet);
			IntSet secondComplementSet = secondSet.getComplement();
			System.out.print("Complement of Second Set: ");
			printSet(secondComplementSet);
			break;
			
		case 5 :
			// Perform union of First and Second Set
			IntSet unionSet = firstSet.union(secondSet);
			System.out.print("Union of First and Second Set: ");
			printSet(unionSet);
			break;
			
		case 6:
			// Perform intersection of First and Second Set
			IntSet intersectionSet = firstSet.intersection(secondSet);
			System.out.print("Intersection of First and Second Set: ");
			printSet(intersectionSet);
			break;
			
		case 7:
			// Perform difference of First and Second Set
			IntSet differenceSet = firstSet.difference(secondSet);
			System.out.print("Difference of First and Second Set: ");
			printSet(differenceSet);
			break;
			
		case 8:
			// Perform complement of A with respect to the universal set
			IntSet firstComplementSetWrtSecondSet = firstSet.complement(secondSet);
			System.out.print("Complement of First Set wrt Second Set: ");
			printSet(firstComplementSetWrtSecondSet);
			IntSet secondComplementSetWrtFirstSet = secondSet.complement(firstSet);
			System.out.print("Complement of Second Set wrt First Set: ");
			printSet(secondComplementSetWrtFirstSet);
			break;
			
			
			
			
		default:
			System.out.println("Please enter valid input.");
		}
		
		// Ask user if they want to continue or exit
        System.out.println("\nDo you want to continue? (yes/no)");
        String userResponse = scanner.next();
        if (userResponse.equalsIgnoreCase("no")) {
        	scanner.close();
            continueProgram = false;
        }
        
		}
	}
	
    	// Helper method to print the elements of a set
    	private static void printSet(IntSet s) {
    		for (int i = 1; i <= 1000; i++) {
    			if (s.isMember(i)) {
    				System.out.print(i + " ");
    			}
    		}
    		System.out.println();
    	}

}
