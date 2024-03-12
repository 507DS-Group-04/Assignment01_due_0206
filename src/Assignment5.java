import java.util.*;

/*
* Implementing a basic Tree operation

This assignment is to work with tree data structures.

Create a tree of 10 cities where cities are from a same country and the root city R is the capital city.
* Some smaller cities (towns) are part of a city. Find depth and length of a city M.

Expectations:

Draw the tree.
Implement the problem in any language you prefer.
For runtime results:
Let user to select a city.
display depth and height of the corresponding city.
Submit your document containing
the snippets of the code.
runtime displays of the input data and the corresponding output.
* */
public class Assignment5 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        TreeNode root = createcTree();
        System.out.println(root);
        Scanner scanner = new Scanner(System.in);
        System.out.print("select a city: ");
        String cName = scanner.nextLine();
        int depth = findDepth(root, cName);
        int height = findHeight(root);
        if (depth == -1) {
            System.out.println("not found node in the tree");
            return;
        }
        System.out.println("Depth  " + cName + ": " + depth);
        System.out.println("Height: " + height);

        long endTime = System.nanoTime();
        long time = (endTime - startTime) / 1000000;
        long mem = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024;
        System.out.println("memory requirement: "+ mem +"KB and CPU execution time " + time + " ms");
    }
    public static TreeNode createcTree() {
        TreeNode capital = new TreeNode("Beijing");
        TreeNode c1 = new TreeNode("Shanghai");
        TreeNode c2 = new TreeNode("Gansu");
        TreeNode c3 = new TreeNode("Fujian");
        TreeNode c4 = new TreeNode("Tianjin");
        TreeNode c5 = new TreeNode("Chongqing");
        TreeNode c6 = new TreeNode("Anhui");
        TreeNode t1 = new TreeNode("Jingan");
        TreeNode t2 = new TreeNode("Lanzhou");
        TreeNode t3 = new TreeNode("Fuzhou");

        capital.addChild(c1);
        capital.addChild(c2);
        capital.addChild(c3);
        c1.addChild(c4);
        c1.addChild(c5);
        c2.addChild(c6);
        c4.addChild(t1);
        c4.addChild(t2);
        c6.addChild(t3);

        return capital;
    }

    public static TreeNode findc(TreeNode node, String targetc, int depth) {
        if (node == null) {
            return null;
        }
        if (node.cName.equals(targetc)) {
            return node;
        }
        TreeNode result = null;
        for (TreeNode child : node.children) {
            result = findc(child, targetc, depth + 1);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    public static int findDepth(TreeNode root, String cName) {
        TreeNode cNode = findc(root, cName, 0);
        if (cNode == null) {
            return -1;
        }
        return depthFromRoot(root, cNode);
    }

    public static int depthFromRoot(TreeNode root, TreeNode target) {
        if (root == null || target == null) {
            return -1;
        }
        if (root == target) {
            return 0;
        }
        for (TreeNode child : root.children) {
            int depth = depthFromRoot(child, target);
            if (depth != -1) {
                return depth + 1;
            }
        }
        return -1;
    }

    public static int findHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int maxHeight = -1;
        for (TreeNode child : root.children) {
            int height = findHeight(child);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight + 1;
    }
}
class TreeNode {
    String cName;
    List<TreeNode> children;

    public TreeNode(String name) {
        this.cName = name;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        this.children.add(child);
    }
}