package MergeArrays;

import java.util.Scanner;

public class MergeArrays {

	public static void main(String args[]) {
		Scanner asker = new Scanner(System.in);
		System.out.println("Enter an array length (must be 10 or greater).");
		int userInput = asker.nextInt();
		
		while(userInput < 10) {
			System.out.println("Enter an array length (must be 10 or greater).");
			userInput = asker.nextInt();
		}
		
		int [] array1 = new int [userInput];
		int [] array2 = new int [userInput];
		
		for(int i = 0; i < userInput; i++) {
			//(Math.random() * ((max - min) + 1)) + min
			array1[i] = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
			array2[i] = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
		}
		
		System.out.print("First Array: ");
		for(int i = 0; i < userInput; i++) {
			System.out.print(array1[i]+ " ");
		}
		System.out.println("\n");
		
		System.out.print("Second Array: ");
		for(int i = 0; i < userInput; i++) {
			System.out.print(array2[i]+ " ");
		}
		System.out.println("\n");
		
		int[] mergedArray = new int[userInput*2];
		int mergedArrayIndex = 0;
		for(int i = 0; i < userInput; i++) {
			
			int element1 = array1[i];
			boolean ele1InMergedArray = false;
			
			int element2 = array2[i];
			boolean ele2InMergedArray = false;
			
			for(int j = 0; j < userInput*2; j++) {
				if(mergedArray[j]!=0 && mergedArray[j]== element1) {
					System.out.println("Dup: " + element1);
					ele1InMergedArray = true;
				}
			}

			if (ele1InMergedArray == false) {
				mergedArray[mergedArrayIndex] = element1;
				mergedArrayIndex++;
			}

			for(int j = 0; j < userInput*2; j++) {
				if(mergedArray[j]!=0 && mergedArray[j]== element2) {
					System.out.println("Dup: " + element2);
					ele2InMergedArray = true;
				}
			}
			if (ele2InMergedArray == false) {
				mergedArray[mergedArrayIndex] = element2;
				mergedArrayIndex++;
			}
		}
		
		System.out.print("Merged Array: ");
		for(int i = 0; i < userInput*2; i++) {
			if(mergedArray[i]!= 0) {
				System.out.print(mergedArray[i]+ " ");
			}
			
		}
		System.out.println("\n");
		
		String a [] = new String [1];
		main(a);
	}
}
