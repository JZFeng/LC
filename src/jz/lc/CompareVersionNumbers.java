/* 
 https://leetcode.com/problems/compare-version-numbers/description/
  
 */
package jz.lc;

public class CompareVersionNumbers {

    // 1.1 < 2.0
    public int compareVersion(String v1, String v2) {
	String[] a1 = v1.split("\\."); //attention !! split("\\.") NOT split(".");
	String[] a2 = v2.split("\\.");
	int maxLength = Math.max(a1.length, a2.length); //attention !! a1.length NOT v1.length();

	for (int i = 0; i < maxLength; i++) {
	    int num1 = i < a1.length ? Integer.parseInt(a1[i]) : 0;
	    int num2 = i < a2.length ? Integer.parseInt(a2[i]) : 0;
	    if (num1 < num2) {
		return -1;
	    } else if (num1 > num2) {
		return 1;
	    }
	}

	return 0;
    }
}
