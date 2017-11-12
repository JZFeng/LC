package jz.Lintcode;

public class IsPrimeNumber {

	public static void main(String[] args) {

	}

	// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
	// 71, 73, 79, 83, 89, 97,
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}

		for (int i = 3; i * i <= n; i = i + 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

}
