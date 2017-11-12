/* 
 https://leetcode.com/problems/compare-version-numbers/description/
  
 */
package jz.Lintcode;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {

		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int i = 0;
		int j = 0;
		while (i < v1.length && j < v2.length) {
			int tmp1 = Integer.parseInt(v1[i]);
			int tmp2 = Integer.parseInt(v2[j]);
			if (tmp1 > tmp2) {
				return 1;
			} else if (tmp1 == tmp2) {
				i++;
				j++;
			} else {
				return -1;
			}
		}

		while (i < v1.length) {
			if (Integer.parseInt(v1[i]) > 0) {
				return 1;
			}
			i++;
		}
		while (j < v2.length) {
			if (Integer.parseInt(v2[j]) > 0) {
				return -1;
			}
			j++;
		}

		return 0;

	}
}
