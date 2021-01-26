package lecture_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_BFS_0126 {
	
	// BFS�� Ǯ��� --> Queue �̿�
	
	public int solve(TreeNode root){
		
		// ��üũ
		if (root==null) return 0;
			
		// ť ����� ��Ʈ �ֱ�
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count=0;
		
		while(!queue.isEmpty()){
			// ť �ȿ� ����ִ� ��� ���� ��ŭ�� �ݺ��ϱ�
			int size=queue.size();
			for (int i=0;i<size;i++){
				//ť���� ���� left, right ť�� �ֱ�
				TreeNode node = queue.poll();
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			// ��������ʾ� �ݺ��� ������ �������Ƿ� ī���� ����
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
