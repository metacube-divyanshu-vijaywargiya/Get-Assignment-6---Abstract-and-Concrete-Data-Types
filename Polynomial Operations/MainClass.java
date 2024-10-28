package com.metacube;


import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Creating the first polynomial
        System.out.print("Enter the degree of the first polynomial : ");
        int degree1 = scanner.nextInt();
        int[] coefficients1 = new int[degree1 + 1];
        System.out.println("Enter coefficients for first polynomial :");
        for (int i = 0; i <= degree1; i++) {
            System.out.print("Coefficient for x^" + i + ": ");
            coefficients1[i] = scanner.nextInt();
        }
        Poly poly1 = new Poly(coefficients1);

        // Creating the second polynomial
        System.out.print("\nEnter the degree of the second polynomial : ");
        int degree2 = scanner.nextInt();
        int[] coefficients2 = new int[degree2 + 1];
        System.out.println("Enter coefficients for second polynomial :");
        for (int i = 0; i <= degree2; i++) {
            System.out.print("Coefficient for x^" + i + ": ");
            coefficients2[i] = scanner.nextInt();
        }
        Poly poly2 = new Poly(coefficients2);
        
        // Display polynomials degree
        System.out.println("\nFirst Polynomial Degree: " + poly1.degree());
        System.out.println("Second Polynomial Degree: " + poly2.degree());

        // addition of 2 polynomials and display answer multiplication of polynomials
        Poly sumPoly = Poly.addPoly(poly1, poly2);
        System.out.println("Sum of Polynomials Degree: " + sumPoly.degree());
        System.out.println("Sum polynomial: ");
        StringBuilder sumPolynomialString = new StringBuilder();

        for (int i = sumPoly.coefficients.length - 1; i >= 0; i--) {
            if (sumPoly.coefficients[i] != 0) {
                if (sumPolynomialString.length() > 0) {
                    sumPolynomialString.append(" + ");
                }
                
                sumPolynomialString.append(sumPoly.coefficients[i]);
                
                if(i>0) {                	
                	sumPolynomialString.append("x^").append(i);
                }
            }
        }
        System.out.println(sumPolynomialString.toString());
        
        
        // multiplication of 2 polynomials and display answer multiplication of polynomials
        Poly productPoly = Poly.multiplyPoly(poly1, poly2);
        System.out.println("Product of Polynomials Degree: " + productPoly.degree());
        System.out.println("Multiply polynomial: ");
        StringBuilder multiplyPolynomialString = new StringBuilder();

        for (int i = productPoly.coefficients.length - 1; i >= 0; i--) {
            if (productPoly.coefficients[i] != 0) {
                if (multiplyPolynomialString.length() > 0) {
                	multiplyPolynomialString.append(" + ");
                }
                
                multiplyPolynomialString.append(productPoly.coefficients[i]);
               
                if(i>0) {                	
                	multiplyPolynomialString.append("x^").append(i);
                }
            }
        }
        System.out.println(multiplyPolynomialString.toString());

        // Evaluate polynomial1 at a given value of x
        System.out.print("\nEnter value x to evaluate first polynomial: ");
        float x = scanner.nextFloat();
        System.out.println("First Polynomial evaluated at x = " + x + ": " + poly1.evaluate(x));

        // Evaluate polynomial2 at a given value of x
        System.out.print("\nEnter value x to evaluate second polynomial: ");
        x = scanner.nextFloat();
        System.out.println("Second Polynomial evaluated at x = " + x + ": " + poly2.evaluate(x));

        scanner.close();
    }
}


