package day17trees;

import java.util.Iterator;

public class BSearchTree<E extends Comparable<E>> implements Iterable<E> {
	
	BSTNode<E> overallRoot;
	static int SPACES_PER_LEVEL = 4;
	int size;
	
	public BSearchTree () {
		this.overallRoot = null;
		size = 0;
	}

	public void add(E value) {
		overallRoot = add(overallRoot, value);
		size++;
	}
	
	private BSTNode<E> add (BSTNode<E> root, E value) {
		if (root == null) {
			root = new BSTNode<E>(value, null, null);
		} else if (root.data.compareTo(value) >= 0) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
		}
		return root;
	}
	
	public void remove (E value) {
		overallRoot = remove(overallRoot, value);
		size--;
	}

	private BSTNode<E> remove(BSTNode<E> root, E value) {

		if (root != null) {
			if (root.data.equals(value)) {
				if (root.isLeaf()) 
					root = null;
				else if (root.left == null) 
					root = root.right;
				else if (root.right == null)
					root = root.left;
				else {	// If node has 2 branches
					BSTNode<E> smallest = findSmallest(root.right);
					root.data = smallest.data;
					root.right = remove(root.right, smallest.data);
				}
			} else {
				if (root.data.compareTo(value) >= 0) 
					root.left = remove(root.left, value);
				else 
					root.right = remove(root.right, value);
			}
		}			
		return root;
	}
	
	public void print () {
		print(overallRoot, 0);
	}

	private void print(BSTNode<E> root, int level ) {
		if (root == null) return;
		if (root.isLeaf()) {
			for (int i = 0; i < level*SPACES_PER_LEVEL; i++) {
				System.out.print(" ");
			}
			System.out.println(root);
		} else {
			print(root.right, level + 1);
			for (int i = 0; i < level*SPACES_PER_LEVEL; i++) {
				System.out.print(" ");
			}
			System.out.println(root);
			print(root.left, level + 1);
		}
	}
	
	public BSTNode<E> findSmallest() {
		return findSmallest(overallRoot);
	}
	
	BSTNode<E> findSmallest(BSTNode<E> root) {
		if (root == null)
			return root;
		if (root.left == null) 
			return root;
		else 
			return findSmallest(root.left);
	}

	@Override
	public Iterator<E> iterator() {
		return new BSTIterator<E>(this);
	}
		
/*	List<E> sort() {	
		List<E> sorted = new LinkedList<E>();
		addToList(overallRoot, sorted);	
		return sorted;
	}
	
	void addToList(BSTNode<E> root, List<E> sortedList) {
		if (root == null) 
			return;
		else {
			addToList(root.left, sortedList);
			sortedList.add(root.data);
			addToList(root.right, sortedList);
		}		
	}
*/	
	void clear() {
		overallRoot = null;
		size = 0;
	}
	
	E[] sort() {
		@SuppressWarnings("unchecked")
		E[] sorted = (E[]) (new Comparable[size]);
		addToArray(overallRoot, sorted, 0);		
		return sorted;
	}

	private int addToArray(BSTNode<E> root, E[] sorted, int indexToAdd) {
		if (root == null) 
			return indexToAdd;
		else {
			indexToAdd = addToArray(root.left, sorted, indexToAdd);
			sorted[indexToAdd] = root.data;
			indexToAdd++;
			indexToAdd = addToArray(root.right, sorted, indexToAdd);
		}
		return indexToAdd;
	}	
}
