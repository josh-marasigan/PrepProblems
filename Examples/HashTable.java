package day20hash;

import java.util.Arrays;

public class HashTable {
	int size = 16;
	HashEntry[] table;
	DeletedHashEntry deletedEntry;
	int noEntries;
	
	public HashTable () {
		table = new HashEntry[size];
		deletedEntry = new DeletedHashEntry();
		noEntries = 0;
	}
	
	private int calculateHashCode(Integer value) {
	    int mod = value.hashCode() % size;
	    return mod < 0 ? mod + size : mod;
	}

	private int findSlot(Integer value) {
		int initHashValue = calculateHashCode(value);
		boolean searchedAll = false;
		
		int i = initHashValue;
		while (table[i] != null && 
				(table[i] == deletedEntry || !table[i].data.equals(value)) && !searchedAll) {
					i = (i + 1) %size;
					searchedAll = i == initHashValue;
				}
		if (searchedAll)
			return -1;
		return i;
	}
	
	private int findPutSlot(Integer value) {
		// TODO
		return 0;
	}

	public Integer get(Integer value) {
		int index = findSlot(value);
		if (index < 0)
			return null;
		return table[index] == null ? null : table[index].data;
	}

	public void put(Integer value) {
		// TODO:
	}
	
	private void resize(int newSize) {
		
		size = newSize;
		
		HashEntry[] oldTable = table;
		table = new HashEntry[newSize];
		
		for (HashEntry e : oldTable) {
			if (e !=  null && e.getClass().equals((new HashEntry(null)).getClass())) {
				put(e.data);
			}
		}
	}
	
	public void remove(Integer value) {
		int index = findSlot(value);
		if (index >= 0 || table[index] != null) {
			table[index] = deletedEntry;
		}
		noEntries--;
	}
	
	public String toString () {
		return Arrays.toString(table);
	}
	
	void clear () {
		Arrays.fill(table, null);
	}
	
	static class HashEntry{
		Integer data;
		public HashEntry (Integer e) {
			data = e;
		}		
		
		public String toString  () {
			return data.toString();
		}
		
	}
	
	static class DeletedHashEntry extends HashEntry {
		public DeletedHashEntry () {
			super(null);
		}

		
		public String toString () {
			return "D";
		}
	}
}

