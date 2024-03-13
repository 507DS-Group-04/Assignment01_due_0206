/*
* Expectations:
1. Implement the problems in Java.
2. Submit your document containing
             a. the snippets of the code.
             b. runtime displays of the input data and the corresponding output.
* */
class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    BinaryTree() { root = null; }
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
    void printPreorder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
    void printPostorder(Node node)
    {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }

    public static void main(String[] args)
    {
        long startTime = System.nanoTime();

        BinaryTree StackMaster = new BinaryTree();
        StackMaster.root = new Node(1);
        StackMaster.root.left = new Node(2);
        StackMaster.root.right = new Node(3);
        StackMaster.root.left.left = new Node(4);
        StackMaster.root.left.right = new Node(5);
        System.out.println(
                "Inorder traversal of binary StackMaster is ");
        StackMaster.printInorder(StackMaster.root);
        System.out.println();
        System.out.println(
                "Preorder traversal of binary StackMaster is ");
        StackMaster.printPreorder(StackMaster.root);
        System.out.println();
        System.out.println(
                "Postorder traversal of binary StackMaster is ");
        StackMaster.printPostorder(StackMaster.root);
        System.out.println();

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println("memory requirement: "+ mem +"KB and CPU execution time " + time + " ms");
    }
}
