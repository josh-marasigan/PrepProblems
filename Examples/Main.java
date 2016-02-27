
package Examples;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		// Test bit counter
		/* System.out.println(findNumBitsToChangeInts(0,15));
		System.out.println(isUniqueCharacters("abcdefff"));
		String str = new String("Space Twenty Ayyy    ");
		char[] strC = str.toCharArray();
		twenty(strC, 16);
		System.out.println(strC);
		
		System.out.println(indexer("AB"));
		*/
		if(SortStrings.isPermutation("abcdefg3322", "ba2d3c3egf2")) {
			System.out.println("Is Permutation");
		} // Should print true
		else {
			System.out.println("Not Permutation");
		}
		
		// Before
		System.out.println("This is a space problem.");
		char[] param = new String("Mr John Smith    ").toCharArray();
		System.out.println(param);
		// After
		SortStrings.replaceSpaces(param , 13);
		System.out.println(param);
		
		System.out.println("raecrac == racecar");
		System.out.println(SortStrings.checkIfPalindromePermutation("raecrac"));
		
		System.out.println(SortStrings.ifOneEdit("geographical", "geographica") + " -> true");
		System.out.println(SortStrings.ifOneEdit("pales", "pale") + " -> true");
		System.out.println(SortStrings.ifOneEdit("pale", "bale") + " -> true");
		System.out.println(SortStrings.ifOneEdit("pale", "bae") + " -> false");
		
		int[] arr = {0, 1, 5, 100, 2, 2000, 1, 11, 30, 2};
		System.out.println(StockExample.maxLoss(arr));
	}
	
	public static int indexer(String in){
		int indeces = 0;
		int m = 0;
		// The first most digit has the most power
		for(int n = in.length()-1; n>=0 ; ++n){
			// Index starts at 1
			int current_ind = in.charAt(n) - ('A'-1);
			indeces += current_ind*(Math.pow(26, m));
			m++;
		}
		return indeces;
	}
	
	public static void twenty(char[] str, int length){
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = length + spaceCount * 2;
		str[index] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	
	public static boolean isUniqueCharacters(String str) {
		
		/* If a string has 256+ characters. It MUST have duplicates 
		 * because a character can only hold up to 256 in Java */
		if(str.length()>=256) {
			return false;
		}
		
		int check_bits = 0;
		int bool_digit=0;
		for(int n = 0; n < str.length(); n++) {
			// Firstly we will convert the current character
			// to an integer value (ie. a=0, z=25)
			int current_bit = str.charAt(n) - 'a';
			bool_digit = (1<<current_bit)&(check_bits);
			if(bool_digit>0){
				return false;
			}
			
			// Indicate that a character has been found
			check_bits |= (1<<current_bit);
		}
		
		// Know that there are all unique char
		return true;
		
	}
	
	public static int findNumBitsToChangeInts(int x, int y){
		// First we need to establish an "array" of bits (through int)
		// which contains all the different bits between integers
		
		// We can do this through an XOR gate
		int z = x^y;
		
		// Now we must count these unique bits.
		int count = 0;
		while(!(z==0)) {
			if((z&1)==1){
				++count;
				z=(z>>>1);
			}
			else{
				// We will use the unsigned right shift in order
				// to account for negative integers as well
				z=(z>>>1);
			}
		}
		return count;
	}
}







