import java.io.*;
import java.util.*;
public class WordList {
    public static void main(String[] args) {
        
        //Scanner input = new Scanner(System.in);

        /*This BST will contain all the words from the text file, including duplicates. */
        BinarySearchTree allWords = new BinarySearchTree();

        /*This BST will contain only the unique words, removing the duplicates */
        BinarySearchTree uniqueWords = new BinarySearchTree();
        String str;

        //will contain the line of text after reading from textfile
        String[] line;
        ArrayList<String> lineList = new ArrayList<String>();
        /* TODO:
           > 1 BST will contain copies of the words in the .txt file
           (without all the unnecassary spaces)
           > Make a String array that has one copy of all words, without any of the unnecassary chars
           > Make an int array of the same size, the index of each array space corresponds
           to the index of the word present in the String array
           >Make a BST method that traverses the tree, increments the count everytime the same
           word is encountered (maybe in order)
           >Do this for all Strings in the array
           >use buffered writer to output  a file

            
            TODO: 
        */

        try { 
            //instantiate reader and writer
            BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("WORDS.txt"));
           
            

            while((str = br.readLine()) != null) {
               
               //assume that words ared always separated by a single space " "
               line = str.split(" ");
               
               //removes unnecassary chars like chars that aren't letters(!, ?, .)
               removeChars(line);
               
               //removes unnecassary words that are less than 3 chars
               //arraylist lineList contains final list of valid words to be added to BST
               removeSmallWords(line, lineList);

               for(int i = 0; i < lineList.size(); i++) {
                    allWords.insert(lineList.get(i));

                    if(!uniqueWords.search(lineList.get(i))) {
                        uniqueWords.insert(lineList.get(i));
                    }

               }
                    
                  
               //System.out.println("ITEM #" + (i + 1) + ":" + lineList.get(i) + "*");

               lineList.removeAll(lineList);

               

            }
           
            //Traverse the BST with in order walk, while getting the count of each word in the allWords BST
            uniqueWords.printWordsToFile(out, allWords);
            

            /*The commented out code below prints the in order walk in console. */
            //uniqueWords.inOrderWalkStart();
            //bst.inOrderWalkStart();
            
               

            br.close();
            out.close();

        } catch (IOException e) {
            System.out.println("ERROR: File not found.");

        } finally {
            //before terminating program, destroy trees
           allWords.destroy();
           uniqueWords.destroy();
           //input.close();
           System.gc();
           
        }
    }
    /**
     * Removes unnecassary words that are less than or equal to 3 in length. The resulting ArrayList
     * lineList contains the words that are valid which will be added to the 
     * binary search tree.
     * @param line The line that was read from the text file, made into a String array
     * @param lineList The arraylist that will contain the valid words 
     */
    public static void removeSmallWords(String[] line, ArrayList<String> lineList) {
        
        for(int i = 0; i < line.length; i++) {
            if(line[i] != null && line[i].length() >= 3) {

                lineList.add(line[i]);

            }
        }
    }
    /**
     * This method removes the unecassary characters in a word that can be read
     * from the text file, such as periods, question marks, and commas.
     * 
     * @param line The line read from the text file, which is an array of Strings
     */
    public static void removeChars(String[] line) {
        for(int i = 0; i < line.length; i++) {
            line[i] = line[i].toLowerCase();
            for(int j = 0; j < line[i].length(); j++) {
                
                
                if(line[i].charAt(j) != '-' && !Character.isLetter(line[i].charAt(j))) {
                    line[i] = removeCharAt(line[i], j);
                    
                }
                    
            }
        }
    }

    /**
     * This method removes a character in a word given the index of that character in
     * the String.
     * @param str The String being modified
     * @param index the index of the character that will be removed
     * @return the new String after removing the character at the specified index
     */
    public static String removeCharAt(String str, int index) {  
        return str.substring(0, index) + str.substring(index + 1);  
    }  


    
}
