package lecture_StringAndArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 배열 안에서 두개의 원소의 합이 주어진 숫자가 되도록 하는 인덱스 두개를 구하기
 
 input : int[] nums, int taget
 output : int[] = {0,0}
 
 
 solve : 1)n번째 원소 num을 꺼낸다
         2)target에서 num을 뺀 값을 Map에 num의 인덱스와 함께 저장한다
         3)2의 값이 남은 원소들 중에 존재하는지 살핀 후 존재한다면 그 인덱스를 Map에 저장
 
 */

public class TwoSum_0109 {
	
	public int[] solve(int[] nums, int target){
		
		// 결과를 담을 것
		Map<Integer,Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		for (int i=0;i<nums.length;i++){
			
			//map에 값이 들어있다면 이 값을 찾는 다른 인덱스가 있다는 것!
			if(map.containsKey(nums[i])){
				
				// 현재 i와 map의 value값이 target을 만드는 두개의 인덱스가 됨
				result[0] = map.get(nums[i]);
				result[1] = i;
				
			}else{
				
				// map에 값이 들어있지 않다면 새로 넣기 (찾아야 할 값, 현재 인덱스)
				map.put(target-nums[i], i);
			}

		} 
		
		return result;
	}
	

	public static void main(String[] args){
		int[] nums={2,8,11,21};
		int target=10;
		TwoSum_0109 a = new TwoSum_0109();
		System.out.println(Arrays.toString(a.solve(nums, target)));
	}

}
