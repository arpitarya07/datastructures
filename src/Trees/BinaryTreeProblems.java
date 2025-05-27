package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProblems {
    // maxSum is a global variable
    int maxSum = 0;
    int maxSumToAnyNode = 0;
    int maxSumPathNodeToNode = 0;

    public static void main(String[] args) {
        BinaryTreeProblems binaryTreeProblems = new BinaryTreeProblems();
        System.out.println(binaryTreeProblems.heightOfBinaryTree(createRandomBinaryTree()));
        System.out.println(binaryTreeProblems.maxSumOfBinaryTreeToLeaf(createRandomBinaryTree()));
        binaryTreeProblems.inOrderTraversal(createRandomBinaryTree());
        System.out.println();
        binaryTreeProblems.preOrderTraversal(createRandomBinaryTree());
        System.out.println();
        binaryTreeProblems.postOrderTraversal(createRandomBinaryTree());
        System.out.println();
        binaryTreeProblems.levelOrderTraversal(createRandomBinaryTree());

        binaryTreeProblems.maxSumOfBinaryTreeToLeafUsingMaxSum(createRandomBinaryTree(), 5);
        System.out.println(binaryTreeProblems.maxSum);

        binaryTreeProblems.maxSumOfBinaryTreeToAnyNode(createRandomBinaryTreeWithNegativeValues(), 5);
        System.out.println(binaryTreeProblems.maxSumToAnyNode);

        binaryTreeProblems.maxSumPathFromAnyNodeToAnyNode(createRandomBinaryTreeWithNegativeValues());
        System.out.println(binaryTreeProblems.maxSumPathNodeToNode);
    }

    public static BinaryTreeNode createRandomBinaryTree() {
        BinaryTreeNode left4 = new BinaryTreeNode(40, null, null);
        BinaryTreeNode right4 = new BinaryTreeNode(100, null, null);


        BinaryTreeNode left3 = new BinaryTreeNode(30, null, null);
        BinaryTreeNode right3 = new BinaryTreeNode(35, null, right4);

        BinaryTreeNode left2 = new BinaryTreeNode(20, left4, null);
        BinaryTreeNode right2 = new BinaryTreeNode(25, null, null);

        BinaryTreeNode left1 = new BinaryTreeNode(10, left2, right2);
        BinaryTreeNode right1 = new BinaryTreeNode(15, left3, right3);

        BinaryTreeNode root = new BinaryTreeNode(5, left1, right1);
        return root;
    }

    public static BinaryTreeNode createRandomBinaryTreeWithNegativeValues() {
        BinaryTreeNode left4 = new BinaryTreeNode(40, null, null);

        BinaryTreeNode left3 = new BinaryTreeNode(30, null, null);
        BinaryTreeNode right3 = new BinaryTreeNode(-35, null, null);

        BinaryTreeNode left2 = new BinaryTreeNode(-20, left4, null);
        BinaryTreeNode right2 = new BinaryTreeNode(25, null, null);

        BinaryTreeNode left1 = new BinaryTreeNode(-10, left2, right2);
        BinaryTreeNode right1 = new BinaryTreeNode(15, left3, right3);

        BinaryTreeNode root = new BinaryTreeNode(5, left1, right1);
        return root;
    }

    public int heightOfBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightOfLeftBinaryTree = heightOfBinaryTree(root.getLeft()) + 1;
        int heightOfRightBinaryTree = heightOfBinaryTree(root.getRight()) + 1;
        int heightOfBinaryTree = Math.max(heightOfLeftBinaryTree, heightOfRightBinaryTree);
        return heightOfBinaryTree;
    }

    public int maxSumOfBinaryTreeToLeaf(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumOfLeftBinaryTree = maxSumOfBinaryTreeToLeaf(root.getLeft()) + root.data;
        int sumOfRightBinaryTree = maxSumOfBinaryTreeToLeaf(root.getRight()) + root.data;
        int maxSumOfBinaryTree = Math.max(sumOfLeftBinaryTree, sumOfRightBinaryTree);
        return maxSumOfBinaryTree;
    }

    public void maxSumOfBinaryTreeToLeafUsingMaxSum(BinaryTreeNode root, int currSum) {
        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, currSum);
        }
        if (root.left != null) {
            maxSumOfBinaryTreeToLeafUsingMaxSum(root.left, currSum + root.left.data);
        }
        if (root.right != null) {
            maxSumOfBinaryTreeToLeafUsingMaxSum(root.right, currSum + root.right.data);
        }
    }

    public void maxSumOfBinaryTreeToAnyNode(BinaryTreeNode root, int currSum) {
        maxSumToAnyNode = Math.max(maxSumToAnyNode, currSum);
        if (root.left != null) {
            maxSumOfBinaryTreeToAnyNode(root.left, currSum + root.left.data);
        }
        if (root.right != null) {
            maxSumOfBinaryTreeToAnyNode(root.right, currSum + root.right.data);
        }
    }

    public int maxSumPathFromAnyNodeToAnyNode(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSumPathFromAnyNodeToAnyNode(root.left);
        int right = maxSumPathFromAnyNodeToAnyNode(root.right);
        int maxSingle = Math.max(Math.max(left, right) + root.data, root.data);
        maxSumPathNodeToNode = Math.max(maxSumPathNodeToNode, Math.max(maxSingle, left + right + root.data));
        return maxSingle;
    }


    //left,root,right
    public void inOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.print(root.data + "\t");
        inOrderTraversal(root.getRight());
    }

    //root,left,right
    public void preOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "\t");
        inOrderTraversal(root.getLeft());
        inOrderTraversal(root.getRight());
    }

    //left,right,root
    public void postOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        inOrderTraversal(root.getRight());
        System.out.print(root.data + "\t");
    }

    public void levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> levelOrderQueue = new LinkedList<>();
        levelOrderQueue.add(root);
        while (!levelOrderQueue.isEmpty()) {
            root = levelOrderQueue.remove();
            if (root != null) {
                System.out.println(root.data);
                levelOrderQueue.add(root.left);
                levelOrderQueue.add(root.right);
            }
        }
    }


}
