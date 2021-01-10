package lecture_StringAndArray;

public class MaximumSubarray_0110 {
	
	/*Subarray중에 제일 큰 수 구하기
	  
	 max값 하나 정해놓고 하나씩 더해나가면서 max보다 크다면 max 교체*/
	
	public int solve(int[] nums){
		
		int max=0, newSum=0;
		for (int num: nums){
			// 지금까지 더해 온 값에 현재 값을 더하는것 보다 그냥 현재의 값이 더 크다면 현재값을 선택하도록
			newSum = Math.max(num, newSum+num);
			max = Math.max(max,newSum);
		}
		
		return max;
	}

	public static void main(String[] args) {
		MaximumSubarray_0110 a = new MaximumSubarray_0110();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(a.solve(nums));
	}

}
