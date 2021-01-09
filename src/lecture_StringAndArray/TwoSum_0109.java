package lecture_StringAndArray;

import java.util.Arrays;

/*
 배열 안에서 두개의 원소의 합이 주어진 숫자가 되도록 하는 원소 두개를 구하기
 
 input : int[] nums, int taget
 output : int[] = {0,0}
 
 
 solve : 1)n번째 원소 num을 꺼낸다
         2)target에서 num을 뺀다
         3)2의 값이 남은 원소들 중에 존재하는지 살핀다
 
 */

public class TwoSum_0109 {
	
	public int[] solve(int[] nums, int target){
		return nums;
	}
	

	public static void main(String[] args){
		int[] nums={2,8,10,21};
		int target=10;
		TwoSum_0109 a = new TwoSum_0109();
		System.out.println(Arrays.toString(a.solve(nums, target)));
	}

}
