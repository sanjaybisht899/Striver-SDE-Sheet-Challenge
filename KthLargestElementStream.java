class KthLargest {
    TreeNode _root;
    int _k;
    int _size;
    // Obtain the minimum value of the tree
    private int findMin() {
        TreeNode node = _root;
        while (node.left != null)
            node = node.left;
        return node.val;
    }
    
    // Obtain the smallest value in the tree > than root->val
    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) 
            root = root.left;
        return root.val;
    }
    
    // Obtain the largest value in the tree <= node->val
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) 
            root = root.right;
        return root.val;
    }

    // If the tree has an extra node, prune off the smallest one
    private TreeNode pruneToK(TreeNode root) {
        if (_size <= _k)
            return root;
        if (root == null) {
            return null;
        } else if (root.left != null) {
            // delete from the left subtree
            root.left = pruneToK(root.left);
        } else {
            --_size;
            if (root.left == null && root.right == null) {
                // the node is a leaf
                root = null;
            } else if (root.right != null) {
                // the node is not a leaf and has a right child
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } 
        }
        return root;
    }
    
    // Delete a node with val=key from the tree rooted at 'root'
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) 
            return null;
        if (key > root.val) {
            // delete from the right subtree
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            // delete from the left subtree
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                // the node is a leaf
                root = null;
            } else if (root.right != null) {
                // the node is not a leaf and has a right child
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // the node is not a leaf, has no right child, and has a left child    
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    // insert a node into the tree at 'root' with a value 'val'
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            ++_size;
            return new TreeNode(val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
    
    public KthLargest(int k, int[] nums) {
        _k = k;
        _root = null;
        _size = 0;
        for (int val: nums) {
            _root = insertIntoBST(_root, val);
            _root = pruneToK(_root);
        }
    }
    
    public int add(int val) {
        _root = insertIntoBST(_root, val);
        _root = pruneToK(_root);
        return findMin();
    }
};