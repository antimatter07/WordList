import java.io.*;
import java.util.*;
public class FileTry {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree uniqueWords = new BinarySearchTree();
        String str;
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
            BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
            BufferedWriter out = new BufferedWriter(new FileWriter("WORDS.txt"));
           
            

            while((str = br.readLine()) != null) {
               
               line = str.split(" ");
               
               //removes unnecassary chars like chars that aren't letters(!, ?, .)
               removeChars(line);
               
               //removes unnecassary words that are less than 3 chars
               //arraylist lineList contains final list of valid words to be added to BST
               removeSmallWords(line, lineList);

               for(int i = 0; i < lineList.size(); i++) {
                bst.insert(lineList.get(i));

               }
                    
                  
               //System.out.println("ITEM #" + (i + 1) + ":" + lineList.get(i) + "*");

               lineList.removeAll(lineList);

               

            }
           
            bst.printWordsToFile(out);
            System.out.println(bst.getCount("how"));
            bst.inOrderWalkStart();
            //bst.inOrderWalkStart();
            bst.destroy();
               

            br.close();
            out.close();
        } catch (IOException e) {
            System.out.println("ERROR: File not found. Please enter a valid file name.");

        } finally {
           input.close();
           
        }
    }
    public static void removeSmallWords(String[] line, ArrayList<String> lineList) {
        
        for(int i = 0; i < line.length; i++) {
            if(line[i] != null && line[i].length() >= 3) {

                lineList.add(line[i]);

            }
        }
    }
    public static void removeChars(String[] line) {
        for(int i = 0; i < line.length; i++) {
            line[i] = line[i].toLowerCase();
            for(int j = 0; j < line[i].length(); j++) {
                
                if(!Character.isLetter(line[i].charAt(j))) {
                    line[i] = removeCharAt(line[i], j);
                    
                }
                    
            }
        }
    }

   
     public static String removeCharAt(String str, int index) {  
        return str.substring(0, index) + str.substring(index + 1);  
     }  


    
}
