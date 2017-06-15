/*
 http://www.lintcode.com/en/problem/strstr-ii/
 */
package jz.lintcode;

public class strStrII {

	public static void main(String[] args) {
		String source = "abcdef";
		String target = "cde";
		System.out.println(strStr2(source,target));

	}
	
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public static int strStr2(String source, String target) {
    	if(source == null || target == null || source.length() < target.length() ){
    		return -1;
    	}
    	
    	int m = target.length();
    	long BASE = Integer.MAX_VALUE / 31;

    	long target_code = 0 ;
    	for(int i = 0 ; i < m ; i++){
    		target_code = (target_code * 31 + target.charAt(i)) % BASE ;
    	}
    	
    	long power = 1 ; //power = 1 NOT power = 0;
    	for(int i = 0 ; i < m; i++){
    		power = (power * 31) % BASE;
    	}
    		
    		
    	long source_code = 0 ;
    	for(int i = 0 ; i < source.length(); i++){
    		source_code = (source_code * 31 + source.charAt(i)) % BASE;
    		if(i < m - 1){
    			continue;
    		}
    		else if( i >= m){
    			source_code = source_code - source.charAt(i - m) * power;
    			if(source_code < 0){
    				source_code += BASE;
    			}
    		}
    		
    		if(target_code == source_code){
    			if(source.substring(i - m + 1, i + 1).equals(target)){
    				//subString(left, right) , left inclusive, right exclusive 
    				return i - m + 1;
    			}
    		}
    		
    	}
    	
    	return -1;
    }

}
