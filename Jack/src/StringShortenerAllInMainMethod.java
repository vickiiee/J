import java.util.Scanner;

public class StringShortenerAllInMainMethod {

	public StringShortenerAllInMainMethod() {
		// constructor
	
	int students = 0;
	students = attendance();
	
	}

	public int attendance() {
		//calculates how many ppl are absent
		
		return 10;
	}

	public static void main(String[] args) {
		// Create a Scanner object to get user input
		Scanner message = new Scanner(System.in); 
		System.out.println("Enter message:");
		//initialize all your variables!
		String userInput = message.nextLine(); // get user input
		
		int repeatedLetters = 0; 
		//^ keeps track of any repeated letters that we remove/do not add to the result message 'shortenedMesaage'
		
		int vowels = 0;
		//^ keeps track of any vowels letters that we remove/do not add to the result message 'shortenedMesaage'
		
		int totalCharactersRemoved = 0; //dont need to initialize this because it gets a value later; see line: 153
		
		String shortenedMessage = "";
		//^ this is the string that you will concatenate each individual char of 'userInput' into
		
		//tTHE REQUIREMENTS OF THIS ASSIGNMENT
		
		/*
		 * if 'userInput' (aka the message) is shorter than 10 characters, say 'it doesnt need shortening' and thats it.
		 */
		if (userInput.length() < 10) {
			System.err.println("This doesn't need shortening!");
			StringShortener randomName = new StringShortener();
		} else {
			/*
			 * However, if 'userInput' is longer than 10 characters
			 * 		(1) message should be immediately converted to lowercase
			 * 		(2) create a string that produces the result of message that 
			 * 			(a) has no vowels if the vowel isn't at the beginning of a word, or 
			 * 			(b) repeated consonants
			 */

			//(1) convert all letters to lowercase:
			userInput = userInput.toLowerCase(); 
			/* Must have userInput '=' it because .toLowerCase() RETURNS string with all lowercase letters and doesn't actually change the value of 'userInput'. 
			 * So to actually change the value of 'userInput', assign it (=) to the result of .toLowerCase() 
			 */

			shortenedMessage += userInput.charAt(0);
			/*
			 *The first char of userInput is also the first letter of a word.
			 *Words that start with a vowel is not removed.
			 *	Ex: the shortened message of 'apple' will be 'appl' 
			 *So therefore, it doesnt matter if the first char is a vowel or consonant.
			 *So you can just automatically concontenate it to your result string called "shortenedMessage"
			 */
				
			/*
			 * In order to solve this problem, you must go through and check each character in the string/'userInput' at every index to see if it is a vowel or not.
			 * To do this, you can use a while or for loop, but since you don't know how to use a for loop, we will stick with a while loop.
			 */
			int index = 1;
			/*
			 * ^ this int variable will keep track of what index you are at in the string.
			 * It is starting at 1 and not 0 because earlier, it was already said it doesnt matter if the char at index 0 is a vowel or not.
			 * So the first char we need to check is at index 1.
			 */
			
			int length = userInput.length();
			/*
			 * get the length of the userInput/message so you know at what index you will have to stop at.
			 * 	Ex: 'apple' has a length of 5, with indexes 0,1,2,3,4
			 */

			while (index < length - 1) { // doesnt check last value!!
				/*
				 * while the index is less than the length -1, then it will execute the code.
				 * I put 'length -1' so i can avoid an 'outOfBounds' error later on in the code.	  
				 */
				
				/*If the char is a VOWEL:*/
				if (userInput.charAt(index) == 'a' || userInput.charAt(index) == 'e' || userInput.charAt(index) == 'i' || userInput.charAt(index) == 'o' || userInput.charAt(index) == 'u') {

					/*
					 * Check if the vowel is at the beginning of a word.
					 * 	> if the vowel is the first letter of a word, we keep it (concatenate it)
					 * 	> else we remove it (don't concatenate it)
					 * 
					 * We determine this if there is a space/' ' before the vowel
					 */
					
					// if the char at the index before the current index is a space,
					if (userInput.charAt(index-1) == (' ')) {
						shortenedMessage += userInput.charAt(index); 
						index++;
						/*^ increment index so while loop can continue searching rest of the indexes 
						since you are done looking at the char at the current index */
					}
					else { //this means that the vowel is not the first letter of a word & is in the middle of a word
						//so you do not concatenate
						vowels++;
						//^ increment because you are not adding this vowel to the result string 'shortenedMesage'.
						index++;
						/*^ increment index so while loop can continue searching rest of the indexes 
						since you are done looking at the char at the current index */
					}
				} else { /*If the char is NOT a vowel but a consonant:*/
					shortenedMessage += userInput.charAt(index);
					/*
					 *^ Concatonate immediately because only vowels are not added to the result string 'shortenedMessages'
					 */
					
					//Now, check if the next char is the same as the current one / check if the char is repeating
					if (userInput.charAt(index) == userInput.charAt(index + 1)) { 
						//if the chars are equal:
						
						int otherIndex = index + 1;
						//^ i made this variable so i can compare the current index (index) with the next upcoming indexes (otherIndex)
						while (userInput.charAt(index) == userInput.charAt(otherIndex)) {
							//while the char at the current index == the char at the next index
							
							otherIndex++;
							//^increment this variable so we can check if the char at the next index is the same with the char at the current index
							
							repeatedLetters++;
							//^since the chars are the same, increment this variable
						}
						index = otherIndex;
					} else {//if the chars are NOT equal:
						index++;
					}
				}

			} // end while loop

			// Check last element:
			int lastIndex = userInput.length() - 1;
			if (userInput.charAt(lastIndex) != 'a' || userInput.charAt(lastIndex) != 'e'
					|| userInput.charAt(lastIndex) != 'i' || userInput.charAt(lastIndex) != 'o'
					|| userInput.charAt(lastIndex) != 'u') {
				//if char at last index is a consonant/ NOT a vowel, add it to the result string 'shortenedMessage'
				shortenedMessage += userInput.charAt(lastIndex);
			} else {
				//char is a vowel
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
