package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS_0126 {
	
	// BFS로 풀어보기 --> Queue 이용
	
	public int solve(TreeNode root){
		
		// 널체크
		if (root==null) return 0;
			
		// 큐 만들어 루트 넣기
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count=0;
		
		while(!queue.isEmpty()){
			// 큐 안에 들어있는 노드 개수 만큼만 반복하기
			int size=queue.size();
			for (int i=0;i<size;i++){
				//큐에서 빼서 left, right 큐에 넣기
				TreeNode node = queue.poll();
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			// 비어있진않아 반복문 안으로 들어왔으므로 카운터 증가
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		MaximumDepthOfBinaryTree_BFS_0126  a = new MaximumDepthOfBinaryTree_BFS_0126();
		
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.left.left.left = new TreeNode(7);

		System.out.println(a.solve(tree));
	
	}

}
