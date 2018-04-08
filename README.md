# Anagram Finder Programming Task

What is an **Anagram**?<br>
An anagram is a word, phrase, or name formed by rearranging the letters of another, such as `cinema,` formed from `iceman`.

What **data structure** is used?<br>
 The data structure used to save the contents of the text file provided is a HashMap with a key as the sorted version of the characters present in the word.

Reason to use the given  **data structure**
1. Faster Lookup
2. Time consumed during the load  of the dictionary initially is more than the time  during the lockup of the of the anagrams.

Functions used in the code base

**public void readFile(String fileName)**
*Input*- String <br>
*Output*- void<br>
*Description* -Reads the contents of the file and puts it into the dictionary HashMap.

**public void putIntoDictionary(String word)**
*Input*- String<br>
*Output*- void<br>
*Description* -Places in the given word to the given key in the dictionary HashMap.

**public void interactiveConsole()**
*Input*- Nothing<br>
*Output*- void<br>
*Description*- Creates an Interactive Console as mentioned in the project description where it takes a string and finds its corresponding anagrams

**public String sortString(String word)**
*Input*- String<br>
*Output*- String<br>
*Description*- Given a word, the function sorts the characters in a given word and returns back the sorted String

**public ArrayList<String> findAnagrams (String word)**
*Input*- String<br>
*Output*- ArrayList<String><br>
*Description*- Returns the ArrayList of Integers for a given word

**public void printOutput(long startTime, long endTime, ArrayList<String>  anagrams, String word)**
*Input*- (long,long,ArrayList<String>,String)<br>
*Output*- void<br>
*Description*- Prints the output in a given format as mentioned in the project Description

# Programming Setup

1. Run the following command in the given `java -version` on your system

`Shubhams-MacBook-Pro-2:RealtorCom shubhamagiwal$ java -version
java version "1.8.0_152"
Java(TM) SE Runtime Environment (build 1.8.0_152-b16)
Java HotSpot(TM) 64-Bit Server VM (build 25.152-b16, mixed mode)`

2. Ensure that java virtual machine and java versions are installed on your system.
3. Run the given command `javac AnagramFinder.java`
4. On successful compilation of the code run the given command `java AnagramFinder dictionary.txt`.

**Note**- The text file containing the words must be in the same path as that of the java code.
