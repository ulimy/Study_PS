package lecture_StringAndArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 �迭 �ȿ��� �ΰ��� ������ ���� �־��� ���ڰ� �ǵ��� �ϴ� �ε��� �ΰ��� ���ϱ�
 
 input : int[] nums, int taget
 output : int[] = {0,0}
 
 
 solve : 1)n��° ���� num�� ������
         2)target���� num�� �� ���� Map�� num�� �ε����� �Բ� �����Ѵ�
         3)2�� ���� ���� ���ҵ� �߿� �����ϴ��� ���� �� �����Ѵٸ� �� �ε����� Map�� ����
 
 */

public class TwoSum_0109 {
	
	public int[] solve(int[] nums, int target){
		
		// ����� ���� ��
		Map<Integer,Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		for (int i=0;i<nums.length;i++){
			
			//map�� ���� ����ִٸ� �� ���� ã�� �ٸ� �ε����� �ִٴ� ��!
			if(map.containsKey(nums[i])){
				
				// ���� i�� map�� value���� target�� ����� �ΰ��� �ε����� ��
				result[0] = map.get(nums[i]);
				result[1] = i;
				
			}else{
				
				// map�� ���� ������� �ʴٸ� ���� �ֱ� (ã�ƾ� �� ��, ���� �ε���)
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
