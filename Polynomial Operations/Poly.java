package com.metacube;

public class Poly {
	public int[] coefficients;
	
	/**
	 * Constructor that will accepts array of coefficients
	 * @param coefficients array of coefficients to make a polynomial
	 */
	public Poly(int [] coefficients) {
		this.coefficients = new int[coefficients.length];
		System.arraycopy(coefficients, 0, this.coefficients, 0, coefficients.length);
	}
	
	
	/**
	 * To evaluate polynomial for value of x
	 * @param x float value which we will put at the place of x in polynomial
	 * @return float after putting x we will evaluate value of polynomial and return it
	 */
	public float evaluate(float x) {
		float result = 0;
		float xPower = 1;
		for(int coeff : coefficients) {
			result += coeff*xPower;
			xPower *= x;
		}
		
		return result;
	}
	
	/**
	 * To find degree of polynomial
	 * @return integer return the degree of polynomial
	 */
	public int degree() {
		for(int i= coefficients.length-1; i>=0;i-- ) {
			if(coefficients[i] != 0) {
				return i;
			}
		}
		
		return 0;
	}
	
	/**
	 * To add 2 polynomials 
	 * @param polynomial1 polynomial to add with polynomial2
	 * @param polynomial2 polynomial to add with polynomial1
	 * @return Poly it returns polynomial with the sum of coefficients of poly1 and poly2
	 */
	public static Poly addPoly(Poly polynomial1, Poly polynomial2) {
		int maxDegree = Math.max(polynomial1.coefficients.length, polynomial2.coefficients.length);
		int[] resultCoefficients = new int[maxDegree];
		
		for(int i=0;i<maxDegree;i++) {
			int coeff1 = (i < polynomial1.coefficients.length) ? polynomial1.coefficients[i] : 0;
			int coeff2 = (i < polynomial2.coefficients.length) ? polynomial2.coefficients[i] : 0;
			resultCoefficients[i] = coeff1 + coeff2;
		}
		
		return new Poly(resultCoefficients);
	}
	
	/**
	 * 
	 * @param polynomial1 polynomial to multiply with polynomial2
	 * @param polynomial2 polynomial to multiply with polynomial1
	 * @return Poly it returns polynomial with the multiply of coefficients of poly1 and poly2
	 */
	public static Poly multiplyPoly(Poly polynomial1, Poly polynomial2) {
		int resultDegree = polynomial1.coefficients.length + polynomial2.coefficients.length - 1;
		int[] resultCoefficients = new int[resultDegree];
		
		for (int i=0;i< polynomial1.coefficients.length; i++) {
			for (int j=0; j<polynomial2.coefficients.length; j++) {
				resultCoefficients[i+j] += polynomial1.coefficients[i]*polynomial2.coefficients[j];
			}	
		}
		return new Poly(resultCoefficients);
	}
}
