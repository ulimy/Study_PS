package lecture_StringAndArray;

import java.util.Arrays;

/* �迭���� 0�� ���� �� �ڷ� ������ */

public class MoveZeros_0105 {

	public int[] solve(int[] nums){
		
		//1. 0�� �ƴ� ���� ���� ��ġ�� ����� ���� index
		int index=0;
		
		//2. 0�� �ƴ� ���� ���ʴ�� �ֱ�
		for (int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				nums[index]=nums[i];
				index++;
			}
		}
		
		//3. 0�� index���� �ֱ�
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
