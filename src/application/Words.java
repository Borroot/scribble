package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Bram Pulles
 * This class handles everything regarding the words. 
 *
 */

public class Words {
	
	private File wordFile = new File("resources/words.txt");
	private Scanner input;
	
	private ArrayList<String> allWords = new ArrayList<>();
	private int allWordsSize; 
	private String[] randomWords; 
	
	private int amount;
	
	/**
	 * @param amount for the amount of random words
	 * The word file is read.
	 */
	public Words(int amount) {
		
		this.amount = amount;
		randomWords = new String[amount];
		createWordList();
	}
	
	/**
	 * Creates a connection to the word file and saves the words in an ArrayList.
	 */
	private void createWordList() {
		
		try {
			input = new Scanner(wordFile);
		} catch (FileNotFoundException e) {
			System.out.println("The word file has not been found.");
		}
		
		while(input.hasNextLine()) {
			String word = input.nextLine();
			allWords.add(word);
		}
		
		allWordsSize = allWords.size();
		input.close();
	}
	
	/**
	 * Resets the random words.
	 */
	public void resetWords() {
		
		for(int i = 0; i < amount; i++) {
			randomWords[i] = allWords.get((int)(Math.random() * allWordsSize));
		}
		
	}
	
	/**
	 * @return Some random words.
	 */
	public String[] getWords() {
		return randomWords; 
	}

}
