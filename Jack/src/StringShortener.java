import java.util.Scanner;
public class StringShortener {
	//og
	private String userInput;
	private int repeatedLetters;
	private int vowels;
	private String shortenedMessage;
	private int totalCharactersRemoved;
	
	public StringShortener() {
		repeatedLetters = 0;
		vowels = 0;
		shortenedMessage = "";
		Scanner message = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter message:");

	    userInput = message.nextLine();  // Read user input
	    if(userInput.length()<10) {
	    	System.err.println("This doesn't need shortening!");
	    }else {
	    	delete();
	    	System.out.println("Shortened Message: "+shortenedMessage);
	    	System.out.println("Repeated letters removed: "+repeatedLetters);
	    	System.out.println("Vowels removed: "+vowels);
	    	totalCharactersRemoved = vowels+repeatedLetters;
	    	System.out.println("Total characters saved: " + totalCharactersRemoved);
	    	
	    	StringShortener randomName = new StringShortener();
	    }
	    
	}

	public static void main(String[] args) {
		StringShortener randomName = new StringShortener();
	//type message

	//delete vowels
		
	//delete multiple charaters in a row
			
	}

	public void delete() {
		//This message could be a little shorter
		//I will arrive in Mississippi really soon
		
		//convert all leters to lowercase:
		userInput = userInput.toLowerCase();
		
		 int length = userInput.length();
		 System.out.println("length: " +length);
		 
		 int index = 1;
		 
		 shortenedMessage+=userInput.charAt(0);
		 
		 //look at each letter in the string, keeping track of which letter by using index
		 
		 while(index < length-1) { //check last value!!
			 
			 //if vowels
			 if(userInput.charAt(index) == 'a' ||
				userInput.charAt(index) == 'e' ||
				userInput.charAt(index) == 'i' ||
				userInput.charAt(index) == 'o' ||
				userInput.charAt(index) == 'u' ) {
				
				 if(userInput.substring(index-1, index).equals(" ")){ //vowel is at beginning of word
					 //System.out.println("b4vowel: "+ userInput.substring(index-1, index));
					 shortenedMessage+= userInput.charAt(index); //userInput.substring(index, index+1);
					 index++;
					 //change
					 //vowels--;
				 }
				/* if(userInput.charAt(index) == userInput.charAt(index+1)){ //repeating vowels
					 System.out.println("repeatVowel: ");
					 
					 int counter = index+1;
					 while (userInput.charAt(index) == userInput.charAt(counter)) {
						 counter++;
						 vowels++;
						 repeatedLetters++;
					 }
					 index = counter;*/
				 else {
					 vowels++;
					 index++;
				 }
				
			 }else {
				 shortenedMessage+=userInput.charAt(index);
				 
				 if(userInput.charAt(index) == userInput.charAt(index+1)){
					 int counter = index+1;
					 while (userInput.charAt(index) == userInput.charAt(counter)) {
						 counter++;
						 repeatedLetters++;
					 }
					 index = counter;
				 }else {
					 index++;
				 }
				
			 }
			 
		 }//end while loop
		 
		 //Check last element:
		 int lastIndex = userInput.length()-1;
		 if(userInput.charAt(lastIndex) != 'a' ||
					userInput.charAt(lastIndex) != 'e' ||
					userInput.charAt(lastIndex) != 'i' ||
					userInput.charAt(lastIndex) != 'o' ||
					userInput.charAt(lastIndex) != 'u' ) {
			 shortenedMessage+= userInput.charAt(lastIndex);
		 }else {
			 vowels++;
		 }
	}
}
