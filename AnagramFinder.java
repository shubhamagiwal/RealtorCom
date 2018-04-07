import java.io.*;
import java.util.*;

public class AnagramFinder {

	private HashMap<String,ArrayList<String>> dictionary= new HashMap<String,ArrayList<String>> ();
	long startTime,endTime;
	long differenceTimeInMilli;

	public AnagramFinder() {
		// TODO Auto-generated constructor stub
	}

	/* Read the contents of the file and put it into the dictionary created*/
	public void readFile(String fileName) {
		System.out.println("Welcome to the Anagram Finder");
		System.out.println("-----------------------------");
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
			System.out.println("Dictionary loaded in "+(endTime-startTime) + "ms");
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*Use HashMap to put the contents of the file*/
	public void putIntoDictionary(String word) {
		String wordSorted= sortString(word);
		ArrayList <String> tempArray = new ArrayList<String>();
		if(dictionary.containsKey(wordSorted)) {
		    tempArray=dictionary.get(wordSorted);
			tempArray.add(word);
			dictionary.put(wordSorted,tempArray);
		}else {
			tempArray.add(word);
			dictionary.put(wordSorted,tempArray);
		}
	}

	/* Interactive Console*/
	public void interactiveConsole() {
		Scanner user_input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.print("AnagramFinder> ");
			String word = user_input.nextLine();

			if(word.equalsIgnoreCase("exit")) {
				flag = false;
				break;
			}else {
				startTime = System.currentTimeMillis();
				String sortedWord = sortString(word);
				ArrayList<String> anagrams = findAnagrams(sortedWord);
				endTime=System.currentTimeMillis();
				printOutput(startTime,endTime,anagrams,word);
			}
		}
	}

	/* Core Logic */
	public String sortString(String word) {
		 char tempArray[] = word.toCharArray();
		 Arrays.sort(tempArray);
		 String sortedString= new String(tempArray);
		 tempArray=null;
	     return sortedString;
	}

	public ArrayList<String> findAnagrams (String word){
		return dictionary.get(word);
	}

	public void printOutput(long startTime, long endTime, ArrayList<String>  anagrams, String word) {
		differenceTimeInMilli = endTime - startTime;
		if(anagrams == null) {
            System.out.println("No anagrams found for "+word+" in "+differenceTimeInMilli+"ms");
        } else if(anagrams.size() == 1 || anagrams.size() == 0){
            System.out.println("No anagrams found for "+word+" in "+differenceTimeInMilli+"ms");
		} else {
			System.out.println(anagrams.size()+ " Anagrams found for "+word +" in "+differenceTimeInMilli+"ms");
			System.out.println(String.join(",", anagrams));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagramFinder af = new AnagramFinder();
		af.readFile(args[0]);
		af.interactiveConsole();
	}

}
