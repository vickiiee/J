
import java.util.Scanner;

public class StringShortenerWithNoComments {

	public StringShortenerWithNoComments() {
		// constructor
	}

	public static void main(String[] args) {
		Scanner message = new Scanner(System.in);
		System.out.println("Enter message:");
		String userInput = message.nextLine();

		int repeatedLetters = 0;
		int vowels = 0;
		int totalCharactersRemoved = 0;
		
		String shortenedMessage = "";
		//-----------------------------------------------------
		if (userInput.length() < 10) {
			System.err.println("This doesn't need shortening!");
			StringShortener randomName = new StringShortener();
		} else {

			userInput = userInput.toLowerCase();
			shortenedMessage += userInput.charAt(0);

			int index = 1;

			int length = userInput.length();

			while (index < length - 1) { // doesnt check last value!!
				if (userInput.charAt(index) == 'a' || userInput.charAt(index) == 'e' || userInput.charAt(index) == 'i' || userInput.charAt(index) == 'o' || userInput.charAt(index) == 'u') {

					if (userInput.charAt(index-1) == (' ')) {
						shortenedMessage += userInput.charAt(index); 
						index++;
					}
					else {
						vowels++;
						index++;
					}
				} else { 
					shortenedMessage += userInput.charAt(index);

					if (userInput.charAt(index) == userInput.charAt(index + 1)) { 
						int otherIndex = index + 1;
				
						while (userInput.charAt(index) == userInput.charAt(otherIndex)) {
							otherIndex++;
							repeatedLetters++;
						}
						index = otherIndex;
					} else {
						index++;
					}
				}

			} // end while loop

			
			int lastIndex = userInput.length() - 1;
			if (userInput.charAt(lastIndex) != 'a' || userInput.charAt(lastIndex) != 'e'|| userInput.charAt(lastIndex) != 'i' || userInput.charAt(lastIndex) != 'o'|| userInput.charAt(lastIndex) != 'u') {
				shortenedMessage += userInput.charAt(lastIndex);
			} else {
				vowels++;
			}
		}
		
		//FRONT END
		System.out.println("Shortened Message: " + shortenedMessage);
		System.out.println("Repeated letters removed: " + repeatedLetters);
		System.out.println("Vowels removed: " + vowels);
		totalCharactersRemoved = vowels + repeatedLetters;
		System.out.println("Total characters saved: " + totalCharactersRemoved);
		
		StringShortener randomName = new StringShortener();
		//^ just included this so we dont need to always manually run the program to test it.
		//^ with this line, it will always prompt "Enter message"
	}
}

/**
 * if(char is a vowel){
 * 		if(vowel is the first letter of word){
 * 			do concatenate it
 * 		else if(vowel is Not the first letter){
 *			 do not concatenate it	
 * 		}
 * }else if(char is NOT a vowel)
 * 		do concatenate it
 * }
 */
