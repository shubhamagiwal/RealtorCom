import java.io.*;
import java.util.*;

public class AnagramFinder {


	/**
	 * Here we have an HashMap which keeps track of all the Anagrams which have the same sorted Array of characters.
	 * startTime, endTime, differenceTimeInMilli to let calculate to search for the anagrams in th hashmap and loading of the dictionary into the hashmap
	 * fileName is the name of the file which contains of the all words in a given file.
	 */

	private HashMap<String,ArrayList<String>> dictionary = new HashMap<String,ArrayList<String>> ();
	private long startTime,endTime;
	private long differenceTimeInMilli;
	String fileName;

	/**
	 * Constructor of the class which takes the fileName as the Arguments
	 */
	public AnagramFinder(String fileName){
		this.fileName = fileName;
	}

	/**
	 * Read the contents of the file and places it on the the dictionary by calling the putIntoDictionary() functions
	 * @return void
	 */
	public void readFile() {
		startTime = System.currentTimeMillis();
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				putIntoDictionary(line);
			}
			endTime = System.currentTimeMillis();
			System.out.println("Welcome to the Anagram Finder");
			System.out.println("-----------------------------");
			System.out.println("Dictionary loaded in "+(endTime-startTime) + "ms");
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Puts the contents of the file into the HashMap
	 * @return void
	 */
	public void putIntoDictionary(String word) {
		String wordSorted = sortString(word);
		ArrayList <String> tempArray = new ArrayList<String>();
		if (dictionary.containsKey(wordSorted.toLowerCase())) {
		    tempArray = dictionary.get(wordSorted.toLowerCase());
			tempArray.add(word);
			dictionary.put(wordSorted.toLowerCase(),tempArray);
		} else {
			tempArray.add(word);
			dictionary.put(wordSorted.toLowerCase(),tempArray);
		}
	}

	/**
	 * Creates the interactive Console for the taking in the Anagram to be found for a given String
	 * @return void
	 */
	public void interactiveConsole() {
		Scanner user_input = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("AnagramFinder> ");
			String word = user_input.nextLine();
			if (word.equalsIgnoreCase("exit")) {
				flag = false;
				break;
			} else {
				startTime = System.currentTimeMillis();
				String sortedWord = sortString(word);
				ArrayList<String> anagrams = findAnagrams(sortedWord);
				endTime = System.currentTimeMillis();
				printOutput(startTime,endTime,anagrams,word);
			}
		}
	}

	/**
	 * Sorts the characters in a given string
	 * @return String
	 */
	public String sortString(String word) {
		 word = word.toLowerCase();
		 char tempArray[] = word.toCharArray();
		 Arrays.sort(tempArray);
		 String sortedString = new String(tempArray);
		 tempArray = null;
	     return sortedString;
	}

	/**
	 * Returns the list of Anagrams for a given String
	 * @return ArrayList<String>
	 */
	public ArrayList<String> findAnagrams (String word){
		return dictionary.get(word.toLowerCase());
	}

	/**
	 * Prints the number of the Anagrams present for the given word with the time taken to find the given anagrams
	 * @return void
	 */
	public void printOutput(long startTime, long endTime, ArrayList<String>  anagrams, String word) {
		differenceTimeInMilli = endTime - startTime;
		if (anagrams == null) {
            System.out.println("No anagrams found for "+ word + " in " + differenceTimeInMilli + "ms");
        } else if(anagrams.size() == 1 || anagrams.size() == 0){
            System.out.println("No anagrams found for "+ word + " in " + differenceTimeInMilli + "ms");
		} else {
			System.out.println(anagrams.size() + " Anagrams found for " + word + " in "+ differenceTimeInMilli + "ms");
			System.out.println(String.join(",", anagrams));
		}
	}

	/**
	 * Main of the program which takes the file name as the arguments and provides an interactiveConsole for the user
	 * @return void
	 */

	public static void main(String[] args) {
		if (args.length <= 0){
			System.out.println("Enter the file to be loaded.");
			System.exit(0);
		}
		AnagramFinder af = new AnagramFinder(args[0]);
		af.readFile();
		af.interactiveConsole();
	}

}
