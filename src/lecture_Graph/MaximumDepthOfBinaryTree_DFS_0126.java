package lecture_Graph;

import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS_0126 {
	
	/* 
	  
	 DFS�� Ǯ��� --> Stack
	 
	 1. ��� �ϳ� ���ÿ��� pop
	 2. pop�� ����� left,right�� push null�� ��� X
	
	 */
	
	public int solve(TreeNode root){
		
		// ��üũ
		if (root==null) return 0;
		
		// Tree���� ��
		Stack<TreeNode> stack = new Stack<>();
		// depth ���� ��
		Stack<Integer> valueStack = new Stack<>();
		
		// root�ְ� depth 1 ����
		stack.push(root);
		valueStack.push(1);
		int max=0;
		
		while(!stack.isEmpty()){
			// �˻��� ���
			TreeNode node = stack.pop();
			// �˻��� ����� ����
			int count = valueStack.pop();
			// �ִ� ����
			max = Math.max(max, count);
			if(node.left!=null) {
				stack.push(node.left);
				// count ��ü ���� �������� �ʵ��� 1+count
				valueStack.push(1+count);
			}
			if(node.right!=null) {
				stack.push(node.right);
				valueStack.push(1+count);
			}
		}
		
		return max;
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
