package lecture_StringAndArray;

import java.util.Arrays;

/*
 �迭 �ȿ��� �ΰ��� ������ ���� �־��� ���ڰ� �ǵ��� �ϴ� ���� �ΰ��� ���ϱ�
 
 input : int[] nums, int taget
 output : int[] = {0,0}
 
 
 solve : 1)n��° ���� num�� ������
         2)target���� num�� ����
         3)2�� ���� ���� ���ҵ� �߿� �����ϴ��� ���ɴ�
 
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
