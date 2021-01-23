package lecture_QueueAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 바이너리 트리의 같은 깊이끼리 묶기 BFS는 Queue 이용하기!

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
		
		// 널체크
		if (root==null) return result;
		
		// 큐 초기화 -> 진행 할 노드들 넣어놓는 곳!
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()){
			int size=queue.size();
			List<Integer> list = new LinkedList<>();
			for (int i=0;i<size;i++){
				// 뽑아서 val을 list에 넣기
				TreeNode node = queue.poll();
				list.add(node.val);
				// 뽑은 node의 left, right를 다음 깊이에 이용하기 위해 queue에 추가
				if(node.left!=null) queue.offer(node.left);
				if(node.right!=null) queue.offer(node.right);
			}
			// 반복문이 끝나면 한 줄이 끝난 것 -> result에 담기
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
