package Examples;

import java.util.Stack;

public class StackWithMinMax extends Stack<Integer> {

		// Stacks to hold the minimum and maximum vals
		private Stack<Integer> minstack;
		private Stack<Integer> maxstack;
		
		// Peeks
		public int maxval() {
			return maxstack.peek();
		}
		public int minval() {
			return minstack.peek();
		}
		
		public StackWithMinMax() {
			minstack = new Stack<Integer>();
			maxstack = new Stack<Integer>();
		}
		
		// Push Stack BUT also update the minmax values
		public void push(int value) {
			
			if(value <= minval()) {
				minstack.push(value);
			}
			else if(value >= maxval()) {
				maxstack.push(value);
			}
			
			// Actually push it to the parent stack
			super.push(value);
		}
		
		public Integer pop() {
			// Get value from parent stack
			int value = super.pop();
			
			// Update meta info on minmax stack
			if(value == maxval()) {
				maxstack.pop();
			}
			if(value == minval()) {
				minstack.pop();
			}
			
			return value;
			
		}
	
}
