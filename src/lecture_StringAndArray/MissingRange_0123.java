package lecture_StringAndArray;

import java.util.ArrayList;
import java.util.List;

public class MissingRange_0123 {
	
	public List<String> solve(int[] nums,int lower,int upper){
		List<String> result = new ArrayList<>();
		
		if(nums==null||nums.length==0) return result;
		
		// 맨처음.
		if(lower<nums[0]) result.add(makeRange(lower,nums[0]-1));
		
		// 중간.
		for (int i=0;i<nums.length-1;i++){
			if (nums[i]+1<nums[i+1] && nums[i]+1<nums[i+1]){
				result.add(makeRange(nums[i]+1,nums[i+1]-1));
			}
		}
		
		// 마지막.
		if(nums[nums.length-1]<upper){
			result.add(makeRange(nums[nums.length-1]+1,upper));
		}
		
		return result;
	}
	
	// 같으면 그 값을, 다르면 화살표 넣기
	public String makeRange(int low,int high){
		return (low==high?String.valueOf(low):(low+"->"+high));
	}

	public static void main(String[] args) {
		MissingRange_0123 a = new MissingRange_0123();
		int[] nums = {2,3,5,50,75};
		int lower=0, upper=99;
		System.out.println(a.solve(nums, lower, upper));
	}

}
