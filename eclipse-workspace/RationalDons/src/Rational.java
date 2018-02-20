
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
	public Rational divide(Rational rationaltwo) {
		int numerator = this.numerator*rationaltwo.denominator;
		int denominator = this.denominator*this.numerator;
		Rational newRational = new Rational(numerator,denominator);
		return newRational;
	}
	public boolean Equals(Rational rationaltwo) {
		int firstNumber = this.numerator*rationaltwo.denominator;
		int secondNumber = this.denominator*rationaltwo.numerator;
		if(firstNumber==secondNumber) {
			return true;
		}
		return false;
	}
	public boolean isLessThan(Rational rationaltwo) {
		int firstNumber = this.numerator*rationaltwo.denominator;
		int secondNumber = this.denominator*rationaltwo.numerator;
		if(secondNumber>firstNumber) {
			return true;
		}
		else {
			return false;
		}
	}
	public int GCD() {
		int gcd = 1;
		int divisor = 1;
		while ((divisor != -1) && (divisor < this.numerator))
		{
			if (this.numerator%divisor == 0)
			{
				gcd = divisor;
			}
			divisor = getNextDivisor( divisor, this.denominator );
		}
		return gcd;
	}
	public int getNextDivisor ( int lastDivisor, int number )
	{

		if ((lastDivisor > 0) && (lastDivisor < number) &&
				(number % lastDivisor == 0))
		{
			int divisor = lastDivisor;
			do {
				divisor++;
			} while ((divisor < number) && (number % divisor != 0));
			if (number % divisor == 0)
			{
				return divisor;
			}
		}
		return -1;
	}
	public Rational simplify() {
		int gcd = GCD();
		this.numerator = this.numerator/gcd;
		this.denominator = this.denominator/gcd;
		return this; 
	}
	public String toString() {
		String rationalnumber = this.numerator+"/"+this.denominator;
		return rationalnumber;
	}
}

