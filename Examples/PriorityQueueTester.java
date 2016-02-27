package day16binaryheaps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PriorityQueueTester {

	public static void main(String[] args) {
		Random rand = new Random(1);
		ArrayList<Integer> orig = new ArrayList<Integer>();
		ArrayList<Integer> out = new ArrayList<Integer>();

		
		int size = 10;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < size; i++) {
			Integer val = rand.nextInt(size*2);
			
			// Add random int to orig (control list) and to q.
			orig.add(val);
			q.enqueue(val);
		}
		System.out.println("Orig list unsorted" + orig);
		System.out.println("enqueued list in q" + Arrays.toString(q.container));
		// empty out q by dequeueing, and store in out.
		while (!q.isEmpty()) {
			out.add(q.dequeue());  
		}
		System.out.println("Orig list unsorted" + orig);
		System.out.println("out list " + out);
		Collections.sort(orig);
		System.out.println(out.equals(orig) ? "PASS": "FAIL");
		


		CritterList[][] occupants = new CritterList[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j< 10; j++) {
				occupants[i][j] =  new CritterList();
			}
		}
		occupants[0][0].crits.add(5);
		occupants[0][0].crits.add(7);
		occupants[0][1].crits.add(9);
		System.out.println(Arrays.toString(occupants[0]));
	}	

	private static class CritterList {
		public ArrayList<Integer> crits;

		public CritterList () {
			crits = new ArrayList<Integer>();
		}

		public String toString() {
			return crits.toString();
		}
	}
}

