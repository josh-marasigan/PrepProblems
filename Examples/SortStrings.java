package Examples;

import java.util.Arrays;

public class SortStrings {
	
	public static boolean isPermutation(String s, String t) {
		
		// Special Case: Strings are unequal = Not a permutation since there are
		// an excess of elements
		if (s.length() != t.length()) {
			return false;
		}
		
		// First sort the strings and place in a character array, then compare.
		// Permutations are just rearrangements of character values within the string set.
		char[] s1 = s.toCharArray();
		char[] s2 = t.toCharArray();
		
		// Sort with the native Array quicksort method. O(nlog(n))?
		Arrays.sort(s1);
		Arrays.sort(s2);
				
		if(Arrays.equals(s1, s2)) {
			return true;
		}
		// They are not equal, therefore, s2 is not a permutation of s1
		return false;
		
	}
	
	/* Replace all spaces with '%20' given a fixed final string length */
	public static void replaceSpaces(char[] str, int len) {
		
		// len in this case is the length of the string without the appended buffer.
		
		// 1. Scan to find the number of spaces. Then triple that number
		// in order to track and prevent writing a longer string than anticipated.
		int numSpaces = 0;
		for(int i = 0; i < len; i++) {
			if(str[i] == ' ') {
				numSpaces++;
			}
		}
		
		// 2. Replace all the ' ' characters in original string with %20
		// This will fit perfectly with the final character count.
		
		// We start from the end of the array to avoid overwriting. (Which would occur
		// if we started from the front of the string)
		
		// Case: if the string has fewer spaces within but greater buffer in the end.
		// This is JUST for indexing purposes for the original char array,
		// the FINAL array will be indexed in descending order by 'trueLength'
		if(str.length > len) {
			str[len] = '\0';
		}
		
		int trueLength = len + numSpaces*2;
		// For every space character, we must allocate 3 characters. (' ' -> '%20')
		for (int n = len - 1; n >= 0; --n) {
			// Case: Replace space with '%20'
			if(str[n] == ' ') {
				str[trueLength - 1] = '0';
				str[trueLength - 2] = '2';
				str[trueLength - 3] = '%';
				
				// Account that we just used 3 indexes.
				trueLength -= 3;
			}
			else {
				str[trueLength - 1] = str[n];
				
				// Keep descending. We're basically having two index for the same String.
				trueLength--;
			}
		}
	}
	
	public static boolean checkIfPalindromePermutation(String str) {
		
		// We will utilize the fact that a palindrome is just a series of characters that
		// is the same forwards and backwards. This means that in the middle can be two back
		// to back characters (String has even num characters)
		
		// 1. Place all the characters in a Hash Table. (26 letters in alphabet)
		int[] alphabetTable = new int[26];
		
		// Hash all characters into Table to see number count for each character
		for(char temp : str.toCharArray()) {
			// Case: not a char, ignore
			if((Character.getNumericValue(temp) < Character.getNumericValue('a'))
					|| (Character.getNumericValue(temp) > Character.getNumericValue('z'))) 
			{
				continue;
			}
			// Increment count for that specific character
			alphabetTable[Character.getNumericValue(temp) - Character.getNumericValue('a')]++;
		}
		
		// Iterate through hash to see if there is more than one odd number
		int oddCount = 0;
		for(int count : alphabetTable) {
			
			// If odd
			if(count % 2 == 1) {
				oddCount++;
			}
			
		}
		
		if (oddCount > 1) {
			return false;
		}
		return true;
		
	}
	
	public static boolean ifOneEdit(String str1, String str2) {
		
		// Compare string lengths to indicate they are within plausable range.
		int len_1 = str1.length();
		int len_2 = str2.length();
		
		// If theres a one letter changed:		apple -> epple
		if (len_1 == len_2) {
			return ifOneLetterChange(str1, str2);
		}
		// If theres a one letter insertion/deletion:	apple -> apples, apple -> aple
		else if((len_1 + 1 == len_2) || (len_1 == len_2 + 1)) {
			return ifOneLetterDifference(str1, str2);
		}
		// Case: Varies by more than one letter, cannot be a valid edit.
		else {
			return false;
		}
			
	}
	
	// Helper methods
	private static boolean ifOneLetterChange(String s1, String s2) {
		// Check to see if there's more than a one letter difference
		int numChanges = 0; // Count of different letters
		
		for(int n = 0; n < s1.length(); n++) {
			if(s1.charAt(n) != s2.charAt(n)) {
				numChanges++;
			}
			// Case: Theres more than a one letter difference
			if(numChanges > 1) {
				return false;
			}
		}
		
		// Only one change found. Also accounts for zero edits.
		return true;
		
	}
	
	private static boolean ifOneLetterDifference(String s1, String s2) {
		
		// Check to see which one is the longer one
		String longer = s1.length() > s2.length() ? s1 : s2;
		String shorter = s1.length() > s2.length() ? s2 : s1;
		
		// Iterate through the short string to see where the variance starts.
		// (Increment long index when found to even strings)
		// A Counter for the number of variances
		int changeCount = 0;
		int long_n = 0;
		for(int n = 0; n < shorter.length(); n++, long_n++) {
			
			// There is a variance, but it could be the only one. (Insert or Delete)
			if(longer.charAt(long_n) != shorter.charAt(n)) {
				// Even out the strings. From now on there should not be any difference.
				long_n++;
				changeCount++;
				
				// Check if the new shift is also equal.
				if(longer.charAt(long_n) != shorter.charAt(n)) {
					return false;
				}
				
			}
			
			// Theres more than one change count, then return false.
			if(changeCount>1) {
				return false;
			}
			
		}
		
		// Passes through the iteration with only one change.
		return true;
		
	}
	
}
