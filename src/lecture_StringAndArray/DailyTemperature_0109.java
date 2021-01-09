package lecture_StringAndArray;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature_0109 {
	
	/*자신보다 더 큰 온도가 나올 떄 까지 얼마나 걸렸는가를 반환
	 
	 input : int[] nums ={73, 74, 75, 71, 69, 72, 76, 73}
	 output : [1, 1, 4, 2, 1, 1, 0, 0]
	 
	 stack 이용하기!
	 */
	
	public int[] solve(int[] nums){
		
		// 이용할 스택과 결과물을 담을 배열 선언
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[nums.length];
		
		for (int i =0;i<nums.length;i++){
			
			// 스택이 비어있지 않고 스택에 들어있는 값들이 현재 비교하는 값보다 작은 경우 -> 온도가 올라간 것!
			while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
				int index = stack.pop(); 
				result[index] = i-index;
			}
			
			stack.push(i);
		}
		
		return result; 
	}
	
	
	public static void main(String[] args){
		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		DailyTemperature_0109 a = new DailyTemperature_0109();
		
		System.out.println(Arrays.toString(a.solve(nums)));
		
	}
}
