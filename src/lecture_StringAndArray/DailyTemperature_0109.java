package lecture_StringAndArray;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature_0109 {
	
	/*�ڽź��� �� ū �µ��� ���� �� ���� �󸶳� �ɷȴ°��� ��ȯ
	 
	 input : int[] nums ={73, 74, 75, 71, 69, 72, 76, 73}
	 output : [1, 1, 4, 2, 1, 1, 0, 0]
	 
	 stack �̿��ϱ�!
	 */
	
	public int[] solve(int[] nums){
		
		// �̿��� ���ð� ������� ���� �迭 ����
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[nums.length];
		
		for (int i =0;i<nums.length;i++){
			
			// ������ ������� �ʰ� ���ÿ� ����ִ� ������ ���� ���ϴ� ������ ���� ��� -> �µ��� �ö� ��!
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
