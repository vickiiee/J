package fractions;

public class Fraction {
	private int numerator;
	private int denominator;

	// TODO write default constructor
	public Fraction() {
		numerator = 1;
		denominator = 1;
	}

	// TODO write constructor for fraction n/d where n, d > 0
	public Fraction(int n, int d) {
		if (n <= 0) { // n is negative
			numerator = 1;
		} else { // n is positive
			numerator = n;
		}

		if (d <= 0) { // n is negative
			denominator = 1;
		} else { // n is positive
			denominator = d;
		}
	}

	// TODO write method to return fraction as a String
	public String toString() {
		return numerator + "/" + denominator;
	}

	// TODO write method to return fraction as a mixed number String
	public String mixedNumber() {
		if (numerator > denominator) { // mixed number
			int integer = numerator / denominator;
			int num = numerator % denominator;

			if (num == 0) {
				return "" + integer;
			} else {
				return integer + " " + num + "/" + denominator;
			}
		} else if (numerator == denominator) {
			return "1";
		} else {
			return numerator + "/" + denominator;
		}
	}

	// TODO write method to add fraction n/d to this Fraction
	public void add(int n, int d) {
		if(n < 0 || d <0) {
			//do nothing to denominator & denominator
		}else {
			numerator = numerator*d + n*denominator;
			denominator = denominator*d;
		}
	}
}