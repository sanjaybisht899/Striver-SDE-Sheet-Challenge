import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Node<T> implements Comparable<Node<T>> {
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;

	private int height;
	private T value;
	private Comparator comparator;
	private int size;

	public Node (T val, Comparator comp) {
		value = val;
		height = 0;

		size = 1;
		comparator = comp;
	}

	public void setVal(T v) {
		value = v;
	}

	public void setHeight() {
		height = -1;

		if (left != null)
			height = left.getHeight();

		if (right != null)
			height = Math.max(height, right.getHeight());

		height++;
	}

	public void setSize() {
		size = 1;

		if (left != null)
			size += left.getSize();

		if (right != null)
			size += right.getSize();
	}

	public void setLeft(Node<T> l) {
		left = l;
		if (l != null)
			l.setParent(this);

	}

	public void setRight(Node<T> r) {
		right = r;
		if (r != null)
			r.setParent(this);
	}

	public void setParent(Node<T> node) {
		parent = node;
	}

	public T getValue() {
		return value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public Node<T> getParent() {
		return parent;
	}

	public int getHeight() {
		return height;
	}

	public int getSize() {
		return size;
	}

	public void leftRotate() {
		assert parent.getRight() == this;
		parent.setRight(left);

		Node<T> grandParent = parent.getParent();
		setLeft(parent);

		if (grandParent != null) {

			if (grandParent.getLeft() != null && grandParent.getLeft().equals(parent))
				grandParent.setLeft(this);

			else 
				grandParent.setRight(this);
		}

		else 
			setParent(null);

		left.setHeight();
		left.setSize();

		setHeight();
		setSize();

		if (parent != null){
			parent.setHeight();
			parent.setSize();
		}
	}

	public void rightRotate() {
		assert parent.getLeft() == this;
		parent.setLeft(right);

		Node<T> grandParent = parent.getParent();
		setRight(parent);

		if (grandParent != null) {

			if (grandParent.getLeft() != null && grandParent.getLeft().equals(parent))
				grandParent.setLeft(this);

			else 
				grandParent.setRight(this);
		}

		else 
			setParent(null);

		right.setHeight();
		right.setSize();

		setHeight();
		setSize();

		if (parent != null){
			parent.setHeight();
			parent.setSize();
		}
	}

	@Override
	public int compareTo(Node<T> node) {
		return comparator.compare(value, node.getValue());
	}

	public void insert (Node<T> node) {
		size++;
        
		if (this.compareTo(node) < 0){
			if (right != null)
				right.insert(node);
			else 
				setRight(node);
		}

		else{
			if (left != null)
				left.insert(node);
			else 
				setLeft(node);
		}

		setHeight();
		int leftHeight = -1, rightHeight = -1;

		if (left != null)
			leftHeight = left.getHeight();

		if (right != null)
			rightHeight = right.getHeight();

		if (Math.abs(leftHeight - rightHeight) > 1){

			if (rightHeight > leftHeight) {
				if (right.compareTo(node) <= 0)
					right.leftRotate();

				else {
					right.getLeft().rightRotate();
					right.leftRotate();
				}
			}
			else {
				if (left.compareTo(node) >= 0)
					left.rightRotate();

				else {
					left.getRight().leftRotate();
					left.rightRotate();
				}
			}
		}
	}

	public List<String> getInorderTraversal() {
		List<String> t = new ArrayList<String>();
		if (left != null)
			t.addAll(left.getInorderTraversal());

		t.add(toString());

		if(right != null)
			t.addAll(right.getInorderTraversal());

		return t;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

class Tree<T> {
	private Node<T> root;
	private int size;

	private int capacity;
	private Comparator comparator;

	public Tree (Comparator comp){
		comparator = comp;
		size = 0;
		capacity = -1;
	}

	public Tree (int c, Comparator comp) {
		comparator = comp;
		size = 0;
		capacity = c;
	}

	public Node<T> getRoot(){
		return root;
	}

	public boolean isEmpty(){
		return (size == 0);
	}

	public boolean isFull() {
		return (capacity >= 0 && size == capacity);
	}

	public boolean insert(T data) {
		if (isFull())
			return false;

		Node<T> node = new Node<T>(data, comparator);
		size++;

		if (root == null) {
			root = node;
		}
		else {
			root.insert(node);
			while (root.getParent() != null)
				root = root.getParent();
		}

		return true;
	}

	/*
	 *  Equivalent to getKthSmallestNode(_k)
	 * 	  		where, 	  _k = size - k - 1
	 *  @ 0-indexed
	 */
	public Node<T> getKthSmallestNode(int k){
		assert k < size;
		Node<T> node = root;

		int off = (node.getLeft() == null)? 0: node.getLeft().getSize();
		while (k != off) {

			if (k < off) {
				assert node.getLeft() != null;
				node = node.getLeft();
			}

			else {
				k -= off + 1;
				assert node.getRight() != null;
				node = node.getRight();
			}
			off = (node.getLeft() == null)? 0: node.getLeft().getSize();
		}

		return node;
	}

	public Node<T> getKthLargestNode(int k){
		return getKthSmallestNode(size - k - 1);
	}

	public List<String> getInorderTraversal() {
		return root.getInorderTraversal();
	}

	public int getSize(){
		return size;
	}
}

class IntegerComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer a, Integer b){
		return a.compareTo(b);
	}
}

class MedianFinder {
    Tree<Integer> tree;
    
    public MedianFinder() {
        tree = new Tree<>(new IntegerComparator());
    }
    
    public void addNum(int num) {
        tree.insert(num);
    }
    
    public double findMedian() {
        int index = tree.getSize() / 2;
        if ((tree.getSize() & 1) == 0){
            double first = tree.getKthSmallestNode(index).getValue();
            return 0.5 * (first + tree.getKthSmallestNode(index - 1).getValue());
        }
        else {
            return tree.getKthSmallestNode(index).getValue();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */