package lecture_Graph;

public class MaximumDepthOfBinaryTree_DFS_0126 {
	
	// DFS로 풀어보기 --> Stack
	
	public int solve(TreeNode root){
		return 0;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree_DFS_0126 a = new MaximumDepthOfBinaryTree_DFS_0126();

		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.left.left.left = new TreeNode(7);

		System.out.println(a.solve(tree));

	}

}
