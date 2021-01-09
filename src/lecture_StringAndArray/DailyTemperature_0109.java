package lecture_StringAndArray;

public class DailyTemperature_0109 {
	
	/*자신보다 더 큰 온도가 나올 떄 까지 얼마나 걸렸는가를 반환
	 
	 input : int[] nums ={73, 74, 75, 71, 69, 72, 76, 73}
	 output : [1, 1, 4, 2, 1, 1, 0, 0]
	 
	 stack 이용하기!
	 */
	
	public int[] solve(int[] nums){
		return nums;
	}
	
	
	public static void main(String[] args){
		int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
		DailyTemperature_0109 a = new DailyTemperature_0109();
		
		System.out.println(a.solve(nums));
		
	}
}
