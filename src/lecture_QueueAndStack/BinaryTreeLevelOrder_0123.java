package lecture_QueueAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// ���̳ʸ� Ʈ���� ���� ���̳��� ���� BFS�� Queue �̿��ϱ�!

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val=x;
	}
}

public class BinaryTreeLevelOrder_0123 {
	
	public List<List<Integer>> solve(TreeNode root){
		List<List<Integer>> result = new ArrayList<>();
		
		// ��üũ
		if (root==null) return result;
		
		// ť �ʱ�ȭ -> ���� �� ���� �־���� ��!
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> list = new LinkedList<>();
			for (int i=0;i<size;i++){
				// �̾Ƽ� val�� list�� �ֱ�
				TreeNode node = queue.poll();
				list.add(node.val);
				// ���� node�� left, right�� ���� ���̿� �̿��ϱ� ���� queue�� �߰�
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			// �ݺ����� ������ �� ���� ���� �� -> result�� ���
			result.add(list);
		}
		
		return result;
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
