package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_0204 {
	// �κ����� ��� ���ϱ�

	public List<List<Integer>> solve(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		// ��üũ
		if (nums == null || nums.length == 0) return result;

		dfs(nums, result, list, 0);

		return result;
	}

	public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur, int start) {
		
		List<Integer> list = new ArrayList<>(cur);
		lists.add(list);
		
		for(int i=start;i<nums.length;i++){
			
			cur.add(nums[i]);
			dfs(nums,lists,cur,i+1);
			
			//������ �ϳ� �����
			cur.remove(cur.size()-1);
		}
		
	}

	public static void main(String[] args) {
		Subsets_0204 a = new Subsets_0204();
		int[] nums = { 1, 2, 3 };

		System.out.println(a.solve(nums));
	}

}
