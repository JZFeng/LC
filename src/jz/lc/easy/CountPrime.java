/*
https://leetcode.com/problems/count-primes/#/description

204. Count Primes

Description:

Count the number of prime numbers less than a non-negative number, n.

 */
package jz.lc.easy;

import jz.Util;

public class CountPrime {

	public static void main(String[] args) {
		System.out.println("\r\n" + countPrimes(100));

	}

	// from 1 to n, n exclusive;埃拉托斯特尼筛法Sieve of Eratosthenes
	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;

		boolean[] notPrime = new boolean[n]; // numbers from 0 to n-1;
		notPrime[0] = true;
		notPrime[1] = true;

		for (int i = 2; i * i < n; i++) // 固定一端。
		{
			if (notPrime[i] == false) {
				for (int j = i; i * j < n; j++)
					notPrime[i * j] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < notPrime.length; i++) {
			if (notPrime[i] == false) {
				System.out.print(i + ", ");

				count++;
			}
		}

		return count;
	}

}
