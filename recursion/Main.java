package recursion;

public class Main {

	public static void main(String[] args) {
		
		Main recursion = new Main();
		var rec = recursion.factorial(3);
		System.out.println(rec);
		
		var rec1 = recursion.fibonacci(4);
		System.out.println(rec1);
		
		var rec2 = recursion.sumofDigits(154);
		System.out.println(rec2);
		
		var rec3 = recursion.power(2, 2);
		System.out.println(rec3);
		
		var rec4 = recursion.gcd(48, 18);
		System.out.println(rec4);
		
		var rec5 = recursion.decimalToBinary(10);
		System.out.println(rec5);

	}
	// factorial 
	public int factorial(int n) {
		if (n<1) {
			return -1;
		}		
		if ( n==0 || n==1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	// fibonacci
	public int fibonacci(int n) {
		if(n<0) {
			return -1;
		}
		if(n==0 || n==1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	// sum of digits
	public int sumofDigits(int n) {
		if(n==0 || n < 0) {
			return 0;
		}
		return n%10 + sumofDigits(n/10);
	}
	// power of numbers
	public int power(int base, int exp) {
		if (exp < 0) {
			return -1;
		}
		if (exp == 0) {
			return 1;
		}
		return base * power(base, exp-1);
	}

	// Gcd Eucledian method
	public int gcd(int a, int b) {
		if ( a < 0 || b < 0) {
			return -1;
		}
		if (b==0) {
			return a;
		}
		return gcd(b, a%b);
	}
	// decimal to binary
	public int decimalToBinary(int n) {
		if (n==0) {
			return 0;
		}
		return n%2 + 10 * decimalToBinary(n/2);
	}
}
