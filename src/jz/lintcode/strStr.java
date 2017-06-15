/*
 http://www.lintcode.com/en/problem/strstr/
  
 */
package jz.lintcode;

public class strStr {

	public static void main(String[] args) {
		String source = "abcdef";
		String target = "cde";
		System.out.println(strStr(source,target));

	}
    
	//Version 1
	public static int strStr(String source, String target) {
		if(source == null || target == null || source.length() < target.length()){
			return -1;
		}
		
		int l_t = target.length();
		
		for(int i = 0 ; i < source.length()  - l_t + 1; i++){ // i位置固定, i < source.length - target.length + 1;
			int j = 0;
			for (j = 0; j < l_t; j++) {
				if (source.charAt(i + j) == target.charAt(j)) {
					continue;
				} else {
					break;
				}
			}
			
			if (j == l_t) {
				return i  ;
			}
		}

		return -1;
	}
}
