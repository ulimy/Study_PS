package lecture_StringAndArray;

public class TrappingRainWater_0123 {
	
	/* ������ ä������ ����
	
	1. ���� �� ���� ��� ���ϱ�
	2. ������ �� ��� ���ϱ�
	3. 1�� 2�� ���� ���� ���ϸ� �װ� ����
	4. ���� ���� ���ϱ� (������ �ٴڿ� �ִ� ��� ����� ��)
	5. 3���� 5���� �װ� ���� ����
	
	
	*/
	
	public int solve(int[] height){
		int result=0;
		
		// ����ִ��� Ȯ��
		if(height==null||height.length==0) return result;
		
		// ���� ��, ������ �� ���� ���ϱ�
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		// ���� ù��°�� ������ ù��° height
		int max=height[0];
		left[0]= max;
		
		// left ä���ֱ�
		for (int i=1;i<height.length;i++){
			// ���� height�� max�� �� ū ���� �װ��� ���� �� ���̰� ��
			if (max<height[i]){
				left[i]=height[i];
				max=height[i];
			}else{
				left[i]=max;
			}
		}
		
		// right�� �ڿ�������
		max = height[height.length-1];
		right[height.length-1] = max;
		
		//right ä���ֱ�
		for (int i=height.length-2;i>=0;i--){
			if(max<height[i]){
				right[i]=height[i];
				max=height[i];
			}else{
				right[i]=max;
			}
		}
		
		// right�� left�� �� ���� �� ���ϱ�
		for (int i=0;i<height.length;i++){
			result += Math.min(left[i], right[i])-height[i];
		}
		
		return result;
	}
	
	public static void main(String args[]){
		TrappingRainWater_0123 a = new TrappingRainWater_0123();
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(a.solve(nums));
	}

}
