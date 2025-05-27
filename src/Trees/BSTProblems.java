package Trees;

public class BSTProblems {

    public static void main(String[] args) {
        BSTProblems bst = new BSTProblems();
        BSTNode root = bst.createRandomBinarySearchTree();
        System.out.println(bst.searchBST(root,15));
        bst.insertBST(root,15);
        System.out.println(bst.searchBST(root,15));
        bst.printBST(root,0);
    }

    public BSTNode createRandomBinarySearchTree(){
        BSTNode left4 = new BSTNode(5, null, null);

        BSTNode left3 = new BSTNode(60, null, null);
        BSTNode right3 = new BSTNode(80, null, null);

        BSTNode left2 = new BSTNode(10, left4, null);
        BSTNode right2 = new BSTNode(30, null, null);

        BSTNode left1 = new BSTNode(20, left2, right2);
        BSTNode right1 = new BSTNode(70, left3, right3);

        BSTNode root = new BSTNode(50, left1, right1);
        return root;
    }

    public boolean searchBST(BSTNode root, int searchValue) {
        if(root == null) {
            return false;
        }
        if(root.data == searchValue) {
            return true;
        }
        if(searchValue < root.data) {
            return searchBST(root.left, searchValue);
        }
        else {
            return searchBST(root.right, searchValue);
        }
    }

    public BSTNode insertBST(BSTNode root, int insertValue) {
        if (root == null) {
            root = new BSTNode(insertValue);
        }
        else if (insertValue < root.data) {
            root.left = insertBST(root.left, insertValue);
        }
        else {
            root.right = insertBST(root.right, insertValue);
        }
        return root;
    }

    //public int inOrderSuccessor()

    public void printBST(BSTNode root, int count) {
        if (root == null) {
            for (int i = 0; i < count; i++) {
                System.out.print("\t");
            }
            System.out.println("null");
        } else {

            for (int i = 0; i < count; i++) {
                System.out.print("\t");
            }
            System.out.println(root.data);

            int temp = count + 1;
            printBST(root.left, temp);
            printBST(root.right, temp);
        }
    }
}
