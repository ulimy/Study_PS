package lecture_BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_0204 {
	
	// 주어진 문자열로 만들 수 있는 모든 문자열 순열 구하기
	// dfs 이용하기!
	
	public List<List<Integer>> solve(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		//널체크
		if(nums==null || nums.length==0) return result;
		
		dfs(nums,result,list);
		
		return result;
	}
	
	public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur){
		
		// 담기!
		if(cur.size()==nums.length){
			List<Integer> list = new ArrayList<>(cur);
			lists.add(list);
		}
		
		// 탈출 조건 설정해놓고 저장
		for (int i=0; i<nums.length;i++){
			if(cur.contains(nums[i])) continue;
			
			cur.add(nums[i]);
			dfs(nums,lists,cur);
			
			// 마지막 하나 삭제해줘야함
			cur.remove(cur.size()-1);
		}
	}

	public static void main(String[] args) {
		Permutation_0204 a = new Permutation_0204();
		int[] nums = {1,2,3};
		
		System.out.println(a.solve(nums));

	}

}
