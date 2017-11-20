package jz.Lintcode;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}

		int[] f = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			f[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					int diff = i - coins[j];
					if (f[diff] != Integer.MAX_VALUE) {
						f[i] = Math.min(f[diff] + 1, f[i]);
					}
				}
			}
		}

		return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];

	}

}
