package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_0204 {
	
	// �־��� ���ڿ��� ���� �� �ִ� ��� ���ڿ� ���� ���ϱ�
	// dfs �̿��ϱ�!
	
	public List<List<Integer>> solve(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		//��üũ
		if(nums==null || nums.length==0) return result;
		
		dfs(nums,result,list);
		
		return result;
	}
	
	public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur){
		
		// ���!
		if(cur.size()==nums.length){
			List<Integer> list = new ArrayList<>(cur);
			lists.add(list);
		}
		
		// Ż�� ���� �����س��� ����
		for (int i=0; i<nums.length;i++){
			if(cur.contains(nums[i])) continue;
			
			cur.add(nums[i]);
			dfs(nums,lists,cur);
			
			// ������ �ϳ� �����������
			cur.remove(cur.size()-1);
		}
	}

	public static void main(String[] args) {
		Permutation_0204 a = new Permutation_0204();
		int[] nums = {1,2,3};
		
		System.out.println(a.solve(nums));

	}

}
