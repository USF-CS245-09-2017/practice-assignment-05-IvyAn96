

public class BSTree {

	private BSTNode node;

	public boolean find(String value) {
		return findH(value, node);
	}

	public BSTNode insert(String value) {
		node = insertH(value, node);
		return node;
	}

	public BSTNode delete(String value) {
		node = deleteH(value, node);
		return node;
	}

	public String toStringInOrder() {
		String value = toStringInOrderH(node);
		value.trim();
		return value;
	}

	public String toStringPreOrder() {
		
		return toStringPreOrderH(node).trim();
	}

	public boolean findH(String value, BSTNode node) {
		if(node == null){
			return false;
		}
		if (value.equals(node.data)) {
			return true;
		}
		if (value.compareTo(node.data) > 0) {
			return findH(value, node.right);
		}
		else  {
			return findH(value, node.left);
		}
	}

	public BSTNode insertH(String value, BSTNode node) {

		if (node == null) {
			return new BSTNode(value);
		}
		if (value.compareTo(node.data) < 0) {
			node.left = insertH(value, node.left);
			return node;
		}
		else  {
			node.right = insertH(value, node.right);
			return node;
		}
	}

	private BSTNode deleteH(String value, BSTNode node) {
		if (node == null) {
			return null;
		}
		if (node.data.compareTo(value) == 0) {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				if (node.right.left == null) {
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				} else {
					node.data = removeSmallest(node.right);
					return node;
				}
			}
		} else if (value.compareTo(value) < 0) {
			node.left = deleteH(value, node.left);
			return node;
		} else {
			node.right = deleteH(value, node.right);
			return node;
		}
	}

	private String removeSmallest(BSTNode node) {
		if (node.left.left == null) {
			String smallest = node.data;
			node.left = node.left.right;
			return smallest;
		} else {
			return removeSmallest(node.left);
		}
	}

	public String toStringInOrderH(BSTNode node) { 
		if (node == null) {
			return "";
		}
		String left = toStringInOrderH(node.left);
		if(!left.equals("")){
			left+=" ";
		}
		String right = toStringInOrderH(node.right);
		if(!right.equals("")){
			right = " " + right;
		}
		
		return left + node.data + right;
	}
	

	public String toStringPreOrderH(BSTNode node) {
		if (node == null) {
			return "";
		}
		String left = toStringPreOrderH(node.left);
		if(!left.equals("")){
			left = " " + left;
		}
		String right = toStringPreOrderH(node.right);
		if(!right.equals("")){
			right =" " + right;
		}
		return node.data + left + right;
	}

}
