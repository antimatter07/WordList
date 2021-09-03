public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert("cat");
        bst.insert("dog");
        bst.insert("apple");
        bst.insert("hi");
       
        bst.inOrderWalkStart();
    }
    
}
