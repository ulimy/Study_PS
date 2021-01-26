package lecture_Graph;

class TreeNode{
	
	int val;
	TreeNode left, right;
	
	TreeNode(int val){
		this.val = val;
	}
}

public class MaximumDepthOfBinaryTree_0126 {
	
	public int solve(TreeNode root){
		
		// 널체크
		if (root==null) return 0;
		
		// 재귀호출 이용. 위에서 널체크 하므로 널이면 재귀호출 종료
		int leftMax = solve(root.left);
		int rightMax = solve(root.right);
		
		// 비교 후 큰 값+1 (맨 처음 -> 양쪽 둘다 null -> 0+1=1)
		return Math.max(leftMax, rightMax)+1;
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree_0126 a = new MaximumDepthOfBinaryTree_0126();
		
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left =  new TreeNode(5);
		tree.left.right =  new TreeNode(8);
		tree.left.left.left =  new TreeNode(7);
		
		System.out.println(a.solve(tree));

	}

}
