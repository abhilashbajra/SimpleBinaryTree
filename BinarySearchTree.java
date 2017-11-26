import java.util.Queue;
public class BinarySearchTree {
	private Node root;
	private Node root2;
	
	public void setup() {
		Node leaf1 = new Node(20, null, null);
		Node leaf2 = new Node(35, null, null);
		Node leaf3 = new Node(55, null, null);
		
		Node p1 = new Node(80, leaf1, leaf2);
		Node p2 = new Node(60, leaf3, null);
		
		root = new Node(50, p1, p2);
	}
	
	private void setup2() {
		Node leaf1 = new Node(20, null, null);
		Node leaf2 = new Node(35, null, null);
		Node leaf3 = new Node(55, null, null);
		
		Node p1 = new Node(80, leaf1, leaf2);
		Node p2 = new Node(60, leaf3, null);
		
		root2 = new Node(50, p1, p2);
	}
	
	private static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int d, Node lt, Node rt) {
			data = d;
			left = lt;
			right = rt;
		}
	}
	
	private int sum(Node t) {
		if (t == null)
			return 0;
		else {
			return t.data + sum(t.left) + sum(t.right);
		}
	}
	public int sum() {
		return sum(root);
	}
	
	private int nodeCount(Node t) {
		if (t == null)
			return 0;
		else {
			return 1 + nodeCount(t.left) + nodeCount(t.right);
		}
	}
	
	public int nodeCount() {
		return nodeCount(root);
	}
	
	private boolean isFull(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if ((root.left != null) && (root.right != null))
			return (isFull(root.left) && isFull(root.right));
		return false;
	}
	
	public boolean isFull() {
		return isFull(root);
	}
	
	private boolean equals(Node r1, Node r2) {
		if (r1 == null && r2 == null)
			return true;
		if (r1 != null && r2 != null)
			return (r1.data == r2.data && equals(r1.left, r2.left) && equals(r1.right, r2.right));
		return false;
	}
	
	public boolean equals() {
		return equals(root, root2);
	}
	
	private Node mirror(Node root) {
		if (root == null)
			return root;
		Node l = mirror(root.left);
		Node r = mirror(root.right);
		root.left = r;
		root.right = l;
		return root;
	}
	
	public Node mirror() {
		return mirror(root);
	}
	
	public void printLevels() {
		printLevels(root);
	}
	
	private void printLevels(Node root) {
		Queue<Node> queue = new java.util.LinkedList<Node>();
		if (root == null) {
				return;
		}
		queue.add(root);
		while (queue.size() > 0) {
			Node temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}
	
	boolean isSameStructure(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.data != root2.data)
			return false;
		return (isSameStructure(root1.left, root2.left) && isSameStructure(root1.right, root2.right)) || (isSameStructure(root1.left, root2.right) && isSameStructure(root1.right, root2.left));
		}
	
	public boolean isSameStructure() {
		return equals(root, root2);
	}
		
	boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root1.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
	}
	
	public boolean isMirror() {
		return isMirror(root, root2);
	}
	
	private Node rotateRight(Node root) {
		Node x = root.left;
		Node T2 = x.right;
		x.right = root;
		root.left = T2;
		return x;
	}
	
	private Node rotateLeft(Node root) {
		Node y = root.right;
		Node T2 = y.left;
		y.left = root;
		root.right = T2;
		return y;
	}
	
	public Node rotateRight() {
		return rotateRight(root);
	}
	
	public Node rotateLeft() {
		return rotateLeft(root);
	}
	
	public static void main(String[] args) {
		BinarySearchTree t = new BinarySearchTree();
		t.setup();
		BinarySearchTree t1 = new BinarySearchTree();
		t1.setup2();
		System.out.println("Node Count: " + t.nodeCount());
		System.out.println("Is Full Tree: " + t.isFull());
		System.out.println("Is Equal Tree: " + t.equals());
		System.out.println("Is Same Structure Tree: " + t.isSameStructure());
		System.out.println("Print Levels: ");
		t.printLevels();
		System.out.println("Is Mirror Tree: " + t.isMirror());
		// Mirror
		t.mirror();
		// RotateLeft
		t.root = t.rotateLeft();
		// RotateRight
		t.root = t.rotateRight();
	}
}

