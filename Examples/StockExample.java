package Examples;

public class StockExample {
	
	/*
	 * Given an array of stock prices from day 0 to N-1 of a company X,
	 * we have to find the max loss that is possible.
	 * Loss occurs if stock is bought at higher price and sold at lower price. 
	 * 
	 * Ex: 1 2 3 7 5 8 9 4 6 10 12 (algo and code including main) 
	 * Max Loss is 9 - 4 = 5 (Possible losses are 8-4 = 4, 7-5 = 2 etc).
	 * Max difference between stock price is 12 - 1 = 11 but max loss is 9 - 4 = 5
	 * */
	public static int maxLoss(int[] stocks) {
		
		// We have a loss if an index value is larger than a proceeding value. 
		// Keep track of highest number and largest difference
		int largest_num = 0;
		int largest_difference = 0;
		for(int n = 0; n < stocks.length; n++) {
			
			if(stocks[n] > largest_num) {
				largest_num = stocks[n];
			}
			// else, check if we have a difference
			if((largest_num > stocks[n]) && (largest_difference < (largest_num - stocks[n]))) {
				largest_difference = largest_num - stocks[n];
			}
			
		}
		
		return largest_difference;
		
	}
	
}
