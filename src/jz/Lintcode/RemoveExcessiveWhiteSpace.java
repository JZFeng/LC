package jz.Lintcode;

public class RemoveExcessiveWhiteSpace {

	public static void main(String[] args) {
		String s = "abc  def   jhk   abcc";
		System.out.println(removeExcessiveWhiteSpace(s));
		System.out.println(removeExcessiveWhiteSpaceII(s));
		
	}
	
	public static String removeExcessiveWhiteSpace(String s) {
		s = s.trim();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (; i < s.length() - 1; i++) {
			if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ')
				continue;
			else
				sb.append(s.charAt(i));
		}
		sb.append(s.charAt(i));
		return sb.toString().trim();
	}
	
	public static String removeExcessiveWhiteSpaceII(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0 ;
		int j = 0 ;
		s = s.trim();
		while(j < s.length()) {
			while(j < s.length() && s.charAt(j) != ' ') {
				j++;
			}
			while(i < s.length() && s.charAt(i) == ' ' ) {
				i++;
			}
			if( i < j) {
				sb.append(s.substring(i, j));
				sb.append(" ");
				i = j;
				j = j + 1;
			} else {
				j++;
			}
		}
		return sb.toString();
	}

}
