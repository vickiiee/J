package ArrayStats;

import java.util.Scanner;

public class ArrayStatistics {

	public static void main(String[] args) {
		
		Scanner asker = new Scanner(System.in);
		System.out.println("How long do you want the array to be?");
		
		int userInput = asker.nextInt();
		
		if(userInput<=0) {
			System.out.println("Not a valid length");
		}else {
			
			double[] numberArray = new double[userInput];
			
			for(int i = 0; i < userInput; i++) {
				System.out.println("Enter a number:");
				double num = asker.nextDouble();
				
				numberArray[i] = num;
			}
			//^ insert elements into the empty array so it is full
			
			System.out.print("Your array is {");
			for(int i = 0; i < userInput; i++) { 
				if(i == userInput -1) {
					System.out.print(numberArray[i]);
				}else {
					System.out.print(numberArray[i]+", ");
				}
				
			}
			System.out.println("}");
			
			//System.out.println(Arrays.toString(numberArray));
		
			double sum = 0;
			for(int i = 0; i < userInput; i++) {
				sum += numberArray[i];
			}
			
			double avg = 0;
			avg = sum/userInput;
			System.out.println("The average is "+ avg);
		
			double min = numberArray[0];
			for(int i = 1; i < userInput; i++) {
				if(numberArray[i] < min) {
					min = numberArray[i];
				}
			}
			
			double max = numberArray[0];
			for(int i = 1; i < userInput; i++) {
				if(numberArray[i] > max) {
					max = numberArray[i];
				}
			}
			
			System.out.println("The range is: " + (max - min));
			// 3,5,2,7,1
			/*
			 * min = 3
			 * i = 1: min = 3, n[1] = 5 //min doesnot change
			 * i = 2: min = 3, n[2] = 2 //min does change min = 2
			 */
			
			boolean ascending  = true;
			for(int i = 0; i < userInput-1; i++) {
				if(numberArray[i] > numberArray[i+1]) {
					ascending = false;
					break;
				}
			}
			// 1,3,5,6,7
			// 1,3,2,6,7
			
			if (ascending == true) {
				System.out.println("The array is sorted in ascending order");
			}else {
				//decreasing
				boolean descending = true;
				for(int i = 0; i < userInput - 1; i++) {
					if(numberArray[i] < numberArray[i+1]) {
						descending = false;
						break;
					}
				}
				
				if(descending == true) {
					System.out.println("The array is sorted in descending order");
				}else {
					System.out.println("The array is unsorted");
				}
			}
			
		}

	}

}
