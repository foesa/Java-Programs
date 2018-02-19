
public class Rational {
	float rationalValue;
	int numerator;
	int denominator;
	public Rational(int topNumber, int bottomNumber) {
		int numerator = topNumber;
		int denominator = bottomNumber;
	}
	public Rational(int topNumber) {
		this(topNumber,1);
	}
	public Rational add(Rational rationaltwo) {
		 int numerator = (rationaltwo.denominator*this.numerator + this.denominator*rationaltwo.numerator);
		 int denominator = (this.denominator*rationaltwo.denominator);
		 Rational newRational = new Rational(numerator, denominator);
		 return newRational;
	}
	public Rational subtract(Rational rationaltwo) {
		int numerator = (rationaltwo.denominator*this.numerator - this.denominator*rationaltwo.numerator);
		int denominator = (this.denominator*rationaltwo.denominator);
		Rational newRational = new Rational(numerator,denominator);
		return newRational;
	}
	public Rational multiply(Rational rationaltwo) {
		int numerator = this.numerator*rationaltwo.numerator;
		int denominator = this.denominator*rationaltwo.denominator;
		Rational newRational = new Rational(numerator,denominator);
		return newRational;
	}
}
