package com.neeraj.codingproblems;

public class LongestRepeatedSubString {

	
	public static void main(String[] args) throws Exception {
	    String longest = longestDuplicate("ababcaabcabcaab");
	    System.out.println(longest);
	}

	public static String longestDuplicate(String text) {
	    String longest = "";
	    for (int i = 0; i < text.length() - 2 * longest.length() * 2; i++) {
	        OUTER:
	        for (int j = longest.length() + 1; j * 2 < text.length() - i; j++) {
	            String find = text.substring(i, i + j);
	            for (int k = i + j; k <= text.length() - j; k++) {
	                if (text.substring(k, k + j).equals(find)) {
	                    longest = find;
	                    continue OUTER;
	                }
	            }
	            break;
	        }
	    }
	    return longest;
	}
	
}
