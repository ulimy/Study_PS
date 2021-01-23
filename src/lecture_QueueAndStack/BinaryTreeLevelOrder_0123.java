package lecture_QueueAndStack;

import java.util.List;

// πŸ¿Ã≥ ∏Æ ∆Æ∏Æ¿« ∞∞¿∫ ±Ì¿Ã≥¢∏Æ π≠±‚

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val=x;
	}
}

public class BinaryTreeLevelOrder_0123 {
	
	public List<List<Integer>> solve(TreeNode root){
		return null;
	}
	
	public static void main(String[] args){
		BinaryTreeLevelOrder_0123 a = new BinaryTreeLevelOrder_0123();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(a.solve(root));
	}
}
