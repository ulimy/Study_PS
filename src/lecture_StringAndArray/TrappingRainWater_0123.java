package lecture_StringAndArray;

public class TrappingRainWater_0123 {
	
	/* 벽돌에 채워지는 빗물
	
	1. 왼쪽 벽 높이 모두 구하기
	2. 오른쪽 벽 모두 구하기
	3. 1과 2중 작은 값을 구하면 그게 높이
	4. 벽돌 높이 구하기 (벽돌이 바닥에 있는 경우 빼줘야 함)
	5. 3에서 5빼면 그게 최종 높이
	
	
	*/
	
	public int solve(int[] height){
		int result=0;
		
		// 비어있는지 확인
		if(height==null||height.length==0) return result;
		
		// 왼쪽 벽, 오른쪽 벽 높이 구하기
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		// 왼쪽 첫번째는 무조건 첫번째 height
		int max=height[0];
		left[0]= max;
		
		// left 채워넣기
		for (int i=1;i<height.length;i++){
			// 현재 height와 max중 더 큰 값이 그곳의 왼쪽 벽 높이가 됨
			if (max<height[i]){
				left[i]=height[i];
				max=height[i];
			}else{
				left[i]=max;
			}
		}
		
		// right는 뒤에서부터
		max = height[height.length-1];
		right[height.length-1] = max;
		
		//right 채워넣기
		for (int i=height.length-2;i>=0;i--){
			if(max<height[i]){
				right[i]=height[i];
				max=height[i];
			}else{
				right[i]=max;
			}
		}
		
		// right와 left중 더 작은 값 구하기
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
