package lecture_StringAndArray;

public class MaximumSubarray_0110 {
	
	/*Subarray�߿� ���� ū �� ���ϱ�
	  
	 max�� �ϳ� ���س��� �ϳ��� ���س����鼭 max���� ũ�ٸ� max ��ü*/
	
	public int solve(int[] nums){
		
		int max=0, newSum=0;
		for (int num: nums){
			// ���ݱ��� ���� �� ���� ���� ���� ���ϴ°� ���� �׳� ������ ���� �� ũ�ٸ� ���簪�� �����ϵ���
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
