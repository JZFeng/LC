package jz.lc;

public class RemoveExcessiveWhiteSpace {

	public static void main(String[] args) {

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


}
