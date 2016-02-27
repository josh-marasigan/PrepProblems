package day17trees;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTreeTester {

	public static void main(String[] args) {

		BSearchTree<Integer> intTree = new BSearchTree<Integer>();
		
		intTree.add(4);
		intTree.add(3);
		intTree.add(6);
		intTree.add(1);
		intTree.add(7);
		intTree.add(5);
		intTree.print();
		System.out.println("-------remove 7 below -------------------");
		intTree.remove(7);
		intTree.print();
		System.out.println("-------remove 3 below -------------------");
		intTree.remove(3);
		intTree.print();
		System.out.println("-----------------------------------------");
		intTree = new BSearchTree<Integer>();
		
		intTree.add(4);
		intTree.add(3);
		intTree.add(6);
		intTree.add(1);
		intTree.add(7);
		intTree.add(5);
		intTree.print();
		System.out.println("-----------------------------------------");
		System.out.println(intTree.findSmallest());
		System.out.println("--------------remove 6--------------------");
		intTree.remove(6);
		intTree.print();
		System.out.println("--------------remove 4-------------------");
		intTree.remove(4);
		intTree.print();
		System.out.println(Arrays.toString(intTree.sort()));

		intTree.clear();
		List<Integer> numbers = new LinkedList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		while (!numbers.isEmpty()) {
			intTree.add(numbers.remove(0));
		}
		//System.out.println(intTree.sort());
		System.out.println(Arrays.toString(intTree.sort()));
		
		Iterator<Integer> it = intTree.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}
}
