import java.io.*;

public class BinarySearchTree {
    
    Node root;
    class Node {
        Node right;
        Node left;
    
        String content;
    
        public Node(String content) {
            this.content = content;
         
        }
    
       
    
       
    }

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String newNodeContent) {
        
        root = insert(newNodeContent, root);
    }
    //get count of a word in the BST
    public int getCount(String key) {
        int count = 0;
        //Node temp;
        count = getCount(key, root, count);

        return count;

    }

    //recursively get the count (number of isntances) of a word in the BST
    public int getCount(String key, Node root, int count) {
        
        if(root != null && key.equalsIgnoreCase(root.content))
            count++;
        if(root == null)
            return count;
        
        if(key.compareToIgnoreCase(root.content) < 0)
            return getCount(key, root.left, count);
        else 
            return getCount(key, root.right, count);

        
        
    }

    //return true if word is in the BST, false otherwise
    public boolean search(String key) {
        Node temp = null;

        temp = search(key, root);

        if(temp == null)
            return false;
        return true;
       
    }

    public Node search(String key, Node root) {
        if(root == null || key.equalsIgnoreCase(root.content))
            return root;
        else {
            if(key.compareToIgnoreCase(root.content) < 0)
                return search(key, root.left);
            else 
                return search(key, root.right);

        }
        
    }
    //insert String in the proper position in the BST
    public Node insert(String newNodeContent, Node root) {
        if(root == null) {
            
          
            root = new Node(newNodeContent);
            
           return root;
        } 
            

            if(newNodeContent.compareToIgnoreCase(root.content) > 0)
                root.right = insert(newNodeContent, root.right);
            else if (newNodeContent.compareToIgnoreCase(root.content) < 0)
                root.left = insert(newNodeContent, root.left);
            else if(newNodeContent.compareToIgnoreCase(root.content) == 0)
                root.right = insert(newNodeContent, root.right);

            return root;
    }

        

        
    public void printWordsToFile(BufferedWriter bf, BinarySearchTree allWords) {
        if(root != null)
            printWordsToFile(this.root, bf, allWords);
    }

    //traverse the tree via in order walk, write each word into file, and get count each
    // in the binary search allWords that contains the same words including the duplicates.
    public void printWordsToFile(Node root, BufferedWriter bf, BinarySearchTree allWords) {
        if(root != null) {
            
            printWordsToFile(root.left, bf, allWords);
            try {
                //write word and spaces
                bf.write(root.content + "   ");
                //write count of that particular word
                bf.write(allWords.getCount(root.content) + "\n");

            } catch (IOException e) {
                System.out.println("ERROR IN WRITING TO FILE");
            }
            printWordsToFile(root.right, bf, allWords);
        }
    }
    
    public void inOrderWalkStart() {
      
        
        if(root != null)
            inOrderWalk(this.root);
        
    }
    //traverse the tree with in order walk
    public void inOrderWalk(Node root) {
        
        if(root != null) {
            
            inOrderWalk(root.left);
            System.out.println(root.content);
            inOrderWalk(root.right);
        }
    }
    //destroy tree and its contents
    public void destroy() {
        root = null;
    }


}
