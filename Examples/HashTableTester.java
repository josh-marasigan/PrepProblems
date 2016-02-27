package day20hash;

public class HashTableTester {

	public static void main (String [] args) {
		HashTable table1 = new HashTable();
		checker(table1.size, 16, 1); // init size = 16
		// Add 3 distinct entries
		table1.put(1);
		table1.put(2);
		table1.put(10);
		System.out.println(table1); 
		
		// Collision at index 1
		table1.put(17);
		System.out.println(table1); // 17 should be at index 3
		checker(table1.noEntries, 4, 2);

		// Try to add repeated value.  Should not be added.
		table1.put(17);
		System.out.println(table1);
		checker(table1.noEntries, 4, 3);
		
		// Remove 2, get 17.
		table1.remove(2);
		System.out.println(table1);
		checker(table1.noEntries, 3, 4);
		checker(table1.get(17), 17, 5);

		
		
		// Fill up table beyond resize limit, and check for resize.  
		// New table size should be 32.
		table1.clear();
		System.out.println(table1);
		for (int i = 0; i <= 16*0.7 + 1; i++) {
			table1.put(i);
		}
		System.out.println(table1);
		
	}
	
	static void checker (int a, int b, int testNo) {
		System.out.println("Test " + testNo + (a == b ? " PASS" : " FAIL"));
	}
}
