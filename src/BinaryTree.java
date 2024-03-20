/*
In-class activity 3: Traverse a Tree @ Mar 20
Due Wednesday by 11:59pm Points 2 Submitting a file upload
Traverse the following tree and show the results of In-Order, Pre-Order, Post-Order traversals.
* */
class Node {
    int key;
    Node left, right;

    public Node(int item)
    {
        this.key = item;
        this.left = right = null;
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
        StackMaster.root = new Node(25);
        StackMaster.root.left = new Node(15);
        StackMaster.root.left.left = new Node(10);
        StackMaster.root.left.left.left = new Node(4);
        StackMaster.root.left.left.right = new Node(12);
        StackMaster.root.left.right = new Node(22);
        StackMaster.root.left.right.left = new Node(18);
        StackMaster.root.left.right.right = new Node(24);
        StackMaster.root.right = new Node(50);
        StackMaster.root.right.left = new Node(35);
        StackMaster.root.right.left.left = new Node(31);
        StackMaster.root.right.left.right = new Node(44);
        StackMaster.root.right.right = new Node(70);
        StackMaster.root.right.right.left = new Node(66);
        StackMaster.root.right.right.right = new Node(90);
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
