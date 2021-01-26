package lecture_Graph;

import java.util.Stack;

public class MaximumDepthOfBinaryTree_DFS_0126 {
	
	/* 
	  
	 DFS로 풀어보기 --> Stack
	 
	 1. 노드 하나 스택에서 pop
	 2. pop한 노드의 left,right를 push null인 경우 X
	
	 */
	
	public int solve(TreeNode root){
		
		// 널체크
		if (root==null) return 0;
		
		// Tree담을 곳
		Stack<TreeNode> stack = new Stack<>();
		// depth 담을 곳
		Stack<Integer> valueStack = new Stack<>();
		
		// root넣고 depth 1 설정
		stack.push(root);
		valueStack.push(1);
		int max=0;
		
		while(!stack.isEmpty()){
			// 검색할 노드
			TreeNode node = stack.pop();
			// 검색할 노드의 깊이
			int count = valueStack.pop();
			// 최대 깊이
			max = Math.max(max, count);
			if(node.left!=null) {
				stack.push(node.left);
				// count 자체 값이 증가되지 않도록 1+count
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
