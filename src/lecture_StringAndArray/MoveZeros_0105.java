package lecture_StringAndArray;

import java.util.Arrays;

/* 배열에서 0만 전부 맨 뒤로 보내기 */

public class MoveZeros_0105 {

	public int[] solve(int[] nums){
		
		//1. 0이 아닌 값을 넣을 위치를 기억할 변수 index
		int index=0;
		
		//2. 0이 아닌 값들 차례대로 넣기
		for (int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				nums[index]=nums[i];
				index++;
			}
		}
		
		//3. 0을 index부터 넣기
		while(index<nums.length){
			nums[index++]=0;
		}
		
		return nums;
	}
	
	public static void main(String[] args){
		MoveZeros_0105 a = new MoveZeros_0105();
		int[] nums={0,3,2,0,8,5};
		System.out.println(Arrays.toString(a.solve(nums)));
	}
	
}
